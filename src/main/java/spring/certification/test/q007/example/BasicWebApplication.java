package spring.certification.test.q007.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

/**
 * Basic Spring Boot application to demonstrate web layer test support provided by Spring Boot framework.
 */
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class BasicWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasicWebApplication.class, args);
    }
}
