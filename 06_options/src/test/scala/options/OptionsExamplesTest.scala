package options

import org.scalatest.FlatSpec
import OptionExamples._

class OptionExamplesTest extends FlatSpec {

  "OptionExample" should "return Some()" in {
    val name1 = OptionExamples.getUserById(535)
    assert(name1 == Some("Zoe"))
  }

  "it" should "return None" in {
    val name2 = OptionExamples.getUserById(213)
    assert(name2 == None)
  }

  "it" should "return a default String" in {
    val name3 = OptionExamples.processOptionResult1(getUserById(101))
    assert(name3 == "<default name>")
  }

  "it" should "return a String" in {
    val name4 = OptionExamples.processOptionResult2(getUserById(101))
    assert(name4 == "<not found>")
  }

}
