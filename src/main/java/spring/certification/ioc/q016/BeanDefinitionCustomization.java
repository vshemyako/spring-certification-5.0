package spring.certification.ioc.q016;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.Ordered;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertySources;
import spring.certification.ioc.q016.example.ProcessedByPostProcessorConfiguration;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 016:<br>
 * What is a BeanFactoryPostProcessor and what is it used for? When is it invoked?<br>
 * Why would you define a static @Bean method?<br>
 * What is a PropertySourcePlaceholderConfigurer used for?<br>
 * <p>
 * Answer:<br>
 * {@link BeanFactoryPostProcessor} is a substantial interface of an {@link ApplicationContext} which allows to
 * customize configuration metadata of IoC container. Configuration metadata of IoC container consists of all bean
 * definitions ({@link BeanDefinition}) which are loaded into IoC container.
 * <p>
 * Spring IoC container lets {@link BeanFactoryPostProcessor} to read this configuration metadata and change it before
 * the container actually creates any beans from this changed/untouched bean definitions (this doesn't apply to
 * {@link BeanFactoryPostProcessor} themselves as they are used to change bean definitions of other (later created)
 * instances).
 * <p>
 * One doesn't need to register {@link BeanFactoryPostProcessor} in an {@link ApplicationContext} as they are detected
 * automatically and invoked at the appropriate time. Order of invocations of several {@link BeanFactoryPostProcessor}
 * can be changed in case {@link BeanFactoryPostProcessor} implements {@link Ordered} interface.
 * <p>
 * {@link BeanFactoryPostProcessor} bean factories should be declared as <b>static</b> methods to make it possible
 * for the container to pick them up without the need to instantiate outer {@link Configuration} class within which
 * post-processor beans are declared. Otherwise {@link Autowired} or {@link Value} defined dependencies will not be
 * properly processed by Spring IoC container. This is also true to bean factories which produce
 * {@link BeanPostProcessor} beans.
 * <p>
 * {@link PropertySourcesPlaceholderConfigurer} is an implementation of {@link BeanFactoryPostProcessor} interface
 * which resolves ${...} placeholders within bean definition property values and {@code @Value} annotations against the
 * current Spring {@link Environment} and its set of {@link PropertySources}.
 * Examples of mentioned terms:<br>
 * {@link ProcessedByPostProcessorConfiguration} - demonstrates basic usage of property placeholders which will be
 * substituted by {@link PropertySourcesPlaceholderConfigurer} post-processor bean.
 *
 * @author Valentine Shemyako
 * @since November 20, 2018
 */
public class BeanDefinitionCustomization {
}
