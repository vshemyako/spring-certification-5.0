package spring.certification.mvc;

import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 004:<br>
 * Is the DispatcherServlet instantiated via an application context?<br>
 * <p>
 * Answer:<br>
 * DispatcherServlet is instantiated by a servlet container. Each dispatcher servlet has its own context
 * which is instantiated along with each servlet. In particular such instantiation pattern is implemented
 * by {@link AbstractDispatcherServletInitializer#registerDispatcherServlet} method. This initializer
 * is also responsible for root application context bootstrapping which is shared among all servlet registered
 * within the application.<br>
 *
 * @author Valentine Shemyako
 * @since January 11, 2019
 */
public class Q004bootstrap {
}
