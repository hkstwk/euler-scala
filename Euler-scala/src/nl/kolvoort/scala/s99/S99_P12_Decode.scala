package nl.kolvoort.scala.s99


object S99_P12_Decode {
  val ls = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))
  
  def decode[A](ls : List[(Int, A)]) : List[Any] = 
    ls flatMap { x => make(x._1, x._2) }
  
  def make[A](t : Int, li: A) : List[A] = {
    var l = List[A]()
    var a = 0
    for (a <- 1 to t) {
      l = li :: l
    } 
    return l
  }
  
  def main(args: Array[String]): Unit = {
    println(decode(ls))
  }
}