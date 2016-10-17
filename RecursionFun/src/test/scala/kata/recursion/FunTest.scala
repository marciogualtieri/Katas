package kata.recursion

import org.scalatest._

class FunTest extends FlatSpec with Matchers with BeforeAndAfter with PrivateMethodTester {

  "Recursive Factorial calls" should "be successful." in {
    someFactorialCalls(Fun().recursiveFactorial)
  }

  "Imperative Factorial calls" should "be successful." in {
    someFactorialCalls(Fun().imperativeFactorial)
  }

  "Tail Recursive Factorial calls" should "be successful." in {
    someFactorialCalls(Fun().tailRecursiveFactorial)
  }

  def someFactorialCalls(f: Int => Int) = {
    f(0) shouldBe 1
    f(1) shouldBe 1
    f(2) shouldBe 2
    f(3) shouldBe 6
    f(4) shouldBe 24
    f(5) shouldBe 120
  }

  "Recursive Fibonacci calls" should "be successful." in {
    someFibonacciCalls(Fun().recursiveFibonacci)
  }

  "Imperative Fibonacci calls" should "be successful." in {
    someFibonacciCalls(Fun().imperativeFibonacci)
  }

  "Tail Recursive Fibonacci calls" should "be successful." in {
    someFibonacciCalls(Fun().tailRecursiveFibonacci)
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
