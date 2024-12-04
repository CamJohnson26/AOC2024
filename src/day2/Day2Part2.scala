package day2

import scala.collection.mutable.ListBuffer
import scala.io.Source

object Day2Part2 {

  def reportIsSafe(report: Array[Int]): Boolean = {

    var prevVal = -1
    var isSafe: Boolean = true
    var direction = 0

    report.foreach{value =>
      if (prevVal != -1) {
        val diff = value - prevVal
        val range = Math.abs(diff)
        if (diff == 0) {
          isSafe = false
        }
        val newDirection = if ( diff > 0) 1 else -1
        if (direction == 0) {
          direction = newDirection
        }
        if (direction != newDirection) {
          isSafe = false
        }
        if (range < 1 || range > 3) {
          isSafe = false
        }

      }
      prevVal = value
    }
    isSafe
  }
  def main(args: Array[String]): Unit = {
    val file = "./src/day2/input.txt"
    val lines = Source.fromFile(file).getLines().toList
    val reports = ListBuffer.empty[Array[Int]]
    lines.foreach{line =>
      val split = line.split(" ")
      val report = split.map(_.toInt)
      reports += report
    }

    var sum = 0
    reports.foreach{report =>
      var isSafe = reportIsSafe(report)
      report.zipWithIndex.foreach{case (value, index) =>
        val listWithoutIndex = report.zipWithIndex.filter{case (_, i) => index != i}.map(_._1)
        val dampenerIsSafe = reportIsSafe(listWithoutIndex)
        if (dampenerIsSafe) {
          isSafe = true
        }
      }
      if (isSafe) {
        sum += 1
      }
    }
    println(sum)
  }
}