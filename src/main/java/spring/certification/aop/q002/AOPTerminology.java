package spring.certification.aop.q002;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 002:<br>
 * What is a pointcut, a join point, an advice, an aspect, a weaving?<br>
 * <p>
 * Answer:<br>
 * <b>An aspect</b> is a module (package) or a class which implements cross-cutting functionality of an application.<br>
 * <b>A join point</b> is a point of program execution where <b>aspect's</b> logic cab be potentially applied.<br>
 * <b>An advice</b> is a logic applied at a specific <b>join point</b> implemented by an <b>aspect</b>.<br>
 * <b>A pointcut</b> is a logical expression (a predicate) which defines whether <b>an advice</b> should be applied at
 * a particular <b>join point</b> or not.<br>
 * <b>An introduction</b> is a declaration of additional methods or properties on behalf of a type.<br>
 * <b>A target object</b> or <b>an advised object</b> it's an object to which aspect's logic is applied.<br>
 * <b>A weaving</b> is a process of combining aspect's logic with other application logic. Weaving can be done at
 * compile time, load time or at runtime. Spring AOP weaves aspect's logic at runtime only.<br>
 * <b>A proxy object</b> is an object which wraps advised object to apply cross-cutting logic.<br>
 *
 * @author Valentine Shemyako
 * @since December 03, 2018
 */
public class AOPTerminology {
}
