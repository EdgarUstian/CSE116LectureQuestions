package inheritance

class Dog(val name: String) extends Animal(name) {
  override def sound(): String = {
    "woof"
  }
}
