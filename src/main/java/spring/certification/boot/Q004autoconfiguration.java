package spring.certification.boot;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.autoconfigure.condition.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.env.Environment;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 004:<br>
 * How does Spring Boot work? How does it know what to configure?<br>
 * <p>
 * Answer:<br>
 * Autoconfiguration facility is provided by <i>spring-boot-autoconfigure</i> jar. This jar
 * lists autoconfiguration classes under <code>META-INF/spring.factories</code> file, presence
 * of which is checked by Spring Boot. It's important to emphasise that autoconfiguration
 * classes should be registered this way only, and should never be the target of component
 * scanning.<br>
 * <p>
 * Usually autoconfiguration classes are annotated with {@link Conditional} annotation which
 * specifies a condition that should match in order for a component to be registered. Those
 * conditional annotations can be divided into the following groups:<br>
 * 1. Class conditions ({@link ConditionalOnClass}, {@link ConditionalOnMissingClass}) - which
 * check presence or absence of a class on the classpath.<br>
 * 2. Bean conditions ({@link ConditionalOnBean}, {@link ConditionalOnMissingBean}) - which
 * check presence or absence of a bean in the {@link BeanFactory}.<br>
 * 3. Property conditions ({@link ConditionalOnProperty}) - which check presence or absence of
 * Spring {@link Environment} property.<br>
 * 4. Resource conditions ({@link ConditionalOnResource}) - which check presence or absence of a
 * resource.<br>
 * 5. Application context type conditions ({@link ConditionalOnWebApplication}, {@link ConditionalOnNotWebApplication}) -
 * which check configured type of {@link ApplicationContext}.<br>
 * 6. SpEL conditions ({@link ConditionalOnExpression}) - which check a result of specific SpEL expression.<br>
 *
 * @author Valentine Shemyako
 * @since January 21, 2019
 */
public class Q004autoconfiguration {
}
