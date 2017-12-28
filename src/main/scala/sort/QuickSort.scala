package sort

/**
  * 快速排序。 一个scala基本知识的应用
  */
class QuickSort {
  def sort(list: List[Int]): List[Int] = {
    if (list.length < 2)
      list
    else
      return sort(list.filter(list.head > _)) ++ //3个List的相加
        List(list.head) ++
        sort(list.filter(list.head < _))
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    val sortList = new QuickSort().sort(List(6, 5, 4, 8, 2, 9))
    println(sortList)
  }
}