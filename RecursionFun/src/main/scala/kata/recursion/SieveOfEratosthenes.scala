package kata.recursion

class SieveOfEratosthenes {

  def primes(): Stream[Int] = {

    def from(first: Int): Stream[Int] = first #:: from(first + 1)

    def sievePrimes(numbers: Stream[Int]): Stream[Int] =
      numbers.head #:: sievePrimes(numbers.tail.filter(_ % numbers.head != 0))

    sievePrimes(from(2))
  }
}

object SieveOfEratosthenes {
  def apply(): SieveOfEratosthenes = new SieveOfEratosthenes
}

