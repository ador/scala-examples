package pmatching

object MatcherApp extends App {

  case class User(name: String)
  case class TweetMsg(id: Long, user: User, msg: String)
  
  
  
  def processTweet(tweet: TweetMsg) = tweet match {
    case TweetMsg(id, _, _) if id < 0 => "Invalid (negative) tweet id!"
    case TweetMsg(_, user, _) if user.name == "adorster" => "Welcome, " + user.name + "!"
    case _ => "Just another tweet"
  }
  def printMyMsg(tweet: TweetMsg) = println(processTweet(tweet))


  override def main(args: Array[String]): Unit = {
    val user1 = new User("adri")
    val user2 = new User("adorster")
    val user3 = new User("stern")
    printMyMsg(new TweetMsg(12L, user1, "hello"))
    printMyMsg(new TweetMsg(1345L, user2, "hello"))
    printMyMsg(new TweetMsg(-1L, user3, "hello"))
  }

}
