

import java.util.NoSuchElementException

object NinetyNineScalaProblems {
  val ls1 = List(1,1,2,3,885,8)
  val ls2 = List("Hello", "World")
  val ls3 = List("One item List","")
  
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
  
  def findNth[A](n: Int, ls: List[A]) : A = (n, ls) match {
    case (0, h :: _) => h
    case (n, _ :: tail) => findNth(n-1, tail)
    case (_, Nil) => throw new NoSuchElementException
  }
  
  def getLength[A](n: Int, ls : List[A]) : Int = ls match {
    case Nil => n
    case head :: tail => getLength(n+1, tail) 
  }
  
  def reverseList[A](ls: List[A]) : List[A] = ls match {
    case head :: tail => reverseList(tail) ::: List(head)
    case Nil => Nil  
  }
  
  def isPalindrome[A](ls: List[A]) : Boolean = ls == ls.reverse 
  
  def flatten(ls: List[Any]) : List[Any] = ls flatMap {
    case ms : List[_] => flatten(ms)
    case e => List(e)
  }
  
  def main(args: Array[String]): Unit = {
    //p01 Find the last element of a list.
    println(ls1.last)
    println(findLast(ls1))
    println(findLast(ls2))
    
    //p02 Find the last but one element of a list.
    println(ls1.init.last)
    println(penultimate(ls1))
    println(penultimate(ls2))
    println(penultimate(ls3))
    
    //p03 Find the Kth element of a list.
    println(ls1.apply(3)) // 4th element
    println(ls1(1)) // 2nd element
    println(findNth(3, ls1))
    println(findNth(1, ls1))
    println(findNth(0, List(999)))
    println(findNth(1, List("","")))
    
    //p04 Find the number of elements of a list.
    println(ls1.length)
    println(ls2.length)
    println(getLength(0, ls1))
    println(getLength(0, ls2))
    println(getLength(0, List(1, 2, 3, 4, 5 ,6 ,7 , 8, 9)))
    
    //p05 Reverse a list.
    println(ls1.reverse)
    println(reverseList(ls1))
    println(List(1,2) ::: List(3)) 
    
    //P06 Find out whether a list is a palindrome.
    println(isPalindrome(List(1,2,3,2,1)))
    println(isPalindrome(List(1,2,3,3,1)))
    println(isPalindrome(List("hello","world","hello")))
    
    //P07 Flatten a nested list structure.
    // <scala> flatten(List(List(1, 1), 2, List(3, List(5, 8))))
    // res0: List[Any] = List(1, 1, 2, 3, 5, 8)
    val ls4 = List(List(1, 1), 2, List(3, List(5, 8)))
    println(flatten(ls4))
    
  }
}