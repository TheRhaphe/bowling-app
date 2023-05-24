package zw.co.brighton.bowling.models

import zw.co.brighton.bowling.BowlingGameUtils

class BowlingGame {
    val frames: List<ScoreFrame>

    init {
        val numOfFrames = 10
        frames = MutableList(numOfFrames) { index ->
            ScoreFrame(position = index, isLastFrame = index==(numOfFrames-1))
        }
        BowlingGameUtils.loadSampleGame(this)
    }

    fun updateScore(frameIndex: Int, scoreIndex: Int, score: Int) {
        frames[frameIndex].updateScore(scoreIndex = scoreIndex, score = score)
    }

    fun getFrameScore(position: Int): Int {
        if (position<0) return 0
        val frame = frames[position]
        val prevScore = getFrameScore(position-1)
        return if(frame.isLastFrame) {
            if (frame.isFirstOrSecondStrikeOrSpare()) {
                prevScore + STRIKE_SPARE_SCORE + frame.getThirdScore()
            } else {
                prevScore + frame.getFirstScore() + frame.getSecondScore()
            }
        } else if (frame.hasStrike()) {
            prevScore + STRIKE_SPARE_SCORE + getStrikeBonus(position)
        } else if (frame.hasSpare()) {
            prevScore + STRIKE_SPARE_SCORE + getSpareBonus(position)
        } else {
            prevScore + frame.getFirstScore() + frame.getSecondScore()
        }
    }

    fun getSpareBonus(position: Int): Int {
        if (position>=frames.size-1) return 0
        val frame = frames[position+1]
        if (frame.hasStrike()) return STRIKE_SPARE_SCORE
        return frame.getFirstScore()
    }

    fun getStrikeBonus(position: Int): Int {
        if (position>=frames.size) return 0
        val frame = frames[position+1]
        return if(frame.hasSpare()||frame.hasStrike()) STRIKE_SPARE_SCORE
        else frame.getFirstScore() + frame.getSecondScore()
    }

    companion object {
        const val SPARE = -1
        const val STRIKE = -2
        const val STRIKE_SPARE_SCORE = 10
    }
}