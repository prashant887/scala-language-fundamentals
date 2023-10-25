package classesandobjects

import java.time.LocalDateTime
sealed  trait Kind

case object Debit extends Kind
case object Credit extends Kind
case object Refund extends Kind

case class TransactionCase(name:String,amount:Double,kind:String,when:LocalDateTime)
object TransactionCaseRunner extends App{

  val t1=TransactionCase("T1",12.23,"debit",LocalDateTime.now())
  println(t1.toString)

  val t2=TransactionCase("T2",23.23,"credit",LocalDateTime.now())
  println(t2)

  println(t1==t2)

  val amount:Double=t2 match {
    case TransactionCase(name,amount,kind,when)=>amount
  }

  println(amount)

  /*
  Sealed Traits and Extenstions are used to restrict the possiblities of match
  and only certain match patterns are possible
   */
  def getMessage(kind:Kind):String={
  kind match {
    case Debit => "Debit Transaction"
  }
  }
  println(getMessage(Debit))
}
