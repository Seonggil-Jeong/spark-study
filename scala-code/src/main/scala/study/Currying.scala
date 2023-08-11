package study

import scala.::

object Currying {
  /**
   * Currying : 함수의 재사용성을 높이기 위헤 함수 자체를 return 하는 함수
   */

  def modN(n: Int)(x: Int): Boolean = {
    ((x % n) == 0)
  }

}

object RunCurrying extends App {
  def modOne = Currying.modN(1) _ // create new F (modN(1, {value}))

  def modTwo: Int => Boolean = Currying.modN(2)

  println(s"${"result : " + modOne(2)}")
  println(s"${"result : " + modTwo(4)}")
}

object TestCurrying extends App {

  def filter(xs: List[Int], p: Int => Boolean): List[Int] =
    if (xs.isEmpty) xs // 비어있는 리스트의 경우 반환
    else if (p(xs.head)) { // 2 % value in list == 0
      println("xs.head : " + xs.head) /** Get First el in List */
      println("xs.tail : " + xs.tail) /** The rest of the collection without its first element. */
      xs.head :: filter(xs.tail, p)
    }
    else filter(xs.tail, p)



  val nums = List(1, 2, 3, 4, 5, 6, 7, 8)

  println(filter(nums, Currying.modN(2))) // List(2, 4, 6, 8)
  println(filter(nums, Currying.modN(3))) // List(3, 6)
}
