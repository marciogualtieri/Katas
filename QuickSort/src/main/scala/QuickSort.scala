package kata.quicksort

class QuickSort {
  def sort(array: Array[Int]): Array[Int] = {
    val sorted = array.clone()
    sort(sorted, 0, array.length - 1)
    sorted
  }

  private def sort(array: Array[Int], low: Int, high: Int): Unit = {
    if (high > low) {
      val pivot = partition(array, low, high)
      sort(array, low, pivot - 1)
      sort(array, pivot + 1, high)
    }
  }

  private def partition(array: Array[Int], low: Int, high: Int) = {
    var pivot = low
    for(index <- low + 1 to high) {
      if(array(index) <= array(pivot)) {
        swap(array, index, pivot + 1)
        swap(array, pivot + 1, pivot)
        pivot += 1
      }
    }
    pivot
  }

  private def swap(array: Array[Int], one: Int, other: Int) = {
    val tmp = array(one)
    array(one) = array(other)
    array(other) = tmp
  }
}

object QuickSort {
  def apply(): QuickSort = new QuickSort
}