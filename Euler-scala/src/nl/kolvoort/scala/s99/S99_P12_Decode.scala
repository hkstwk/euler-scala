package nl.kolvoort.scala.s99


object S99_P12_Decode {
  val ls = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))
  
  def decode[A](ls : List[(Int, A)]) : List[A] = 
    ls flatMap { x => make(x._1, x._2) }
  
  def make[A](t : Int, li: A) : List[A] = {
    
    def makeHelper[A](n: Int, t: Int, c: A, result : List[A]) : List[A] = n match {
      case t => result
      case _ => makeHelper(n+1, t, c, c :: result)
    }
    
    makeHelper(0, t, li, List())
  }
  
  def main(args: Array[String]): Unit = {
    println(decode(ls))
  }
}