package spring.certification.aop.q003.example;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Configuration to test different proxy types created by Spring AOP.
 */
@ComponentScan
@Configuration
@EnableAspectJAutoProxy
public class ProxyTypeConfiguration {
}
