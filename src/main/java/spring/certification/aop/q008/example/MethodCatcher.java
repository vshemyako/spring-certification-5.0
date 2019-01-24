package spring.certification.aop.q008.example;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * An aspect which catches method executions of {@link Calculator} class.
 */
@Aspect
@Component
public class MethodCatcher {

    /**
     * Simple advice to functionality of {@link JoinPoint} object
     */
    @Before("within(spring.certification.aop.q008.example.Calculator)")
    public void catchCalculations(JoinPoint joinPoint) {
        int argumentIndex = 1;
        for (Object arg : joinPoint.getArgs()) {
            System.out.println(String.format("Argument %d: %s", argumentIndex++, arg));
        }
    }
}
