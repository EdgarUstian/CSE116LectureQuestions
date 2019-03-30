package oop
import org.scalatest._

class TestReferee extends FunSuite {
  val t1: Team = new Team(7, 3)
  val t2: Team = new Team(4, 20)
  Referee.playGame(t1, t2)
  assert(Referee.declareWinner(t1, t2) == t2)
  assert(Referee.declareWinner(t2, t1) == t2)

}
