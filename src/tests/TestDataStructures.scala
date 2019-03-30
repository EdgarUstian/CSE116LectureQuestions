package tests
import org.scalatest._
import lecture.DataStructures

class TestDataStructures extends FunSuite {
  test("Testing maxMultiply method") {
    val testCasesAll: Map[List[Int], Int] = Map(
      List(1, 2, 3, 4, 5) -> 20,
      List(2, 5, 3, 6) -> 30,
      List(-1, -2, 3, -4, 5) -> 15,
      List(3, 6, -6, -5, -1) -> 30,
      List() -> -1,
      List() -> -1,
      List() -> -1,
      List(1) -> 1,
      List(5) -> 25,
      List(4) -> 16)

    for ((key, value) <- testCasesAll){
      if (key.isEmpty){
        assert(DataStructures.maxMultiply(key) == value, key)
      } else if (key.length == 1){
        assert(DataStructures.maxMultiply(key) == value, key)
      } else {
        assert(DataStructures.maxMultiply(key) == value, key)
      }

    }
  }
}
