package pmatching

import org.scalatest.FlatSpec
import MatcherApp._

class MatcherTest extends FlatSpec {

  "Matcher" should "return 'Just another tweet'" in {
    val user1 = new User("adri")
    assert("Just another tweet" == MatcherApp.processTweet(new TweetMsg(134L, user1, "hello")))
  }

  "Matcher" should "return error" in {
    val user1 = new User("adri")
    assert("Invalid (negative) tweet id!" == MatcherApp.processTweet(new TweetMsg(-1L, user1, "hello")))
  }

  "Matcher" should "return 'Welcome'" in {
    val user2 = new User("adorster")
    assert("Welcome, adorster!" == MatcherApp.processTweet(new TweetMsg(139L, user2, "hello")))
  }

  "Matcher" should "return 'String'" in {
    assert("String" == MatcherApp.getType("Hello"))
  }

  "Matcher" should "return 'Int'" in {
    assert("Int" == MatcherApp.getType(23))
  }

  "Matcher" should "return 'I don't know'" in {
    assert("I don't know" == MatcherApp.getType(new User("username")))
  }

}
