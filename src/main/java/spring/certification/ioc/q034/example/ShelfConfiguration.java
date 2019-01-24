package spring.certification.ioc.q034.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Demonstrates how a bean can be assembles with the help of {@link Value} annotation.
 */
@PropertySource("classpath:construction.properties")
@ComponentScan
@Configuration
public class ShelfConfiguration {
}
