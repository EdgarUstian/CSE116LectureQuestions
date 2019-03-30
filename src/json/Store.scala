package json

import play.api.libs.json.{JsValue, Json}

class Store(var cashInRegister: Double, var inventory: List[String]){
  def toJSON(): String = {
    val cash: JsValue = Json.toJson(cashInRegister)
    val stuff: JsValue = Json.toJson(inventory)
    val map: Map[String, JsValue] = Map("cashInRegister" -> cash, "inventory" -> stuff)
    Json.stringify(Json.toJson(map))
  }

  def fromJSON(jsonString: String): Unit = {
    val opened: JsValue = Json.parse(jsonString)
    val newCashInRegister: Double = (opened \ "cashInRegister").as[Double]
    val newInventory: List[String] = (opened \ "inventory").as[List[String]]
    this.cashInRegister = newCashInRegister
    this.inventory = newInventory
  }
}