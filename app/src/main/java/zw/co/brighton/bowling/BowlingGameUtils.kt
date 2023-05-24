package zw.co.brighton.bowling

import zw.co.brighton.bowling.models.BowlingGame

object BowlingGameUtils {
    fun loadSampleGame(game: BowlingGame) {
        game.updateScore(0, 0, 1)
        game.updateScore(0, 1, 4)

        game.updateScore(1, 0, 4)
        game.updateScore(1, 1, 5)

        game.updateScore(2, 0, 6)
        game.updateScore(2, 1, BowlingGame.SPARE)

        game.updateScore(3, 0, 5)
        game.updateScore(3, 1, BowlingGame.SPARE)

        game.updateScore(4, 0, BowlingGame.STRIKE)

        game.updateScore(5, 0, 0)
        game.updateScore(5, 1, 1)

        game.updateScore(6, 0, 7)
        game.updateScore(6, 1, BowlingGame.SPARE)

        game.updateScore(7, 0, 6)
        game.updateScore(7, 1, BowlingGame.SPARE)

        game.updateScore(8, 0, BowlingGame.STRIKE)

        game.updateScore(9, 0, 2)
        game.updateScore(9, 1, BowlingGame.SPARE)
        game.updateScore(9, 2, 6)
    }
}