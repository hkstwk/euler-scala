import scala.Stream
import scala.annotation.tailrec

object Sieve {
 
   def ints(n: Int): Stream[Int] = {
      require(n > 1)
      Stream.cons(n, ints(n+1))
   }
 
   def primes(nums: Stream[Int]): Stream[Int] = {
     Stream.cons(nums.head, primes(nums.tail filter (x => x % nums.head != 0)))
   }

   def primes2(nums : List[Int]): List[Int] = {
     @tailrec
     def innerPrimes(numsInner: List[Int], accum: List[Int]) : List[Int] = {
       if (numsInner.length == 0) return accum.reverse
       else {
           val primes = numsInner.tail.filter(x => x % numsInner.head != 0)
           val acc : List[Int] = numsInner.head :: accum
           innerPrimes(primes, acc)
       }
     }
     innerPrimes(nums, List())
   }
   
   def isPrime(n: Int) : Boolean = {
     var result = true
     for (i: Int <- 2 to Math.sqrt(n).intValue()){
       if (n%i == 0)
         return false
     }
     return result
   } 
   
   def split(n: Int) : List[Int] = if (n == 0) List(0) else { 
      (Stream.iterate(n)(_/10)takeWhile(_!=0)map(_%10)toList) reverse
   }
   
   def perm(l: List[Int]) : List[List[Int]] = {
     l.permutations.toList
   }
   
   def rotations(num: Int) = {
     def rotationHelper(str: String, times: Int): List[String] = {
       if (times == 1) List(str)
       else str :: rotationHelper(str.tail + str.head, times - 1)
     }
     val numString = num.toString
     rotationHelper(numString, numString.length).map(_.toInt)
   }
   
   def perm2(l: List[List[Int]]) : List[Int] = {
     l.map { x => convertListToInt(x) }
   }
   
   def isCircularPrime(l : List[Int]) : Boolean = {
     val primesOrNot = l.filter { x =>isPrime(x) }
     if ( primesOrNot.length < l.length) false
     else true
   }
   
   def hasEvenNumber(l: List[Int]): Boolean = {
     val evens = l.filter(a => a % 2 == 0) 
     if (evens.length == 0) false
     else if (l.length>1) true
     else false
   }
   
   def convertListToInt(l : List[Int]) : Int = {
     val lReverse = l.reverse
     var intResult = 0
     var factor = 1
     lReverse.foreach{ x => intResult += x*factor; factor *=10}
     return intResult 
   }
   
   def circPrimesUnder(n : Int) : Int = {
     val allPrimesUnderN = primes2(ints(2).take(n-1).toList)
     val primeRotations = allPrimesUnderN.map{ x=> rotations(x) }    
     val primeRotationsListWithoutEvenNumbers = primeRotations.filter { x => !hasEvenNumber(x) }
     val primeRotatiosThatAreCircularPrimesList = primeRotationsListWithoutEvenNumbers.filter { x => isCircularPrime(x) } 
     primeRotatiosThatAreCircularPrimesList.foreach { x => println(x) }
     println("----")
     
     primeRotatiosThatAreCircularPrimesList.length

   }
   
   def main(args: Array[String]): Unit = {
     val start = System.nanoTime
     println("Started at " + start/1e6+"ms")
     val n = 1000000
     println("Number of circular primes under " + n + " = " + circPrimesUnder(n))
     val stop = System.nanoTime()
     println("Stopped at " + stop/1e6+"ms")
     println("Elapsed time : "+(System.nanoTime-start)/1e6+"ms")
   }
}