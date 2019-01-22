package spring.certification.boot;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 013:<br>
 * What is a Spring Boot starter POM?<br>
 * Why is it useful?<br>
 * <p>
 * Answer:<br>
 * Spring Boot starters is a *.jar file which aggregates various application dependencies into a single dependency.
 * Dependencies which are grouped under a single *.jar file are organized by the type of functionality they bring.
 * Usage examples:<br>
 * - spring-boot-starter-web - is a starter for web, RESTful applications<br>
 * - spring-boot-starter-test - is a starter for testing, which includes JUnit, Mockito and Hamcrest libraries<br>
 * - etc.<br>
 * Usage of spring-boot-starters makes dependency management easier since no manual configuration is required.<br>
 * <p>
 * Note: sometimes it is necessary to utilize libraries which do not come with a used spring-boot-starter. Spring Boot
 * framework offers convenient <i>dependency management</i> plugin which allows to specify required dependency omitting
 * its version.<br>
 *
 * @author Valentine Shemyako
 * @since January 21, 2019
 */
public class Q013starter {
}
