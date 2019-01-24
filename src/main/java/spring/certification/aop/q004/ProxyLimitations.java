package spring.certification.aop.q004;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 004:<br>
 * What are the limitations of the two proxy types?<br>
 * What visibility must Spring bean methods have to be proxied using Spring AOP?<br>
 * <p>
 * Answer:<br>
 * <b>Common limitation:</b><br>
 * 1. Both JDK and CGLIB dynamic proxies do not intercept inner method call (due to limitation of run-time proxies).<br>
 * <b>JDK proxies limitations (interface-based dynamic proxy):</b><br>
 * 1. Target object has to implement at least one interface.<br>
 * 2. Only overridden public method invocations are intercepted.<br>
 * <b>CGLIB proxies limitations (subclass-based dynamic proxy):</b><br>
 * 1. Objects of final classes cannot be proxied.<br>
 * 2. Calls to final methods cannot be intercepted.<br>
 * 3. Non-private method calls are intercepted.<br>
 *
 * @author Valentine Shemyako
 * @since December 04, 2018
 */
public class ProxyLimitations {
}
