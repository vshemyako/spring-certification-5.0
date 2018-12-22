package spring.certification.data;

import java.util.function.Consumer;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 004:<br>
 * What is a callback?<br>
 * What are the three JdbcTemplate callback interfaces that can be used with queries?<br>
 * What each JdbcTemplate is used for?<br>
 * <p>
 * Answer:<br>
 * <b>Callback</b> is a function 'A' which is provided as an argument to a function 'B' and is allowed to be called by
 * the function 'B'.<br>
 * <b>Main JdbcTemplate callbacks:</b><br>
 * - {@link org.springframework.jdbc.core.CallableStatementCreator} - is used for executing stored procedures<br>
 * - {@link org.springframework.jdbc.core.PreparedStatementCreator} - is used for repeatable executing of pre-compiled
 * SQL statements<br>
 * - {@link org.springframework.jdbc.core.RowCallbackHandler} - is used for mapping ResultSet results on one-row basis<br>
 * <p>
 * Examples of mentioned terms:<br>
 * {@link CallbackExample} - demonstrates a basic usage of callback function.<br>
 *
 * @author Valentine Shemyako
 * @since December 21, 2018
 */
public class Q004callback {

    /**
     * Demonstrates how 'callback' function might be implemented using Java language.
     */
    public static class CallbackExample {

        /**
         * A large board on which the score in a game is displayed.
         */
        public static class Scoreboard {

            /**
             * The score to be displayed on a board.
             */
            private String score = "0 - 0";

            /**
             * Setter will be our call-back function, which is invoked in case score changes.
             */
            public void setScore(String score) {
                this.score = score;
            }

            /**
             * Getter, to verify behavior of a callback function in unit tests.
             */
            public String getScore() {
                return score;
            }
        }

        /**
         * A person who changes the score displayed on a board.
         */
        public static class ScoreboardManager {

            /**
             * Invokes callback function in case score has changed.
             */
            public void manageScore(Consumer<String> changeScore) throws InterruptedException {
                // Score doesn't change instantly...
                Thread.sleep(1000);
                // Our callback function is invoked...
                changeScore.accept("0 - 1");
            }
        }
    }
}
