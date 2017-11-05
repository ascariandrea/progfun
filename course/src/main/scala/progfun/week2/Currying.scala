package com.ascariandrea.progfun.week2

object Currying {
  def product(f: Int => Int)(a: Int, b: Int): Int = {
    if (a > b) 1 else f(a) * product(f)(a + 1, b)
  }

  def factorial(n: Int) = product(x => x)(1, n)

  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int = {
    if (a > b) zero
    else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))
  }

  println(product(x => x * x)(1, 2))
  println(mapReduce(x => x * x, (a, b) => a * b, 1)(1, 2))

  println(factorial(3))
  println(mapReduce(x => x, (a, b) => a * b, 1)(1, 3))
}

