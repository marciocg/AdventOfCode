import scala.collection.mutable.SortedMap
import scala.io.Source

def getMinMaxPair(row: String, tm: Map[String, String]): String =
  val smin: SortedMap[Int, String] = SortedMap()
  val smax: SortedMap[Int, String] = SortedMap()

  for k <- tm.keySet
  do 
    if row.indexOf(k) > -1 then
      if smin.get(row.indexOf(k)) == None then
        smin.addOne(row.indexOf(k) -> k)
      end if
      smax.addOne(row.lastIndexOf(k) -> k)
    end if

  tm(smin.head._2) concat tm(smax.last._2)

def day1(): Unit =

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
  val data = Source.fromResource("day1.txt").getLines()

  for row <- data
  do  sum += Integer.parseInt(getMinMaxPair(row, tmap))

  println(sum)
