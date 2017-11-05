package com.ascariandrea.progfun.week4

object Lists {
  import scala.collection.immutable.{List, Nil}

  def isort(xs: List[Int]): List[Int] = xs match {
    case Nil => Nil
    case y :: ys => insert(y, isort(ys))
  }

  def insert(x: Int, xs: List[Int]): List[Int] = xs match {
    case Nil => x :: Nil
    case y :: ys => if (y > x) x :: xs else y :: insert(x, ys)
  }

  val xs = List(9, 4, 6, 3);
  println("List to sort " +  xs)
  println(isort(xs))
}
