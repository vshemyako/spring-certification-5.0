package spring.certification.data;

import org.junit.Assert;
import org.junit.Test;
import spring.certification.data.Q004callback.CallbackExample.Scoreboard;
import spring.certification.data.Q004callback.CallbackExample.ScoreboardManager;

/**
 * Verifies functionality of a callback functions.
 */
public class Q004callbackTest {

    /**
     * Verifies that a callback function is indeed invoked, after being passed to another method.
     */
    @Test
    public void shouldChangeScoreboardScore() throws InterruptedException {
        ScoreboardManager scoreboardManager = new ScoreboardManager();
        // Verify that initial score of a score board is "0 - 0"
        Scoreboard scoreboard = new Scoreboard();
        Assert.assertEquals("0 - 0", scoreboard.getScore());

        // Verify that score has changed to "0 - 1"
        scoreboardManager.manageScore(scoreboard::setScore);
        Assert.assertEquals("0 - 1", scoreboard.getScore());
    }
}