package spring.certification.aop;

import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import spring.certification.aop.helper.WithinHelper;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 007:<br>
 * If shown pointcut expressions, would you understand them?<br>
 * For example, in the course we matched getter methods on Spring Beans, what would be the correct pointcut expression
 * to match both getter and setter methods?<br>
 * <p>
 * Answer:<br>
 * Important thing to remember: Spring AOP pointcut expressions define a subset of <b>method executions</b> and nothing
 * more. Those method executions can be limited by pointcut <b>designators</b> associated with <b>designator pattern</b>.
 * <b>Important note:</b> pointcut signature (method which is associated with <b>{@link Pointcut}</b> annotation) must
 * have {@code void} return type.<br>
 * Valid designators are:<br>
 * <b>execution</b> - matches method execution points.<br>
 * Pattern: [access-modifier] [return-type] [package].[class].[method]([parameters] [throws exceptions])<br>
 * <b>within</b> - matches method execution in specific class.
 * Pattern: [package].[class]
 * <b>@within</b> - matches method execution in a class annotated with specific annotation.
 * <p>
 * Examples of mentioned terms:<br>
 * -
 *
 * @author Valentine Shemyako
 * @since December 08, 2018
 */
public class Q007pointcut {

    @Configuration
    @ComponentScan
    @EnableAspectJAutoProxy
    public static class PointcutConfigurationMarker {
    }

    /**
     * Demonstrates basic usage of different pointcuts types.
     */
    public static class Pointcuts {

        /**
         * Specifies pointcut which matches any public method in any package.
         */
        @Pointcut("execution(public * spring.certification.aop.Q007pointcut.Politeness.*(..))")
        public void publicPointcutMatcher() {
        }

        /**
         * Specifies pointcut which matches any protected method in any package.
         */
        @Pointcut("execution(protected * spring.certification.aop.Q007pointcut.Politeness.*(..))")
        public void protectedPointcutMatcher() {
        }

        /**
         * Specifies pointcut which matches any method execution in {@link Executor} class.
         */
        @Pointcut("within(spring.certification.aop.Q007pointcut.Executor)")
        public void withinClass() {
        }

        /**
         * Specifies pointcut which matches any method within class annotated with {@link WithinHelper} annotation.
         */
        @Pointcut("@within(spring.certification.aop.helper.WithinHelper)")
        public void withinAnnotatedClass() {
        }
    }

    /**
     * Aspect
     */
    @Aspect
    @Component
    public static class ExecutionMatcher {

        /**
         * Prints out simple message before any public method which runs within the application.
         */
        @Before(value = "spring.certification.aop.Q007pointcut.Pointcuts.publicPointcutMatcher()")
        public void beforeJoinPoint() {
            System.out.println("Before");
        }

        /**
         * Prints out simple message after any protected method which runs within the application.
         */
        @AfterReturning(value = "spring.certification.aop.Q007pointcut.Pointcuts.protectedPointcutMatcher()")
        protected void afterJoinPoint() {
            System.out.println("After");
        }

        /**
         * Prints out simple message after any method executed in {@link Executor} class.
         */
        @After(value = "spring.certification.aop.Q007pointcut.Pointcuts.withinClass()")
        public void withinExecutorClass() {
            System.out.println("Within");
        }

        /**
         * Prints out simple message before methods of annotated class are invoked.
         */
        @Before(value = "spring.certification.aop.Q007pointcut.Pointcuts.withinAnnotatedClass()")
        public void withinAnnotatedHelperClass() {
            System.out.println("@Within");
        }
    }

    /**
     * Prints simple polite messages.
     */
    @Component
    public static class Politeness {

        /**
         * Prints out simple greeting message.
         */
        public void greet() {
            System.out.println("Greet");
        }

        /**
         * Prints out goodbye message.
         */
        protected void sayGoodbye() {
            System.out.println("Goodbye");
        }
    }

    /**
     * Prints simple messages.
     */
    @Component
    public static class Executor {

        /**
         * Prints 'execute' message.
         */
        public void execute() {
            System.out.println("Execute");
        }
    }
}
