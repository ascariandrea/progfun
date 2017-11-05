package com.ascariandrea.progfun.week3

object Scratch {

  println(new NonEmpty(7, Empty, Empty))

  def error(msg: String) = throw new Error(msg)
  try {
    error("New error")
  } catch {
    case e: Error => println(e)
  }


  val x = null
  val y: String = x

  // error types mismatch
  // val z: Int = x
}
