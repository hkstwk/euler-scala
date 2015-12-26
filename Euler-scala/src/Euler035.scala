object Euler035 {

   def isPrime(n: Int) : Boolean = {
     var result = true
     for (i: Int <- 2 to Math.sqrt(n).intValue()){
       if (n%i == 0)
         return false
     }
     return result
   } 

   def rotations(num: Int) = {
     def rotationHelper(str: String, times: Int): List[String] = {
       if (times == 1) List(str)
       else str :: rotationHelper(str.tail + str.head, times - 1)
     }
     val numString = num.toString
     rotationHelper(numString, numString.length).map(_.toInt)
   }
   
   def isCircularPrime(l : List[Int]) : Boolean = {
     val primesOrNot = l.filter { x =>isPrime(x) }
     if ( primesOrNot.length < l.length) false
     else true
   }

   def getCircularPrimes(n: Int) {
     println("\n----")
     val start = System.nanoTime
     println("Started at " + start/1e6+"ms")
     
     val result = (2 to n).filter(isPrime(_)).map(rotations(_)).filter(isCircularPrime(_))
     result.foreach { x => println(x) }
     println("Number of circular primes under " + n  + " = "  + result.length)
     
     val stop = System.nanoTime()
     println("Stopped at " + stop/1e6+"ms")
     println("Elapsed time = "+(System.nanoTime-start)/1e6+"ms")
     println("----\n")
   }
   
   def main(args: Array[String]): Unit = {
     val n = 1000000
     getCircularPrimes(n)
   }
}