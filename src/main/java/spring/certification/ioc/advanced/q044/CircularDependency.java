package spring.certification.ioc.advanced.q044;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 044:<br>
 * Application context detect circular dependencies in case A bean is dependent on B bean and B bean is dependent on A bean.
 * How to resolve this circular dependency?<br>
 * <p>
 * The only possibility to resolve this circular dependency is to apply {@link Autowired} annotations on setter methods not constructors.<br>
 *
 * @author Valentine Shemyako
 * @since January 31, 2018
 */
public class CircularDependency {
}
