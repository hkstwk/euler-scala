

object Euler010 {
  
  def isPrime(n: Int) : Boolean = {
    var result = true
    for (i: Int <- 2 until Math.sqrt(n).intValue()){
      if (n%i == 0)
        result = false
    }
    return result
  } 

  def main(args: Array[String]){
    var sum : Long = 0
    for (getal: Int <- 2 until 2000000){
      if (isPrime(getal))
        sum += getal
    }
    println(sum);
  }
}