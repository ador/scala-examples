package futures

import org.scalatest.FlatSpec
import FutureExamples._
import ExecutionContext.Implicits.global

class FutureExamplesTest extends FlatSpec {

  "FutureExamples" should "return a Promise object" in {
    val maybeTweets = FutureExamples.fetchTweetList
    assert("class scala.concurrent.impl.Promise$DefaultPromise" == maybeTweets.getClass.toString)
  }

  "it" should "return some messages " in {
    val tweetsPromise = FutureExamples.fetchTweetList
    val result: List[TweetMsg] = for (tweets <- tweetsPromise) yield tweets // unwrapping list of tweets from the Future
    assert( 3 == result.length)
  }
}
