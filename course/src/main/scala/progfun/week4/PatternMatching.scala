package com.ascariandrea.progfun.week4

object PatternMatching {
  trait Expr {
    def show: String = this match {
      case Number(n) => n.toString
      case Sum(e1, e2) => e1.show + "+" + e2.show
    }
  }

  case class Number(n: Int) extends Expr
  case class Sum(e1: Expr, e2: Expr) extends Expr

  println(Sum(Number(1), Number(3)).show)
}
