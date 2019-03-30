package vending

object TestVendingMachine {
  val vending: VendingMachine = new VendingMachine

  def main(args: Array[String]): Unit = {
    vending.insertCoin(300)
    vending.beverageButtonPressed()
    println(vending.totalCoin)
    println(vending.returnCoin)
    println(vending.beverageButtonPressed())
  }
}
