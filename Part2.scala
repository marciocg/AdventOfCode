import scala.collection.mutable.SortedMap
import scala.io.Source

def getMinMaxPair(row: String, tm: Map[String, String]): String =
  var sm: SortedMap[Int, String] = SortedMap()
  for k <- tm.keySet
      // x <- row.indexOf(k)
      // if x >= 0
  do  sm.addOne(row.indexOf(k) -> k)
  sm.remove(-1)
  tm(sm.head._2) concat tm(sm.last._2)

@main def Part2(): Unit =

  val tmap: Map[String, String] = Map(
     "one" -> "1",
     "two" -> "2",
     "three" -> "3",
     "four" -> "4",
     "five" -> "5",
     "six" -> "6",
     "seven" -> "7",
     "eight" -> "8",
     "nine" -> "9",
     "0" -> "0",
     "1" -> "1",
     "2" -> "2",
     "3" -> "3",
     "4" -> "4",
     "5" -> "5",
     "6" -> "6",
     "7" -> "7",
     "8" -> "8",
     "9" -> "9"
  )

  var sum: Int = 0
  val data = Source.fromFile("in.txt").getLines()

  for row <- data
  do
    // println(s"$row => ${Integer.parseInt(getMinMaxPair(row, tmap))}")
    sum += Integer.parseInt(getMinMaxPair(row, tmap))

  println(sum)