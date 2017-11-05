package com.ascariandrea.progfun.week2

object FunctionsAndData {
  val x = new Rational(1, 2)
  println(x.numerator)
  println(x.denominator)

  val y = new Rational(2, 3)
  x.add(y)

  val z = new Rational(3, 2)
  x.sub(y).sub(z)

  y.add(y)
  x.less(y)

  // val strange = new Rational(1, 0);
  // strange.add(strange)

  // new Rational(1)

  // x < y
}

class Rational(x: Int, y: Int) {
  require(y != 0, "Denominator must be nonzero")

  def this(x: Int) = this(x, 1)

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  private val g = gcd(x, y)
  def numerator = x / g
  def denominator = y / g

  def <(that: Rational) = this less that

  def less(that: Rational) =
    numerator * that.denominator < that.numerator * denominator

  def max(that: Rational) =
    if (this.less(that)) that else this

  def neg = new Rational(-numerator, denominator)

  def unary_- : Rational = new Rational(-numerator, denominator)


  def add(that: Rational) =
    new Rational(
      numerator * that.denominator + that.numerator * denominator,
      denominator * that.denominator
    )

  def sub(that: Rational) = add(that.neg)

  def -(that: Rational) = add(that.neg)

   override def toString = numerator + "/" + denominator

}
