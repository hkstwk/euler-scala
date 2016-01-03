

object Euler032 {
  val ms = for {
    a <- 1 to 10000; b <- 1 to 10000 / a
    m = a * b; s = a.toString + b + m
    if s.length == 9 && (1 to 9).mkString.forall(s.contains(_))
  } yield m

  def main(args: Array[String]): Unit = {
    println((1 to 9).mkString)
    val r1 = ms.distinct
    println(r1)
    val r2 = r1.sum
    println(r2)
    assert(r2 == 45228) // 73 ms
  }
}