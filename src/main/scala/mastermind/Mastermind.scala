package mastermind

object Mastermind {

  sealed trait Color

  case object Blue   extends Color
  case object Red    extends Color
  case object Yellow extends Color
  case object Purple extends Color
  case object Green  extends Color
  case object Pink   extends Color

  case class Combination(first: Color, second: Color, third: Color, fourth: Color) {
    def toList: List[Color] = first :: second :: third :: fourth :: Nil
  }

  case class Hint(wellPlaced: Int, misplaced: Int)

  case class Position(secretColor: Color, guessedColor: Color, wellPlaced: Boolean)

  def evaluate(secret: Combination, guess: Combination): Hint = {
    val zipped = secret.toList.zip(guess.toList)

    val positions = zipped.map {
      case (secretColor, guessedColor) =>
        Position(secretColor, guessedColor, secretColor == guessedColor)
    }

    val wellPlaced    = positions.filter(_.wellPlaced)
    val notWellPlaced = positions.filter(!_.wellPlaced)

    val remainingSecrets = notWellPlaced.map(_.secretColor)
    val remainingGuesses = notWellPlaced.map(_.guessedColor)

    val wrongGuesses = remainingGuesses.diff(remainingSecrets)

    Hint(wellPlaced.size, remainingGuesses.size - wrongGuesses.size)
  }
}
