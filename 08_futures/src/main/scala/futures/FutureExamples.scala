package futures

object FutureExamples extends App {

  case class User(name: String)
  case class TweetMsg(id: Long, user: User, msg: String)


// TODO : use futures
  def fetchTweetList: List[TweetMsg] = {
    val user1 = new User("ador")
    val user2 = new User("szeli")
    val t1 = new TweetMsg(9243012L, user1, "scala program")
    val t2 = new TweetMsg(9534594L, user2, "ice cream")
    val t3 = new TweetMsg(9811235L, user1, "playing with scala")
    val tweetList: List[TweetMsg] = List(t1, t2 ,t3)
    tweetList
  }


  override def main(args: Array[String]): Unit = {
    println("Say 'Hello' to Futures in Scala!")
    val tweets = fetchTweetList
    for (tw <- tweets) {
      println("Tweeter was: " + tw.user + " and message was: " + tw.msg)
    }
  }
}
