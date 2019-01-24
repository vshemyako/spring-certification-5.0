package spring.certification.aop.q006.example.unfair;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import spring.certification.aop.q006.example.people.GenerousMan;

/**
 * Configuration which doesn't enable processing of {@link Aspect} annotations.
 */
@ContextConfiguration
@ComponentScan(basePackageClasses = GenerousMan.class)
public class UnfairWorldConfiguration {
}
