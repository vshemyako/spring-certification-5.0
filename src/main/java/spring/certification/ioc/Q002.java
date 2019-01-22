package spring.certification.ioc;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 002:<br>
 * What is a pattern?<br>
 * What is an anti-pattern?<br>
 * Is dependency injection a pattern?
 * <p>
 * Answer:<br>
 * Design pattern is a typical solution to commonly occurring problem in software design which is considered a good
 * programming practice. <b>Singleton</b> is an example of a design pattern which is also widely used by Spring
 * framework.
 * <p>
 * Anti-pattern is the opposite - typical solution that is considered a bad programming practice because it's usually
 * ineffective and counterproductive. <b>God object</b> is well known object-oriented anti-pattern.
 * <p>
 * Dependency injection is a design pattern which makes code look cleaner, decreases decoupling between objects,
 * makes code easier to test. For more information about dependency injection design pattern look at {@link Q001DependencyInjection}.
 * <p>
 * Examples of mentioned terms:<br>
 * {@link Q002.DesignPattern} - an example of good coding practice (design pattern).<br>
 * {@link Q002.AntiPattern} - an example of bad coding practice (anti-pattern).<br>
 * {@link Q001DependencyInjection} - discusses dependency injection design pattern in greater details.
 *
 * @author Valentine Shemyako
 * @since November 12, 2018
 */
public class Q002 {

    /**
     * Example demonstrates good programming practice in regard of software design.
     */
    public static class DesignPattern {

        /**
         * There's no reason to allow creation of several instances of a stateless class.
         */
        public static class Singleton {

            /**
             * Reference to single instance is created eagerly.
             */
            private static final Singleton INSTANCE = new Singleton();

            /**
             * External creation of singleton instances is forbidden.
             */
            private Singleton() {
            }

            /**
             * Public access point to get singleton reference.
             */
            public static Singleton getInstance() {
                return INSTANCE;
            }
        }
    }

    /**
     * Example demonstrates bad programming practice in regard of software design.
     */
    public static class AntiPattern {

        /**
         * An example of a class which offers too much non-related functionality which should
         * be separate into several separate classes:<br>
         * 1. Methods functionality of which is related to reading and writing from a file
         * {@link #writeToFile(String, String)}, {@link #readFromFile(String)}<br>
         * 2. Method functionality of which is related to string manipulation:
         * {@link #capitalize(String)}, {@link #toLowerCase(String)}
         */
        public static class GodObject {

            /**
             * Writes provided textual data {@code payload} to already existing {@code destination} file.
             *
             * @param payload     textual data to write.
             * @param destination already existing file.
             */
            public void writeToFile(String payload, String destination) {
                // Implementation omitted for brevity.
            }

            /**
             * Reads content of a file defined by {@code source} parameter.
             *
             * @param source file to read textual data from.
             * @return file contents read from {@code source} file.
             */
            public String readFromFile(String source) {
                // Implementation omitted for brevity.
                return null;
            }

            /**
             * Capitalizes the first letter of a {@code original} string.
             *
             * @param original string first letter of which to capitalize.
             * @return capitalized string.
             */
            public String capitalize(String original) {
                // Implementation omitted for brevity.
                return null;
            }

            /**
             * Converts all of the characters of {@code original} string to lower case.
             *
             * @param original string characters of which will be converted to lower case.
             * @return converted string.
             */
            public String toLowerCase(String original) {
                // Implementation omitted for brevity.
                return null;
            }
        }
    }
}
