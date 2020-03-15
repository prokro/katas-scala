package mastermind

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class MastermindSpec extends AnyFlatSpec with Matchers {

  import Mastermind._

  "Mastermind" should "evaluate guess returning a hint" in {
    evaluate(Combination(Blue, Blue, Blue, Blue), Combination(Red, Red, Red, Red)) should be(
      Hint(wellPlaced = 0, misplaced = 0))

    evaluate(Combination(Blue, Blue, Blue, Blue), Combination(Blue, Blue, Blue, Blue)) should be(
      Hint(wellPlaced = 4, misplaced = 0))

    evaluate(Combination(Blue, Red, Blue, Blue), Combination(Red, Blue, Blue, Blue)) should be(
      Hint(wellPlaced = 2, misplaced = 2))
    evaluate(Combination(Blue, Blue, Red, Red), Combination(Red, Red, Blue, Blue)) should be(
      Hint(wellPlaced = 0, misplaced = 4))
    evaluate(Combination(Blue, Green, Yellow, Red), Combination(Blue, Purple, Red, Pink)) should be(
      Hint(wellPlaced = 1, misplaced = 1))

    evaluate(Combination(Red, Red, Blue, Blue), Combination(Yellow, Blue, Red, Red)) should be(
      Hint(wellPlaced = 0, misplaced = 3))
    evaluate(Combination(Red, Red, Blue, Blue), Combination(Yellow, Yellow, Red, Red)) should be(
      Hint(wellPlaced = 0, misplaced = 2))
    evaluate(Combination(Red, Red, Blue, Blue), Combination(Yellow, Yellow, Yellow, Red)) should be(
      Hint(wellPlaced = 0, misplaced = 1))

    evaluate(Combination(Yellow, Red, Blue, Yellow), Combination(Yellow, Blue, Yellow, Red)) should be(
      Hint(wellPlaced = 1, misplaced = 3))
    evaluate(Combination(Red, Red, Blue, Yellow), Combination(Red, Red, Yellow, Blue)) should be(
      Hint(wellPlaced = 2, misplaced = 2))
  }

  // TODO property based tests
  // - never 3 well placed and 1 misplaced
  // - wellPlaced + misplaced <= 4
  // - intersecting colors = 0 => well placed + misplaced == 0
  // - intersecting colors = 4 => well placed + misplaced == 4
  // - intersecting colors = 1 => well placed + misplaced == 1
  // - intersecting colors = 2 => well placed + misplaced == 2, 3 or 4
  // - intersecting colors = 3 => well placed + misplaced == 3 or 4
}
