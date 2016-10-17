package kata.recursion

class Fun {

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

  def recursiveFibonacci(n: Int): Int = ???

  def imperativeFibonacci(n: Int): Int = ???

  def tailRecursiveFibonacci(n: Int): Int = ???
}

object Fun {
  def apply(): Fun = new Fun
}

