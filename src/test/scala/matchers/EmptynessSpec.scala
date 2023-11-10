package matchers

import unittests.{Currency, Customer, CustomerService}

import java.util.UUID

class EmptynessSpec extends UnitSpec {

  val customerService: CustomerService = new CustomerService {}
  behavior of "Customer Service for Emptiness"

  it should "correctly return empty of first " in {
    val (first, last, email, dateOfBirth) = ("", "Smith", "john@smith.com", "1982/03/12")

    val customerId: UUID = customerService.createNewCustomer(first, last, email, dateOfBirth)
    val customer: Customer = customerService.getCustomer(customerId).get

    customer.first should be (empty)
    customer.first shouldBe (empty)


  }

  it should "be empty when no curriencies are added to wallet" in {
    val wallet:List[Currency]=List.empty
    wallet should be (empty)
  }

}
