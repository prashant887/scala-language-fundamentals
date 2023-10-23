package methodsandfunctions


object FunctionInvocationWithExpressionBlocks extends App {

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

  val getStockDetails=(ticker:String)=>records.filter(x=>x.ticker==ticker)

  val ttmStockDetails=getStockDetails("TTM")

  println("--TTM--")
  println(ttmStockDetails)

  /*
  Expression is invoked each time function is called,everytime new randmom stock is picked function is called
   */
  val randomStockDetails = getStockDetails {
    val list: List[String] = List("MSFT", "GOOG", "TTM", "DB", "DNS")
    val radmonNum: Int = util.Random.nextInt(list.length)
    list(radmonNum)
  }
  println("--Random--")
  println(randomStockDetails)

}

