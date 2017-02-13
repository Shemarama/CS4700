object Quicksort
{

  def main(args: Array[String])
  {
    val fileLines = io.Source.fromFile("../list.txt").getLines.toList
    fileLines.foreach(println)
  }
}
