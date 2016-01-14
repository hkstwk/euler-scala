package nl.kolvoort.scala.s99

object S99_P16_DropEveryN {
/*
 * Example:
 * scala> drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
 * res0: List[Symbol] = List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)
*/
  val ls = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)
  
  def dropNthElements[A](n: Int, ls: List[A]) : List [A] = ls filter { e => (ls.indexOf(e)+1) % n != 0  }
  
  def main(args: Array[String]): Unit = {
    println(dropNthElements(5,ls))
  }
}