func main() {
	points := []Point{{8, 1}, {3, 2}, {7, 4}, {6, 3}}

	var wg sync.WaitGroup
	wg.Add(len(points) * (len(points) - 1) / 2) // set the number of goroutines to wait for

	for i := 0; i < len(points); i++ {
		for j := i + 1; j < len(points); j++ {
			wg.Add(1) // add a goroutine to the wait group
			go func(p1, p2 Point) {
				midPoint, length := MidPoint(p1, p2)
				fmt.Printf("Points: (%v,%v) (%v,%v)\n", p1.x, p1.y, p2.x, p2.y)
				fmt.Printf("MidPoint= (%v, %v)\n", midPoint.x, midPoint.y)
				fmt.Printf("Length= %.2f\n", length)
				wg.Done() // signal completion of goroutine
			}(points[i], points[j])
		}
	}

	wg.Wait() // wait for all goroutines to complete
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
