package spring.certification.aop;

import org.aspectj.lang.annotation.*;

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
public class Q005_advice {
}
