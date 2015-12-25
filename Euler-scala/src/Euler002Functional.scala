
import scala.math.BigInt

object Euler002Functional extends App {
  lazy val fibs: Stream[Int] = 0 #:: fibs.scanLeft(1)(_ + _)
  println(fibs.view.takeWhile(_ <= 4000000).filter(_% 2==0).sum)
}