package inheritance

abstract class Animal(name: String) {
  def sound(): String ={
    this.name
  }
  override def toString: String ={
    this.name
  }
}
