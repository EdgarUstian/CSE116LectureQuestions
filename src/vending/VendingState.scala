package vending

trait VendingState {
  def insertCoin(coin: Int): Unit
  def coinReturnPressed(): Int
  def beverageButtonPressed(): Boolean
}
