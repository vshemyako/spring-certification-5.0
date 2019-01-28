package spring.certification.data.q004.example;

import org.junit.Test;
import spring.certification.data.q004.example.CallbackExample.ScoreboardManager;

import static org.junit.Assert.assertEquals;
import static spring.certification.data.q004.example.CallbackExample.Scoreboard;

/**
 * Verifies functionality of a callback functions.
 */
public class CallbackExampleTest {

    /**
     * Verifies that a callback function is indeed invoked, after being passed to another method.
     */
    @Test
    public void shouldChangeScoreboardScore() throws InterruptedException {
        ScoreboardManager scoreboardManager = new ScoreboardManager();
        // Verify that initial score of a score board is "0 - 0"
        Scoreboard scoreboard = new Scoreboard();
        assertEquals("0 - 0", scoreboard.getScore());

        // Verify that score has changed to "0 - 1"
        scoreboardManager.manageScore(scoreboard::setScore);
        assertEquals("0 - 1", scoreboard.getScore());
    }
}