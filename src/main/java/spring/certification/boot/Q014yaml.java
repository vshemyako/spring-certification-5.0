package spring.certification.boot;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 014:<br>
 * Spring Boot supports both Java properties and YML files. Would you recognize and understand them if you saw them?<br>
 * <p>
 * Answer:<br>
 * YAML is a superset of JSON, which is very handy for specifying hierarchical data:<br>
 * <pre>
 * <b>YAML example:</b>
 * db:
 *   dev:
 *     server: localhost
 *     port: 8080
 * application:
 *   technology:
 *     - java
 *     - spring
 * </pre>
 * <pre>
 * <b>JSON example:</b>
 * db.dev.server=localhost
 * db.dev.port=8080
 * application.technology[0]=java
 * application.technology[1]=spring
 * </pre>
 *
 * @author Valentine Shemyako
 * @since January 21, 2019
 */
public class Q014yaml {
}
