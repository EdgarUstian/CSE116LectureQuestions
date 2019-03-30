package datastructures

// Simple Linked List implementation (note: Cannot represent empty list)
class LinkedListNode[A](var value: A, var next: LinkedListNode[A]) {
  def prepend(first: A): LinkedListNode[A] = {
   new LinkedListNode[A](first, LinkedListNode.this)
  }

  def foreach(function: A = Unit): Unit = {
    if (this.value != null){
    function(this.value)
    this.next.foreach(function)
    }
    else if (this.value == null){
      null
    }
  }

  def foreachIterative(function: A => Unit): Unit = {
    var node: LinkedListNode[A] = this
    while (node != null) {
      function(node.value)
      node = node.next
    }
  }
}
