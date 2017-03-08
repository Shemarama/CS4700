// Quicksort.java
import java.util.*;
import java.io.*;

public class Quicksort
{
  public static Vector<Integer> quicksort(Vector<Integer> array)
  {
    return quicksortHelper(array, 0, array.size()-1);
  }

  public static Vector<Integer> quicksortHelper(Vector<Integer> array, int start, int end)
  {
    if (end-start > 0)
    {
      int tmp = 0;
      int pivot = array.get(start);
      int left = start;
      int right = end;
      while (left <= right)
      {
        while (array.get(left) < pivot)
          left += 1;
        while (array.get(right) > pivot)
          right -= 1;
        if (left <= right)
        {
          tmp = array.get(left);
          array.set(left,array.get(right));
          array.set(right,tmp);
          left += 1;
          right -= 1;
        }
      }
      array = quicksortHelper(array, start, right);
      array = quicksortHelper(array, left, end);
    }
    return array;
  }

  public static void main(String[] args)
  {
    String fileName = "../list.txt";
    String line = null;
    Vector<Integer> list = new Vector<>();

    try
    {
      FileReader fileReader = new FileReader(fileName);

      BufferedReader bufferedReader = new BufferedReader(fileReader);

      while((line = bufferedReader.readLine()) != null)
      {
        list.add(Integer.parseInt(line));
      }

      bufferedReader.close();

      long s = System.nanoTime();
      list = quicksort(list);
      System.out.println("Time: " + (System.nanoTime()-s/1e6 + " ms"));

      //for(Integer x : list)
      //  System.out.println(x);
    }
    catch(FileNotFoundException ex)
    {
      System.out.println("File not found");
    }
    catch(IOException ex)
    {
      System.out.println("Error reading file");
    }
  }
}
