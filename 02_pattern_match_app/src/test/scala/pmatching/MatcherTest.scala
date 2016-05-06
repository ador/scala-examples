package pmatching

import org.scalatest.FlatSpec
import MatcherApp._


class MatcherTest extends FlatSpec {

  "Matcher" should "return 'hi'" in {
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
  
  
}
