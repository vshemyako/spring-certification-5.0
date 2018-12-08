package spring.certification.aop;

import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 005:<br>
 * How many advice types does Spring support. Can you name each one?<br>
 * What different advice types are used for?<br>
 * Which types of advices can you use if you would like to try and catch exceptions?<br>
 * <p>
 * Answer:<br>
 * Spring AOP supports the following type of advices:<br>
 * 1. {@link Before} - advice runs before execution of a join point.<br>
 * 2. {@link AfterReturning} - advice runs after a join point completes normally.<br>
 * 3. {@link AfterThrowing} - advice runs in case a join point throws an exception.<br>
 * 4. {@link After} - advice runs regardless of normal or exceptional execution.<br>
 * 5. {@link Around} - advice that surrounds execution of a join point. Custom logic can be executed before and after
 * a join point. Join point can be invoked one, many or none times.<br>
 * <p>
 * Examples of mentioned terms:<br>
 * -
 *
 * @author Valentine Shemyako
 * @since December 07, 2018
 */
public class Q005advice {

    @Configuration
    @ComponentScan
    @EnableAspectJAutoProxy
    public static class ConfigurationMarker {
    }

    /**
     * A smart person.
     */
    @Aspect
    @Component
    public static class Genius {

        /**
         * Gives a cue about asked question before someone answered.
         */
        @Before(value = "@annotation(spring.certification.aop.Q005advice.GiveMeBeforeCue) && args(country)")
        public void giveBeforeCue(String country) {
            String capital;
            switch (country) {
                case "Germany":
                    capital = "Berlin";
                    break;
                case "Italy":
                    capital = "Rome";
                    break;
                default:
                    capital = "New York";
                    break;
            }
            System.out.println(capital);
        }

        /**
         * Gives a cue about asked question after some answered.
         */
        @AfterReturning(value = "@annotation(spring.certification.aop.Q005advice.GiveMeAfterCue) && args(country)")
        public void giveAfterCue(String country) {
            String queen;
            switch (country) {
                case "England":
                    queen = "Elizabeth";
                    break;
                default:
                    queen = "Margrethe";
                    break;
            }
            System.out.println(queen);
        }

        /**
         * Gives a cue after someone panics =).
         */
        @AfterThrowing(value = "@annotation(spring.certification.aop.Q005advice.GiveMeExceptionalCue) && args(country)")
        public void giveExceptionalCue(String country) {
            String continent;
            switch (country) {
                case "China":
                    continent = "Asia";
                    break;
                default:
                    continent = "Africa";
                    break;
            }
            System.out.println(continent);
        }
    }

    /**
     * A dumb person =).
     */
    @Component
    public static class Fool {

        /**
         * A fool person is asked to name capital of a specified country.
         */
        @GiveMeBeforeCue
        public void nameCapital(String country) {
            System.out.println(String.format("Capital of %s unknown", country));
        }

        /**
         * A fool person is asked to name queen of a specified country.
         */
        @GiveMeAfterCue
        public void nameQueen(String country) {
            System.out.println(String.format("Queen of %s unknown", country));
        }

        /**
         * A fool person panics when he is asked about continents =).
         */
        @GiveMeExceptionalCue
        public void nameContinent(String country) {
            throw new IllegalArgumentException(String.format("Continent of %s unknown", country));
        }
    }

    /**
     * Marker annotations for methods which ask to 'advice' them.
     */
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface GiveMeBeforeCue {
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface GiveMeAfterCue {
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface GiveMeExceptionalCue {
    }
}
