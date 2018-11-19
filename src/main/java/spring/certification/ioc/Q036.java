package spring.certification.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.EnvironmentCapable;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 036:<br>
 * What is the Environment abstraction in Spring?<br>
 * <p>
 * Answer:<br>
 * Environment abstraction in Spring represents conditions in which current application is running. More specifically,
 * those conditions are: {@link Profile Profiles} and {@link PropertySource Properties}.<br>
 * <p>
 * {@link ApplicationContext} is {@link EnvironmentCapable}, therefore it exposes {@link EnvironmentCapable#getEnvironment()}
 * method to get reference to the single environment in which current application is running.<br>
 * <p>
 * Beans managed by {@link ApplicationContext} may register {@link EnvironmentAware} hook or directly injection
 * environment reference by the means of DI.<br>
 * Examples of mentioned terms:<br>
 * -
 *
 * @author Valentine Shemyako
 * @since November 19, 2018
 */
public class Q036 {
}
