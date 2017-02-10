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

  def firstPrimeNumbers(n: Int): Unit = {
    if (n < 1) { return }
    
    // since 2 is the first prime number
    var count: Int = 1
    var i: Int = 2
    println(s"$count: $i") // string interpolation
    
    i += 1
    
    while (count < n)
    {
      if (is_prime(i))
      {
        count += 1
        println(s"$count: $i")
      }
      i += 2
    }
  }

  def timeIt(f: Int => Unit, n: Int) = {
    val s = System.nanoTime
    f(n)
    println("Time: " + (System.nanoTime-s)/1e9 + " seconds")
  }

  def main(args: Array[String])
  {
    val n = 1000
    timeIt(firstPrimeNumbers,n)
  }
}
