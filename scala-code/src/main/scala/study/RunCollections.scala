package study

object RunCollectionsDeep extends App {
  val strs = List("david", "kevin", "james")
  println(strs.map(_.toUpperCase))

  var datas = List(("A", 1), ("B", 2), ("C", 6), ("B", 2), ("A", 8), ("C", 2))
  datas.groupBy(_._1).foreach({
    case (k, v) => println("key : " + k, "value : " + v)
  })

  val list = (1 to 10)
  println(list.filter(_ > 5))

  var maps = Map("A" -> 1, "B" -> 2, "C" -> 3, "D" -> 4, "E" -> 5)
  maps.mapValues(x => x*x).foreach( x => x match { case (k, v) => printf("key: %s, value: %s\n", k, v) })
}

object RunCollections extends App {

  //  for (num <- 0 to 3) {
  //    println(num)
  //  }
  //
  //  for (num <- 0 until 3) {
  //    println(num)
  //  }

  val strs = Array("A", "B", "C", "D", "E")

  //  for (str <- strs) {
  //    println(str)
  //  }

  strs.foreach(println)

  strs.zipWithIndex.foreach(println)

  // map
  val map = Map("k1" -> "v1",
    "k2" -> "v2",
    "k3" -> "v3",
    "k4" -> "v4",
    "k5" -> "v5")

  for ((k, v) <- map) {
    println(k, v)
  }


  // yield
  def fives(n: Int) = {
    for (x <- 0 to n; if x % 5 == 0)
      yield x
  }

  for (num <- fives(100)) {
    println(num)
  }

}
