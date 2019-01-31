package spring.certification.aop.q009;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 009:<br>
 * What is a ProceedingJoinPoint?<br>
 * When ProceedingJoinPoint is used?<br>
 * <p>
 * Answer:<br>
 * {@link ProceedingJoinPoint} is an extension of an {@link JoinPoint} interface which allows to control execution logic
 * of an advised method. In particular it allows to adjust input parameters of advised method, skip execution of an advised
 * method, or invoke advised method logic multiple times. In order to invoke advised method {@link ProceedingJoinPoint#proceed()}
 * or {@link ProceedingJoinPoint#proceed(Object[])} method should be used.<br>
 * {@link ProceedingJoinPoint} must be the first argument of the advice and is only accessible in {@link Around} advices.<br>
 *
 * @author Valentine Shemyako
 * @since December 09, 2018
 */
public class ProceedingJoinPointArgument {
}
