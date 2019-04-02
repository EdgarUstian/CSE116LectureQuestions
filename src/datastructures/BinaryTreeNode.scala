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
}
