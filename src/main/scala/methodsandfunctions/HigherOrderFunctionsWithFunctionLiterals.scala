package methodsandfunctions

object HigherOrderFunctionsWithFunctionLiterals extends App {

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

  val getStockDetails=(ticker:String,extractFunction:(StockRecord)=>Float)=>{
    val filteredRecord=records.filter(x=>x.ticker==ticker)
    extractFunction(filteredRecord.head)
  }

  val ttmRecord=getStockDetails("TTM",(record:StockRecord)=>record.high)
  println("TTM High")
  println(ttmRecord)

  println("\n")
  val googleRecord = getStockDetails("GOOG", (record: StockRecord) => record.low)
  println("Google Low")
  println(googleRecord)

  def getStockDetailsCurrying(ticker: String)( extractFunction: (StockRecord) => Float): Float = {
    val filteredRecord = records.filter(x => x.ticker == ticker)
    extractFunction(filteredRecord.head)
  }

  println("\n")
  val ttmRecsCurrying=getStockDetailsCurrying("TTM"){
    (records:StockRecord)=>records.high
  }
  println("TTM High")
  println(ttmRecsCurrying)

  println("\n")

  val googleRecsCurrying = getStockDetailsCurrying("GOOG") {
    (records: StockRecord) => records.low
  }
  println("GOOG Low")
  println(googleRecsCurrying)


}
