

object Euler031 {

  def f(ms: List[Int], n: Int): Int = ms match {
    case h :: t =>
      //println(h + " " + t)
      if (h > n) {
        //println("\n"  + ms + ", " + n) 
        //println("result = 0, because h = " + h + " and greater than " + n)
        0 
      } else if (n == h) {
        //println("\n" + ms + ", " + n) 
        //println("result = 1, because h = " + h + " = n")
        1 
      } else { 
        //println("\n" + ms + ", " + (n-h) + ")" 
        //    + " + " + t + ", " + n + ")\n" )
        f(ms, n - h) + f(t, n)
      }
    case _ => 
      //println("default = 0")
      0
  }

  def main(args: Array[String]): Unit = {
    val l = List(1, 2, 5, 10, 20, 50, 100, 200)
    val l1 = List(1, 2, 5)
    val n = 200
    println(l + " " + n + ")\n" )
    val r = f(l, n)
    println("\n" + r)
  }
}