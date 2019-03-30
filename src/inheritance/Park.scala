package inheritance

object Park {
  def animals(): List[Animal] ={
    List(
      new Dog("Snoopy"), new Dog("Finn"),
      new Cat("Garfield"), new Cat("Morris"))
  }
  def makeSomeNoise(animalia: List[Animal]): List[String] ={
    var noise: List[String] = List()
    for (animal <- animalia){
      noise = noise :+ animal.sound()
    }
    noise
  }

  def main(args: Array[String]): Unit = {
    println(makeSomeNoise(animals()))
  }
}