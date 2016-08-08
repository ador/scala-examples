package futures

import org.scalatest.FlatSpec
import FutureExamples._

class FutureExamplesTest extends FlatSpec {

  "FutureExamples" should "return a Future object" in {
    val maybeTweets = FutureExamples.fetchTweetList
    // TODO
  }

  "it" should "return some messages " in {
  }
}
