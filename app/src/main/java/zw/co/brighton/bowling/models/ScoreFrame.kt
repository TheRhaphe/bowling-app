package zw.co.brighton.bowling.models

import zw.co.brighton.bowling.models.BowlingGame.Companion.SPARE
import zw.co.brighton.bowling.models.BowlingGame.Companion.STRIKE

data class ScoreFrame(
    val position: Int,
    val isLastFrame: Boolean = false,
) {
    private val scores: MutableList<Int> = if (isLastFrame) mutableListOf(0,0,0) else mutableListOf(0,0)

    fun updateScore(scoreIndex: Int, score: Int) {
        if (score in 0..9 || score == STRIKE || score == SPARE)
            scores[scoreIndex] = score
    }

    fun getFirstScore() = scores.first()

    fun getSecondScore() = scores[1]

    fun getThirdScore(): Int {
        return if (isLastFrame) scores[2]
        else -1
    }

    fun isFirstOrSecondStrikeOrSpare(): Boolean {
        return getFirstScore() == STRIKE
                || getFirstScore() == SPARE
                || getSecondScore() == STRIKE
                || getSecondScore() == SPARE
    }

    fun hasStrike(): Boolean = scores.any { it == STRIKE }

    fun hasSpare(): Boolean = scores.any { it == SPARE }

}
