package kata.recursion

case class Point(x: Int, y: Int) {
  def +(point: Point): Point = Point(this.x + point.x, this.y + point.y)

}

case class Area(stringArea: String) {

  private val arrayArea = stringArea.split("\n").map(_.split(" ").map(_.toInt))

  def contains(point: Point): Boolean =
    point.x >= 0 && point.x < arrayArea.length &&
    point.y >= 0 && point.y < arrayArea(0).length

  def getColorFor(point: Point): Int = arrayArea(point.x)(point.y)

  def setColorFor(point: Point, color: Int): Unit = arrayArea(point.x)(point.y) = color

  def toArray: Array[Array[Int]] = arrayArea

  override def toString = arrayArea.map(_.mkString(" ")).mkString("\n")

  override def equals(that: Any): Boolean =
    that match {
      case that: Area => arrayArea.deep == that.toArray.deep
      case _ => false
    }

}

class FloodFill {

  private val Moves = List(Point(1, 0), Point(-1, 0), Point(0, 1), Point(0, -1))

  def fill(area: Area, point: Point, oldColor: Int, newColor: Int): Unit = {

    val neighbors = Moves.map(move => point + move).filter(area.contains)

    if (area.getColorFor(point) == oldColor) {
      area.setColorFor(point, newColor)
      neighbors.foreach(neighbor => fill(area, neighbor, oldColor, newColor))
    }
  }

}

object FloodFill {
  def apply(): FloodFill = new FloodFill

}


