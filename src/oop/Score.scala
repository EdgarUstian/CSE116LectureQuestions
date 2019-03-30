package oop

class Score(var score: Int) {
  def scoreGoal(): Unit = {
    this.score += 1
  }
  def isWinner(input: Score): Boolean = {
    if (this.score > input.score){
      true
    }
    else{
      false
    }
  }
}
