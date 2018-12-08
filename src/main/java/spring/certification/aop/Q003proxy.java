package spring.certification.aop;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 003:<br>
 * How does Spring framework solve a cross cutting concern?<br>
 * <p>
 * Answer:<br>
 * Spring framework solves a cross cutting concern using proxy objects. Those proxy objects wrap some target object, thus
 * intercepting method calls to that proxied target object. Spring AOP framework uses two types of proxies depending on
 * the type of the object being proxied:<br>
 * 1. JDK dynamic proxies - in case target object implements at least one interface, overridden methods of which should
 * be intercepted.<br>
 * 2. CGLIB proxies - in case target object does not implement any interface, or in case all concrete object methods
 * invocations should be intercepted.<br>
 *
 * @author Valentine Shemyako
 * @since December 04, 2018
 */
public class Q003proxy {
}
