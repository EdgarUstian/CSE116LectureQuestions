package vending

class VendingMachine {
  var vendingState: VendingState = new VendingStateWorking(this)
  var totalCoin: Int = 0
  var returnCoin: Int = 0
  def insertCoin(coin: Int): Unit = {
    this.vendingState.insertCoin(coin)
  }

  def coinReturnPressed(): Int = {
    this.vendingState.coinReturnPressed()
  }

  def beverageButtonPressed(): Boolean = {
    this.vendingState.beverageButtonPressed()
  }

  def destroy(): Unit = this.vendingState = new VendingStateBroken(this)

  def fix(): Unit = this.vendingState = new VendingStateWorking(this)
}
