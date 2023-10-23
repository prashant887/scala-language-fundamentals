package methodsandfunctions

object CurryFunctionDefault extends App {

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

  def getStockPriceDetails(date:String="11-06-2020")(ticker:String="GOOG")(priceTag:String):(String,String,Float)={
    println(s"Access for Records $date")
    val filterDateRecs=records.filter(x=>x.date==date)

    println(s"Access for Records $ticker")
    val filterTickerRecs=filterDateRecs.filter(x=>x.ticker==ticker)

    println(s"Access for Records $priceTag")

    val price:Float=priceTag match {
      case "open" => filterTickerRecs.head.open
      case "close" => filterTickerRecs.head.close
      case "high" => filterTickerRecs.head.high
      case "low" => filterTickerRecs.head.low

    }
    (date,ticker,price)
  }

  println(getStockPriceDetails(date="11-06-2020")(ticker="DB")(priceTag = "high"))
  println("\n")
  println(getStockPriceDetails()(ticker="DB")(priceTag = "low"))
  println("\n")
  println(getStockPriceDetails(date="11-06-2020")()(priceTag = "open"))
  println("\n")
  println(getStockPriceDetails()()(priceTag = "close"))
}
