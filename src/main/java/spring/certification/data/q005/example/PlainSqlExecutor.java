package spring.certification.data.q005.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import spring.certification.data.helper.Employee;

import static spring.certification.data.helper.SqlQueries.QUOTE_WRAPPER;
import static spring.certification.data.helper.SqlQueries.SQL_INSERT_EMPLOYEE_STATEMENT;

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

    /**
     * Executes plain-sql insert statement using {@link JdbcTemplate}.
     */
    public int executeInsertEmployee(Employee employee) {
        String insertString = String.format(
                SQL_INSERT_EMPLOYEE_STATEMENT,
                employee.getNumber(),
                String.format(QUOTE_WRAPPER, employee.getBirthDate()),
                String.format(QUOTE_WRAPPER, employee.getFirstName()),
                String.format(QUOTE_WRAPPER, employee.getLastName()),
                String.format(QUOTE_WRAPPER, employee.getGender()),
                String.format(QUOTE_WRAPPER, employee.getHireDate())
        );
        return jdbcTemplate.update(insertString);
    }

    public int executeInsert(String insertString) {
        return jdbcTemplate.update(insertString);
    }
}
