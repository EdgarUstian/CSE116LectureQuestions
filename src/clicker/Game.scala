package clicker

import clicker.equipment._

class Game {

  // Do not change these state variable names, types, or initial values
  //
  // These same names, types, and initial values will be the same in all submissions on AutoLab so you can
  //  use these in your test cases
  var gold: Double = 0.0
  var lastUpdateTime: Long = System.nanoTime()
  var equipment: Map[String, Equipment] = Map("shovel" -> new Shovels, "excavator" -> new Excavators, "mine" -> new GoldMines)
  //

  def goldPerSecond(): Double = {
    0.0
  }

  def goldPerClick(): Double = {
    0.0
  }


  def clickGold(): Unit = {

  }

  def buyEquipment(equipmentKey: String): Unit = {

  }

  /**
    * takes the current epoch time in nanoseconds
    */
  def update(time: Long): Unit = {

  }


  def toJSON(): String = {
    ""
  }


  def fromJSON(jsonGameState: String): Unit = {
  }


  // Given
  def goldString(): String = {
    f"$gold%1.0f"
  }

  def buttonText(equipmentKey: String): String = {
    val thing: Equipment = this.equipment.getOrElse(equipmentKey, null) // will crash program if key not found
    val cost = thing.costOfNextPurchase()
    val gpc = thing.goldPerClick()
    val gps = thing.goldPerSecond()
    thing.name + f"\n$cost%1.0f gold\n$gpc%1.0f gpc\n$gps%1.0f gps\nowned: " + thing.numberOwned
  }

  //

}
