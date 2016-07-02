package options

object OptionExamples extends App {

  def getUserMap: Map[Int, String] = {
    val userMap: Map[Int, String] = Map(
      824 -> "Jane",
      2723 -> "Kate",
      535 -> "Zoe",
      8260 -> "Jonathan")
    userMap
  }

  def getUserById(id: Int): Option[String] = {
    val users = getUserMap
    //  Note: we could have just used 
    //  Map's buil-in get() method that returns an Option:
    // users.get(id) 
    if (users.contains(id)) { 
      Some(users(id)) 
    } else {
      None
    }
  }

  // with Option's "getOrElse" method
  def processOptionResult1(result: Option[String]): String = {
    result.getOrElse("<default name>")
  }

  // with pattern matching (Some is a case class!)
  def processOptionResult2(result: Option[String]): String = {
    val toReturn: String = result match {
      case Some(name) => name 
      case None => "<not found>"
    }
    toReturn
  }
  
  override def main(args: Array[String]): Unit = {
    println("Hello to Options in Scala!")
    println("535: " + getUserById(535))
    println("550: " + getUserById(550))

    println("With getOrElse:")
    println(processOptionResult1(getUserById(824)))
    println(processOptionResult1(getUserById(111)))
    
    println("With pattern matching:")
    println(processOptionResult2(getUserById(824)))
    println(processOptionResult2(getUserById(111)))

  }
}
