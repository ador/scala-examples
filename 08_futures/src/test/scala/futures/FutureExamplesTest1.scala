package futures

import org.scalatest.FlatSpec
import FutureExamples._
import org.specs2.concurrent.ExecutionEnv
import scala.concurrent.{future, Future}
import scala.util.{Success, Failure}

class FutureExamplesTest1 extends FlatSpec {

  "FutureExamples" should "return a Promise object" in {
    val maybeTweets = FutureExamples.fetchTweetList
    assert("class scala.concurrent.impl.Promise$DefaultPromise" == maybeTweets.getClass.toString)
  }
  
}