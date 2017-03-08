// adapted from https://gist.github.com/alexwestphal/1267131

import java.io._

object Quicksort
{
  def quicksort(xs: Array[Int]): Array[Int] = {
    if (xs.length <= 1) xs
    else {
      val pivot = xs(xs.length / 2)
      Array.concat(
        quicksort(xs filter (pivot > _)),
        xs filter (pivot == _),
        quicksort(xs filter (pivot < _)))
    }
  }

  def main(args: Array[String])
  {
    val output = new PrintWriter(new File("quickscala.csv"))
    for (i <- 1 to 100)
    {
      var fileLines = io.Source.fromFile("../list.txt").getLines.toArray.map(_.toInt)
      val s = System.nanoTime
      fileLines = quicksort(fileLines)
      //println("Time: " + (System.nanoTime-s)/1e6 + " ms")
      output.write(((System.nanoTime-s)/1e6) + ",")
    }
    output.close()
  }
}
