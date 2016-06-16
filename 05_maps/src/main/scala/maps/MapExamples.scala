package maps

// Scala.collection.immutable.Map is imported by default,
// and can be used as "Map".
// But we import it with another name:
import scala.collection.immutable.{Map => ImmuMap}
// We'll also need a mutable version (not imported by default):
import scala.collection.mutable.{Map => MuMap}


object MapCollExamples extends App {

  // our usual example classes
  case class User(name: String)
  case class TweetMsg(id: Long, user: User, msg: String)

  def createSimpleTweetMap(): ImmuMap[Int, String] = {
    val tMap = Map(
      414 -> "#scaladays are coming to Berlin!",
      435 -> "Scala is the new golden child", 
      506 -> "#scaladays Scaladex: scala package index")
    return tMap
  }
  
//   def createTweetMap(idList: List[Long], msg: String) = {
//   }

  
//   def getMutableMap(list: List[Int]): scala.collection.mutable.ListBuffer[Int] = {
//   }
  
 
  override def main(args: Array[String]): Unit = {
    println("Hello to Maps in Scala!")
    val emptyMap: Map[Int, Int] = Map()
    if (emptyMap.isEmpty) { println("An empty map!") }
    val map1 = createSimpleTweetMap()
    // iterating on all with foreach: needs a function that returns Unit and accepts a corresponding tuple from the map (key, value)
    def simpleTweetPrinterFunction(tuple: (Int, String)) : Unit = {
      println("the key: " + tuple._1 + ", the value : " + tuple._2)
    }
    
    map1.foreach(simpleTweetPrinterFunction)


  }
}
