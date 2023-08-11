package study

object Maths {
  def add(a: Int = 0, b: Int = 0): Int = (a + b)

  // exec는 3개의 파라미터(함수 f, x, y)를 받음
  def exec(f: (Int, Int) => Int, x: Int, y: Int): Int = f(x, y)

}

object RunMaths extends App {
  println(Maths.exec(
    f = (a: Int, b: Int) => a + b,
    x = 2,
    y = 3
  )
  )

  println(Maths.exec(
    f = (x, y) => x + y,
    x = 2,
    y = 3
  ))

  println(Maths.exec(_ + _, 2, 3))

}
