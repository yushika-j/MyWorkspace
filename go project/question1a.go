// a) Créer la fonction MidPoint prenant en entrée deux Points définissant une ligne et qui
// effectue les calculs suivants :
// a. Les coordonnées du point milieu de cette ligne
// b. La longueur de cette ligne

package main

import (
	"fmt"
	"math"
)

type Point struct {
	x float64
	y float64
}

func main() {
	//points := []Point{{8., 1.}, {3., 2.}, {7., 4.}, {6., 3.}}
	p1 := Point{1, 2}
	p2 := Point{3, 2}
	midPoint, length := MidPoint(p1, p2)
	fmt.Printf("Points: (%v,%v) (%v,%v)\n", p1.x, p1.y, p2.x, p2.y)
	fmt.Printf("MidPoint= (%v, %v)\n", midPoint.x, midPoint.y)
	fmt.Printf("Length= %v\n", length)
	//fmt.Printf("Length= %.2f\n", length)
}

func MidPoint(p1 Point, p2 Point) (Point, float64) {

	midX := ((p1.x + p2.x) / 2)
	midY := ((p1.y + p2.y) / 2)
	midPoint := Point{midX, midY}

	length := math.Sqrt(math.Pow((p2.x-p1.x), 2) + math.Pow((p2.y-p1.y), 2))
	//round length to 2 decimal places
	length = math.Round(length*100) / 100

	return midPoint, length
}
