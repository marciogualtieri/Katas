package fizzbuzz_lib

import (
	"strconv"
)

func GetResult(number int) string {
	result := ""
	if number % 3 == 0 {
		result = "Fizz"
	}
	if number % 5 == 0 {
		result += "Buzz"
	}
	if result == "" {
		result = strconv.Itoa(number)
	}
	return result
}
