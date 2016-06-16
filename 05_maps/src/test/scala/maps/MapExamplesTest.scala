package maps

import org.scalatest.FlatSpec
import MapCollExamples._

class MapCollExamplesTest extends FlatSpec {

  "MapCollExample" should "check elements" in {
    val map1 = MapCollExamples.createSimpleTweetMap()
    // note: map(key) throws an Exception if the key is not valid!
    assert("#scaladays are coming to Berlin!" == map1(414))
    assert("Scala is the new golden child" == map1(435))
    assert("#scaladays Scaladex: scala package index" == map1(506)) 
  }

  "it" should "Return an Option" in {
    val map1 = MapCollExamples.createSimpleTweetMap()
    // note: map.get(key) returns an Option, no Exception is thrown for invalid key, but a None will be returned
    assert(Some("#scaladays are coming to Berlin!") == map1.get(414))
    assert(map1.get(999) == None)
  }



}
