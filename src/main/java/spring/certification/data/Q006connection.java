package spring.certification.data;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 006:<br>
 * When does the JDBC template acquire (and release) a connection - for every method called or once per template?<br>
 * <p>
 * Answer:<br>
 * {@link JdbcTemplate} acquires and releases connection of each called method. {@link JdbcTemplate} source code
 * confirms that (look at {@link JdbcTemplate#execute}). This connection acquire/release strategy is used to minimize
 * connection holding time allowing other client to utilize free connections.<br>
 * <p>
 * Examples of mentioned terms:<br>
 * -
 *
 * @author Valentine Shemyako
 * @since December 21, 2018
 */
public class Q006connection {
}
