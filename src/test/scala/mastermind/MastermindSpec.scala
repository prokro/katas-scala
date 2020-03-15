package mastermind

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers


class MastermindSpec extends AnyFlatSpec with Matchers {

  import Mastermind._

  "Mastermind" should "evaluate guess returning a hint" in {
    evaluate(Combination(Blue, Blue, Blue, Blue), Combination(Red, Red, Red, Red)) should be(Hint(wellPlaced = 0, misplaced = 0))
    evaluate(Combination(Blue, Blue, Blue, Blue), Combination(Blue, Blue, Blue, Blue)) should be(Hint(wellPlaced = 4, misplaced = 0))
    evaluate(Combination(Blue, Red, Blue, Blue), Combination(Red, Blue, Blue, Blue)) should be(Hint(wellPlaced = 2, misplaced = 2))
  }
}
