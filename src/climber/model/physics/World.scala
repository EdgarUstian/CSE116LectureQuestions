package climber.model.physics

import climber.model.game_objects.{PhysicalObject, Platform}

class World(var gravity: Double) {

  var objects: List[PhysicalObject] = List()
  var platforms: List[Platform] = List()

}
