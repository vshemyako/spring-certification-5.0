package spring.certification.boot;

import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 008:<br>
 * What is the difference between an embedded container and a WAR?<br>
 * <p>
 * Answer:<br>
 * Embedded container allows to create self-sufficient web applications (packaged in a jar file);
 * war file is essentially the same jar file with specific hierarchical directory structure, which should
 * be deployed on a standalone web container. It's possible to construct Spring Boot application in any
 * of those ways.<br>
 * <p>
 * The following steps should be taken in order to package a Spring Boot application into a deployable war file:<br>
 * 1. Main application class should extend {@link SpringBootServletInitializer} class.<br>
 * 2. Main build system's configuration file should be adjusted in order to package war file instead of jar (or in addition to).<br>
 * 3. <code>spring-boot-starter-tomcat</code> dependency should be marked as <code>provided</code>.<br>
 *
 * @author Valentine Shemyako
 * @since January 21, 2019
 */
public class Q008war {
}
