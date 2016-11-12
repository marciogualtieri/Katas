package kata.recursion

class Combinatorial {

  def choose[T](elems: Set[T], k: Int): Set[Set[T]] = {
    if (k > elems.size) Set()
    else if (k == 1) elems.map(Set(_))
    else choose(elems.tail, k - 1).map(_ + elems.head) ++ choose(elems.tail, k)
  }

  def choose[T](n: Int, k: Int): Int = {
    if (k > n) 0
    else if (k == 1) n
    else choose(n - 1, k - 1) + choose(n - 1, k)
  }
}

object Combinatorial {
  def apply(): Combinatorial = new Combinatorial
}

