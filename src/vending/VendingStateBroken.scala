package vending

class VendingStateBroken(vending: VendingMachine) extends VendingState {
  override def insertCoin(coin: Int): Unit = {
    vending.totalCoin += coin
  }

  override def coinReturnPressed(): Int = {
    vending.returnCoin = 0
    vending.totalCoin = 0
    vending.returnCoin
  }

  override def beverageButtonPressed(): Boolean = {
    false
  }
}
