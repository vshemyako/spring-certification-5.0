package spring.certification.ioc.q028;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.certification.ioc.q028.example.BeanScopingSupportiveConfig;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 028:<br>
 * Why are you not allowed to annotate a final class with @Configuration?<br>
 * How do @Configuration annotated classes support singleton beans?<br>
 * Why can’t @Bean methods be final either?<br>
 * <p>
 * Answer:<br>
 * {@link Configuration} classes and {@link Bean} methods which are contained in these classes cannot be marked as
 * final because a proxy object is created for each of those {@link Configuration} classes. A proxy object is actually
 * a sub-class of a class marked with {@link Configuration} annotation, with all of the {@link Bean} methods overridden.
 * Thus marking {@link Configuration} class or {@link Bean} method as final forbids sub-classing and method override.
 * <p>
 * For the same reason <b>private</b> {@link Configuration} classes and <b>private</b> {@link Bean} methods are
 * forbidden.
 * <p>
 * Due to those proxies being created it's possible to intercept internal calls between {@link Bean} methods and respect
 * bean scoping and AOP semantics.<br>
 * Examples of mentioned terms:<br>
 * {@link BeanScopingSupportiveConfig} - demonstrates inter-bean references which are intercepted by generated
 * proxy.
 *
 * @author Valentine Shemyako
 * @since November 18, 2018
 */
public class ConfigurationAnnotationFunctionality {
}
