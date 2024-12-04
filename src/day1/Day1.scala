package day1
import scala.collection.mutable.ListBuffer
import scala.io.Source

object Day1 {

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
    val sortedRight = rightList.sorted
    var sum = 0

    sortedLeft.zipWithIndex.foreach{ case (leftElement, index) =>
      val rightElement = sortedRight.lift(index).getOrElse(0)
      val diff = Math.abs(leftElement - rightElement)
      sum += diff
    }
    println(sum)
  }
}
