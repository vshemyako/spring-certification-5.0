package spring.certification.data.q005.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * Wrapper class which executes only plain-sql statements using {@link JdbcTemplate} capabilities.
 */
@Component
public class PlainSqlExecutor {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PlainSqlExecutor(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Executes plain-sql ddl string using {@link JdbcTemplate}.
     */
    public void executeDdlStatement(String ddlString) {
        jdbcTemplate.execute(ddlString);
    }

    /**
     * Executes plain-sql query string using {@link JdbcTemplate}.
     */
    public <T> T executeQuery(String queryString, Class<T> requiredType) {
        return jdbcTemplate.queryForObject(queryString, requiredType);
    }

    public int executeInsert(String insertString) {
        return jdbcTemplate.update(insertString);
    }
}
