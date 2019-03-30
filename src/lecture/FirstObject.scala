package lecture
object FirstObject {

  def computeShippingCost (input:Double): Double = {
    val weightLimit: Double = 30.0
    if (input > weightLimit) {
      5.0 + (input - weightLimit) * 0.25
    } else {
      5.0
    }
  }
}
