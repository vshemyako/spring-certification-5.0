package spring.certification.aop;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 004:<br>
 * What are the limitations of the two proxy types?<br>
 * What visibility must Spring bean methods have to be proxied using Spring AOP?<br>
 * <p>
 * Answer:<br>
 * <b>Common limitation</b> for both JDK and CGLIB dynamic proxies is that interception of inner method calls is not
 * performed (due to limitation of run-time proxies).<br>
 * <b>JDK proxies limitations (interface-based dynamic proxy):</b><br>
 * 1. Target object has to implement at least one interface.<br>
 * 2. Only overridden public method invocations are intercepted.<br>
 * <b>CGLIB proxies limitations (subclass-based dynamic proxy):</b><br>
 * 1. Objects of final classes cannot be proxied.<br>
 * 2. Calls to final methods cannot be intercepted.<br>
 * 3. Only protected and public method calls are intercepted.<br>
 *
 * @author Valentine Shemyako
 * @since December 04, 2018
 */
public class Q004_limitations {
}
