package climber.model.game_objects

import climber.model.physics.PhysicsVector

object Platform {

  var nextID: Int = 0

}

class Platform(var start:PhysicsVector, var end: PhysicsVector){

  val platformID: Int = Platform.nextID
  Platform.nextID += 1

}
