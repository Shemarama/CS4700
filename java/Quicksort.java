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
    try
    {
      PrintWriter output = new PrintWriter(new File("quickjava.csv"));
      FileReader fileReader;
      BufferedReader bufferedReader;
      for (int i=0; i<100; i++)
      {
        try
        {
          String fileName = "../list.txt";
          String line = null;
          Vector<Integer> list = new Vector<>();
          
          fileReader = new FileReader(fileName);
          bufferedReader = new BufferedReader(fileReader);

          while((line = bufferedReader.readLine()) != null)
          {
            list.add(Integer.parseInt(line));
          }

          bufferedReader.close();

          long s = System.nanoTime();
          list = quicksort(list);
          //System.out.println("Time: " + (System.nanoTime()-s)/1e6 + " ms");
          output.write(((System.nanoTime()-s)/1e6) + ",");

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
      output.close();
    }
    catch (IOException e)
    {
      System.out.println("Could not open file");
    }
  }
}
