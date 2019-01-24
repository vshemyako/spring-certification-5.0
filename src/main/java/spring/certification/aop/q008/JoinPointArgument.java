package spring.certification.aop.q008;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Before;
import spring.certification.aop.q008.example.MethodCatcher;

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
public class JoinPointArgument {
}
