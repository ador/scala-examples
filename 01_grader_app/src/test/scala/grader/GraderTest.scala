package grader

import org.scalatest.FlatSpec
import GraderApp.Grade._

class GraderTest extends FlatSpec {

  "Grader" should "grade a zero valued test to F" in {
    assert(F == GraderApp.grade(0))
  }
  "Grader" should "grade a negative valued test to F" in {
    assert(F == GraderApp.grade(-10))
  }
  "Grader" should "grade a 40 valued test to F" in {
    assert(E == GraderApp.grade(41))
  }
  "Grader" should "grade a 41 valued test to E" in {
    assert(E == GraderApp.grade(41))
  }
  "Grader" should "grade a 51 valued test to D" in {
    assert(D == GraderApp.grade(51))
  }
  "Grader" should "grade a 61 valued test to C" in {
    assert(C == GraderApp.grade(61))
  }
  "Grader" should "grade a 71 valued test to B" in {
    assert(B == GraderApp.grade(71))
  }
  "Grader" should "grade a 80 valued test to A" in {
    assert(A == GraderApp.grade(81))
  }
  "Grader" should "grade a 90 valued test to A" in {
    assert(A == GraderApp.grade(90))
  }
  "Grader" should "grade a 100 valued test to A" in {
    assert(A == GraderApp.grade(100))
  }
  "Grader" should "grade a 101 valued test to A" in {
    assert(A == GraderApp.grade(101))
  }

  "Grader" should "accept as passed with A" in {
    assert(GraderApp.isPassed(A))
  }
  "Grader" should "accept as passed with B" in {
    assert(GraderApp.isPassed(B))
  }
  "Grader" should "accept as passed with C" in {
    assert(GraderApp.isPassed(C))
  }
  "Grader" should "accept as passed with D" in {
    assert(GraderApp.isPassed(D))
  }
  "Grader" should "reject as not passed with E" in {
    assert(!GraderApp.isPassed(E))
  }
  "Grader" should "reject as not passed with F" in {
    assert(!GraderApp.isPassed(F))
  }
  
  "Grader" should "reject as not passed with F22" in {
    assert(GraderApp.getTweetData(5)._1 == "angie")
    assert(GraderApp.getTweetData(10)._1 == "zoe")
    val(name, age, _) = GraderApp.getTweetData(8L)
    assert(name == "zoe")
    assert(age == 13)
  }

}
