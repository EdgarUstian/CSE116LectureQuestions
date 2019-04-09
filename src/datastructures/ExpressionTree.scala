package datastructures

import datastructures.BinaryTreeTraversals.postOrderTraversal

object ExpressionTree {

  def fullyParenthesizedInOrderTraversal[A](node: BinaryTreeNode[A], f: A => Unit): Unit = {
    if (node != null) {
      val operator = List("^", "*", "/", "+", "-").contains(node.value)
      if (operator) {
        print("(")
      }
      fullyParenthesizedInOrderTraversal(node.left, f)
      f(node.value)
      fullyParenthesizedInOrderTraversal(node.right, f)
      if (operator) {
        print(")")
      }
    }
  }

  def evaluateTree(node: BinaryTreeNode[String]): Double = {
    var postFixList: List[String] = List()
    postOrderTraversal[String](node, (operand: String) => postFixList = postFixList :+ operand)

    //Helps with evaluating the tree
    val pow = (a: Double, b: Double) => Math.pow(a, b)
    val mul = (a: Double, b: Double) => a * b
    val div = (a: Double, b: Double) => a / b
    val add = (a: Double, b: Double) => a + b
    val sub = (a: Double, b: Double) => a - b

    //Map of operators
    val operatorTable: Map[String, (Double, Double) => Double] = Map(
      "^" -> pow,
      "*" -> mul,
      "/" -> div,
      "+" -> add,
      "-" -> sub
    )

    var nextList: List[String] = postFixList

    var index: Int = 0
    while (index < nextList.size) {
      if (operatorTable.contains(nextList(index))) {
        val operation = operatorTable(nextList(index))
        val result: Double = operation(nextList(index - 2).toDouble, nextList(index - 1).toDouble)
        nextList = nextList.patch(index - 2, List(result.toString), 3)
        index = 0
      }
      else {
        index += 1
      }
    }

    nextList.head.toDouble
  }

  def main(args: Array[String]): Unit = {

    val pow = (a: Double, b: Double) => Math.pow(a, b)
    val mul = (a: Double, b: Double) => a * b
    val div = (a: Double, b: Double) => a / b
    val add = (a: Double, b: Double) => a + b
    val sub = (a: Double, b: Double) => a - b

    val operatorTable: Map[String, (Double, Double) => Double] = Map(
      "^" -> pow,
      "*" -> mul,
      "/" -> div,
      "+" -> add,
      "-" -> sub
    )


    // infix: (12-4)-(8+9/3)
    val root: BinaryTreeNode[String] = new BinaryTreeNode[String]("-", null, null)

    root.left = new BinaryTreeNode[String]("-", null, null)
    root.left.left = new BinaryTreeNode[String]("12", null, null)
    root.left.right = new BinaryTreeNode[String]("4", null, null)

    root.right = new BinaryTreeNode[String]("+", null, null)
    root.right.left = new BinaryTreeNode[String]("8", null, null)
    root.right.right = new BinaryTreeNode[String]("/", null, null)
    root.right.right.left = new BinaryTreeNode[String]("9", null, null)
    root.right.right.right = new BinaryTreeNode[String]("3", null, null)

    val tree: BinaryTreeNode[String] = new BinaryTreeNode[String]("/", null, null)

    tree.left = new BinaryTreeNode[String]("+", null, null)
    tree.left.left = new BinaryTreeNode[String]("15", null, null)
    tree.left.right = new BinaryTreeNode[String]("4", null, null)

    tree.right = new BinaryTreeNode[String]("+", null, null)
    tree.right.left = new BinaryTreeNode[String]("5", null, null)
    tree.right.right = new BinaryTreeNode[String]("*", null, null)
    tree.right.right.left = new BinaryTreeNode[String]("7", null, null)
    tree.right.right.right = new BinaryTreeNode[String]("2", null, null)

    println("\nInfix Notation:")
    fullyParenthesizedInOrderTraversal(root, print)


    println("\n\nPostfix Notation:")
    postOrderTraversal(root, (token: String) => print(token + " "))

    println("\n")
    println(evaluateTree(root))
    println(evaluateTree(tree))
  }

}
