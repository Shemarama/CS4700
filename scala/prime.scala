// prime.scala
import math.sqrt

object PrimeNumbers
{
  def is_prime(n: Int): Boolean = {
    if (n < 2) { return false } 
    if (n == 2) { return true } 
    if (n%2 == 0) { return false } 
    
    for (i <- 3 to sqrt(n).toInt by 2)
    {
      if (n%i == 0) { return false } 
    }
    
    return true
  }

  def main(args: Array[String])
  {
    val n = 10000
    val s = System.nanoTime

    for( i <- 0 to n )
    {
      if (is_prime(i))
        println(i.toString + " is prime")
    }

    println("Time: " + (System.nanoTime-s)/1e9 + " seconds")
  }
}
