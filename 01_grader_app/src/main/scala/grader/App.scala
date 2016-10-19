package grader

object GraderApp extends App {
  object Grade extends Enumeration {
      type Grade = Value
      val A, B, C, D, E, F = Value
  }

  import Grade._
  override def main(args: Array[String]): Unit = {
//    Grade.values filter isPassed foreach println
    println(grade(50))
  }

  def isPassed(d: Grade) = ! (d == E || d == F)

  def getTweetData(id: Long):(String, Int, String) = {
    if (id == 5) {
      return ("angie", 30, "Hi, it's my birthday!")
    }
    if (id == 7) {
      return ("tony", 11, "Rainbows! :)")
    }
    return ("zoe", 13, "More rainbows! :)")
  }

  
  def grade(score: Int):Grade = score match {
      case a if (a < 40) => F
      case a if (40 <= a && a < 50) => E
      case a if (50 <= a && a < 60) => D
      case a if (60 <= a && a < 70) => C
      case a if (70 <= a && a < 80) => B
      case _ => A
   }
}

