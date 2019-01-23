package spring.certification.ioc.q010;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 010:<br>
 * Describe dependency injection using Java configuration.<br>
 * <p>
 * Answer:
 * Dependency injection using Java annotation is based on two central annotations:<br>
 * 1. {@link Bean} - indicates that annotated method produces a bean to be managed by the Spring container<br>
 * 2. {@link Configuration} - indicates that a class declares one or more {@link Bean} methods<br>
 * <p>
 * For stand-alone applications such java-based configuration classes could be loaded into
 * {@link AnnotationConfigApplicationContext} class instance.
 * <p>
 * Therefore java-based DI is based on three steps:<br>
 * 1. Create configuration classes annotated with {@link Configuration} annotation.<br>
 * 2. Within created configuration classes define factory methods annotated with {@link Bean} annotation.<br>
 * 3. Load configuration classes in appropriated implementation of {@link ApplicationContext} instance.<br>
 * <p>
 * Example of mentioned java based configuration is located in the counterpart test class.
 * <p>
 * <b>Note:</b> special attention should be payed on internal method calls which are intercepted only
 * within {@link Configuration} annotated classes. Test cases clearly confirm that.
 *
 * @author Valentine Shemyako
 * @since November 17, 2018
 */
public class DependencyInjectionJavaConfig {
}
