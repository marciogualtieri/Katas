package kata.recursion

import org.scalatest._

class CombinatorialTest extends FlatSpec with Matchers with BeforeAndAfter {

  "3 choose 2" should "be return the correspondent combinations." in {
    Combinatorial().choose(2, Set(1, 2, 3)) shouldBe Set(Set(1, 2), Set(1, 3),
                                                         Set(2, 3))
  }

  "4 choose 2" should "be return the correspondent combinations." in {
    Combinatorial().choose(2, Set(1, 2, 3, 4)) shouldBe Set(Set(1, 2), Set(1, 3), Set(1, 4),
                                                            Set(2, 3), Set(2, 4),
                                                            Set(3, 4))
  }

}