package study

class Person(val name: String, // 접근 가능, 변경 불가
             var age: Int, // 접근 가능, 변경 가능
             id: String = "DEFAULT-ID" // 접근 불가능, 변경 불가능
            ) {

  def getId(): String = id

  def greeting() = println(s"${name} 님은 ${age}살 입니다")


}

class Writer(name: String, age: Int, id: String)
  extends Person(name = name, age = age, id = "WRITER " + id) {
  def work() = println("직업은 작가입니다")

}


object RunPerson extends App {
  val p: Person = new Person(
    name = "Seonggil",
    age = 22,
    id = "NEW ID"
  )
  p.age = 23
  println("p age : " + p.age)
  println("id : " + p.getId())
  p.greeting()

  val w: Writer = new Writer(name = "name", age = 20, id = "WW_ID")
  println(w.getId())
  w.work()

  val wTwo: Writer = new Writer(name = "name2", age = 23, id = "WE") {
    override def work(): Unit = println("직업은 작가 Two 입니다")
  }

  wTwo.work()
}
