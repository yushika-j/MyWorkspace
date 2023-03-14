package main

import (
	"bufio"
	"encoding/csv"
	"fmt"
	"log"
	"math"
	"math/rand"
	"os"
	"strconv"
	"strings"
	"sync"
)

type Point3D struct {
	X float64
	Y float64
	Z float64
}

type Plane3D struct {
	A float64
	B float64
	C float64
	D float64
}

type Plane3DwSupport struct {
	Plane3D
	SupportSize int
}

// reads an XYZ file and returns a slice of Point3D
func ReadXYZ(filename string) []Point3D {
	file, err := os.Open(filename)
	if err != nil {
		log.Fatal(err)
	}
	defer file.Close()

	scanner := bufio.NewScanner(file)
	var points []Point3D
	for scanner.Scan() {
		line := scanner.Text()
		fields := strings.Fields(line)
		if len(fields) >= 3 {
			x, _ := strconv.ParseFloat(fields[0], 64)
			y, _ := strconv.ParseFloat(fields[1], 64)
			z, _ := strconv.ParseFloat(fields[2], 64)
			points = append(points, Point3D{X: x, Y: y, Z: z})
		}
	}

	if err := scanner.Err(); err != nil {
		log.Fatal(err)
	}

	return points
}

// saves a slice of Point3D into an XYZ file
func SaveXYZ(filename string, points []Point3D) {
	file, err := os.Create(filename + ".xyz")
	if err != nil {
		log.Fatal(err)
		fmt.Println("Failed to create file! ")
	}
	writer := csv.NewWriter(file)

	writer.Comma = '\t'
	myline := []string{"x", "y", "z"}
	writer.Write(myline)

	for _, line := range points {
		a := fmt.Sprint("%v", line.X)
		b := fmt.Sprint("%v", line.Y)
		c := fmt.Sprint("%v", line.Z)
		inputData := []string{a, b, c}

		if err := writer.Write(inputData); err != nil {
			fmt.Println("error")
		}
	}

	writer.Flush()
	file.Close()
	// for _, point := range points {
	// 	fmt.Fprintf(file, "%.8f %.8f %.8f\n", point.X, point.Y, point.Z)
	// }
}

// computes the distance between points p1 and p2
func (p1 *Point3D) GetDistance(p2 *Point3D) float64 {
	dx := p1.X - p2.X
	dy := p1.Y - p2.Y
	dz := p1.Z - p2.Z
	return math.Sqrt(dx*dx + dy*dy + dz*dz)
}

// computes the plane defined by a slice of 3 points
func GetPlane(points [3]Point3D) Plane3D {
	if len(points) < 3 {
		log.Fatal("Cannot compute plane with less than 3 points")
	}

	p1, p2, p3 := points[0], points[1], points[2]

	// compute the plane normal
	ux, uy, uz := p2.X-p1.X, p2.Y-p1.Y, p2.Z-p1.Z
	vx, vy, vz := p3.X-p1.X, p3.Y-p1.Y, p3.Z-p1.Z
	nx, ny, nz := uy*vz-uz*vy, uz*vx-ux*vz, ux*vy-uy*vx
	magnitude := math.Sqrt(nx*nx + ny*ny + nz*nz)
	nx, ny, nz = nx/magnitude, ny/magnitude, nz/magnitude

	// compute the plane offset
	d := -(nx*p1.X + ny*p1.Y + nz*p1.Z)

	return Plane3D{A: nx, B: ny, C: nz, D: d}
}

// // computes the number of required RANSAC iterations
func GetNumberOfIterations(confidence float64, percentageOfPointsOnPlane float64) int {
	if percentageOfPointsOnPlane <= 0 || percentageOfPointsOnPlane >= 1 {
		log.Fatal("Percentage of points on plane must be between 0 and 1")
	}

	if confidence <= 0 || confidence >= 1 {
		log.Fatal("Confidence must be between 0 and 1")
	}

	inlierProbability := percentageOfPointsOnPlane * percentageOfPointsOnPlane
	return int(math.Log(1-confidence) / math.Log(1-inlierProbability))
}

