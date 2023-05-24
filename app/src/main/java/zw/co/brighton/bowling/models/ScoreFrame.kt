package zw.co.brighton.bowling.models

data class ScoreFrame(
    val position: Int,
    val isLastFrame: Boolean = false,
) {
    private val scores: MutableList<Int> = if (isLastFrame) mutableListOf(0,0,0) else mutableListOf(0,0)

    fun updateScore(scoreIndex: Int, score: Int) {
        scores[scoreIndex] = score
    }

    fun getFirstScore() = scores.first()

    fun getSecondScore() = scores[1]

    fun getThirdScore(): Int {
        return if (isLastFrame) scores[2]
        else -1
    }

    fun isFirstOrSecondStrikeOrSpare(): Boolean {
        return getFirstScore() == BowlingGame.STRIKE
                || getFirstScore() == BowlingGame.SPARE
                || getSecondScore() == BowlingGame.STRIKE
                || getSecondScore() == BowlingGame.SPARE
    }

    fun hasStrike(): Boolean = scores.any { it==BowlingGame.STRIKE }

    fun hasSpare(): Boolean = scores.any { it==BowlingGame.SPARE }

}
