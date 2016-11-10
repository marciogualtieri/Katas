package kata.recursion

import org.scalatest._

class FibonacciTest extends FlatSpec with Matchers with BeforeAndAfter {

  "Recursive Fibonacci calls" should "be successful." in {
    someFibonacciCalls(Fibonacci().recursiveFibonacci)
  }

  "Imperative Fibonacci calls" should "be successful." in {
    someFibonacciCalls(Fibonacci().imperativeFibonacci)
  }

  "Tail Recursive Fibonacci calls" should "be successful." in {
    someFibonacciCalls(Fibonacci().tailRecursiveFibonacci)
  }

  def someFibonacciCalls(f: Int => Int) = {
    f(0) shouldBe 1
    f(1) shouldBe 1
    f(2) shouldBe 2
    f(3) shouldBe 3
    f(4) shouldBe 5
    f(5) shouldBe 8
    f(6) shouldBe 13
  }
}

