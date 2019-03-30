package climber.model

import climber.model.game_objects.PhysicalObject
import climber.model.physics._
import climber.model.playerstates.PlayerState
import climber.model.playerstates.groundstates.Standing

class Player(playerLocation: PhysicsVector,
             playerVelocity: PhysicsVector
            ) extends PhysicalObject(playerLocation, playerVelocity) {

  val walkingSpeed: Double = 4.0
  val airSpeed: Double = 3.0

  val standingJumpVelocity: Double = 6.0
  val walkingJumpVelocity: Double = 8.0

  var state: PlayerState = new Standing(this)

  // Held flags used to improve responsiveness. Without them the player has to either repress the button or
  // wait for the next button pressed event (which is slow)
  var leftKeyHeld = false
  var rightKeyHeld = false
  var jumpKeyHeld = false

  // Begin API methods
  def leftPressed(): Unit = {
    this.leftKeyHeld = true
    this.state.leftPressed()
  }

  def rightPressed(): Unit = {
    this.rightKeyHeld = true
    this.state.rightPressed()
  }

  def jumpPressed(): Unit = {
    this.jumpKeyHeld = true
    this.state.jumpPressed()
  }

  def leftReleased(): Unit = {
    this.leftKeyHeld = false
    this.state.leftReleased()
  }

  def rightReleased(): Unit = {
    this.rightKeyHeld = false
    this.state.rightReleased()
  }

  def jumpReleased(): Unit = {
    this.jumpKeyHeld = false
    this.state.jumpReleased()
  }

  def update(dt: Double): Unit = {
    this.state.update(dt)
  }

  def platformCollision(): Unit = {
    this.state.platformCollision()
  }

  def noPlatformCollision(): Unit = {
    this.state.noPlatformCollision()
  }

  def isAlive: Boolean = {
    this.state.isAlive
  }

  // End API methods


  // 5 helper methods that will be called by multiple states. Methods added here to avoid rewriting them in each state
  // where they are called

  def walkLeft(): Unit = {
    this.velocity.x = -this.walkingSpeed
  }

  def walkRight(): Unit = {
    this.velocity.x = this.walkingSpeed
  }


  // Adjust to air speed when in air. Only applies if the direction is changed mid air
  def moveLeftMidAir(): Unit = {
    this.velocity.x = this.velocity.x.min(-this.airSpeed)
  }

  def moveRightMidAir(): Unit = {
    this.velocity.x = this.velocity.x.max(this.airSpeed)
  }


  def stop(): Unit = {
    this.velocity.x = 0.0
  }


}
