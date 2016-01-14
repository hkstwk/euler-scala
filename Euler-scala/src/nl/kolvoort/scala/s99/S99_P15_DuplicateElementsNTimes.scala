package nl.kolvoort.scala.s99

object S99_P15_DuplicateElementsNTimes {
  
  /* 
   * Example
   * scala> duplicate(List('a, 'b, 'c, 'c, 'd))
   * res0: List[Symbol] = List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)
  */
  
  val ls = List(1, 2, 3, 4, 5)
  
  def duplicateNTimes[A](times: Int, ls: List[A]) : List [A] = ls flatMap { e => List.fill(times)(e) }
  
  def main(args: Array[String]): Unit = {
    println(duplicateNTimes(10,ls))
  }
}