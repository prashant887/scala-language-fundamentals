package methodsandfunctions

import scala.annotation.tailrec

object TailReccursive extends App {

  case class StockRecord(date: String,
                         open: Float,
                         high: Float,
                         low: Float,
                         close: Float,
                         ticker: String)

  val readFinanceData = () => {
    val source = io.Source.fromFile("data/stockMarketData.csv")
    for {
      line <- source.getLines().drop(1).toVector
      cols = line.split(",").map(_.trim)
    } yield StockRecord(cols(0), cols(1).toFloat,
      cols(2).toFloat, cols(3).toFloat,
      cols(4).toFloat, cols(5))
  }



  @tailrec
  def rollingAvgReccursion(records:Vector[StockRecord],numDays:Int):Unit={
    //Base case
    if(records.length<numDays){
      println("Execution Completed")
      throw new Exception("Error to see stack trace")
    }
    else {
      val avrageClosePrice: Double = records.map(x => x.close).take(numDays).sum / numDays
      println(s"Rolling Average for $numDays is date ${records.head.date} $avrageClosePrice")
      val updatedRecords=records.drop(1)
      rollingAvgReccursion(updatedRecords,numDays)
      //println("Last Line of Method")

    }
  }
  println("\n")
  rollingAvgReccursion(readFinanceData(),7)
}
