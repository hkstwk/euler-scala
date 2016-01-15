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
  
  def splitRecursive[A](n: Int, ls: List[A]) : (List[A], List[A]) = (n, ls) match {
    case (0, _) => {
      println((Nil, ls))
      (Nil, ls)
    }
    case (_, Nil) => {
      println((Nil, Nil))
      (Nil, Nil)
    }
    case (n, h :: t) => {
      print(n + "\t")
      println(h :: t)
      val (pre, post) = splitRecursive(n-1, t)
      print(h :: pre)
      println(" , " + post)
      ( h :: pre, post) 
    }
  }
  
  def main(args: Array[String]): Unit = {
    println(splitAfterN(12,ls))
    println(ls.splitAt(11))
    
    println(splitRecursive(5, ls))
  }
}