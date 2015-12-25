

object MapFlatMap {
  def main(args: Array[String]) {
    
    def f(x : Int) = if (x > 2) Some(x) else None
    def g(y : Int) = List(y-1,y,y+1)
    def h(k : Int, v : Int) = if (v > 2) Some(k -> v) else None
    
    val l = List(1,2,3,4,5)
    var m = Map( 1->2, 2->4, 3->6)
    val t = (5,10);
    val r = (100 to 999).view.flatMap(x => (x to 999).map(_ * x)).filter(n => n.toString() == n.toString().reverse).max
    println(r)
    
    //What is the difference between the sum of the squares and the square of the sums?
    
    val numbers = 1 to 100
    def square(number : Int) = number * number
    val result1 = square(numbers.sum)
    val result2 = numbers.map(square).sum
    println(result1)
    println(result2)
    println(result1 - result2)
    
    def timesTwo(n: Int) = n*n
    val result3 = numbers.map(timesTwo).view.toList
    println(result3)
    

    
    

    println(l.map(x => x*2))
    println(l.map(x => f(x)))
    println(l.flatMap(x => f(x)))
    println(l.map(x => g(x)))
    println(l.flatMap(x => g(x)))
    println(m.toList)
    println(t._1)
    println(t._2)
    m += (4-> 8)
    println(m.toList)
    println((m + (5 -> 10)).toList)
    println(m.mapValues( x => x*2 ))
    println(m.mapValues( x => f(x)))
    println(m.flatMap(e => List(e._2)))
    println(m.flatMap(e => List(e)))
    println(m.flatMap(e => h(e._1, e._2)))
    println(m.flatMap {case (k,v) => h(k,v) })
    
    
  }
}