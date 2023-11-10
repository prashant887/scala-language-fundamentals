package matchers

import org.scalatest.Inside
import unittests.{Currency, Dollars}

class PatternMatchingSpec extends UnitSpec with Inside{

  behavior of "Currency Pattern Matching"

  it should "be able to assert values on Currency" in {
    val tenUsd:Currency="10 USD"

    inside(tenUsd){
      case Currency(code, amount, costInDollars)=>
        code should equal("USD")
        amount should equal(10.0+-0.5)
        costInDollars should be > Dollars(12)
    }
  }
  it should "be able to patternMatch values on Currency" in {
    val tenUsd: Currency = "10 USD"
tenUsd should matchPattern {case Currency("USD",_,_)=>}
  }

  }
