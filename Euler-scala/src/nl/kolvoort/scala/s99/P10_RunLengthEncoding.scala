package nl.kolvoort.scala.s99

object S99_P10_RunLengthEncoding {
  
  //  Use the result of problem P09 to implement the so-called run-length encoding data compression method. Consecutive duplicates of elements are encoded as tuples (N, E) where N is the number of duplicates of the element E.
  //  Example:
  //
  //  scala> encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  //  res0: List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))
  
  val ls = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
   
  def encode[A](ls : List[A]) : List[(Int, A)] = ls match {
    case Nil => List()
    case h :: t => {
      val (front, back) = ls span (_ == h)
      (front.size, h) :: encode(back)
    }
  }
   
  def main(args: Array[String]): Unit = {
    println(encode(ls))
  }
  
}