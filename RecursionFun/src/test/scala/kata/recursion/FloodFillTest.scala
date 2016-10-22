package kata.recursion

import org.scalatest._

class FloodFillTest extends FlatSpec with Matchers with BeforeAndAfter with PrivateMethodTester {

  val WikiStringArea =
    """
      |1 1 1 1 1 1 1 1 1
      |1 0 0 0 1 0 0 0 1
      |1 0 0 0 1 0 0 0 1
      |1 0 0 1 0 0 0 0 1
      |1 1 1 0 0 0 1 1 1
      |1 0 0 0 0 1 0 0 1
      |1 0 0 0 1 0 0 0 1
      |1 0 0 0 1 0 0 0 1
      |1 1 1 1 1 1 1 1 1
    """.stripMargin.trim

  val FloodFilledWikiStringArea =
    """
      |1 1 1 1 1 1 1 1 1
      |1 0 0 0 1 2 2 2 1
      |1 0 0 0 1 2 2 2 1
      |1 0 0 1 2 2 2 2 1
      |1 1 1 2 2 2 1 1 1
      |1 2 2 2 2 1 0 0 1
      |1 2 2 2 1 0 0 0 1
      |1 2 2 2 1 0 0 0 1
      |1 1 1 1 1 1 1 1 1
    """.stripMargin.trim

  val SimpleStringArea =
    """
      |1 1 0 0
      |1 1 0 0
      |1 1 0 0
      |1 1 0 0
    """.stripMargin.trim

  val FloodFilledSimpleStringArea =
    """
      |1 1 2 2
      |1 1 2 2
      |1 1 2 2
      |1 1 2 2
    """.stripMargin.trim

  "to vector" should "return area as vector." in {
    Area(SimpleStringArea).toArray shouldBe Array(Array(1, 1, 0, 0), Array(1, 1, 0, 0), Array(1, 1, 0, 0), Array(1, 1, 0, 0))
  }

  "to string" should "return area as string." in {
    Area(SimpleStringArea).toString shouldBe SimpleStringArea
  }

  "flood fill" should "return updated simple area." in {
    val area = Area(SimpleStringArea)
    FloodFill().fill(area, Point(0, 2),  0, 2)
    area should be (Area(FloodFilledSimpleStringArea))
  }

  "flood fill" should "return updated wiki area." in {
    val area = Area(WikiStringArea)
    FloodFill().fill(area, Point(1, 5),  0, 2)
    area should be (Area(FloodFilledWikiStringArea))
  }

}

