package kata.recursion

class Fibonacci {

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

object Fibonacci {
  def apply(): Fibonacci = new Fibonacci
}


