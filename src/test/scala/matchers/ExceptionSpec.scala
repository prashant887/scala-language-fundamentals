package matchers

import unittests.Currency

class ExceptionSpec extends UnitSpec {

  behavior of "Currency during Exception"

  it should "Throw Invalid Number Exception when Invalid Number is Provided in Currency" in {
    a [NumberFormatException] should be thrownBy Currency.stringToCurrency("Two USD")
    an [NumberFormatException] should be thrownBy Currency.stringToCurrency("Two USD")

  }

}
