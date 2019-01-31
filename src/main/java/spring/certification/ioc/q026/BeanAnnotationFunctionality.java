package spring.certification.ioc.q026;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import spring.certification.ioc.q010.DependencyInjectionJavaConfig;
import spring.certification.ioc.q018.BeanLifecycleCallbacks;
import spring.certification.ioc.q019.JSR250BeanLifecycleCallbacks;
import spring.certification.ioc.q026.example.SimpleJavaConfig;
import spring.certification.ioc.q027.BeanNaming;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 026:<br>
 * What does the @Bean annotation do?<br>
 * <p>
 * Answer:<br>
 * The {@link Bean} annotation is used to indicate that a method instantiates, configures, and initializes a new object
 * to be managed by the Spring IoC container. The {@link Bean} annotation plays the same role as the {@code <bean/>}
 * element in xml configuration. It's legal to use {@link Bean} annotated methods within {@link Component},
 * {@link Configuration} classes or plain java classes.
 * <p>
 * In case {@link Bean} method is used within {@link Configuration} class it is processed by Spring IoC container
 * in a <b>full mode</b>. The <b>full mode</b> processing means that {@link Bean} methods can declare inter-dependencies
 * which will be intercepted by Spring IoC container.<br>
 * In case {@link Bean} method is used within {@link Component} class it is processed by Spring IoC container in a <b>lite
 * mode</b>. The <b>lite mode</b> means that internal calls between {@link Bean} methods are not intercepted by Spring IoC
 * container.
 * <p>
 * <b>Note</b>:<br>
 * - lite / full mode behavior was examined in a test suite of question {@link DependencyInjectionJavaConfig}.<br>
 * - initialization and destruction callbacks were examined in test suites of questions {@link BeanLifecycleCallbacks} and {@link JSR250BeanLifecycleCallbacks}.<br>
 * - bean naming was examined in a test suite of question {@link BeanNaming}.<br>
 * <p>
 * Examples of mentioned terms:<br>
 * <p>
 * {@link SimpleJavaConfig} - demonstrates the most basic usage of {@link Bean} annotation.
 *
 * @author Valentine Shemyako
 * @since November 17, 2018
 */
public class BeanAnnotationFunctionality {
}
