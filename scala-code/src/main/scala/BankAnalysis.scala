import org.apache.spark.sql.{Row, SparkSession}
import org.apache.spark
import org.apache.spark.rdd.RDD

case class Bank(age: Int, job: String, marital: String, education: String, balance: Int)

object Spark extends App {

  val spark = Init.spark("BankAnalysis")

  import spark.implicits._

  val bankText: RDD[String] = spark.read.textFile("hdfs://localhost:9000/user/seonggil/bank-full.csv").rdd

  def parseLine(line: String): Bank = {
    val parts = line.split(";")
    Bank(
      age = parts(0).toInt,
      job = parts(1).replaceAll("\"", ""),
      marital = parts(2).replaceAll("\"", ""),
      education = parts(3).replaceAll("\"", ""),
      balance = parts(5).toInt
    )
  }

  val bank = bankText.filter(s => !s.contains("age")).map(parseLine).toDS()

  bank.createOrReplaceTempView("bank")

  spark.sql("SELECT age, COUNT(1) FROM bank GROUP BY age ORDER BY age").show()

  spark.stop()
}
