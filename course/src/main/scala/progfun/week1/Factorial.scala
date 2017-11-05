package com.ascariandrea.progfun.week1

object Factorial {
  def factorial(n: Int) {
    def rec(i: Int, total: Int): Int =
      if (i == 0) total
      else rec(i - 1, i * total);

    println(rec(n, 1))
  }
  factorial(5);

}
