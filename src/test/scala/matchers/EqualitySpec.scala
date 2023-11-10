package matchers

import unittests.Dollars

class EqualitySpec extends UnitSpec{

  it should "Match 2 USD Dollar Amount" in {
    val currencyOne:Dollars=Dollars(10)
    val currencyTwo:Dollars=Dollars(10)

    currencyOne should equal(currencyTwo)

  }

  it should "Match 2 USD Dollar Amount should ===" in {
    val currencyOne: Dollars = Dollars(10)
    val currencyTwo: Dollars = Dollars(10)

    currencyOne should === (currencyTwo)

  }

  it should "Match 2 USD Dollar Amount shouldEqual" in {
    val currencyOne: Dollars = Dollars(10)
    val currencyTwo: Dollars = Dollars(10)

    currencyOne shouldEqual currencyTwo

  }

  it should "Match 2 USD Dollar Amount shouldBe" in {
    val currencyOne: Dollars = Dollars(10)
    val currencyTwo: Dollars = Dollars(10)

    currencyOne shouldBe  currencyTwo

  }


  it should "Match 2 USD Dollar Amount should Be" in {
    val currencyOne: Dollars = Dollars(10)
    val currencyTwo: Dollars = Dollars(10)

    currencyOne should be (currencyTwo)

  }

}
