

import java.util.NoSuchElementException

object NinetyNineScalaProblems {
  val p01_l1 = List(1,1,2,3,885,8)
  val p01_l2 = List("Hello", "World")
  val p01_l3 = List("One item List")
  
  def findLast[A](ls: List[A]) : A = ls match {
    case h :: Nil => h
    case h :: t => findLast(t)
    case _ => throw new NoSuchElementException("Not a list or empty List")
  }
  
  def penultimate[A](ls: List[A]) : A = ls match {
    case h :: _ :: Nil => h
    case _ :: tail => penultimate(tail)
    case _ => throw new NoSuchElementException
  }
  
  def main(args: Array[String]): Unit = {
    println(p01_l1.last)
    println(findLast(p01_l1))
    println(findLast(p01_l2))
    
    println(p01_l1.init.last)
    println(penultimate(p01_l1))
    println(penultimate(p01_l2))
    println(penultimate(p01_l3))
  }
}