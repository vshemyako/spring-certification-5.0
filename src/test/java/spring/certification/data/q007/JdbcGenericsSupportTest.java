package spring.certification.data.q007;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import spring.certification.data.helper.config.jpa.config.EmbeddedDBConfiguration;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

/**
 * Verifies {@link JdbcTemplate} functionality for executing generic queries.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = EmbeddedDBConfiguration.class)
@Sql(scripts = {"classpath:drop-database.sql", "classpath:create-database.sql", "classpath:database-data.sql"})
public class JdbcGenericsSupportTest {

    private static final String GENERIC_SQL_QUERY = "SELECT %s FROM holidays WHERE name = ?";
    private static final String LIMIT_SQL_QUERY = "SELECT %s FROM holidays LIMIT %s";
    private static final String CHRISTMAS_HOLIDAY_NAME = "Christmas";
    private static final String INDEPENDENCE_HOLIDAY_NAME = "Independence Day";
    private static final String EASTER_HOLIDAY_NAME = "Easter";
    private static final String ID_COLUMN = "id";
    private static final String WILDCARD = "*";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Verifies functionality for retrieving different types of objects using generic {@link JdbcTemplate} methods.
     */
    @Test
    public void shouldExecuteGenericQuery() {
        // Retrieve holiday's id
        String formattedQuery = String.format(GENERIC_SQL_QUERY, ID_COLUMN);
        Integer holidayId = jdbcTemplate.queryForObject(formattedQuery, Integer.class, CHRISTMAS_HOLIDAY_NAME);
        assertThat(holidayId).isNotNull();

        // Retrieve holiday's name
        formattedQuery = String.format(GENERIC_SQL_QUERY, "name");
        String name = jdbcTemplate.queryForObject(formattedQuery, String.class, CHRISTMAS_HOLIDAY_NAME);
        assertThat(name).isNotNull();
    }

    /**
     * Verifies that {@link JdbcTemplate} throws an exception in case single expected object wasn't found.
     */
    @Test
    public void shouldEndUpWithEmptyResultDataAccessException() {
        // Intentionally try to retrieve non-existing holiday
        try {
            jdbcTemplate.queryForMap(String.format(GENERIC_SQL_QUERY, WILDCARD), INDEPENDENCE_HOLIDAY_NAME);
            fail();
        } catch (EmptyResultDataAccessException ex) {
            // Legal to ignore...
        }
    }

    /**
     * Verifies that {@link JdbcTemplate} throws an exception in case returned result has size greater than one.
     */
    @Test
    public void shouldEndUpWithIncorrectResultSizeDataAccessException() {
        try {
            jdbcTemplate.queryForMap(String.format(GENERIC_SQL_QUERY, WILDCARD), EASTER_HOLIDAY_NAME);
            fail();
        } catch (IncorrectResultSizeDataAccessException ex) {
            // Legal to ignore...
        }
    }

    /**
     * Verifies that {@link JdbcTemplate} functionality allows to query for lists of objects.
     */
    @Test
    public void shouldQueryForList() {
        int limit = 3;
        String formattedQuery = String.format(LIMIT_SQL_QUERY, ID_COLUMN, limit);
        List<Integer> ids = jdbcTemplate.queryForList(formattedQuery, Integer.class);
        assertThat(ids.size()).isEqualTo(limit);
    }

    /**
     * Verifies that {@link JdbcTemplate} functionality allow to query for map.
     */
    @Test
    public void shouldQueryForMap() {
        String formattedQuery = String.format(GENERIC_SQL_QUERY, WILDCARD);
        Map<String, Object> columnToValueMap = jdbcTemplate.queryForMap(formattedQuery, CHRISTMAS_HOLIDAY_NAME);
        assertThat(columnToValueMap).containsValue(CHRISTMAS_HOLIDAY_NAME);
    }
}