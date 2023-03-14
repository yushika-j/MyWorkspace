package main

import (
	"fmt"
	"sync"
)

func fct(line []float64) {
	for _, v := range line {
		fmt.Printf("%f, ", v)
	}
}

//CSI 2120 page 3

func fct2(matrix [][]float64) {
	matrix[2][0] = 12345.6
}

func main() {
	// Initialize 2D array
	array := [][]float64{{7.1, 2.3, 1.1},
		{4.3, 5.6, 6.8},
		{2.3, 2.7, 3.5},
		{4.5, 8.1, 6.6}}

	// Print input array
	fmt.Println("Input array:")
	for i := range array {
		fct(array[i])
	}

	// Sort rows of array
	sortRows(array)

	// Transpose array
	transpose(array)

	// Sort rows of transposed array
	sortRows(array)

	// Transpose array back to original form
	transpose(array)

	// Print output array
	fmt.Println("Output array:")
	for i := range array {
		fct(array[i])
	}
}

func sort(tab []float64) {
	for i := 0; i < len(tab); i++ {
		for j := 0; j < len(tab)-1-i; j++ {
			if tab[j] > tab[j+1] {
				tab[j], tab[j+1] = tab[j+1], tab[j]
			}
		}
	}
}

func transpose(tab [][]float64) [][]float64 {
	numRows := len(tab)
	numCols := len(tab[0])
	transposed := make([][]float64, numCols)
	for i := range transposed {
		transposed[i] = make([]float64, numRows)
	}
	for i, row := range tab {
		for j, val := range row {
			transposed[j][i] = val
		}
	}
	return transposed
}

func sortRow(tab [][]float64, rowIdx int, wg *sync.WaitGroup) {
	defer wg.Done()
	sort(tab[rowIdx])
}

func sortRows(tab [][]float64) {
	numRows := len(tab)
	var wg sync.WaitGroup
	for i := 0; i < numRows; i++ {
		wg.Add(1)
		go sortRow(tab, i, &wg)
	}
	wg.Wait()
}
