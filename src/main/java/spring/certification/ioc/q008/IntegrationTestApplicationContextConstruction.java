package spring.certification.ioc.q008;

import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 008:<br>
 * How are you going to create an ApplicationContext in an integration test?<br>
 * <p>
 * Answer:<br>
 * {@link ApplicationContext} for an integration test is loaded via {@link ContextConfiguration} annotation (for standalone application)
 * or via {@link WebAppConfiguration} annotation used along with {@link ContextConfiguration} annotation (for web application).<br>
 * More info about integration testing can be found in the {@link spring.certification.test test package}.<br>
 *
 * @author Valentine Shemyako
 * @since November 30, 2018
 */
public class IntegrationTestApplicationContextConstruction {
}
