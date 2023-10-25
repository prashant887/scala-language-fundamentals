package classesandobjects

trait User{
  def getFirst:String
  def getLast:String
}

trait Transactions  {
  //Self Types
  this:User=>
  def printAmountWithTransaction(amount:Double):Unit={
    val fullNmae:String=this.getFirst+" "+this.getLast
    val tax:Double=amount*0.10
    println(s"$fullNmae Paid $tax Tax on Amount $amount")
  }
}


//Instance Variables and not class variables
class DebitTrans(val first:String,val last:String) extends User with Transactions {
  override def getFirst: String = first

  override def getLast: String = last
}
object TransactionRunner extends App {
val transactions:DebitTrans=new DebitTrans("Tony","Stark")
transactions.printAmountWithTransaction(100.02)
}
