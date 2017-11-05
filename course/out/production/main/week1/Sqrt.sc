object Sqrt {

  def abs(x: Double) = if (x > 0) -x else x

  def isGoodEnough(guess: Double, x: Double): Double =
    (guess * guess - x) >= 0.0001

  def improve(guess: Double, x: Double): Double =
    (guess + x / guess) / 2

  def sqrtIterator(guess: Double, x: Double): Double =
    if (isGoodEnough(guess, x)) guess
    else sqrtIterator(improve(guess, x), x)

  def sqrt(x: Double) = sqrtIterator(1.0, x)

  sqrt(2)
  sqrt(4)
}

