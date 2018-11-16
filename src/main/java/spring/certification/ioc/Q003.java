package spring.certification.ioc;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 003:<br>
 * What is an interface and what are the advantages of making use of them in Java?<br>
 * Why are they recommended for Spring beans?
 * <p>
 * Answer:<br>
 * Interface is an abstract reference type which defines a set of methods with no implementations (prior to Java 8).
 * <p>
 * Advantages of using interfaces:<br>
 * 1. Reduces dependencies on implementation details, therefore making code more reusable and easier to refactor<br>
 * 2. Allows to provide different implementations at runtime<br>
 * 3. Makes code easier to test
 * <p>
 * Those advantages are the main reasons why interfaces are suggested to be used by Spring beans (replacements,
 * interception, decoration of beans is possible).<br>
 * <p>
 * <p>
 * Note:<br>
 * Spring bean is an object which is instantiated, assembled and otherwise managed by Spring IoC container.
 * The motivation for using the name 'bean' arose as a response to the complexity of <b>Enterprise JavaBeans</b>
 * technology.
 * <p>
 * Examples of mentioned terms:<br>
 * {@link Q003.InterfaceExample} - shows advantages of programming to an interface not an implementation.<br>
 *
 * @author Valentine Shemyako
 * @since November 13, 2018
 */
public class Q003 {

    /**
     * Demonstrates advantages of using an interface instead of a class.
     */
    public static class InterfaceExample {

        /**
         * Interface which defines basic actions each human can perform.
         */
        public interface Human {

            /**
             * Gives a polite word or sign of welcome.
             */
            void greet();

            /**
             * Gives food to somebody who needs it.
             */
            void feed();

            /**
             * Makes one easier to do something.
             */
            void help();
        }

        /**
         * A domestic animal.
         */
        public static class Pet {

            /**
             * An owner of a pet.
             */
            private Human owner;

            /**
             * It's easy (and possible) to write code which relies on abstract types. Actual implementation
             * can be developed later, substituted with mocks or stubs at the test phase. Moreover our own
             * implementation details know nothing about actual implementation details of our dependencies.
             *
             * @param owner any sort of human who will be an owner of a pet.
             */
            public Pet(Human owner) {
                this.owner = owner;
            }

            /**
             * Pet is fed by an abstract human, concrete implementation of which can be changed at runtime
             * (for example injected by DI container).
             */
            public void eat() {
                this.owner.feed();
            }
        }
    }
}
