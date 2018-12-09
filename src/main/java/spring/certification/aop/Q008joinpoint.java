package spring.certification.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 008:<br>
 * What is the JoinPoint argument used for?<br>
 * <p>
 * Answer:<br>
 * {@link JoinPoint} it's an interface which might by used as a first parameter in advice methods of the following type:<br>
 * - {@link Before}<br>
 * - {@link After}<br>
 * - {@link AfterReturning}<br>
 * - {@link AfterThrowing}<br>
 * Object of that type contains information about advised method:<br>
 * - method arguments<br>
 * - proxy object<br>
 * - advised object<br>
 * - method signature<br>
 * - etc.<br>
 * <p>
 * Examples of mentioned terms:<br>
 * {@link MethodCatcher} - demonstrates how method arguments can be accessed using {@link JoinPoint} object.<br>
 *
 * @author Valentine Shemyako
 * @since December 09, 2018
 */
public class Q008joinpoint {

    /**
     * Simple marker to enable auto-scanning facility.
     */
    @Configuration
    @EnableAspectJAutoProxy
    @ComponentScan
    public static class JoinPointMarkerConfiguration {
    }

    /**
     * An aspect which catches method executions of {@link Calculator} class.
     */
    @Aspect
    @Component
    public static class MethodCatcher {

        /**
         * Simple advice to functionality of {@link JoinPoint} object
         */
        @Before("within(spring.certification.aop.Q008joinpoint.Calculator)")
        public void catchCalculations(JoinPoint joinPoint) {
            int argumentIndex = 1;
            for (Object arg : joinPoint.getArgs()) {
                System.out.println(String.format("Argument %d: %s", argumentIndex++, arg));
            }
        }
    }

    /**
     * A device which performs mathematical calculations.
     */
    @Component
    public static class Calculator {

        /**
         * Performs add math operation.
         */
        public int add(int left, int right) {
            return left + right;
        }
    }
}
