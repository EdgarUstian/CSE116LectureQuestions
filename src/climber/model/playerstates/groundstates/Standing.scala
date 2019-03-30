package climber.model.playerstates.groundstates

import climber.model.Player
import climber.model.playerstates.airstates.Rising

class Standing(player: Player) extends OnGround(player) {

  override def jumpPressed(): Unit = {
    player.velocity.z = player.standingJumpVelocity
    player.state = new Rising(player)
  }

}
