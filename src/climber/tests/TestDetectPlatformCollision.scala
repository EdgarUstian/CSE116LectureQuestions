package climber.tests

import climber.model.game_objects.{PhysicalObject, Platform}
import climber.model.physics._
import org.scalatest._

class TestDetectPlatformCollision extends FunSuite {

  val EPSILON: Double = 0.000001

  def equalDoubles(d1: Double, d2: Double): Boolean = {
    (d1 - d2).abs < EPSILON
  }

  def equalVectors(v1: PhysicsVector, v2: PhysicsVector): Boolean = {
    equalDoubles(v1.x, v2.x) && equalDoubles(v1.y, v2.y) && equalDoubles(v1.z, v2.z)
  }

  test("Physical objects collide with platforms") {
    val player: PhysicalObject = new PhysicalObject(new PhysicsVector(2.0, 0.0, 0.9), new PhysicsVector(0, 0, 0))
    val platform: Platform = new Platform(new PhysicsVector(1.0, 0.0, 1.0), new PhysicsVector(3.0, 0.0, 1.0))

    val collisionExpected: List[PhysicsVector] = List(
      new PhysicsVector(2.0, 0.0, 1.1),
      new PhysicsVector(2.1, 0.0, 1.1),
      new PhysicsVector(2.0, 0.0, 1.01),
      new PhysicsVector(1.9, 0.0, 1.1),
      new PhysicsVector(3.0, 0.0, 1.01),
      new PhysicsVector(-3.0, 0.0, 10.01)
    )

    val noCollisionExpected: List[PhysicsVector] = List(
      new PhysicsVector(2.0, 0.0, 0.7),
      new PhysicsVector(2.0, 0.0, 0.99),
      new PhysicsVector(3.0, 0.0, 0.99),
      new PhysicsVector(1.0, 0.0, 0.99)
    )

    for(newLocation <- collisionExpected){
      assert(Physics.detectPlatformCollision(player, newLocation, platform), newLocation)
    }


    for(newLocation <- noCollisionExpected){
      assert(!Physics.detectPlatformCollision(player, newLocation, platform), newLocation)
    }
  }

  test("Physical object beside platforms") {
    val player: PhysicalObject = new PhysicalObject(new PhysicsVector(1.1, 0.0, 0.9), new PhysicsVector(0, 0, 0))
    val platform: Platform = new Platform(new PhysicsVector(1.0, 0.0, 1.0), new PhysicsVector(-1.0, 0.0, 1.0))

    val collisionExpected: List[PhysicsVector] = List(
    )

    val noCollisionExpected: List[PhysicsVector] = List(
      new PhysicsVector(1.1, 0.0, 1.1)
    )

    for(newLocation <- collisionExpected){
      assert(Physics.detectPlatformCollision(player, newLocation, platform), newLocation)
    }


    for(newLocation <- noCollisionExpected){
      assert(!Physics.detectPlatformCollision(player, newLocation, platform), newLocation)
    }
  }
  test("Physical object on floor") {
    val player: PhysicalObject = new PhysicalObject(new PhysicsVector(6.471269812000002, 0.0, 0.0), new PhysicsVector(0, 0, 0))
    val platform: Platform = new Platform(new PhysicsVector(0, 0, 0), new PhysicsVector(15, 0, 0))

    val collisionExpected: List[PhysicsVector] = List(
      new PhysicsVector(6.536614680000002, 0.0, -0.00266871985871089)
    )

    val noCollisionExpected: List[PhysicsVector] = List(
    )

    for(newLocation <- collisionExpected){
      assert(Physics.detectPlatformCollision(player, newLocation, platform), newLocation)
    }


    for(newLocation <- noCollisionExpected){
      assert(!Physics.detectPlatformCollision(player, newLocation, platform), newLocation)
    }
  }

  test("Physical object resting on platforms") {
    val player: PhysicalObject = new PhysicalObject(new PhysicsVector(5.0, 0.0, 10.0), new PhysicsVector(0, 0, 0))
    val platform: Platform = new Platform(new PhysicsVector(4.0, 0.0, 10.0), new PhysicsVector(8.0, 0.0, 10.0))

    val collisionExpected: List[PhysicsVector] = List(
      new PhysicsVector(5.0, 0.0, 9.9),
      new PhysicsVector(5.1, 0.0, 9.9),
      new PhysicsVector(4.9, 0.0, 9.9)
    )

    for(newLocation <- collisionExpected){
      assert(Physics.detectPlatformCollision(player, newLocation, platform), newLocation)
    }

  }

  test("Physical objects collide with sloped platforms") {
    val player: PhysicalObject = new PhysicalObject(new PhysicsVector(-2.0, 0.0, -0.9), new PhysicsVector(0, 0, 0))
    val platform: Platform = new Platform(new PhysicsVector(-0.0, 0.0, -0.0), new PhysicsVector(-3.0, 0.0, -3.0))

    val collisionExpected: List[PhysicsVector] = List(
      new PhysicsVector(-2.0, 0.0, -2.1),
      new PhysicsVector(-0.5, 0.0, -0.9),
      new PhysicsVector(-3.5, 0.0, -4.1),
      new PhysicsVector(-0.9, 0.0, -2.0)
    )

    val noCollisionExpected: List[PhysicsVector] = List(
      new PhysicsVector(-2.0, 0.0, -0.7),
      new PhysicsVector(-2.0, 0.0, 0.99),
      new PhysicsVector(-3.0, 0.0, -0.9),
      new PhysicsVector(1.0, 0.0, 3.0)
    )

    for(newLocation <- collisionExpected){
      assert(Physics.detectPlatformCollision(player, newLocation, platform), newLocation)
    }


    for(newLocation <- noCollisionExpected){
      assert(!Physics.detectPlatformCollision(player, newLocation, platform), newLocation)
    }
  }

}
