

object Euler027_QuadraticPrimes extends App {
   val rangeA = (-9 to 9)
   val rangeB = (-9 to 9)
   val rangeN = (39 to 39)
   
   def quadratic(n: Int, a: Int, b: Int): Int =  n*n + a*n + b

   
   var result = 0
   rangeN.foreach { n => result = quadratic(n, 1, 41); println(n + " gives " + result)}

}