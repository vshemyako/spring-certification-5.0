package spring.certification.aop.q007.example;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Aspect
 */
@Aspect
@Component
public class ExecutionMatcher {

    /**
     * Prints out simple message before any public method which runs within the application.
     */
    @Before(value = "spring.certification.aop.q007.example.PointcutLibrary.publicPointcutMatcher()")
    public void beforeJoinPoint() {
        System.out.println("Before");
    }

    /**
     * Prints out simple message after any protected method which runs within the application.
     */
    @AfterReturning(value = "spring.certification.aop.q007.example.PointcutLibrary.protectedPointcutMatcher()")
    protected void afterJoinPoint() {
        System.out.println("After");
    }

    /**
     * Prints out simple message after any method executed in {@link Executor} class.
     */
    @After(value = "spring.certification.aop.q007.example.PointcutLibrary.withinClass()")
    public void withinExecutorClass() {
        System.out.println("Within");
    }

    /**
     * Prints out simple message before methods of annotated class are invoked.
     */
    @Before(value = "spring.certification.aop.q007.example.PointcutLibrary.withinAnnotatedClass()")
    public void withinAnnotatedHelperClass() {
        System.out.println("@Within");
    }

    /**
     * Prints out simple message before methods with {@link String} argument.
     */
    @Before(value = "spring.certification.aop.q007.example.PointcutLibrary.withSpecificArgument(word)" +
            "&& spring.certification.aop.q007.example.PointcutLibrary.withinPointcutHelper()", argNames = "word")
    public void stringArgsMethod(String word) {
        System.out.println("Args");
    }

    /**
     * Prints out property access detection message.
     */
    @After(value = "spring.certification.aop.q007.example.PointcutLibrary.getterOrSetter()")
    public void getterSetterMethod() {
        System.out.println("Detected property access");
    }
}
