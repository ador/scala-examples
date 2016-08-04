package foryield

import org.scalatest.FlatSpec
import ForYieldExamples._

class ForYieldExamplesTest extends FlatSpec {

  "ForYieldExample" should "return a list of String tweet messages" in {
    val inputTweets = ForYieldExamples.createTweetList
    val messages = ForYieldExamples.getMessagesOnly(inputTweets)
    assert(3 == messages.length)
    assert("scala program" == messages(0))
  }

  "it" should "return only some messages " in {
    val inputTweets = ForYieldExamples.createTweetList
    val messages = ForYieldExamples.getMessagesWithScalaOnly(inputTweets)
    assert(2 == messages.length)
    for (m <- messages)
      assert(m.contains("scala"))
  }

  "it" should "return all possible user-message pairs " in {
    val inputTweets = ForYieldExamples.createTweetList
    val allPairs = ForYieldExamples.getAllUserMsgPairs(inputTweets)
    assert(9 == allPairs.length)
    assert(allPairs(0)._1.name == "ador")
    assert(allPairs(0)._2 == "scala program")
    assert(allPairs(8)._1.name == "ador")
    assert(allPairs(8)._2 == "playing with scala")
  }

  "it" should "return tweets that have any of the words " in {
    val inputTweets = ForYieldExamples.createTweetList
    val words: List[String] = List("playing", "ice")
    val filteredTweets = ForYieldExamples.filterForManyWords(inputTweets, words)
    assert(2 == filteredTweets.length)
    assert(filteredTweets(0).msg == "ice cream")
    assert(filteredTweets(1).msg == "playing with scala")
  }

}
