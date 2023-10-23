package methodsandfunctions

object NestedMethods extends App {

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

  val records=readFinanceData()

  def printRecords(ticker:String):Unit={
    println("Date|Ticker|Close")
    def printRecords():Unit={
      for (row<-records.filter(x=>x.ticker==ticker)){
        println(s"${row.date}|${row.ticker}|${row.close}")
      }
    }
    printRecords()
  }

  printRecords(ticker = "DB")
}
