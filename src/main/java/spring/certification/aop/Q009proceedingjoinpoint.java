package spring.certification.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 009:<br>
 * What is a ProceedingJoinPoint?<br>
 * When ProceedingJoinPoint is used?<br>
 * <p>
 * Answer:<br>
 * {@link ProceedingJoinPoint} is an extension of an {@link JoinPoint} interface which allows to control execution logic
 * of advised method. In particular it allows to adjust input parameters of advised method, skip execution of an adviced
 * method, or invoke advised method logic multiple times. In order to invoke advised method {@link ProceedingJoinPoint#proceed()}
 * or {@link ProceedingJoinPoint#proceed(Object[])} method should be used.<br>
 * {@link ProceedingJoinPoint} must be the first argument of the advice and is only accessible in {@link Around} advices.<br>
 * <p>
 * Examples of mentioned terms:<br>
 * -
 *
 * @author Valentine Shemyako
 * @since December 09, 2018
 */
public class Q009proceedingjoinpoint {

    @Configuration
    @ComponentScan
    @EnableAspectJAutoProxy
    public static class AspectMarkerConfiguration {
    }

    /**
     * Aspect which validates input parameters passed to {@link PositiveNumbers#addNumber(Integer)} method.
     */
    @Aspect
    @Component
    public static class ArgumentValidator {

        /**
         * Validates numbers which are passed to {@link PositiveNumbers} object.
         */
        @Around(value = "execution(* spring.certification.aop.Q009proceedingjoinpoint.PositiveNumbers.*(*))")
        public Object validateNumbers(ProceedingJoinPoint joinPoint) throws Throwable {
            for (Object arg : joinPoint.getArgs()) {
                if ((Integer) arg < 0) {
                    throw new IllegalArgumentException("Only positive numbers are accessible");
                }
            }
            // In case validation is ok -> allow proceeding of invoked method.
            return joinPoint.proceed(new Object[]{10});
        }
    }

    /**
     * A wrapper object which collects only positive numbers.
     */
    @Component
    public static class PositiveNumbers {

        /**
         * A collection of positive numbers.
         */
        private List<Integer> numbers;

        /**
         * Although class java-docs state that object collects only positive numbers there's no validation
         * of input parameters.
         */
        public void addNumber(Integer number) {
            if (numbers == null) {
                this.numbers = new ArrayList<>();
            }
            numbers.add(number);
        }

        /**
         * @return the first element in the collection.
         */
        public int getFirst() {
            if (numbers.isEmpty()) {
                throw new IllegalStateException("Collection is empty");
            }
            return numbers.get(0);
        }
    }
}
