package com.ascariandrea.progfun.week4

trait Expr {
  def isNumber: Boolean
  def isSum: Boolean
  def numValue: Int
  def leftOp: Expr
  def rightOp: Expr

  def isVar: Boolean
  def isProd: Boolean
  def varValue: String
}

class Number(n: Int) extends Expr {
  def isNumber: Boolean = true
  def isSum: Boolean = false
  def numValue: Int = n
  def leftOp: Expr = throw new Error("Number.leftOp")
  def rightOp: Expr = throw new Error("Number.rightOp")

  def isVar: Boolean = false
  def isProd: Boolean = false
  def varValue: String = null
}

class Sum(e1: Expr, e2: Expr) extends Expr {
  def isNumber: Boolean = false
  def isSum: Boolean = true
  def numValue: Int = throw new Error("Sum.numValue")
  def leftOp: Expr = e1
  def rightOp: Expr = e2

  def isVar: Boolean = false
  def isProd: Boolean = false
  def varValue: String = throw new Error("Sum.varValue")
}

class Prod(e1: Expr, e2: Expr) extends Expr {
  def isNumber = false
  def isSum = false
  def isProd = true
  def isVar = false
  def leftOp: Expr = e1
  def rightOp: Expr = e2
  def varValue: String = throw new Error("Prod.varValue")
  def numValue: Int = throw new Error("Sum.numValue")

}

class Var(x: String) extends Expr {
  def isNumber = false
  def isSum = false
  def isProd = false
  def isVar = true
  def varValue = x
  def leftOp: Expr = throw new Error("Number.leftOp")
  def rightOp: Expr = throw new Error("Number.rightOp")
  def numValue: Int = throw new Error("Sum.numValue")
}

object Decomposition {
  def eval(e: Expr): Int = {
    // if (e.isNumber) e.numValue
    // else if (e.isSum) eval(e.leftOp) + eval(e.rightOp)
    // else throw new Error("Unknown expression" + e)

    if (e.isInstanceOf[Number])
      e.asInstanceOf[Number].numValue
    else if (e.isInstanceOf[Sum])
      eval(e.asInstanceOf[Sum].leftOp) +
      eval(e.asInstanceOf[Sum].rightOp)
    else throw new Error("Unknown expression" +  e)
  }



  println(eval(new Sum(new Number(1), new Number(2))))
}
