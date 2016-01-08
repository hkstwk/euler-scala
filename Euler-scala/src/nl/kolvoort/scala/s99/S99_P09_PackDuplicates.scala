package nl.kolvoort.scala.s99

object S99_P09_PackDuplicates {
  // If a list contains repeated elements they should be placed in separate sublists.  
  
  val ls = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
  
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
    println(pack(ls))
  }
}