package spring.certification.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 005:<br>
 * Can you execute a plain SQL statement with the JDBC template?<br>
 * <p>
 * Answer:<br>
 * It seems that 'plain SQL' term is a bit vague, meaning that SQL statement is executed without additional processing
 * of result set.<br>
 * The following methods allow to execute plain SQL statements:<br>
 * - {@link JdbcTemplate#execute(String)} - used for some DDL (Data Definition Language) sql statements<br>
 *
 * @author Valentine Shemyako
 * @since December 20, 2018
 */
public class Q005sql {

    static final String SQL_CREATE_TABLE_STATEMENT =
            "CREATE TABLE IF NOT EXISTS %s " +
                    "(" +
                    "id INT, " +
                    "name VARCHAR(50)" +
                    ")";
    static final String SQL_TABLE_VERIFICATION_STATEMENT = "SELECT 1 FROM %s";
    static final String SQL_DROP_TABLE_STATEMENT = "DROP TABLE %s";
    static final String SQL_INSERT_STATEMENT = "INSERT INTO employees VALUES(%s, %s, %s, %s, %s)";

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
    }
}
