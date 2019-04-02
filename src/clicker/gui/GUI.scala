package clicker.gui

import clicker.Game
import scalafx.animation.AnimationTimer
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.control.TextField
import scalafx.scene.layout.GridPane

object GUI extends JFXApp {


  val game = new Game()
  val digButton = new DigGoldButton(game, 2, 2)
  val equipmentButtons: List[BuyEquipmentButton] = game.equipment.map({ case (equipmentKey, _) => new BuyEquipmentButton(equipmentKey, game) }).toList
  var goldDisplay: TextField = new TextField {
    editable = false
    style = "-fx-font: 18 ariel;"
  }

  this.stage = new PrimaryStage {
    title = "CSE Clicker"
    scene = new Scene() {
      content = List(
        new GridPane {
          add(digButton, 0, 0, 2, 2)
          add(goldDisplay, 0, 2)
          equipmentButtons.indices.foreach(i => add(equipmentButtons.apply(i), 2, i))
          add(new SaveButton(game), 0, 4)
          add(new LoadButton(game), 1, 4)
        }
      )
    }

    AnimationTimer(update).start()
  }

  def update(time: Long): Unit = {
    game.update(time)
    goldDisplay.text = game.goldString()
    equipmentButtons.foreach(x => x.text = game.buttonText(x.equipmentKey))
  }


}
