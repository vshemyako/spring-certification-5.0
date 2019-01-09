package spring.certification.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import spring.certification.data.helper.Employee;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 005:<br>
 * Can you execute a plain SQL statement with the JDBC template?<br>
 * <p>
 * Answer:<br>
 * It seems that 'plain SQL' term is a bit vague, meaning that SQL string is executed as 'native' database string,
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
public class Q005sql {

    public static final String HOLIDAYS_TABLE_NAME = "holidays";
    public static final String EMPLOYEES_TABLE_NAME = "employees";
    public static final String EMPLOYEE_ID_COLUMN = "emp_no";

    public static final String SQL_CREATE_TABLE_STATEMENT =
            "CREATE TABLE IF NOT EXISTS %s " +
                    "(" +
                    "id INT, " +
                    "name VARCHAR(50)" +
                    ")";
    public static final String SQL_TABLE_VERIFICATION_STATEMENT = "SELECT 1 FROM %s";
    public static final String SQL_DROP_TABLE_STATEMENT = "DROP TABLE %s";

    public static final String SQL_COUNT_QUERY = "SELECT count(*) FROM %s";
    public static final String SQL_MAX_QUERY = "SELECT max(%s) FROM %s";

    public static final String SQL_INSERT_STATEMENT = "INSERT INTO employees (emp_no, birth_date, first_name, last_name, gender, hire_date) VALUES(%s, %s, %s, %s, %s, %s)";

    public static final String QUOTE_WRAPPER = "'%s'";

    /**
     * Wrapper class which executes only plain-sql statements using {@link JdbcTemplate} capabilities.
     */
    @Component
    public static class PlainSqlExecutor {

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
        public int executeInsert(Employee employee) {
            String insertString = String.format(
                    SQL_INSERT_STATEMENT,
                    employee.getNumber(),
                    String.format(QUOTE_WRAPPER, employee.getBirthDate()),
                    String.format(QUOTE_WRAPPER, employee.getFirstName()),
                    String.format(QUOTE_WRAPPER, employee.getLastName()),
                    String.format(QUOTE_WRAPPER, employee.getGender()),
                    String.format(QUOTE_WRAPPER, employee.getHireDate())
            );
            return jdbcTemplate.update(insertString);
        }
    }
}
