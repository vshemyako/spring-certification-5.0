package spring.certification.boot;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 015:<br>
 * How can you control logging with Spring Boot?<br>
 * <p>
 * Answer:<br>
 * Even though Spring Boot is an 'opinionated' framework, its true power comes with possibility to customize each and every preconfigured layer.<br>
 * When it comes to logging the following can be changed:<br>
 * - log level of the core Spring loggers (container, Hibernate, Spring Boot):<br>
 * -- specify <code>--debug</code> or <code>--trace</code> flag.<br>
 * -- specify application property <code>debug=true</code>, <code>trace=true</code>.<br>
 * - message color of console output.<br>
 * - file output using <code>logging.file</code> or <code>logging.path</code> application property.<br>
 * - logging level of specific classes or logging groups.<br>
 * - specify different logging implementation by including libraries on the classpath (logback is used by default).<br>
 *
 * @author Valentine Shemyako
 * @since January 21, 2019
 */
public class Q015logging {
}
