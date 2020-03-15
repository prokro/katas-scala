package mastermind

object Mastermind {

  def evaluate(secret: Combination, guess: Combination): Hint = {
    val wellPlaced = secret.toList.zip(guess.toList).count {
      case (secretColor, guessColor) => secretColor == guessColor
    }
    val misplaced = 0
    Hint(wellPlaced, misplaced)
  }

  case class Combination(first: Color, second: Color, third: Color, fourth: Color) {
    def toList: List[Color] = first :: second :: third :: fourth :: Nil
  }

  case class Hint(wellPlaced: Int, misplaced: Int)

  sealed trait Color
  case object Blue extends Color
  case object Red extends Color
  case object Yellow extends Color
  case object Purple extends Color
  case object Green extends Color
  case object Pink extends Color
}