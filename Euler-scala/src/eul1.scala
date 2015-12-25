/*
 * Corners are constantly increasing by +2, constantly adding the value to previous corner
 * 
 * spiral 1   has 1 corner (one member)
 * spiral 3x3 has 5 (1 + 4) corners
 * spiral 5x5 has 9 (1 + 4 + 4) corners
 * spiral 7x7 has 13 (1 + 4 + 4 + 4) corners
 * spiral nxn has (n-1) / 2 (only odd numbers) * 4 (# corners) +1 (center) corners
 * spiral 1001x1001 has (((1001-1)/2)*4) + 1= 2001 corners
 * 
 * Corner values can be determined by following algorithm
 *  increment = 2 // initial value
 *  corner[1] = corner[0] + increment (2); increment += 2
 *  corner[2] = corner[0] + increment (4); increment += 2
 *  corner[3] = corner[0] + increment (6); increment += 2
 *  corner[4] = corner[0] + increment (8); increment += 2
 *  corner[5] = corner[5-4] + increment (10); increment += 2
 *  ....
 *  corner[2001] = corner[2001-4] + increment
 * 
 * Summing diagonally from top left to bottom right means 
 * summing corners 1, 2, 4, 6, 8, 10, ..., 2000
 * 
 */

import collection.mutable.ArrayBuffer

object eul1 extends App{
   val corners = (1 to 1001).filter(i => i%2!=0).size
   println(corners)
   val corners2 = (corners-1)*4 + 1
   println(corners2)

   var increment = 2;

   var cornerValues = ArrayBuffer[Int]()
   cornerValues += 1
     for (n <- 1 until 5){
          cornerValues += (cornerValues(0) + increment)
          increment += 2
     }
     for (n <- 5 until corners2){
          cornerValues += (cornerValues(n-4) + increment)
          increment += 2
     }
   println(cornerValues.sum)

   var sum = 1
   val range = (2 to 1001).filter(i => i%2!=0)
   def sumCorners(n: Int): Int = (4*n*n) - (6*n) + 6 
   
   range.foreach { sum += sumCorners(_) }
   println(sum)
}

