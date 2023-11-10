package matchers

import unittests.{Customer, CustomerService}

import java.util.UUID

class StringSpec extends UnitSpec {

  val customerService:CustomerService=new CustomerService {}
  behavior of "Customer Service for String"

  it should "correctly match the customer email starting with first name" in {
    val (first,last,email,dateOfBirth)=("John","Smith","john@smith.com","1982/03/12")

    val customerId: UUID = customerService.createNewCustomer(first, last, email, dateOfBirth)
    val customer: Customer = customerService.getCustomer(customerId).get

    customer.email.toString should endWith(".com")
  }

  it should "correctly match the customer email with @" in {
    val (first, last, email, dateOfBirth) = ("John", "Smith", "john@smith.com", "1982/03/12")

    val customerId: UUID = customerService.createNewCustomer(first, last, email, dateOfBirth)
    val customer: Customer = customerService.getCustomer(customerId).get

    customer.email.toString should include("@")
  }

  it should "correctly match the customer email with regexp" in {
    val (first, last, email, dateOfBirth) = ("John", "Smith", "john@smith.com", "1982/03/12")

    val customerId: UUID = customerService.createNewCustomer(first, last, email, dateOfBirth)
    val customer: Customer = customerService.getCustomer(customerId).get

    customer.email.toString should include regex "[a-z]+[@.]com"
  }

  it should "correctly match the customer DateOfBirth with regexp" in {
    val (first, last, email, dateOfBirth) = ("John", "Smith", "john@smith.com", "1982/03/12")

    val customerId: UUID = customerService.createNewCustomer(first, last, email, dateOfBirth)
    val customer: Customer = customerService.getCustomer(customerId).get

    customer.dateOfBirth.toString should fullyMatch regex """[0-9]{4}-[0-9]{2}-[0-9]{2}"""
  }

}
