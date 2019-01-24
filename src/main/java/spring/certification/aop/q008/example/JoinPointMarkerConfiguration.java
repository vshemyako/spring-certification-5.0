package spring.certification.aop.q008.example;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Simple marker to enable auto-scanning facility.
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan
public class JoinPointMarkerConfiguration {
}
