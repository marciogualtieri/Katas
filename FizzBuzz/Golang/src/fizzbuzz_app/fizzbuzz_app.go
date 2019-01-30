package main

import (
	"os"
	"fmt"
	"strconv"
	"fizzbuzz_lib"
)

func main() {
        number, err := strconv.ParseInt(os.Args[1], 10, 0)
	if err == nil {
		fmt.Printf("%d is %s\n", number, fizzbuzz_lib.GetResult(int(number)))
	} else {
		fmt.Printf("Syntax:\n    %s <integer number>\n\n", os.Args[0])
	}
}