// // computes the support of a plane in a slice of points
func GetSupport(plane Plane3D, points []Point3D, eps float64) Plane3DwSupport {
	var supportSize int
	for _, point := range points {
		if math.Abs(plane.A*point.X+plane.B*point.Y+plane.C*point.Z+plane.D) < eps {
			supportSize++
		}
	}
	return Plane3DwSupport{Plane3D: plane, SupportSize: supportSize}
}
func supportingPointFinder(wg *sync.WaitGroup, stop <-chan bool, inputPlaneStream <-chan Plane3D, pointCloud []Point3D, eps float64) <-chan Plane3DwSupport {
	outputPlaneSupportStream := make(chan Plane3DwSupport)

	go func() {
		defer func() {
			wg.Done()
			fmt.Println("\nFin de supportingPointFinder...")
		}()

		for plane := range inputPlaneStream {
			supportCount := 0
			for _, point := range pointCloud {
				if math.Abs(plane.A*point.X+plane.B*point.Y+plane.C*point.Z+plane.D) < eps {
					supportCount++
				}
			}

			select {
			case <-stop:
				return
			case outputPlaneSupportStream <- Plane3DwSupport{Plane3D: plane}:
			}
		}

		close(outputPlaneSupportStream)
	}()

	return outputPlaneSupportStream
}

// // extracts the points that supports the given plane
// // and returns them in a slice of points
func GetSupportingPoints(plane Plane3D, points []Point3D, eps float64) []Point3D {
	var supportingPoints []Point3D
	for _, point := range points {
		if math.Abs(plane.A*point.X+plane.B*point.Y+plane.C*point.Z+plane.D) < eps {
			supportingPoints = append(supportingPoints, point)
		}
	}
	return supportingPoints
}

// // creates a new slice of points in which all points
// // belonging to the plane have been removed
func RemovePlane(plane Plane3D, points []Point3D, eps float64) []Point3D {
	var remainingPoints []Point3D
	for _, point := range points {
		if math.Abs(plane.A*point.X+plane.B*point.Y+plane.C*point.Z+plane.D) > eps {
			remainingPoints = append(remainingPoints, point)
		}
	}
	return remainingPoints
}

func RANSAC(points []Point3D, numIterations int, eps float64) Plane3D {
	var bestPlane Plane3D
	var maxSupportSize int

	// repeat for the specified number of iterations
	for i := 0; i < numIterations; i++ {
		// randomly select three points
		randomIndices := getRandomIndices(len(points), 3)
		randomPoints := [3]Point3D{points[randomIndices[0]], points[randomIndices[1]], points[randomIndices[2]]}

		// compute the plane defined by the random points
		plane := GetPlane(randomPoints)

		// compute the support of the plane in the point cloud
		support := GetSupport(plane, points, eps)

		// update the best plane if the support is larger
		if support.SupportSize > maxSupportSize {
			maxSupportSize = support.SupportSize
			bestPlane = support.Plane3D
		}
	}

	return bestPlane
}

// helper function to generate a slice of n unique random integers in the range [0, max)
func getRandomIndices(max, n int) []int {
	m := make(map[int]bool)
	for len(m) < n {
		randIndex := rand.Intn(max)
		m[randIndex] = true
	}
	indices := make([]int, n)
	i := 0
	for k := range m {
		indices[i] = k
		i++
	}
	return indices
}

