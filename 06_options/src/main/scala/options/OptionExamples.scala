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
    users.get(id)
  }

  override def main(args: Array[String]): Unit = {
    println("Hello to Options in Scala!")
    println("535: " + getUserById(535))
    println("538: " + getUserById(535))

  }
}
