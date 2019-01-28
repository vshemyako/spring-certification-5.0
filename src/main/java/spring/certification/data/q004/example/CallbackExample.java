package spring.certification.data.q004.example;

import java.util.function.Consumer;

/**
 * Demonstrates how 'callback' function might be implemented using Java language.
 */
public class CallbackExample {

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

