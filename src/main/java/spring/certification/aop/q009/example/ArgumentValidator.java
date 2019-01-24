package spring.certification.aop.q009.example;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Aspect which validates input parameters passed to {@link PositiveNumbers#addNumber(Integer)} method.
 */
@Aspect
@Component
public class ArgumentValidator {

    /**
     * Validates numbers which are passed to {@link PositiveNumbers} object.
     */
    @Around(value = "execution(* spring.certification.aop.q009.example.PositiveNumbers.*(*))")
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
