package ch4

import Trees.{Leaf, Node, Tree}

object TreeOps {

  def sum(tree: Tree): Int = {
    tree match {
      case Leaf(v) => v
      case Node(l, r) => sum(l) + sum(r)
    }
  }

  def double(tree: Tree): Tree = {
    tree match {
      case Leaf(v) => Leaf(v * 2)
      case Node(l, r) =>  Node(double(l), double(r))
    }
  }
}
