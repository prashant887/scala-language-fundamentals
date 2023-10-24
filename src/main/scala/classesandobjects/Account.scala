package classesandobjects

import java.time.LocalDateTime
import java.util.UUID

class Account(id:UUID,name:String,dateOpened:LocalDateTime) {


  private val _id:UUID=id
  private var _name:String=name
  private val _dateOpened=dateOpened

  //auxilary constrctor
  def this(name:String){
this(UUID.randomUUID(),name,LocalDateTime.now())
  }

  def getId:UUID=_id

  def getName:String=_name

  def getOpenedDate:LocalDateTime=_dateOpened

  def setName(name:String):Unit=_name=name


}

class CreditAccount(name:String) extends Account(name:String){
  private val _accountType="Credit"
  def getAccountType:String=_accountType
}

class DepositAccount(name:String) extends Account(name:String){
  private val _accountType="Deposit"
  def getAccountType:String=_accountType
}

object AccountRunner extends App{
  val a1=new Account(UUID.randomUUID(),"AccountOne",LocalDateTime.now())
  val a2=new Account(UUID.randomUUID(),"AccountTwo",LocalDateTime.now().minusHours(6))

  println(a1.getId,a1.getName,a1.getOpenedDate)
  println(a2.getId,a2.getName,a2.getOpenedDate)


  val a3 = new Account("AccountThree")

  println(a3.getId, a3.getName, a3.getOpenedDate)

  a3.setName("UpdatedAccountThree")

  println(a3.getId, a3.getName, a3.getOpenedDate)

  println("\n Credit")
  val credit=new CreditAccount("CreditAccount")
  println(credit.getId, credit.getName, credit.getOpenedDate,credit.getAccountType)

}