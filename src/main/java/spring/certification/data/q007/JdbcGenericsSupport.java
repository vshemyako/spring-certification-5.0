package spring.certification.data.q007;

import org.springframework.dao.DataAccessException;
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
 * - {@link JdbcTemplate#queryForObject(String, Class)} - expects single row for retrieval or single column of that row.<br>
 * - {@link JdbcTemplate#queryForList(String, Class)} - result may be of any size.<br>
 * - {@link JdbcTemplate#query(String, RowMapper)}<br>
 * <p>
 * Also, {@link JdbcTemplate} has several methods for retrieving objects, lists, maps:<br>
 * - {@link JdbcTemplate#queryForObject(String, Class)}<br>
 * - {@link JdbcTemplate#queryForList(String, Class)}<br>
 * - {@link JdbcTemplate#queryForMap(String)} - expects single row for retrieval or single column of that row.<br>
 * <p>
 * <b>Big note</b>: quite often programmers expect <code>null</code> to be returned by query methods, but instead
 * {@link JdbcTemplate} will throw {@link DataAccessException} in case of empty result set.<br>
 * Examples of mentioned terms:<br>
 * Look at the corresponding unit test section.<br>
 *
 * @author Valentine Shemyako
 * @since December 22, 2018
 */
public class JdbcGenericsSupport {
}