// func main() {
// 	// read command line arguments
// 	fmt.Println("Reading command line arguments...")
// 	if len(os.Args) < 5 {
// 		fmt.Println("Usage: go planeRANSAC filename confidence percentage eps")
// 		os.Exit(1)
// 	}
// 	filename := os.Args[1]
// 	confidence, err := strconv.ParseFloat(os.Args[2], 64)
// 	if err != nil {
// 		fmt.Println("Error: invalid confidence parameter")
// 		os.Exit(1)
// 	}
// 	percentageOfPointsOnPlane, err := strconv.ParseFloat(os.Args[3], 64)
// 	if err != nil {
// 		fmt.Println("Error: invalid percentageOfPointsOnPlane parameter")
// 		os.Exit(1)
// 	}
// 	eps, err := strconv.ParseFloat(os.Args[4], 64)
// 	if err != nil {
// 		fmt.Println("Error: invalid eps parameter")
// 		os.Exit(1)
// 	}

// 	// read input file
// 	points := ReadXYZ(filename)

// 	// run RANSAC algorithm for the three most dominant planes
// 	for i := 1; i <= 3; i++ {
// 		// compute the number of required RANSAC iterations
// 		numIterations := GetNumberOfIterations(confidence, percentageOfPointsOnPlane)

// 		// run RANSAC algorithm to find the dominant plane
// 		fmt.Printf("Finding dominant plane %d...\n", i)
// 		plane := RANSAC(points, numIterations, eps)

// 		// extract the points that support the plane
// 		supportingPoints := GetSupportingPoints(plane, points, eps)

// 		// save the supporting points to a file
// 		outputFilename := fmt.Sprintf("%s_p%d", filename, i)
// 		SaveXYZ(outputFilename, supportingPoints)

// 		// remove the supporting points from the original point cloud
// 		points = RemovePlane(plane, points, eps)

// 	}
// 	fmt.Println("Press Enter key to exit...")
// 	fmt.Scanln()
// }

func randomPointGenerator(wg *sync.WaitGroup, stop <-chan bool, inputPointCloud []Point3D) <-chan Point3D {
	outputPointStream := make(chan Point3D)
	go func() {
		defer func() { wg.Done() }()
		defer close(outputPointStream)
		for {
			select {
			case <-stop:
				return
			default:
				randomIndex := rand.Intn(len(inputPointCloud))
				outputPointStream <- inputPointCloud[randomIndex]
			}
		}
	}()
	return outputPointStream
}

func tripletPointsGenerator(stop <-chan bool, inputPointStream <-chan Point3D) <-chan [3]Point3D {
	outputTripletStream := make(chan [3]Point3D)
	go func() {
		defer close(outputTripletStream)
		var triplet [3]Point3D
		i := 0
		for p := range inputPointStream {
			triplet[i] = p
			i++
			if i == 3 {
				outputTripletStream <- triplet
				triplet = [3]Point3D{}
				i = 0
			}
		}
	}()
	return outputTripletStream
}

func takeN(wg *sync.WaitGroup, stop <-chan bool, inputTripletStream <-chan [3]Point3D, n int) <-chan [3]Point3D {
	outputTripletStream := make(chan [3]Point3D)
	go func() {
		defer close(outputTripletStream)
		for i := 0; i < n; i++ {
			select {
			case <-stop:
				return
			case triplet := <-inputTripletStream:
				outputTripletStream <- triplet
			}
		}
	}()
	return outputTripletStream
}

func planeEstimator(wg sync.WaitGroup, stop <-chan bool, inputTripletStream <-chan [3]Point3D) <-chan Plane3D {
	outputPlaneStream := make(chan Plane3D)
	go func() {
		defer close(outputPlaneStream)
		for triplet := range inputTripletStream {
			select {
			case <-stop:
				return
			case outputPlaneStream <- GetPlane(triplet):
			}

		}
	}()
	return outputPlaneStream
}

