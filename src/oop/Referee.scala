package oop

object Referee {
  def playGame(team1: Team, team2: Team): Unit = {
    //calculating score for team1`
    if (team1.offense - team2.defense > 0){
      team1.score = team1.offense - team2.defense
    }
    else team1.score = 0

    //calculating score for team2
    if (team2.offense - team1.defense > 0){
      team2.score = team2.offense - team1.defense
    }
    else team2.score = 0
  }

  def declareWinner(team1: Team, team2: Team): Team = {
    if (team1.score > team2.score){
      team1
    }
    else if (team1.score < team2.score){
      team2
    }
    else {
      val emptyTeam: Team = new Team(0, 0)
      emptyTeam
    }
  }
}
