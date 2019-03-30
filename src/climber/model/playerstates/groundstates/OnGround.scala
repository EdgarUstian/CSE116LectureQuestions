package climber.model.playerstates.groundstates

import climber.model.Player
import climber.model.playerstates.PlayerState
import climber.model.playerstates.airstates.Falling

abstract class OnGround(player: Player) extends PlayerState(player) {

  override def leftPressed(): Unit = {
    player.walkLeft()
    player.state = new Walking(player)
  }

  override def rightPressed(): Unit = {
    player.walkRight()
    player.state = new Walking(player)
  }

  override def noPlatformCollision(): Unit = {
    if(this.timeInState > 0.2) {
      player.state = new Falling(player)
    }
  }
}
