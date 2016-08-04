package foryield

object ForYieldExamples extends App {

  case class User(name: String)
  case class TweetMsg(id: Long, user: User, msg: String)

  def createTweetList: List[TweetMsg] = {
    val user1 = new User("ador")
    val user2 = new User("szeli")
    val t1 = new TweetMsg(9243012L, user1, "scala program")
    val t2 = new TweetMsg(9534594L, user2, "ice cream")
    val t3 = new TweetMsg(9811235L, user1, "playing with scala")
    val tweetList: List[TweetMsg] = List(t1, t2 ,t3)
    tweetList
  }

  def getMessagesOnly(tweets: List[TweetMsg]): List[String] = {
    val messageList = for (tw <- tweets) yield tw.msg
    messageList
  }
  
  def getMessagesWithScalaOnly(tweets: List[TweetMsg]): List[String] = {
    val filteredMessageList = for {
      tw <- tweets
      if tw.msg.contains("scala")
    } yield tw.msg
    filteredMessageList
  }

  def getAllUserMsgPairs(tweets: List[TweetMsg]): List[(User, String)] = {
    for {
      tw <- tweets
      user <- tweets.map(_.user)
    } yield (user, tw.msg)
  }
  
  def filterForManyWords(tweets: List[TweetMsg], words: List[String]): List[TweetMsg] = {
    for {
      tw <- tweets
      word <- words
      if tw.msg.contains(word)
    } yield tw
  }
  
  override def main(args: Array[String]): Unit = {
    println("Hello to for comprehensions in Scala!")
    val tweets = createTweetList
    for (tw <- tweets) {
      println("Tweeter was: " + tw.user + " and message was: " + tw.msg)
    }
  }
}
