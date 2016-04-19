package grader

object GraderApp extends App {
  object Grade extends Enumeration {
      type Grade = Value
      val A, B, C, D, E, F = Value
  }
  
  import Grade._
  override def main(args: Array[String]): Unit = {
    def isPassed(d: Grade) = ! (d == E || d == F)

//    Grade.values filter isPassed foreach println
    println(grade(50))
  }

  def grade(score: Int):Grade = score match {
      case a if (0<=a && a < 40) => F
      case a if (40<=a && a < 50) => E
      case a if (50<=a && a < 60) => D
      case a if (60<=a && a < 70) => C
      case a if (70<=a && a < 80) => B
      case _ => A    
   }
}

