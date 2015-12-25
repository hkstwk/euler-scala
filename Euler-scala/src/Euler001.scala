

object Euler001 {
  def main(args: Array[String]){
    var sum = 0
    for (n <- 1 until 1000 ; if n%3==0 || n%5==0)
        sum += n
    println(sum)
  }
}