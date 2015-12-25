
object Euler003Functional extends App {
  
  def factors(n: Long): List[Long] = (2 to math.sqrt(n).toInt)
  .find(n % _ == 0).fold(List(n))(i => i.toLong :: factors(n / i))

  println(factors(600851475143L).last)
  
  def sum(f: Int => Int): (Int, Int) => Int = { 
    def sumF(a: Int, b: Int): Int =
    if (a > b) 0 else f(a) + sumF(a + 1, b) 
    sumF
  }
  
  def sumInts = sum(x => x)
  
  println(sumInts(1,5))
  println(sumInts(5,1))
  println(sumInts(1,10))

}