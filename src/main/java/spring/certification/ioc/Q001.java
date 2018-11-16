package spring.certification.ioc;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 001:<br>
 * What is dependency injection and what are the advantages?
 * <p>
 * Answer:<br>
 * <b>Dependency injection</b> is a design pattern which implements <b>Inversion of Control (IoC)</b> design principle,
 * whereby objects only define their dependencies letting some other code to <b>inject</b> those dependencies during
 * object creation. That is why this process is called an inversion: an object doesn't control instantiation of its
 * dependencies on its own.
 * <p>
 * There are several dependency <b>injection types</b>:<br>
 * 1. Constructor injection - dependencies are provided through a constructor<br>
 * 2. Setter injection - dependencies are provided through an exposed setter method<br>
 * 3. Field injection - dependencies are injected directly in the field, with no constructor or setter method.
 * In Java language field injection is performed with the help of 'magical' reflection technology, so even private
 * fields can be populated in that way. Fields have to be annotated with the {@link Autowired} annotation to become
 * candidate to field injection<br>
 * 4. Interface injection - dependencies are provided through an exposed setter method of implemented interface<br>
 * <p>
 * Dependency injection <b>advantages</b> are the following:<br>
 * 1. Code is cleaner (object configuration details are externalized)<br>
 * 2. Decoupling decreases between an object and its dependencies<br>
 * 3. Code is easier to test using stubs or mocks<br>
 * 4. Facilitating single responsibility principle
 * <p>
 * Dependency injection <b>disadvantages</b> are the following:<br>
 * 1. Increased number of classes<br>
 * 2. Creation of unnecessary interfaces<br>
 * <p>
 * Examples of mentioned terms:<br>
 * {@link Q001.WithoutInjector} - an example which doesn't utilize Dependency Injection design pattern.<br>
 * {@link Q001.WithInjector} - an example which utilizes Dependency Injection design pattern.<br>
 * {@link DependencyInjectionTypes#injectThroughConstructor()} - an example of injecting dependencies through
 * constructor.<br>
 * {@link DependencyInjectionTypes#injectThroughSetter()} - an example of injecting dependencies through setter.<br>
 * {@link DependencyInjectionTypes#injectThroughInterface()} - an example of injecting dependencies through setter
 * of implemented interface.<br>
 *
 * @author Valentine Shemyako
 * @since November 9, 2018
 */
public class Q001 {

    /**
     * Example demonstrates dependencies creation by an object itself.
     */
    public static class WithoutInjector {

        /**
         * A young human being who doesn't have enough life experience to make some actions on his own.
         */
        public static class NaughtyChild {

            /**
             * Some beverage which child drinks when he is thirsty.
             */
            private Beverage drink;

            /**
             * Child chooses what type of beverage to drink on his own. It's potentially dangerous -
             * what if he chose bottle of some alcoholic drink? =).
             */
            public NaughtyChild() {
                this.drink = Refrigerator.getDrink();
            }

            // Additional logic is omitted for brevity.
        }
    }

    /**
     * Example demonstrates dependency injection design pattern: when dependencies are provided
     * by some third-party object.
     */
    public static class WithInjector {

        /**
         * A young human being who asks his parents to help him in different tricky situations
         * (like choosing beverage from a refrigerator :D).
         */
        public static class ObedientChild implements DrinkSetter {

            /**
             * Some beverage which child drinks from time to time.
             */
            private Beverage drink;

            /**
             * It's usual to provide constructor which omits optional dependencies
             * provided through setter methods.
             */
            public ObedientChild() {
            }

            /**
             * Child doesn't choose what type of beverage to drink. Vice versa he is asking
             * his parents to give him some drink.
             *
             * @param drink which is given to the child for drinking.
             */
            public ObedientChild(Beverage drink) {
                this.drink = drink;
            }

            /**
             * It's not required to inject dependencies only through constructor.
             * It's also legal to expose setter method for dependency injection.
             *
             * @param drink which will be given to a child.
             */
            public void setDrink(Beverage drink) {
                this.drink = drink;
            }

            /**
             * Another option to inject dependency - through additional interface.
             *
             * @param drink which is provided to some object.
             */
            @Override
            public void consumeDrink(Beverage drink) {
                setDrink(drink);
            }

            // Additional logic is omitted for brevity.
        }

        /**
         * This is an injector: it provides required dependencies to manages objects.
         * In particular case parent helps his child.
         */
        public class Parent {

            /**
             * Gives a drink to his child.
             */
            public void giveDrinkToChild() {
                ObedientChild child = new ObedientChild(Refrigerator.getDrink());
            }
        }
    }

    /**
     * Example demonstrates different types of dependency injections.
     */
    public static class DependencyInjectionTypes {

        /**
         * Dependency is injected through constructor.
         */
        public void injectThroughConstructor() {
            new WithInjector.ObedientChild(Refrigerator.getDrink());
        }

        /**
         * Dependency is injected through setter.
         */
        public void injectThroughSetter() {
            WithInjector.ObedientChild child = new WithInjector.ObedientChild();
            child.setDrink(Refrigerator.getDrink());
        }

        /**
         * Dependency is injected through setter of implemented interface.
         */
        public void injectThroughInterface() {
            // Interface type is exposed.
            DrinkSetter drinkSetter = new WithInjector.ObedientChild();
            drinkSetter.consumeDrink(Refrigerator.getDrink());
        }
    }

    /**
     * Household appliance which stores food and drinks.
     */
    public static class Refrigerator {

        /**
         * Provides a drink which is stored in refrigerator.
         *
         * @return some beverage which is stored in refrigerator.
         */
        public static Beverage getDrink() {
            return new Beverage();
        }
    }

    /**
     * A drink.
     */
    private static class Beverage {
    }

    /**
     * Additional interface which is exposed by constructed object of a class.
     * Sometimes it's useful to establish how a dependency should be injected.
     */
    private interface DrinkSetter {

        /**
         * Consumes a drink.
         *
         * @param drink which is provided to some object.
         */
        void consumeDrink(Beverage drink);
    }
}
