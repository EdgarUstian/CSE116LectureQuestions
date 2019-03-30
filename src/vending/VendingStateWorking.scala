package vending

class VendingStateWorking(vending: VendingMachine) extends VendingState {
  override def insertCoin(coin: Int): Unit = {
    vending.totalCoin += coin
  }

  override def coinReturnPressed(): Int = {
    vending.returnCoin = vending.totalCoin
    vending.totalCoin = 0
    vending.returnCoin
  }

  override def beverageButtonPressed(): Boolean = {
    if (vending.totalCoin >= 200){
      vending.totalCoin -= 200
      this.coinReturnPressed()
      true
    }
    else {
      false
    }
  }
}
