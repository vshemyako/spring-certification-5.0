package spring.certification.aop.q006.example.fair;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import spring.certification.aop.q006.example.people.GenerousMan;

/**
 * Configuration class which enables processing of {@link Aspect} annotations.
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackageClasses = GenerousMan.class)
public class FairWorldConfiguration {
}
