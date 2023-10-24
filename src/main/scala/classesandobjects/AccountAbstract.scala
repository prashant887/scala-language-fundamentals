package classesandobjects

import java.time.LocalDateTime
import java.util.UUID

abstract class AccountAbstract(id:UUID,name:String,dateOpened:LocalDateTime) {


  private val _id:UUID=id
  private var _name:String=name
  private val _dateOpened=dateOpened

  //variable to be impliemented in sub classes always var
  var _accountType: String


  //auxilary constrctor
  def this(name:String){
this(UUID.randomUUID(),name,LocalDateTime.now())
  }

  def getId:UUID=_id

  def getName:String=_name

  def getOpenedDate:LocalDateTime=_dateOpened

  def setName(name:String):Unit=_name=name

//TO String Method
  override def toString: String = s"Account Id ${_id}  name=${_name} Open Date=${_dateOpened}"
}

class CreditAccountAbstract(name:String) extends AccountAbstract(name:String){
  def getAccountType:String=_accountType

  override var _accountType: String = "Credit"
}

class DepositAccountAbstract(name:String) extends AccountAbstract(name:String){
  def getAccountType:String=_accountType

  override var _accountType: String = "Deposit"
}

object AccountRunnerAbstract extends App{
  val a1=new Account(UUID.randomUUID(),"AccountOne",LocalDateTime.now())
  val a2=new Account(UUID.randomUUID(),"AccountTwo",LocalDateTime.now().minusHours(6))

  println(a1.getId,a1.getName,a1.getOpenedDate)
  println(a2.getId,a2.getName,a2.getOpenedDate)


  val a3 = new Account("AccountThree")

  println(a3.getId, a3.getName, a3.getOpenedDate)

  a3.setName("UpdatedAccountThree")

  println(a3.getId, a3.getName, a3.getOpenedDate)

  println("\n Credit")
  val credit=new CreditAccountAbstract("CreditAccount")
  println(credit.getId, credit.getName, credit.getOpenedDate,credit.getAccountType)

  println("\n")
  //Subtyping
  val deposit: DepositAccountAbstract = new DepositAccountAbstract("DepositAccount")
  println(deposit.getId, deposit.getName, deposit.getOpenedDate, deposit.getAccountType)

  println("\n To String")
  println(deposit)

}