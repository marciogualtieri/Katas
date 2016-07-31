package kata.mergesort

import scala.collection.mutable.ListBuffer

class MergeSort {
  def sort(array: Array[Int]): Array[Int] = {
    val sorted = sort(array.toList)
    sorted.toArray
  }

  private def sort(list: List[Int]): List[Int] = {
    if (list.length > 1) {
      val sorted = ListBuffer[Int]()
      val left = ListBuffer[Int](sort(list.dropRight(list.length - list.length / 2)): _ *)
      val right = ListBuffer[Int](sort(list.drop(list.length / 2)): _ *)
      while (left.length > 0 && right.length > 0) {
        if (left(0) < right(0)) {
          sorted += left(0)
          left.remove(0)
        } else {
          sorted += right(0)
          right.remove(0)
        }
      }
      if (left.size > 0) sorted.appendAll(left)
      if (right.size > 0) sorted.appendAll(right)
      sorted.toList
    } else {
      list
    }
  }

}

object MergeSort {
  def apply(): MergeSort = new MergeSort
}