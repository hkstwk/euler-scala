package nl.kolvoort.scala.s99

object S99_P09_PackDuplicates {
  // If a list contains repeated elements they should be placed in separate sublists.  
  
  val ls = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
  val ls1 = List(1,1,1,1,2,3,6,6,6,3,1,1,4,5,5,5,5)
  
  
  def pack[A](ls: List[A]) : List[List[A]] = {
    if (ls.isEmpty) List(List())
    else {
      val (packed, next) = ls span (_ == ls.head)
      println("packed = " + packed)
      println("next   = " + next)
      if (next == Nil) List(packed)
      else packed :: pack(next)
    }
  }
   
  def main(args: Array[String]): Unit = {
    println(pack(ls1))
  }
}