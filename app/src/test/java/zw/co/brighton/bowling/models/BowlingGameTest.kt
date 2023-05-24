package zw.co.brighton.bowling.models

import org.junit.Assert.*

import org.junit.Before
import org.junit.Test
import zw.co.brighton.bowling.BowlingGameUtils

class BowlingGameTest {
    var game: BowlingGame = BowlingGame()

    @Before
    fun setUp() {
        game = BowlingGame()
        BowlingGameUtils.loadSampleGame(game)
    }

    @Test
    fun testLastFrame() {
        assertEquals(133, game.getFrameScore(9))
    }

    @Test
    fun testFirstFrame() {
        assertEquals(5, game.getFrameScore(0))
    }

    @Test
    fun testFrameWithSpare() {
        assertEquals(29, game.getFrameScore(2))
    }

    @Test
    fun testFrameWithStrike() {
        assertEquals(60, game.getFrameScore(4))
    }

    @Test
    fun testFrameWithNoBonus() {
        assertEquals(61, game.getFrameScore(5))
    }

}