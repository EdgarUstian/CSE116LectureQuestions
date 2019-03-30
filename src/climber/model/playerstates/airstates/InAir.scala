package climber.model.playerstates.airstates

import climber.model.Player
import climber.model.playerstates.PlayerState

abstract class InAir(player: Player) extends PlayerState(player) {

  override def leftPressed(): Unit = {
    player.moveLeftMidAir()
  }

  override def rightPressed(): Unit = {
    player.moveRightMidAir()
  }


}
