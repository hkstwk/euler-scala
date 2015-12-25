

object HelloWolrd {
/** Bigint's can be used seamlessly */
  def main(args: Array[String]) {
    def factorial(n: BigInt): BigInt =
      if (n == 0) 1 else n * factorial(n-1)
  
    val f69 = factorial(69); val f49 = factorial(69)
    println("69! = " + f69)
    println("49! = " + f49)
    println("69!/49! = " + (f69 / f49))
    
    case class Player(name: String, score: Int)
    
    def printWinner(p: Player): Unit =
      println(p.name + " is the winner!")
    
    def winner(p1: Player, p2: Player): Player = {
      println(s"comparing ${p1.name} to ${p2.name}")
      if (p1.score > p2.score) p1 else p2
    }
  
    def declareWinner(p1: Player, p2: Player): Unit =
      printWinner(winner(p1, p2))
      
    val players = List(Player("Sue", 19),
                   Player("Bob", 11),
                   Player("Joe", 99),
                   Player("Charlotte", 13),
                   Player("Joost", 12),
                   Player("Bea", 2))
                   
    val p = players.reduceLeft(winner)
    
    printWinner(p)
  }
}
