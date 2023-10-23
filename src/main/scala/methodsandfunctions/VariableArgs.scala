package methodsandfunctions

object VariableArgs extends App {

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

  //Variable length ars shd be last
  def getRecordsVarsDate(date:String,tickers:String*):Vector[(String,String,Float)]={
    val dateFilterRecs:Vector[StockRecord]=records.filter(x=>x.date==date)
    val filterRecs:Vector[StockRecord]=dateFilterRecs.filter(x=>tickers.contains(x.ticker))
    filterRecs.map(x=>(x.date,x.ticker,x.open))
  }

  println(getRecordsVarsDate("12-06-2020","TTM","DB","GOOG"))

  println("\n")

  def getRecordsVars(tickers: String*): Vector[(String, String, Float)] = {
    val filterRecs: Vector[StockRecord] = records.filter(x => tickers.contains(x.ticker))
    filterRecs.map(x => (x.date, x.ticker, x.open))
  }

  val tickes:List[String]=List("TTM","DB","BNS")
  println(getRecordsVars(tickers = tickes:_*))
  }
