// PrimeNumbers.java
import java.lang.Math.*;

public class PrimeNumbers
{
  public static boolean is_prime(int n)
  {
    if (n < 2) { return false; }
    if (n == 2) { return true; }
    if (n%2 == 0) { return false; }

    for(int i=3; i < (int)Math.sqrt(n)+1; i+=2)
    {
      if (n%i == 0) { return false; }
    }

    return true;
  }

  public static void firstPrimeNumbers(int n)
  {
    if (n < 1) { return; }

    // since 2 is the first prime number
    int count = 1;
    int i = 2;
    System.out.printf("%d: %d\n", count, i);

    i += 1;

    while (count < n)
    {
      if (is_prime(i))
      {
        count += 1;
        System.out.printf("%d: %d\n", count, i);
      }
      i += 2;
    }
  }

  public static void main(String[] args)
  {
    int n = 1000;
    long s = System.nanoTime();
    firstPrimeNumbers(n);
    System.out.println("Time: " + (System.nanoTime()-s)/1e9 + " seconds");
  }
}
