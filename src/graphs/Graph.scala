package graphs

class Graph[A] {

  var nodes: Map[Int, A] = Map()
  var adjacencyList: Map[Int, List[Int]] = Map()


  def addNode(index: Int, a: A): Unit = {
    nodes += index -> a
    adjacencyList += index -> List()
  }

  def addEdge(index1: Int, index2: Int): Unit = {
    adjacencyList += index1 -> (index2 :: adjacencyList(index1))
    adjacencyList += index2 -> (index1 :: adjacencyList(index2))
  }

  def isPath(path: List[Int]): Boolean = {
    var isPath = true
    var index = 1
    var canGo = true
    while (canGo) {
      if (!adjacencyList(path(index - 1)).contains(path(index))) {
        isPath = false
        canGo = false
      }
      else {
        if (index == (path.size - 1)) {
          canGo = false
        }
        else {
          index += 1
        }
      }
    }
    isPath
  }

}
