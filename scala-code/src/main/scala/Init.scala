import org.apache.spark.sql.SparkSession

object Init extends App {

  def spark(appName: String = "SparkApp"): SparkSession = SparkSession.builder()
    .appName(appName)
    .master("local[*]")
    .config("spark.driver.host", "127.0.0.1")
    .config("spark.driver.bindAddress", "127.0.0.1").getOrCreate()

}
