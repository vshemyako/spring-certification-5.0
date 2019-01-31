package spring.certification.data.q005;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 005:<br>
 * Can you execute a plain SQL statement with the JDBC template?<br>
 * <p>
 * Answer:<br>
 * It seems that 'plain SQL' term is a bit vague, meaning that SQL string is executed as is ('native' database string),
 * without additional processing or conversion by database-access framework. Actually the whole purpose of {@link JdbcTemplate}
 * is to execute SQL string as they are.<br>
 * The following methods allow to execute plain SQL statements (among many others):<br>
 * - {@link JdbcTemplate#execute(String)} - used for some DDL (Data Definition Language) sql statements<br>
 * - {@link JdbcTemplate#queryForObject(String, Class)} - used for extracting exactly one row<br>
 * - {@link JdbcTemplate#update(String)} - to execute single modification operation<br>
 *
 * @author Valentine Shemyako
 * @since December 20, 2018
 */
public class PlainSql {
}
