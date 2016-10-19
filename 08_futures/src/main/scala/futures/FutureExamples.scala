package futures

import scala.concurrent._
import scala.concurrent.duration._
import ExecutionContext.Implicits.global
import scala.util.{Success, Failure}

object FutureExamples extends App {

  case class User(name: String)
  case class TweetMsg(id: Long, user: User, msg: String)

  def fetchTweetList: Future[List[TweetMsg]] = Future {
    val user1 = new User("ador")
    val user2 = new User("szeli")
    Thread.sleep(400)    // milliseconds
    val t1 = new TweetMsg(9243012L, user1, "scala program")
    Thread.sleep(600)
    val t2 = new TweetMsg(9534594L, user2, "ice cream")
    Thread.sleep(500)
    val t3 = new TweetMsg(9811235L, user1, "playing with scala")
    val tweetList: List[TweetMsg] = List(t1, t2 ,t3)
    tweetList
  }

  override def main(args: Array[String]): Unit = {
    println("Say 'Hello' to Futures in Scala!")
    fetchTweetList.onComplete {
      case Success(tweetList) => println("got my tweets, " + tweetList.length + " of them")
      case Failure(ex) => println("Something bad happened")
      case _ => "??"
    }
    println("Hi, waiting here a bit so that the app does not exit before we receive the tweets")
    Thread.sleep(2000)
    
    println("Another approach: waiting until it happens. Asking for tweets again... ")
    lazy val tweets = fetchTweetList
    
    Await.result(tweets, 2 second)
    
    // println(tweets.toString)
    // the first '<-' in the for comp. gets the List of tweets from the "Promise" object
    for (tweetList <- tweets; tw <- tweetList) {
       println("Tweeter was: " + tw.user + " and message was: " + tw.msg)
    }
  }
}
