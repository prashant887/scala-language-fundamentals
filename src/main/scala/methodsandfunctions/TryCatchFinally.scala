package methodsandfunctions

import java.io.{FileNotFoundException, IOException}
import scala.io.Source

object TryCatchFinally extends App {

  try {
    val sourcePath=Source.fromFile("data/dividendStocks.csv")
println("Processing FIle Completed")
    val lines=sourcePath.getLines().toVector
    lines.foreach(x=>println(x))
  }catch {
    case ex:FileNotFoundException => println("File Not Found")
    case ex:IOException=>println("Input/Output Exception")
    case ex:Exception => println("Some Error "+ex.getMessage)
  }finally {
    println("Clean Up Done")
  }
println("Final Line Reached")
}
