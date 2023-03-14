package main

import (
	"math/rand"
	"sync"
)

// Point3D represents a 3D point.
type Point3D struct {
	X float64
	Y float64
	Z float64
}

// Plane3D represents a 3D plane defined by its equation: Ax + By + Cz + D = 0.
type Plane3D struct {
	A float64
	B float64
	C float64
	D float64
}

// Point3DwSupport represents a 3D plane and the number of supporting points in a point cloud.
type Point3DwSupport struct {
	Plane      Plane3D
	Supporting int
}

// RandomPointGenerator randomly selects a point from the provided slice of Point3D.
func RandomPointGenerator(input <-chan []Point3D, output chan<- Point3D) {
	for points := range input {
		// Select a random point from the slice
		randomIndex := rand.Intn(len(points))
		randomPoint := points[randomIndex]

		// Send the random point to the output channel
		output <- randomPoint
	}
	close(output)
}

// TripletGenerator reads Point3D instances from its input channel and accumulates 3 points.
// Its output channel transmits arrays of Point3D (composed of three points).
func TripletGenerator(input <-chan Point3D, output chan<- [3]Point3D) {
	var triplet [3]Point3D
	index := 0

	for point := range input {
		// Add the point to the triplet array
		triplet[index] = point
		index++

		if index == 3 {
			// Send the triplet to the output channel
			output <- triplet

			// Reset the triplet and index
			triplet = [3]Point3D{}
			index = 0
		}
	}
	close(output)
}

// TakeN reads arrays of Point3D and resend them. It automatically stops the pipeline after having received N arrays.
func TakeN(input <-chan [3]Point3D, output chan<- [3]Point3D, N int) {
	i := 0
	for triplet := range input {
		output <- triplet
		i++
		if i == N {
			close(output)
			break
		}
	}
}

// PlaneEstimator reads arrays of three Point3D and compute the plane defined by these points.
// Its output channel transmits Plane3D instances describing the computed plane parameters.
func planeEstimator(input <-chan [3]Point3D) <-chan Plane3D {
	output := make(chan Plane3D)
	go func() {
		defer close(output)
		for triplet := range input {
			p1 := triplet[0]
			p2 := triplet[1]
			p3 := triplet[2]
			a := p1.Y*(p2.Z-p3.Z) + p2.Y*(p3.Z-p1.Z) + p3.Y*(p1.Z-p2.Z)
			b := p1.Z*(p2.X-p3.X) + p2.Z*(p3.X-p1.X) + p3.Z*(p1.X-p2.X)
			c := p1.X*(p2.Y-p3.Y) + p2.X*(p3.Y-p1.Y) + p3.X*(p1.Y-p2.Y)
			d := -p1.X*(p2.Y*p3.Z-p3.Y*p2.Z) - p2.X*(p3.Y*p1.Z-p1.Y*p3.Z) - p3.X*(p1.Y*p2.Z-p2.Y*p1.Z)
			output <- Plane3D{a, b, c, d}
		}
	}()
	return output
}


func SupportingPointFinder(plane Plane3D, points []Point3D) Plane3DwSupport {
	var supportingPoints []Point3D
	for _, point := range points {
		if GetDistance(plane, point) < eps {
			supportingPoints = append(supportingPoints, point)
		}
	}
	return Plane3DwSupport{plane, len(supportingPoints)}
}

func FanIn(ins <-chan Plane3DwSupport) <-chan Plane3DwSupport {
	out := make(chan Plane3DwSupport)
	var wg sync.WaitGroup
	wg.Add(len(ins))
	for _, in := range ins {
		go func(in <-chan Plane3DwSupport) {
			defer wg.Done()
			for support := range in {
				out <- support
			}
		}(in)
	}
	go func() {
		wg.Wait()
		close(out)
	}()

}
