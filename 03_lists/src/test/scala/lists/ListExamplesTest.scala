package pmatching

import org.scalatest.FlatSpec
import ListExamples._

class ListExamplesTest extends FlatSpec {

  "ListExample" should "return (5,1,2,3,5)" in {
    val list1: List[Int] = List(1,2,3)
    val list2 = ListExamples.addToBothEnds(list1, 5)
    assert(!list2.isEmpty)
    assert(list2.length == list1.length + 2)
    assert(List(5,1,2,3,5).equals(list2))
  }

  "it" should "return (5,5, 1,2,3, 5,5)" in {
    val list1: List[Int] = List(1,2,3)
    val list2 = ListExamples.addToBothEndsTwice(list1, 5)
    assert(list2.length == list1.length + 4)
    assert(List(5,5,1,2,3,5,5).equals(list2))
  }

  "it" should "return (9,8,7, 1,2,3, 9,8,7)" in {
    val origList: List[Int] = List(1,2,3)
    val list2 = List(9,8,7)
    val concatList = ListExamples.concatAtBothEnds(origList, list2)
    assert(concatList.length == origList.length + 2 * list2.length)
    assert(List(9,8,7,1,2,3,9,8,7).equals(concatList))
  }
  
  "it" should "extend a mutable list" in {
    val mlist = ListExamples.getMutableList(List(23,44,52))
    assert(mlist.length == 3)
    mlist.append(79)
    mlist.append(98)
    assert(mlist.length == 5)
  }

}
