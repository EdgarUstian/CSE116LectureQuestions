package inheritance

class Cat(val name: String) extends Animal(name) {
  override def sound(): String = {
    "meow"
  }
}
