package methodsandfunctions

object CustomFunction extends App {

  lazy val data: Array[String] = {
    println("Initilize Array")
    Array("MS", "APPL")
  }

  val applyGetNumRows :Function1[Array[String], Int] = new Function1[Array[String], Int] {
    override def apply(data: Array[String]): Int = data.length
  }
  println("Total Number of Rows (apply): ", applyGetNumRows(data))
  println(applyGetNumRows.apply(data))


}
