package study

object Closures {

  def divide(n: Int) = (x: Int) => {
    x / n
  }

  def divideFive = Closures.divide(5)

}

object RunClosures extends App {
  println(Closures.divideFive(10)) // 2

  var factor = 10

  def multiplier = (x: Int) => x * factor

  println(multiplier(4)) // 40

  factor = 100
  println(multiplier(4)) // 400


}
