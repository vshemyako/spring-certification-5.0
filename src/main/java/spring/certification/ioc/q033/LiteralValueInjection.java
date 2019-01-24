package spring.certification.ioc.q033;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import spring.certification.ioc.q033.example.LiteralConfiguration;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 033:<br>
 * How do you inject scalar/literal values into Spring beans?<br>
 * <p>
 * Answer:<br>
 * Literal values can be injected into a Spring bean via {@link Value} annotation or using xml-based counterpart.<br>
 * It's important to remember that those values cannot be injected into {@link BeanPostProcessor} and
 * {@link BeanFactoryPostProcessor} type beans, because {@link Value} annotation processing is done by
 * {@link BeanPostProcessor} itself.<br>
 * <p>
 * Examples of mentioned terms:<br>
 * {@link LiteralConfiguration} - demonstrates injection of literal values using {@link Value} annotation and
 * external property file. The same can be done using SpEL.<br>
 *
 * @author Valentine Shemyako
 * @since December 01, 2018
 */
public class LiteralValueInjection {
}
