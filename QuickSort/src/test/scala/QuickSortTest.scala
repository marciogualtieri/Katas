package kata.quicksort

import org.scalatest._

class QuickSortTest extends FlatSpec with Matchers with BeforeAndAfter with PrivateMethodTester {

  "Input array" should "be sorted." in {
    val input = Array(10, 9, 8, 7, 6, 5, 4, 3, 2, 1)
    val quickSort = QuickSort()
    quickSort.sort(input) should be (Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
  }
}