package generics

class Generics {
  def genericMethod[Type](ints: List[Int], function: Int => Type): List[Type] ={
    val newList: List[Type] = List()
    for (int <- ints){
      newList :+ function(int)
    }
    newList
  }
}