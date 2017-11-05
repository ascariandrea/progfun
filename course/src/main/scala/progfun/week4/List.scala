package com.ascariandrea.progfun.week4

import com.ascariandrea.progfun.week3.{NonEmpty, Empty}

trait List[+T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
  // error: covariant type T occurs in contravariant position in type T of value elem
  // def prepend(elem: T): List[T] = new Cons(elem, this)
  //             ^
  def prepend[U >: T](elem: U): List[U] = new Cons(elem, this)
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty = false
}

object Nil extends List[Nothing] {
  def isEmpty = true
  def head = throw new NoSuchElementException("Nil.head")
  def tail = throw new NoSuchElementException("Nil.tail")
}

object List {
  println(new Cons(1, new Cons(2, Nil)))

  val x: List[String] = Nil;
  println(x);

  def f(xs: List[NonEmpty], x: Empty.type) = xs prepend x
}

