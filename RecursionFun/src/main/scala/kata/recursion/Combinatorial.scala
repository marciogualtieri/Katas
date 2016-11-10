package kata.recursion

class Combinatorial {

  def choose[T](k: Int, elems: Set[T]): Set[Set[T]] = {
    if (k > elems.size) Set()
    else if (k == 1) elems.map(Set(_))
    else choose(k - 1, elems.tail).map(_ + elems.head) ++ choose(k, elems.tail)
  }
}

object Combinatorial {
  def apply(): Combinatorial = new Combinatorial
}

