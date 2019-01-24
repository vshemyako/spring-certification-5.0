package spring.certification.ioc.q036;

import org.springframework.context.ApplicationContext;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.EnvironmentCapable;
import spring.certification.ioc.q036.example.EnvironmentConfiguration;

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
 * Beans managed by {@link ApplicationContext} may register {@link EnvironmentAware} hook or directly inject
 * environment reference by the means of DI.<br>
 * <p>
 * Examples of mentioned terms:<br>
 * {@link EnvironmentConfiguration} - demonstrates how to access environment active profiles and jmv properties.<br>
 *
 * @author Valentine Shemyako
 * @since November 19, 2018
 */
public class EnvironmentAbstraction {
}
