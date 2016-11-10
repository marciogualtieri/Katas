package kata.recursion

import org.scalatest._

class SieveOfEratosthenesTest extends FlatSpec with Matchers with BeforeAndAfter {

  "Sieve of Eratosthenes" should "return first N prime numbers." in {
    SieveOfEratosthenes().primes().take(4) shouldBe List(2, 3, 5, 7)
  }

}

