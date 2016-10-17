package kata.recursion

class Factorial {

  def recursiveFactorial(n: Int): Int =
    if (n == 0 || n == 1) 1
    else n * recursiveFactorial(n - 1)

  def imperativeFactorial(n: Int): Int = {
    var result = 1
    for (i <- 1 to n) {
      result *= i
    }
    result
  }

  def tailRecursiveFactorial(n: Int): Int = {
    def loop(i: Int, accumulator: Int): Int = {
      if (i > n) accumulator
      else loop(i + 1, i * accumulator)
    }
    loop(1, 1)
  }

  def recursiveFibonacci(n: Int): Int =
    if(n == 0 || n == 1) 1
    else recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2)

  def imperativeFibonacci(n: Int): Int = {
    var fib0 = 1
    var fib1 = 1
    for(i <- (2 to n)) {
      val tmp = fib1
      fib1 += fib0
      fib0 = tmp
    }
    fib1
  }

  def tailRecursiveFibonacci(n: Int): Int = {
    def loop(i: Int, fib0: Int, fib1: Int): Int = {
      if (i > n) fib1
      else loop(i + 1, fib1, fib0 + fib1)
    }
    loop(2, 1, 1)
  }
}

object Factorial {
  def apply(): Factorial = new Factorial
}

