package matchers

import unittests.Currency

class ContainerSpec extends UnitSpec {

behavior of "Currencies in Wallet"

  it should "Contain a currency that is added to Wallet List " in {
    val oneUsd:Currency="1 USD"
    val twoEuros:Currency="2 EUR"
    val tenCad:Currency="10 CAD"

    val wallet:List[Currency]=List(oneUsd,twoEuros,tenCad)

    wallet should contain(oneUsd)
  }

  it should "Contain a currency that is added to Wallet Map " in {
    val oneUsd: Currency = "1 USD"
    val twoEuros: Currency = "2 EUR"
    val tenCad: Currency = "10 CAD"

    val wallet: Map[String,Currency] = Map(
      "USD"->oneUsd,
      "EUR"->twoEuros,
      "CAD"->tenCad
    )
    wallet should contain("EUR"->twoEuros)

  }


  it should "Contain One Of the USD that is added to wallet " in {
    val oneUsd: Currency = "1 USD"
    val twoEuros: Currency = "2 EUR"
    val tenCad: Currency = "10 CAD"
    val hundredINR: Currency = "100 INR"

    val wallet:Set[Currency]=Set(oneUsd,twoEuros,tenCad,oneUsd,twoEuros,tenCad)

    wallet should contain oneOf(oneUsd,hundredINR)
    wallet should contain oneElementOf List(oneUsd,hundredINR)

  }

  it should "Contain None Of the USD that is added to wallet " in {
    val oneUsd: Currency = "1 USD"
    val twoEuros: Currency = "2 EUR"
    val tenCad: Currency = "10 CAD"
    val hundredINR: Currency = "100 INR"

    val wallet: Set[Currency] = Set(oneUsd, twoEuros, oneUsd)

    wallet should contain noneOf (tenCad, hundredINR)
    wallet should contain noElementsOf  List(tenCad, hundredINR)

  }
}
