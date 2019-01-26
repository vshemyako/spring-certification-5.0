package spring.certification.data.q005.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import spring.certification.data.helper.config.jpa.config.EmbeddedDBConfiguration;

import static org.junit.Assert.assertEquals;
import static spring.certification.data.helper.SqlQueries.*;

/**
 * Verifies functionality of {@link JdbcTemplate} class to execute plain-sql statements.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {EmbeddedDBConfiguration.class, PlainSqlExecutor.class})
public class PlainSqlExecutorTest {

    @Autowired
    private PlainSqlExecutor plainSqlExecutor;

    /**
     * Verifies that {@link JdbcTemplate} indeed executes DDL statements which can alter database structure.
     */
    @Test
    public void shouldExecuteDdlStatement() {
        // Create, verify, drop table
        plainSqlExecutor.executeDdlStatement(String.format(SQL_DROP_TABLE_STATEMENT, HOLIDAYS_TABLE_NAME));
        plainSqlExecutor.executeDdlStatement(String.format(SQL_CREATE_TABLE_STATEMENT, HOLIDAYS_TABLE_NAME));
        plainSqlExecutor.executeDdlStatement(String.format(SQL_TABLE_VERIFICATION_STATEMENT, HOLIDAYS_TABLE_NAME));
        plainSqlExecutor.executeDdlStatement(String.format(SQL_DROP_TABLE_STATEMENT, HOLIDAYS_TABLE_NAME));
    }

    /**
     * Verifies that {@link JdbcTemplate} indeed executes plain-sql insert queries.
     */
    @Test
    @Sql(scripts = {"classpath:drop-database.sql", "classpath:create-database.sql", "classpath:database-data.sql"})
    public void shouldExecuteInsertString() {
        int initialCount = plainSqlExecutor.executeQuery(String.format(SQL_COUNT_QUERY, HOLIDAYS_TABLE_NAME), Integer.class);
        String insertString = String.format(
                SQL_INSERT_HOLIDAYS_STATEMENT,
                String.format(QUOTE_WRAPPER, "Independence Day")
        );
        plainSqlExecutor.executeInsert(insertString);
        int eventualCount = plainSqlExecutor.executeQuery(String.format(SQL_COUNT_QUERY, HOLIDAYS_TABLE_NAME), Integer.class);
        int increment = eventualCount - initialCount;

        assertEquals(1, increment);
    }
}