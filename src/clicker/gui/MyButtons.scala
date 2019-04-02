package clicker.gui

import java.io.FileNotFoundException
import java.nio.file.{Files, Paths}

import clicker.Game
import scalafx.Includes._
import scalafx.event.ActionEvent
import scalafx.scene.control.Button

import scala.io.Source

class MyButton(game: Game, xScale: Double, yScale: Double) extends Button {

  minWidth = 100 * xScale
  minHeight = 100 * yScale
  style = "-fx-font: 12 ariel;"

}

class DigGoldButton(game: Game, xScale: Double = 1.0, yScale: Double = 1.0) extends MyButton(game, xScale, yScale) {
  text = "Gold!"
  style = "-fx-font: 24 ariel;"
  onAction = (event: ActionEvent) => game.clickGold()
}


class BuyEquipmentButton(val equipmentKey: String, game: Game, xScale: Double = 1.0, yScale: Double = 1.0) extends MyButton(game, xScale, yScale) {
  onAction = (event: ActionEvent) => game.buyEquipment(equipmentKey)
}

object SaveState {
  val FILENAME: String = "savedGame.json"
}

class SaveButton(game: Game, xScale: Double = 1.0, yScale: Double = 1.0) extends MyButton(game, xScale, yScale) {
  minHeight = 40 * yScale
  text = "save"
  onAction = (event: ActionEvent) => this.saveGame(SaveState.FILENAME)

  def saveGame(filename: String): Unit = {
    Files.write(Paths.get(filename), game.toJSON().getBytes())
  }

}

class LoadButton(game: Game, xScale: Double = 1.0, yScale: Double = 1.0) extends MyButton(game, xScale, yScale) {
  minHeight = 40 * yScale
  text = "load"
  onAction = (event: ActionEvent) => this.loadGame(SaveState.FILENAME)

  def loadGame(filename: String): Unit = {
    try {
      game.fromJSON(Source.fromFile(filename).mkString)
    } catch {
      case ex: FileNotFoundException => ex.printStackTrace()
    }
  }
}
