package day1

import scala.collection.mutable.ListBuffer
import scala.io.Source

object Day1Part2 {

  def main(args: Array[String]): Unit = {
    val file = "./src/day1/input.txt"
    val lines = Source.fromFile(file).getLines().toList
    val leftList = ListBuffer.empty[Int]
    val rightList = ListBuffer.empty[Int]
    lines.foreach{line =>
      val split = line.split("   ")
      val left = split.lift(0).map(_.toInt).getOrElse(0)
      val right = split.lift(1).map(_.toInt).getOrElse(0)

      leftList += left
      rightList += right
    }
    val sortedLeft = leftList.sorted
    var sum = 0
    sortedLeft.foreach{ leftElement =>
      val count = rightList.count(_ == leftElement)
      sum = sum + leftElement * count
    }
    println(sum)
  }
}
