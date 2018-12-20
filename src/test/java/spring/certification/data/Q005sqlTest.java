package spring.certification.data;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import spring.certification.data.Q005sql.*;

import static spring.certification.data.Q005sql.*;

/**
 * Verifies functionality of {@link JdbcTemplate} class to execute plain-sql statements.
 */
public class Q005sqlTest {

    private static final String HOLIDAYS_TABLE_NAME = "holidays";
    private static final String EMPLOYEES_TABLE_NAME = "employees";

    private AnnotationConfigApplicationContext context;
    private PlainSqlExecutor plainSqlExecutor;

    @Before
    public void setUp() {
        context = new AnnotationConfigApplicationContext(AutoDetectionMarker.class);
        context.registerShutdownHook();
        plainSqlExecutor = context.getBean(PlainSqlExecutor.class);
    }

    /**
     * Verifies that {@link JdbcTemplate} indeed executes DDL statements which can alter database structure.
     */
    @Test
    public void shouldExecuteDdlStatement() {
        // Create, verify, drop table
        plainSqlExecutor.executeDdlStatement(String.format(SQL_CREATE_TABLE_STATEMENT, HOLIDAYS_TABLE_NAME));
        plainSqlExecutor.executeDdlStatement(String.format(SQL_TABLE_VERIFICATION_STATEMENT, HOLIDAYS_TABLE_NAME));
        plainSqlExecutor.executeDdlStatement(String.format(SQL_DROP_TABLE_STATEMENT, HOLIDAYS_TABLE_NAME));
    }

    /**
     * Verifies that {@link JdbcTemplate} indeed executes plain-sql queries.
     */
    @Test
    public void shouldExecuteQueryString() {
        long count = plainSqlExecutor.executeQuery(String.format(SQL_COUNT_QUERY, EMPLOYEES_TABLE_NAME), Long.class);
        Assert.assertTrue(count > 0);
    }
}