package methodsandfunctions

object FunctionalLiteralsAndPlaceholders extends App {

  case class StockRecord(
                        open_date:String,
                        open:Float,
                        high:Float,
                        low:Float,
                        close:Float,
                        adj_close:Float,
                        volume:Double
                        )

  //Generator

  val readFinanceData=()=>{
    val source=io.Source.fromFile("data/VMW.csv")
    for {
      line:String <-source.getLines().drop(1)
      cols=line.split(",").map(x=>x.trim)

    }yield StockRecord(
      cols(0),cols(1).toFloat,
      cols(2).toFloat,cols(3).toFloat,
      cols(4).toFloat,cols(5).toFloat,
      cols(6).toDouble
    )
  }

  val data=readFinanceData().toList


  val getTotalNumberOfRows=()=>data.size


  val getAvgCloseValue=()=>data.map(x=>x.close).sum/data.size


  val getMinCloseValue=()=>data.map(x=>x.close).min


 val getMaxCloseValue=()=>data.map(x=>x.close).max

 val getCloseValueOnDate=(givenDate:String)=> {
   val filteredClose = data.filter(x=>x.open_date==givenDate).map(x=>x.close).max
   filteredClose

 }



 println(s"Data Size ${getTotalNumberOfRows()}")
 println(s"Avg Close ${getAvgCloseValue()}")
 println(s"Min Close ${getMinCloseValue()}")

 println(s"Max Close ${getMaxCloseValue()}")

 val date:String="2020-01-03"
 println(s" Close on date ${date} ${getCloseValueOnDate(date)}")


  val priceDelta=(x:Double,y:Double)=>x-y

  val getDailyDelta=(openPrice:Double,closePrice:Double,delta:(Double,Double)=>Double)=>delta(closePrice,openPrice)

  val record:StockRecord=data.filter(x=>x.open_date==date).head


println(getDailyDelta(record.close,record.open,priceDelta))

}
