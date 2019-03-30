package climber.model.playerstates.airstates

import climber.model.Player
import climber.model.playerstates.groundstates.Standing

class Falling(player: Player) extends InAir(player) {

  override def platformCollision(): Unit = {
    super.platformCollision()
    player.state = new Standing(player)
  }

}
