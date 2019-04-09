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

    val root = new BinaryTreeNode[Int](5, null, null)
    root.left = new BinaryTreeNode[Int](2, null, null)
    root.right = new BinaryTreeNode[Int](8, null, null)
    root.left.left = new BinaryTreeNode[Int](-3, null, null)
    root.left.right = new BinaryTreeNode[Int](4, null, null)
    root.right.left = new BinaryTreeNode[Int](7, null, null)
    root.right.right = new BinaryTreeNode[Int](14, null, null)

    println("In-order Traversal:")
    inOrderTraversal(root, println)

    println("\nPre-order Traversal:")
    preOrderTraversal(root, println)

    println("\nPost-order Traversal:")
    postOrderTraversal(root, println)

    println("\nSize of Tree:")
    println(root.otherSize())

  }

  def insertBinaryTree(): Unit = {
    val intLessThan = (a: Int, b: Int) => a < b
    val bst = new BinarySearchTree[Int](intLessThan)
    bst.insert(5)
    bst.insert(2)
    bst.insert(8)
    bst.insert(4)
    bst.insert(7)
    bst.insert(14)
    bst.insert(-3)
    bst.insert(2)
    bst.insert(20)

    println(bst.max())
  }

  def main(args: Array[String]): Unit = {
    binaryTreeExamples()
  }
}
