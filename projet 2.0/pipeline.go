// package main

// import (
// 	"bufio"
// 	"fmt"
// 	"log"
// 	"math"
// 	"math/rand"
// 	"os"
// 	"strconv"
// 	"strings"
// )

// type Point3D struct {
// 	X float64
// 	Y float64
// 	Z float64
// }
// type Plane3D struct {
// 	A float64
// 	B float64
// 	C float64
// 	D float64
// }
// type Plane3DwSupport struct {
// 	Plane3D
// 	SupportSize int
// }

// // reads an XYZ file and returns a slice of Point3D
// func ReadXYZ(filename string) []Point3D {
// 	file, err := os.Open(filename)
// 	if err != nil {
// 		log.Fatal(err)
// 	}
// 	defer file.Close()

// 	scanner := bufio.NewScanner(file)
// 	var points []Point3D
// 	for scanner.Scan() {
// 		line := scanner.Text()
// 		fields := strings.Fields(line)
// 		if len(fields) >= 3 {
// 			x, _ := strconv.ParseFloat(fields[0], 64)
// 			y, _ := strconv.ParseFloat(fields[1], 64)
// 			z, _ := strconv.ParseFloat(fields[2], 64)
// 			points = append(points, Point3D{X: x, Y: y, Z: z})
// 		}
// 	}

// 	if err := scanner.Err(); err != nil {
// 		log.Fatal(err)
// 	}

// 	return points
// }

// // saves a slice of Point3D into an XYZ file
// func SaveXYZ(filename string, points []Point3D) {
// 	file, err := os.Create(filename)
// 	if err != nil {
// 		log.Fatal(err)
// 	}
// 	defer file.Close()

// 	for _, point := range points {
// 		fmt.Fprintf(file, "%.6f %.6f %.6f\n", point.X, point.Y, point.Z)
// 	}
// }

// // computes the distance between points p1 and p2
// func (p1 *Point3D) GetDistance(p2 *Point3D) float64 {
// 	dx := p1.X - p2.X
// 	dy := p1.Y - p2.Y
// 	dz := p1.Z - p2.Z
// 	return math.Sqrt(dx*dx + dy*dy + dz*dz)
// }

// // computes the plane defined by a slice of 3 points
// func GetPlane(points []Point3D) Plane3D {
// 	if len(points) < 3 {
// 		log.Fatal("Cannot compute plane with less than 3 points")
// 	}

// 	p1, p2, p3 := points[0], points[1], points[2]

// 	// compute the plane normal
// 	ux, uy, uz := p2.X-p1.X, p2.Y-p1.Y, p2.Z-p1.Z
// 	vx, vy, vz := p3.X-p1.X, p3.Y-p1.Y, p3.Z-p1.Z
// 	nx, ny, nz := uy*vz-uz*vy, uz*vx-ux*vz, ux*vy-uy*vx
// 	magnitude := math.Sqrt(nx*nx + ny*ny + nz*nz)
// 	nx, ny, nz = nx/magnitude, ny/magnitude, nz/magnitude

// 	// compute the plane offset
// 	d := -(nx*p1.X + ny*p1.Y + nz*p1.Z)

// 	return Plane3D{A: nx, B: ny, C: nz, D: d}
// }

// // computes the number of required RANSAC iterations
// func GetNumberOfIterations(confidence float64, percentageOfPointsOnPlane float64) int {
// 	if percentageOfPointsOnPlane <= 0 || percentageOfPointsOnPlane >= 1 {
// 		log.Fatal("Percentage of points on plane must be between 0 and 1")
// 	}

// 	if confidence <= 0 || confidence >= 1 {
// 		log.Fatal("Confidence must be between 0 and 1")
// 	}

// 	inlierProbability := percentageOfPointsOnPlane * percentageOfPointsOnPlane
// 	return int(math.Log(1-confidence) / math.Log(1-inlierProbability))
// }

// // computes the support of a plane in a slice of points
// func GetSupport(plane Plane3D, points []Point3D, eps float64) Plane3DwSupport {
// 	var supportSize int
// 	for _, point := range points {
// 		if math.Abs(plane.A*point.X+plane.B*point.Y+plane.C*point.Z+plane.D) < eps {
// 			supportSize++
// 		}
// 	}
// 	return Plane3DwSupport{Plane3D: plane, SupportSize: supportSize}
// }

// // extracts the points that support the given plane
// // and returns them in a slice of points
// func GetSupportingPoints(plane Plane3D, points []Point3D, eps float64) []Point3D {
// 	var supportingPoints []Point3D
// 	for _, point := range points {
// 		if math.Abs(plane.A*point.X+plane.B*point.Y+plane.C*point.Z+plane.D) < eps {
// 			supportingPoints = append(supportingPoints, point)
// 		}
// 	}
// 	return supportingPoints
// }

// // creates a new slice of points in which all points
// // belonging to the plane have been removed
// func RemovePlane(plane Plane3D, points []Point3D, eps float64) []Point3D {
// 	var remainingPoints []Point3D
// 	for _, point := range points {
// 		if math.Abs(plane.A*point.X+plane.B*point.Y+plane.C*point.Z+plane.D) > eps {
// 			remainingPoints = append(remainingPoints, point)
// 		}
// 	}
// 	return remainingPoints
// }

// // RANSAC algorithm for plane fitting
// func RANSAC(points []Point3D, numIterations int, eps float64) Plane3D {
// 	var bestPlane Plane3D
// 	var maxSupportSize int

// 	// repeat for the specified number of iterations
// 	for i := 0; i < numIterations; i++ {
// 		// randomly select three points
// 		randomIndices := getRandomIndices(len(points), 3)
// 		randomPoints := []Point3D{points[randomIndices[0]], points[randomIndices[1]], points[randomIndices[2]]}

// 		// compute the plane defined by the random points
// 		plane := GetPlane(randomPoints)

// 		// compute the support of the plane in the point cloud
// 		support := GetSupport(plane, points, eps)

// 		// update the best plane if the support is larger
// 		if support.SupportSize > maxSupportSize {
// 			maxSupportSize = support.SupportSize
// 			bestPlane = support.Plane3D
// 		}
// 	}

// 	return bestPlane
// }

// // helper function to generate a slice of n unique random integers in the range [0, max)
// func getRandomIndices(max, n int) []int {
// 	m := make(map[int]bool)
// 	for len(m) < n {
// 		randIndex := rand.Intn(max)
// 		m[randIndex] = true
// 	}
// 	indices := make([]int, n)
// 	i := 0
// 	for k := range m {
// 		indices[i] = k
// 		i++
// 	}
// 	return indices
// }

// func main() {
// 	// read command line arguments
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
// }