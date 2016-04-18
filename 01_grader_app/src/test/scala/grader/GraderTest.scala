package grader

import org.scalatest.FlatSpec

class GraderTest extends FlatSpec {

  "Grader" should "grade a zero valued test to 1" in {
    val testScore1 = 0
    val grade = GraderApp.grade(0)
    assert(1 == grade)
  }
}