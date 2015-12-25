

// A comment
/* Another comment */
/** A documentation comment */
object FPinScala2 {
  def abs(n: Int): Int =
    if (n < 0) -n
    else n
    
  private def formatAbs(x: Int) = {
    val msg = "The absolute value of %d is %d"
    msg.format(x, abs(x))
  }
  
  def formatResult(name: String, n: Int, f: Int => Int) = {
    val msg = "The %s of %d is %d."
    msg.format(name, n, f(n))
  }
  
  def factorial(n: Int): Int = {
    def go(n: Int, acc: Int): Int = {
      println(n + " * " + acc)
      if (n <= 0) acc
      else go(n-1, n*acc)
    }
    go(n, 1) 
  }
 
  def fib3( n : Int) : Int = { 
    def fib_tail( n: Int, a:Int, b:Int): Int = n match {
      case 0 => a; 
      case _ => println(n + " " + a + " " + b); fib_tail( n-1, b, a+b )
    }
    fib_tail( n, 0, 1)
  }
  
  def binarySearchInt(ds: Array[Int], key: Int): Int = {
    @annotation.tailrec
    def go(low: Int, mid: Int, high: Int): Int = {
      if (low > high) -mid - 1
      else {
        val mid2 = (low + high) / 2
        val d = ds(mid2)
        if (d == key) mid2
        else if (d > key) go(low, mid2, mid2-1)
        else go(mid2 + 1, mid2, high)
      } 
    }
    go(0, 0, ds.length - 1)
  }
  
    def binarySearchString(ds: Array[String], key: String): Int = {
    @annotation.tailrec
    def go(low: Int, mid: Int, high: Int): Int = {
      if (low > high) -mid - 1
      else {
        val mid2 = (low + high) / 2
        val d = ds(mid2)
        if (d == key) mid2
        else if (d > key) go(low, mid2, mid2-1)
        else go(mid2 + 1, mid2, high)
      } 
    }
    go(0, 0, ds.length - 1)
  }
 
  def gt1(a:Int, b:Int) : Boolean = {
    if (a>b) true else false
  }
  
  def gt2(a: String, b: String) : Boolean = {
    if (a>b) true else false
  }
  
  def gt[A](x: A, y: A) : Boolean = {
    //if (x>y) true else false
    true
  }
  
  
  
  def binarySearch[A](as: Array[A], key: A, gt: (A,A) => Boolean): Int = {
    @annotation.tailrec
    def go(low: Int, mid: Int, high: Int): Int = {
      if (low > high) -mid - 1
      else {
        val mid2 = (low + high) / 2
        val a = as(mid2)
             val greater = gt(a, key)
        if (!greater && !gt(key,a)) mid2
          else if (greater) go(low, mid2, mid2-1)
          else go(mid2 + 1, mid2, high)
      } 
    }
    go(0, 0, as.length - 1)
  }
  
  val intList = List(-15,-14,-13,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20)
  val strList = List("Bea", "Charlotte", "Harm", "Joost")
  
  def main(args: Array[String]): Unit = {
    println(formatResult("absolute value", -99, abs))
    println(formatResult("fibonacci number", 7, fib3))
    println(formatResult("factorial", 7, factorial))
    println(binarySearch(intList.toArray,-13, gt1))
    println(binarySearch(intList.toArray,20, gt1))
    println(binarySearch(strList.toArray,"Harm", gt2))

  }
}
