package main

import (
	"fmt"
	"io/ioutil"
	"strconv"
	"strings"
)

func main() {
	input := readInput("input.txt")
	wires := mapToSlice(input)
	points := mapToPoints(wires)

	for i := range points {
		fmt.Println(points[i])
		fmt.Println()
	}
}

func readInput(fileName string) []string {
	data, err := ioutil.ReadFile(fileName)
	if err != nil {
		fmt.Println("File reading error", err)
		return nil
	}
	return strings.Split(string(data), "\n")
}

func mapToSlice(wires []string) [][]string {
	var s [][]string
	for i := range wires {
		s = append(s, split(wires[i]))
	}
	return s
}

func split(wire string) []string {
	return strings.Split(wire, ",")
}

func mapToPoints(wires [][]string) [][]Point {
	var p [][]Point
	for i := range wires {
		p = append(p, calculatePoints(wires[i]))
	}
	return p
}

func calculatePoints(wire []string) []Point {
	points := []Point{Point{X: 0, Y: 0}}
	for i := range wire {
		distance, err := strconv.ParseInt(wire[i][1:len(wire[i])], 10, 64)
		if err != nil {
			fmt.Println("point conversion error", err)
			return nil
		}
		points = append(points, nextPoint(points[i], wire[i][0:1], int(distance)))
	}
	return points
}

func nextPoint(point Point, direction string, distance int) Point {
	switch direction {
	case "L":
		return Point{X: point.X - distance, Y: point.Y}
	case "R":
		return Point{X: point.X + distance, Y: point.Y}
	case "U":
		return Point{X: point.X, Y: point.Y + distance}
	case "D":
		return Point{X: point.X, Y: point.Y - distance}
	}
	return point
}

type Point struct {
	X int
	Y int
}