func FanIn(wg *sync.WaitGroup, stop <-chan bool, inputStreams []<-chan *Plane3DwSupport) <-chan *Plane3DwSupport {
	outputIntStream := make(chan *Plane3DwSupport)
	var multiplexGroup sync.WaitGroup
	reader := func(ch []<-chan *Plane3DwSupport) {
		defer func() { multiplexGroup.Done() }()
		for _, i := range inputStreams {

			select {
			case <-stop:
				return
			case outputIntStream <- i:
			}
		}
	}

	// all goroutine must return before
	// the output channel is closed
	multiplexGroup.Add(len(inputStreams))
	for _, ch := range inputStreams {
		go reader(inputStreams)
	}

	go func() {
		wg.Wait()
		close(outputIntStream)
	}()

	return outputIntStream
}

func DominantPlaneIdentifier(wg *sync.WaitGroup, stop <-chan bool, input <-chan *Plane3DwSupport, bestPlane *Plane3DwSupport) {
	defer wg.Done()

	for {
		select {
		case <-stop:
			return
		case p, ok := <-input:
			if !ok {
				return
			}
			if p.SupportSize > bestPlane.SupportSize {
				*bestPlane = *p
			}
		}
	}
}

func main() {
	// Read the input filename from the command line arguments
	if len(os.Args) != 6 {
		log.Fatal("Usage: go planeRANSAC filename confidence percentage eps")
	}

	// Read the confidence and percentage from the command line arguments
	confidence, err := strconv.ParseFloat(os.Args[2], 64)
	if err != nil {
		log.Fatal("Invalid confidence value:", os.Args[2])
	}
	percentage, err := strconv.ParseFloat(os.Args[3], 64)
	if err != nil {
		log.Fatal("Invalid percentage value:", os.Args[3])
	}

	// Read the eps value from the command line arguments
	eps, err := strconv.ParseFloat(os.Args[4], 64)
	if err != nil {
		log.Fatal("Invalid eps value:", os.Args[4])
	}

	// Read the points from the input file
	filename := os.Args[1]
	points := ReadXYZ(filename)
	if err != nil {
		log.Fatal("Error reading points from file:", err)
	}

	// Create a bestSupport variable of type Plane3DwSupport initialized to all 0s
	var bestSupport Plane3DwSupport

	// Find the number of iterations required based on the specified confidence and percentage
	numIterations := int((1 - confidence) / math.Log(1-math.Pow(percentage, 3)))

	// Create a pipeline to find the dominant plane
	randomPointGen := make(chan Point3D)
	tripletGen := make(chan [3]Point3D)
	takeN := make(chan [3]Point3D)
	planeEstimator := make(chan Plane3D)
	supportFinder := make(chan Plane3DwSupport)

	// Step 3: Find the number of iterations required.
	n := GetNumberOfIterations(confidence, percentage)

	// Step 4: Create and start the RANSAC pipeline.
	pipeline := createPipeline(points, n, eps)
	supports := make([]Plane3DwSupport, 0)
	for support := range pipeline {
		if support.numSupporting > bestSupport.SupportSize {
			bestSupport = support
		}
		supports = append(supports, support)
	}

	// Step 5: Save the supporting points of the identified dominant plane.
	if err := SaveXYZ(filename+"_p", supports); err != nil {
		fmt.Println("Error saving supporting points:", err)
		return
	}

	// Step 6: Save the original point cloud without the supporting points of the dominant plane.
	if err := SaveXYZ(filename+"_p0", removeSupportingPoints(points, bestSupport.supportingPoints)); err != nil {
		fmt.Println("Error saving point cloud without supporting points:", err)
		return
	}

	// Step 7: Save the supporting points of the 3 dominant planes.
	for i := 1; i <= 3; i++ {
		// Use the supporting points of the previous run as input.
		points = supports[i-1].supportingPoints
		pipeline = fctPipeline(points, n, eps)
		var dominantSupport Plane3DwSupport
		for support := range pipeline {
			if support.numSupporting > dominantSupport.SupportSize {
				dominantSupport = support
			}
		}
		if err := SaveXYZ(fmt.Sprintf("%s_p%d", filename, i), dominantSupport.supportingPoints); err != nil {
			fmt.Println("Error saving supporting points:", err)
			return
		}
	}
}
