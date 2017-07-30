package ch4

object Trees {

  sealed trait Tree

  final case class Leaf(value: Int) extends Tree
  final case class Node(left: Tree, right: Tree) extends Tree
}
