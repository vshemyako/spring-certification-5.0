package spring.certification.aop.q007.example;

import org.aspectj.lang.annotation.Pointcut;
import spring.certification.aop.helper.WithinHelper;

/**
 * Demonstrates basic usage of different pointcuts types.
 */
public class PointcutLibrary {

    /**
     * Specifies pointcut which matches any public method in any package.
     */
    @Pointcut("execution(public * spring.certification.aop.q007.example.Politeness.*(..))")
    public void publicPointcutMatcher() {
    }

    /**
     * Specifies pointcut which matches any protected method in any package.
     */
    @Pointcut("execution(protected * spring.certification.aop.q007.example.Politeness.*(..))")
    public void protectedPointcutMatcher() {
    }

    /**
     * Specifies pointcut which matches any method execution in {@link Executor} class.
     */
    @Pointcut("within(spring.certification.aop.q007.example.Executor)")
    public void withinClass() {
    }

    /**
     * Specifies pointcut which matches any method within class annotated with {@link WithinHelper} annotation.
     */
    @Pointcut("@within(spring.certification.aop.helper.WithinHelper)")
    public void withinAnnotatedClass() {
    }

    /**
     * Specifies pointcut which matches any method with argument of type {@link String}.
     */
    @Pointcut("args(word)")
    public void withSpecificArgument(String word) {
    }

    @Pointcut("within(spring.certification.aop.helper.PointcutHelper)")
    public void withinPointcutHelper() {
    }

    @Pointcut("execution(void set*(..)) || execution(* get*())")
    public void getterOrSetter() {
    }
}
