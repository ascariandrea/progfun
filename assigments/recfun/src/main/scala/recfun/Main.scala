package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   *
   */
    def pascal(c: Int, r: Int): Int = {
      if (c == 0 || r == 1) 1
      else pascal(c - 1, r - 1) + pascal(c, r - 1)
    }

  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
      def loop(ch: List[Char], acc: Int): Boolean = {
        if (ch.isEmpty) acc == 0
        else {
          val delta = if (ch.head == '(') 1 else if (ch.head == ')') -1 else 0
          loop(ch.tail, acc + delta)
        }
      }
      if (chars.size <= 4) false else loop(chars, 0)
    }

  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {
      if (money == 0) 1
      else if (coins.isEmpty || money < 0) 0
      else countChange(money - coins.head, coins) + countChange(money, coins.tail)
    }
  }
