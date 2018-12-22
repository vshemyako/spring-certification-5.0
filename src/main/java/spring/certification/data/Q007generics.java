package spring.certification.data;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 007:<br>
 * How does the JdbcTemplate support generic queries?<br>
 * How does it return objects and lists/maps of objects?<br>
 * <p>
 * Answer:<br>
 * {@link JdbcTemplate} has several methods which accept expected result object type specified by {@link Class} type
 * parameter. Namely some of them are:<br>
 * - {@link JdbcTemplate#queryForObject(String, Class)}<br>
 * - {@link JdbcTemplate#queryForList(String, Class)}<br>
 * - {@link JdbcTemplate#query(String, RowMapper)}<br>
 * <p>
 * Also, {@link JdbcTemplate} has several methods for retrieving objects, lists, maps:<br>
 * - {@link JdbcTemplate#queryForObject(String, Class)}<br>
 * - {@link JdbcTemplate#queryForList(String, Class)}<br>
 * - {@link JdbcTemplate#queryForMap(String)}<br>
 * Examples of mentioned terms:<br>
 * -
 *
 * @author Valentine Shemyako
 * @since December 22, 2018
 */
public class Q007generics {
}
