package spring.certification.aop.q007;

import org.aspectj.lang.annotation.Pointcut;
import spring.certification.aop.q007.example.ExecutionMatcher;

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
 * Pattern: [access-modifier] (return-type) [package].[class].(method)([parameters]) [throws exceptions]<br>
 * <b>within</b> - matches method execution in specific class.<br>
 * Pattern: [package].[class]<br>
 * <b>@within</b> - matches method execution in a class annotated with specific annotation.<br>
 * <b>args</b> - matches method execution with arguments of specified type.<br>
 * Pattern: [package].[class]<br>
 * <b>@args</b> - matches method execution with arguments type of which has specified annotation.<br>
 * <b>@annotation</b> - matches method execution annotated with specified annotation.<br>
 * More exotic:<br>
 * <b>this</b> - AOP proxy is of specified type.<br>
 * <b>target</b> - proxied class is of specified type.<br>
 * <b>@target</b> - proxied class has specified annotation.<br>
 * <b>bean</b> - proxied bean name.<br>
 * <p>
 * Pointcut designators can be combined using {@code &&}, {@code ||}, {@code !} symbols.<br>
 * <p>
 * Examples of mentioned terms:<br>
 * {@link ExecutionMatcher} - demonstrates basic usage of the most common pointcut designators.
 *
 * @author Valentine Shemyako
 * @since December 08, 2018
 */
public class PointcutExpressions {
}
