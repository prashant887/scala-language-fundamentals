package matchers

import unittests.{Customer, CustomerService}

import java.util.UUID

class LengthAndSizeSpec extends UnitSpec {

  val customerService: CustomerService = new CustomerService {}
  behavior of "Customer Service for Length and Size"

  it should "correctly return lenght of first and last" in {
    val (first, last, email, dateOfBirth) = ("John", "Smith", "john@smith.com", "1982/03/12")

    val customerId: UUID = customerService.createNewCustomer(first, last, email, dateOfBirth)
    val customer: Customer = customerService.getCustomer(customerId).get

    customer.first should have length first.length
    customer.last should have length last.length


  }

  it should "correctly return lenght and size of first and last" in {
    val newCustomer:Seq[(String,String,String,String)]= List(
      ("John", "Smith", "john@smith.com", "1982/03/12"),
      ("Amy", "Grove", "amy@grove.com", "1986/11/05")
    )

   val customerIds:Seq[UUID]=newCustomer.map(customer=>
     customerService.createNewCustomer(customer._1,customer._2,customer._3,customer._4)
   )
    customerIds should have size 2


  }
}
