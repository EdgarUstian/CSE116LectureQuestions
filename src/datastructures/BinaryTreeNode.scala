package datastructures

import datastructures.BinaryTreeTraversals._

class BinaryTreeNode[A](var value: A, var left: BinaryTreeNode[A], var right: BinaryTreeNode[A]) {
  def size(): Int = {
    var nodes: Int = 0
    preOrderTraversal[A](this, _ => nodes += 1)
    nodes
  }

  def otherSize(): Int = {
    var count: Int = 1
    if (this.left != null) {
      count += this.left.otherSize()
    }
    if (this.right != null) {
      count += this.right.otherSize()
    }
    count
  }

  def compute(func: (Int, A, Int) => Int): Int = {
    val leftResult = if (this.left != null) {
      println(this.left.value, this.value)
      this.left.compute(func)
    } else 1

    val rightResult = if (this.right != null) {
      println(this.value, this.right.value)
      this.right.compute(func)
    } else 1
    println(leftResult, this.value, rightResult)
    println(func(leftResult, this.value, rightResult))
    func(leftResult, this.value, rightResult)
  }

}
