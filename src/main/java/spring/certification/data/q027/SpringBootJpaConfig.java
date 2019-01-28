package spring.certification.data.q027;

import spring.certification.data.q023.CentralJpaBean;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 027:<br>
 * What do you have to configure to use JPA with Spring?<br>
 * How does Spring Boot make this easier?<br>
 * <p>
 * Answer:<br>
 * Please take a look at {@link CentralJpaBean} and related integration tests which explain how to configure
 * JPA in Spring application.<br>
 * <p>
 * Spring Boot framework provides specific starter jar (<b>spring-boot-starter-data-jpa</b>) which aggregates JPA
 * related dependencies. In case in-memory database jar is added on the classpath - Spring Boot autoconfigures data
 * access layer related beans.<br>
 *
 * @author Valentine Shemyako
 * @since January 08, 2019
 */
public class SpringBootJpaConfig {
}
