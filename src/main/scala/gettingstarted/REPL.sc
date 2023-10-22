val a:Int=100
val b:Int=200

val ifStr:String=if (a>500) {
  "Greater"
}
else {
  "Less"
}

val optStr:Option[String]=if (a>500) {
  Some("Greater")
}
else {
  None
}

val matchStr:String=optStr match {
  case Some(value)=>s"$value Found"
  case None => "Nothing Found"
}

val amounts:Array[Int]=Array(1,2,3,4,5)

for(amount<-amounts) {
  //println(amount)
  amount
}

val notes: Array[Int] = Array(10, 24, 35, 23, 12)
val currencies:Array[String]=Array("USD","INR")

val reuslt:Array[String]=for {
  note <-notes
  currency<-currencies
}yield s"$note $currency" //Generator

val reusltGaurd:Array[String]=for {
  note <-notes
  currency<-currencies
  if note>20 //Gaurd
}yield s"$note $currency" //Generator

abstract class Currency

case class USD() extends Currency;//has apply method
case class INR() extends Currency;

val currency:Currency=USD()
val amount:Int=100

currency match {
  case USD()=>println(s"USD $amount")
  case _ => println("Unknown Currency")
}

//Variable Number of I/p

def multiply(nums:Int*):Int={
  nums.reduce((x,y)=>{x*y})
}

multiply(1,2,3,4,5)

def sumOfOdd(nums:Int):Int={
  def getOdds(n:Int):List[Int]={
     (1 to n by 2).toList

  }
  getOdds(10).reduce((x,y)=>x+y)
}

sumOfOdd(nums = 10)

//Higher Order Function
def sum(a:Int,b:Int):Int=a+b
def cube(a:Int):Int=a*a*a
def square(a:Int):Int=a*a
val fun=(x:Int,y:Int)=>x+y
def transform(f:Int=>Int,nums:Int*):Seq[Int]=nums.map(f)

transform(square,1,2,3,4)

val sq=(n:Int)=>n*n



transform(sq,4,5,6,7)

val calc=(f:(Int,Int)=>Int,x:Int,y:Int)=>{
  f(x,y)
}

calc(fun,2,3)

calc(sum,4,5)
