package fizzbuzz_lib

import (
	"testing"
	"strconv"
)

 func TestFizz(t *testing.T) {
	 var number int = 3
	 if GetResult(number) != "Fizz" {
		 t.Errorf("%d should be Fizz", number)
	 }
 }

func TestBuzz(t *testing.T) {
	var number int = 5
	if GetResult(number) != "Buzz" {
		t.Errorf("%d should be Buzz", number)
	}
}

func TestFizzBuzz(t *testing.T) {
	var number int = 3 * 5
	if GetResult(number) != "FizzBuzz" {
		t.Errorf("%d should be FizzBuzz", number)
	}
}

func TestNumber(t *testing.T) {
	var number int = 2
	if GetResult(number) != strconv.Itoa(number) {
		t.Errorf("%d should be \"%d\"", number, number)
	}
}
