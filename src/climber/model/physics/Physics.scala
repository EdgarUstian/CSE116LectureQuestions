package climber.model.physics

import climber.model.Player
import climber.model.game_objects.{PhysicalObject, Platform}

object Physics {


  val EPSILON: Double = 0.00000001

  def equalDoubles(d1: Double, d2: Double): Boolean = {
    (d1 - d2).abs < EPSILON
  }

  def computePotentialLocation(obj: PhysicalObject, dt: Double): PhysicsVector = {
    val newX = obj.location.x + dt * obj.velocity.x
    val newY = obj.location.y + dt * obj.velocity.y
    val newZ = obj.location.z + dt * obj.velocity.z
    new PhysicsVector(newX, newY, newZ)
  }

  def updateVelocity(obj: PhysicalObject, world: World, dt: Double): Unit = {
    // Always apply gravity. Objects will adjust their velocity if they are on the ground
    obj.velocity.z = obj.velocity.z - world.gravity * dt
  }

  def slope(p1: PhysicsVector, p2: PhysicsVector): Double = {
    if (p2.x - p1.x == 0.0) {
      //      100000000000.0
      Double.PositiveInfinity
    } else {
      (p2.z - p1.z) / (p2.x - p1.x)
    }
  }

  def yIntercept(p1: PhysicsVector, m: Double): Double = {
    p1.z - m * p1.x
  }

  def detectPlatformCollision(obj: PhysicalObject, potentialLocation: PhysicsVector, platform: Platform): Boolean = {

    if (obj.location.x == potentialLocation.x && obj.location.z == potentialLocation.z) {
      return false
    }
    // only in x/z direction
    val mObj = slope(obj.location, potentialLocation)
    val bObj = yIntercept(obj.location, mObj)

    val mBound = slope(platform.start, platform.end)
    val bBound = yIntercept(platform.start, mBound)

    if (equalDoubles(mObj, mBound)) {
      return false
    }

    //    m1x + b1 = m2x + b2
    //    m1x - m2x = b2 - b1
    //    x(m1x - m2) = b2 - b1
    //    x = (b2 - b1) / (m1x - m2)
    val largeSlope = 1000.0
    if (Math.abs(mObj) > largeSlope) {
      val ix: Double = potentialLocation.x
      val iy: Double = ix * mBound + bBound

      val objUp = obj.location.z.max(potentialLocation.z)
      val objDown = obj.location.z.min(potentialLocation.z)

      val bLeft = platform.start.x.min(platform.end.x)
      val bRight = platform.start.x.max(platform.end.x)

      (iy >= objDown && iy <= objUp) && (ix >= bLeft && ix <= bRight)
    } else {

      val ix: Double = (bBound - bObj) / (mObj - mBound)
      val iy: Double = ix * mObj + bObj
      val iy_redundant: Double = ix * mBound + bBound

      val objLeft = obj.location.x.min(potentialLocation.x)
      val objRight = obj.location.x.max(potentialLocation.x)

      val bLeft = platform.start.x.min(platform.end.x)
      val bRight = platform.start.x.max(platform.end.x)

      (ix >= objLeft - EPSILON && ix <= objRight + EPSILON) && (ix >= bLeft - EPSILON && ix <= bRight + EPSILON)
      //      inBoundObject && (ix >= bLeft && ix <= bRight)
      //    ((ix >= objLeft - EPSILON && ix <= objRight + EPSILON) && (iy >= objUp - EPSILON && iy <= objDown + EPSILON)) && ((ix >= bLeft - EPSILON && ix <= bRight + EPSILON) && (iy >= bUp - EPSILON && iy <= bDown + EPSILON))
    }
  }


  def updateWorld(world: World, deltaTime: Double): Unit = {

    for (obj <- world.objects) {
      // update velocity
      updateVelocity(obj, world, deltaTime)

      // get potential location
      val potentialLocation = computePotentialLocation(obj, deltaTime)

      // check collisions
      var collisionDetected = false
      for (wall <- world.platforms) {
        if (detectPlatformCollision(obj, potentialLocation, wall)) {
          collisionDetected = true
        }
      }


      // if collision, do not update z
      obj.location.x = potentialLocation.x
      obj.location.y = potentialLocation.y
      if (!collisionDetected || potentialLocation.z > obj.location.z) {
        obj.location.z = potentialLocation.z
      }


      obj match{
        case player: Player if collisionDetected => player.platformCollision()
        case player: Player if !collisionDetected => player.noPlatformCollision()
        case _ =>
      }

    }

  }

}
