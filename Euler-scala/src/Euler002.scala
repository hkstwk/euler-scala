

object Euler002 {
  def main(args: Array[String]){
    var sum = 2
    var fib1 = 1
    var fib2 = 2
    var tmp = 0
    while (fib1 < 4000000 && fib2 < 4000000) { 
      tmp = fib2
      fib2 = fib2 + fib1
      fib1 = tmp
      if (fib2%2==0) sum += fib2
    }
    println(sum)
  }
}
