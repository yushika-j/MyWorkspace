package main

import (
	"fmt"
	"math/rand"
	"sync"
)

func RandomGenerator(wg *sync.WaitGroup, stop <-chan bool, m int) <-chan int {
	intStream := make(chan int)
	randStream := make(chan int, 1) // buffer the randStream channel to avoid deadlock

	go func() {
		defer wg.Done()
		defer close(intStream)

		for {
			select {
			case <-stop:
				close(randStream)
				return
			case num := <-randStream:
				if IsMultiple(num, m) {
					intStream <- num
				}
			default:
				randStream <- rand.Intn(1000)
			}
		}
	}()

	return intStream
}

func IsMultiple(x int, m int) bool {
	return x%m == 0
}

func main() {
	var wg sync.WaitGroup
	stop := make(chan bool)

	wg.Add(3)
	multiples5 := RandomGenerator(&wg, stop, 5)
	multiples13 := RandomGenerator(&wg, stop, 13)
	multiples97 := RandomGenerator(&wg, stop, 97)

	// use a buffered channel for receiving values asynchronously
	results := make(chan string, 100)

	go func() {
		for i := 0; i < 100; i++ {
			select {
			case n := <-multiples5:
				results <- fmt.Sprintf("%d is a multiple of 5", n)
			case n := <-multiples13:
				results <- fmt.Sprintf("%d is a multiple of 13", n)
			case n := <-multiples97:
				results <- fmt.Sprintf("%d is a multiple of 97", n)
			}
		}
		close(stop) // signal the goroutines to stop generating random numbers
	}()

	go func() {
		wg.Wait()
		close(results) // close the results channel when all goroutines have finished
	}()

	// read values from the results channel
	count5, count13, count97 := 0, 0, 0
	for result := range results {
		fmt.Println(result)
		switch {
		case result[len(result)-1] == '5':
			count5++
		case result[len(result)-2:] == "13":
			count13++
		case result[len(result)-2:] == "97":
			count97++
		}
	}

	fmt.Println("Total multiples of 5:", count5)
	fmt.Println("Total multiples of 13:", count13)
	fmt.Println("Total multiples of 97:", count97)
}
