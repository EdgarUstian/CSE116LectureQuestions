package tests

import inheritance._
import org.scalatest._

class TestPolymorphism extends FunSuite {
  test("test animal names") {
    val animals: List[Animal] = Park.animals()
    val names: List[String] = animals.map(animal => animal.toString).sorted
    val expectedNames: List[String] = List("Garfield", "Morris", "Snoopy", "Finn").sorted
    assert(names == expectedNames)
  }
  test("test animal noises") {
    val sounds: List[String] = Park.makeSomeNoise(Park.animals()).sorted
    val expectedSounds: List[String] = List("meow", "meow", "woof", "woof").sorted
    assert(sounds == expectedSounds)
  }
}
