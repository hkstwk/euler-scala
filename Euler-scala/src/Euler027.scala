

object Euler027 {
  
  
  
  val ps = for {
    a <- -79 to -79; b <- 1601 to 1601
      val r = for { 
        n <- 0 to 79 
        r = n*n + a*n + b
      } yield r
    } yield r
  
  def main(args: Array[String]): Unit = {
    val r1 = ps(0).length
    println(r1)
  }
}