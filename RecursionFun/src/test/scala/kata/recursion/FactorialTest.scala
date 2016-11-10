package kata.recursion

import org.scalatest._

class FactorialTest extends FlatSpec with Matchers with BeforeAndAfter {

  "Recursive Factorial calls" should "be successful." in {
    someFactorialCalls(Factorial().recursiveFactorial)
  }

  "Imperative Factorial calls" should "be successful." in {
    someFactorialCalls(Factorial().imperativeFactorial)
  }

  "Tail Recursive Factorial calls" should "be successful." in {
    someFactorialCalls(Factorial().tailRecursiveFactorial)
  }

  def someFactorialCalls(f: Int => Int) = {
    f(0) shouldBe 1
    f(1) shouldBe 1
    f(2) shouldBe 2
    f(3) shouldBe 6
    f(4) shouldBe 24
    f(5) shouldBe 120
  }
}
