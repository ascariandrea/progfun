package com.ascariandrea.progfun.week2

object Sum {
  def sum(f: Int => Int)(a: Int, b: Int): Int = {
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc
      else loop(a + 1, f(a) + acc);
    }
    loop(a, 0)
  }

  println(sum(x => x + x)(1, 3))

}
