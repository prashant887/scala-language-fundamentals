package methodsandfunctions

object HigherOrderFunctions extends App {

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

  println(records.getClass)

  val extractHighPrice=(records:Vector[StockRecord])=>{
    for(record<-records) yield (record.ticker,record.high)
  }

  val extractOpenPrice = (records: Vector[StockRecord]) => {
    for (record <- records) yield (record.ticker, record.open)
  }

  val extractClosePrice = (records: Vector[StockRecord]) => {
    for (record <- records) yield (record.ticker, record.close)
  }

  val extractPriceDelta = (records: Vector[StockRecord]) => {
    for (record <- records) yield (record.ticker,record.close- record.open)
  }


  val extractInfo = (records:Vector[StockRecord],extractFunction:Vector[StockRecord]=>Vector[(String,Float)] ) => {
    extractFunction(records)
  }

  println("\n \n ")

  println(" High :"+extractHighPrice(records))
  println(" Open :"+extractOpenPrice(records))
  println(" Close :"+extractClosePrice(records))
  println(" Delta :"+extractPriceDelta(records))


  println("\n \n ")
  println(" High :" + extractInfo(records,extractHighPrice))
  println(" Open :" + extractInfo(records,extractOpenPrice))
  println(" Close :" + extractInfo(records,extractClosePrice))


  println("\n Return Function \n")

  val getExtractFunction=(functionName:String,records:Vector[StockRecord])=>{
    functionName match {
      case "high" => ()=>for(record<-records) yield (record.ticker,record.high)
      case "low" => ()=>for(record<-records) yield (record.ticker,record.low)
      case "open" => ()=>for(record<-records) yield (record.ticker,record.open)
      case "close" => ()=>for(record<-records) yield (record.ticker,record.close)
    }
  }

  val openValFunction=getExtractFunction("high",records)

  println("\n")

  println("Open Function "+openValFunction())
}
