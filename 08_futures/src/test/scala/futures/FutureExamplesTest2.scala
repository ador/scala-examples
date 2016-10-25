package futures

import org.scalatest.FlatSpec
import org.specs2.mutable.Specification
import FutureExamples._
import org.specs2.concurrent.ExecutionEnv
import scala.concurrent.{future, Future}
import scala.util.{Success, Failure}

class FutureExamplesTest2 extends org.specs2.mutable.Specification {
  
  "test of a Scala Future" in { implicit ee: ExecutionEnv =>
    FutureExamples.fetchTweetList must be_>(0).await
  }
}
