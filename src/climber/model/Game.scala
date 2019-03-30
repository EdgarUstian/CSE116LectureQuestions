package climber.model

import climber.model.game_objects.Platform
import climber.model.physics.{Physics, PhysicsVector, World}
import climber.model.playerstates.GameOver

class Game {

  val world = new World(10)

  val gridWidth: Double = 15
  val gridHeight: Double = 20
  val playerSize: Double = 0.3

  var killLine: Double = -0.1

  var platforms: List[Platform] = List(
    new Platform(new PhysicsVector(0, 0, 0), new PhysicsVector(gridWidth, 0, 0))
  )

  val minPlatformWidth = 1.0
  val maxPlatformWidth = 6.0
  val maxPlatformGaps = 8.0
  val probabilityOfNoPlatforms = 0.2
  val gapProbability = 0.8

  var lastLevelGenerated = 0

  // Track consecutive skipped levels to reduce the probability of impossible jumps
  var skipped = 0
  var maxConsecutiveSkips = 2

  def generateUntilLevel(levelStop: Int) {
    for (level <- lastLevelGenerated + 1 to levelStop) {
      var currentRow = if (skipped < maxConsecutiveSkips && Math.random() < probabilityOfNoPlatforms) {
        skipped += 1
        gridWidth
      } else {
        skipped = 0
        1.0
      }
      while (currentRow < gridWidth - 3) {
        if (Math.random() < gapProbability) {
          currentRow += Math.random() * maxPlatformGaps
        }
        val platformWidth = minPlatformWidth.max(Math.random() * maxPlatformWidth)
        val newPlatform = new Platform(new PhysicsVector(currentRow, 0, level), new PhysicsVector((gridWidth - 1).min(currentRow + platformWidth), 0, level))
        currentRow += platformWidth + 1.0
        platforms = newPlatform :: platforms
        world.platforms = platforms
      }
    }
    lastLevelGenerated = levelStop
  }

  generateUntilLevel(gridHeight.toInt - 5)

  val player1 = new Player(
    new PhysicsVector(gridWidth / 3.0, 0, 0),
    new PhysicsVector(0, 0, 0)
  )

  val player2 = new Player(
    new PhysicsVector(gridWidth * 2.0 / 3.0, 0, 0),
    new PhysicsVector(0, 0, 0)
  )

  world.objects = List(player1, player2)

  def updateWorldAsPlayerRises(player: Player): Unit = {
    if (player.location.z > (killLine + gridHeight / 2.0)) {
      killLine = player.location.z - gridHeight / 2.0
    }
    if (player.location.z > lastLevelGenerated - gridHeight) {
      generateUntilLevel(lastLevelGenerated + gridHeight.toInt)
    }
  }

  def checkIfPlayerFell(player: Player, name: String): Unit = {
    if (player.location.z < killLine && player.isAlive) {
      player.state = new GameOver(player1)

      // Could add game states and transition to an EndGame state
      println(name + " fell")
    }
  }

  def update(deltaTime: Double): Unit = {
    Physics.updateWorld(this.world, deltaTime)
    player1.update(deltaTime)
    player2.update(deltaTime)

    updateWorldAsPlayerRises(player1)
    updateWorldAsPlayerRises(player2)

    checkIfPlayerFell(player1, "Player 1")
    checkIfPlayerFell(player2, "Player 2")
  }

}
