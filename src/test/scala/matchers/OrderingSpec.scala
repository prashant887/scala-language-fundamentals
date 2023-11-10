package matchers

import unittests.Currency

class OrderingSpec extends UnitSpec{
behavior of "Currency Conversion Cost in Comparision"

  it should "report equal cost of 10 USD , 10 USD" in{
    val tenUsd:Currency="10 USD"
    val anotherUsd:Currency="10 USD"

    tenUsd.costInDollars.amount should be >= anotherUsd.costInDollars.amount

  }

  it should "report equal cost of 10 USD , 100 USD" in {
    val tenUsd: Currency = "10 USD"
    val anotherUsd: Currency = "100 USD"

    anotherUsd.costInDollars.amount should be > tenUsd.costInDollars.amount

  }
}
