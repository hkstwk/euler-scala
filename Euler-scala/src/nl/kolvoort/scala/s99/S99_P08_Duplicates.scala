package nl.kolvoort.scala.s99

object S99_P08_Duplicates {
  
	val ls = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
  
	// standard function distinct. Nice but not the expected result
  // This wrapper function is just for practice purposes but doesn't make much sense of course
  def distinct[A](ls: List[A]): List[A] = ls.distinct
  
  // Eliminate consecutive duplicates of list elements.
  // If a list contains repeated elements they should be replaced with a single copy of the element. 
  // The order of the elements should not be changed.
  def duplicates[A](ls: List[A]) : List[A] = ls match {
	  case Nil => Nil
	  case head :: tail => head :: duplicates(tail dropWhile { x => x == head } )
  }
	
	def duplicatesReverse[A](ls: List[A]) : List[A] = ls match {
	  case Nil => Nil
	  case head :: tail => duplicatesReverse(tail dropWhile { x => x == head }) ::: List(head)
  }
  
  
  def main(args: Array[String]): Unit = {
    println(ls)
    println(distinct(ls)) 
    println(duplicates(ls))
    println(duplicatesReverse(ls))
  }
}