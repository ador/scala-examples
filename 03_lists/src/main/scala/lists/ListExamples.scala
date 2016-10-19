package lists

object ListExamples extends App {

  case class User(name: String)
  case class TweetMsg(id: Long, user: User, msg: String)

  def addToBothEnds(list: List[Int], a: Int): List[Int] = {
    a::list:::List(a)
  }

  def addToBothEndsTwice(list: List[Int], a: Int): List[Int] = {
    a::a::list:::List(a, a)
  }

  def concatAtBothEnds(list: List[Int], toBeAdded: List[Int]): List[Int] = {
    List.concat(toBeAdded, list:::toBeAdded)
  }
  
  
  def getMutableList(list: List[Int]): scala.collection.mutable.ListBuffer[Int] = {
    val buf = scala.collection.mutable.ListBuffer.empty[Int]
    for (intvalue <- list) {
      buf.append(intvalue)
    }
    buf
  }
  
  def isIdPositive(tw: TweetMsg) : Boolean = {
    tw.id > 0L
  }
  
  def printUserAndMsg(tw: TweetMsg) : Unit = {
    println(tw.user + " tweeted: " + tw.msg)
  }
  
  override def main(args: Array[String]): Unit = {
    val list1: List[Int] = List(1,2,3)
    println(list1.isEmpty)
    val fromPosition = 0
    println(list1.indexOf(2, fromPosition))   // prints '1'
  
    val user1 = new User("adri")
    val user2 = new User("adorster")
    val user3 = new User("stern")
    val t1 = new TweetMsg(94432L, user1, "hello data")
    val t2 = new TweetMsg(513454L, user2, "hello science")
    val t3 = new TweetMsg(-68435L, user3, "hello data science")

    val tweetList1: List[TweetMsg] = List(t1, t2 ,t3) 

    // filter
    val filteredList = tweetList1.filter(isIdPositive)
    println("Filtered list is: " + filteredList)  

    // forall
    val trueOrFalse1 = tweetList1.forall(isIdPositive)
    println("All id numbers positive? " +  trueOrFalse1)
    val trueOrFalse2 = List(t1,t2).forall(isIdPositive)
    println("All id numbers positive? " +  trueOrFalse2)
    
    // foreach
    tweetList1.foreach(printUserAndMsg)

    // intersect
    val tweetList2: List[TweetMsg] = List(t3, t2) 
    val intersectList = tweetList1.intersect(tweetList2)
    println("Intersected list is: " + intersectList)

    // distinct
    val tweetList3: List[TweetMsg] = List(t3, t2, t2, t3, t1, t3, t2) 
    val distinctList = tweetList3.distinct
    println("Distinct list is: " + distinctList)
  }
}
