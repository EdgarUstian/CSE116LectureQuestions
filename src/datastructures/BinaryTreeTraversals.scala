package datastructures

object BinaryTreeTraversals {

  def inOrderTraversal[A](node: BinaryTreeNode[A], f: A => Unit): Unit = {
    if (node != null) {
      inOrderTraversal(node.left, f)
      f(node.value)
      inOrderTraversal(node.right, f)
    }
  }

  def preOrderTraversal[A](node: BinaryTreeNode[A], f: A => Unit): Unit = {
    if (node != null) {
      f(node.value)
      preOrderTraversal(node.left, f)
      preOrderTraversal(node.right, f)
    }
  }

  def postOrderTraversal[A](node: BinaryTreeNode[A], f: A => Unit): Unit = {
    if (node != null) {
      postOrderTraversal(node.left, f)
      postOrderTraversal(node.right, f)
      f(node.value)
    }
  }

  def binaryTreeExamples(): Unit = {

    val root = new BinaryTreeNode[Int](7, null, null)
    root.left = new BinaryTreeNode[Int](2, null, null)
    root.right = new BinaryTreeNode[Int](16, null, null)
    root.left.right = new BinaryTreeNode[Int](-8, null, null)
    root.right.left = new BinaryTreeNode[Int](10, null, null)
    root.right.right = new BinaryTreeNode[Int](6, null, null)

    val customFunction = (a: Int, b: Int, c: Int) => a + 2 * b - c
    println(root.compute(customFunction))

    //    println("Pre-order Traversal:")
    //    preOrderTraversal(root, println)
    //
    //    println("\nIn-order Traversal:")
    //    inOrderTraversal(root, println)
    //
    //    println("\nPost-order Traversal:")
    //    postOrderTraversal(root, println)
    //
    //    println("\nSize of Tree:")
    //    println(root.otherSize())

  }

  def insertBinaryTree(): Unit = {
    val intLessThan = (a: Int, b: Int) => a < b
    val bst = new BinarySearchTree[Int](intLessThan)
    bst.insert(10)
    bst.insert(-9)
    bst.insert(9)
    bst.insert(-6)
    bst.insert(8)
    bst.insert(1)
    bst.insert(-10)
    bst.insert(12)

    println(bst.max())
  }

  def main(args: Array[String]): Unit = {
    binaryTreeExamples()
  }
}
