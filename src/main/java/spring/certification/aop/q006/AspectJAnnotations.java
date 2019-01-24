package spring.certification.aop.q006;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 006:<br>
 * What do you have to do to enable the detection of the @Aspect annotation?<br>
 * What does @EnableAspectJAutoProxy do?<br>
 * <p>
 * Answer:<br>
 * {@link Aspect} annotations aren't processed by default. To enable processing - Spring {@link Configuration} class
 * has to be annotated with {@link EnableAspectJAutoProxy} annotation. Moreover {@link Aspect} annotation package
 * isn't yet integrated in Spring framework, therefore additional <b>AspectJ</b> dependency has to be added on the
 * application classpath.<br>
 * <p>
 * Note: plain java classes are not processed as aspect even though are marked with {@link Aspect} annotation - only
 * {@link Bean} or stereotype classes are processed.<br>
 *
 * @author Valentine Shemyako
 * @since December 05, 2018
 */
public class AspectJAnnotations {
}
