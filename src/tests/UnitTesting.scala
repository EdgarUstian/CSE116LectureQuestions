package tests
import org.scalatest._
import lecture.FirstObject

class UnitTesting extends FunSuite {
  test("Testing Shipping Cost By Weight") {
    val smallWeights: List[Double] = List(20.0, 29.9, 15.0, 22.0)
    val largeWeights: List[Double] = List(40.0, 30.1, 45.0, 34.5)

    for (smallWeight <- smallWeights){
      assert(FirstObject.computeShippingCost(
        smallWeight) == 5.0, smallWeight)
    }
    for (largeWeight <- largeWeights){
      assert(FirstObject.computeShippingCost(
        largeWeight) == (5.0+((largeWeight-30.0)*0.25)), largeWeight)
    }

  }
}
