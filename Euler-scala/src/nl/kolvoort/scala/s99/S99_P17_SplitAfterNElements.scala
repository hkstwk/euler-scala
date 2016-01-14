package nl.kolvoort.scala.s99

object S99_P17_SplitAfterNElements {
/*
 * Split a list into two parts.  * The length of the first part is given. Use a Tuple for your result.
 * Example:
 * scala> split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
 * res0: (List[Symbol], List[Symbol]) = (List('a, 'b, 'c),List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
*/
  val ls = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)
  
  def splitAfterN[A](n: Int, ls: List[A]) : (List[A], List [A]) = ls span { e => (ls.indexOf(e)) < n  }
  
  def main(args: Array[String]): Unit = {
    println(splitAfterN(12,ls))
    println(ls.splitAt(11))
  }
}