package nl.kolvoort.scala.s99

object S99_P10_RunLengthEncoding_Enhanced {
  
  // Modified run-length encoding.
  // Modify the result of problem P10 in such a way that if an element has no duplicates it is simply copied into the result list. Only elements with duplicates are transferred as (N, E) terms.
  // Example:
  //
  // scala> encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  // res0: List[Any] = List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e))
  
  val ls = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
  
  import S99_P10_RunLengthEncoding.encode
  
  def encodeModified[A](ls : List[A]): List[Any] = ls match {
    case Nil => List()
    case h :: t => {
      val (front, back) = ls span (_ == h) 
      if (front.size == 1) 
        h :: encodeModified(back)
      else (front.size, h) :: encodeModified(back)
          
    }
  }
  
  def encodeModified2[A](ls : List[A]) : List[Any] = {
    encode(ls) map { t => if (t._1 == 1) t._2 else t }
  }
    
   
  def main(args: Array[String]): Unit = {
    println(encodeModified2(ls))
  }
  
}