package maps

// Scala.collection.immutable.Map is imported by default,
// and can be used as "Map".
// But we import it with another name:
import scala.collection.immutable.{Map => ImmuMap}
// We'll also need a mutable version (not imported by default):
import scala.collection.mutable.{Map => MuMap}


object MapCollExamples extends App {

  def createSimpleTweetMap(): ImmuMap[Int, String] = {
    val tMap = Map(
      414 -> "#scaladays are coming to Berlin!",
      435 -> "Scala is the new golden child", 
      506 -> "#scaladays Scaladex: scala package index")
    return tMap
  }

   def getMutableMap(): scala.collection.mutable.Map[Int, String] = {
     val map: MuMap[Int, String] = MuMap()
     map += (1 -> "think")
     map += (2 -> "write")
     map += (3 -> "publish")
     return map 
   }

  override def main(args: Array[String]): Unit = {
    println("Hello to Maps in Scala!")
    val emptyMap: Map[Int, Int] = Map()
    if (emptyMap.isEmpty) { println("An empty map!") }
    
    val map1 = createSimpleTweetMap()
    // iterating on all with foreach: needs a function that returns Unit and accepts a corresponding tuple from the map (key, value)
    def simpleTweetPrinterFunction(tuple: (Int, String)) : Unit = {
      println("key: " + tuple._1 + ", value: " + tuple._2)
    }
    map1.foreach(simpleTweetPrinterFunction)
    
    val myMuMap = getMutableMap()
    println(" - Iterating with an iterator:")
    val mIter = myMuMap.iterator
    while (mIter.hasNext) { println(mIter.next) }
    println(" - Printing elements with foreach:")
    myMuMap.foreach(kv => println("key: " + kv._1 + ", value: " + kv._2) )
  }
}
