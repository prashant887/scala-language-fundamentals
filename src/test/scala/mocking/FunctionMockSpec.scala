package mocking

import org.scalamock.scalatest.MockFactory
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import unittests.Currency


class FunctionMockSpec extends AnyFlatSpec with Matchers with MockFactory {

  behavior of "Currency's Mocking"

  it should "be able to mock a higher-order function for any input argument and anyNumberOfTimes" taggedAs (Fast) in {
    val currencies: List[Currency] = List("100 USD", "20 EUR", "1000 CAD", "1 USD")

    def getCurrency(criteria: Currency => Boolean): List[Currency] = currencies.filter(criteria)


    val mocked = mockFunction[Currency, Boolean]

    mocked.expects(*).anyNumberOfTimes()

    getCurrency(mocked)

  }
}