package spring.certification.data;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import spring.certification.data.Q005sql.*;

import static spring.certification.data.Q005sql.*;

/**
 * Verifies functionality of {@link JdbcTemplate} class to execute plain-sql statements.
 */
public class Q005sqlTest {

    private static final String TABLE_NAME = "holidays";

    /**
     * Verifies that {@link JdbcTemplate} indeed executes DDL statements which can alter database structure.
     */
    @Test
    public void shouldExecuteDdlStatement() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AutoDetectionMarker.class);
        context.registerShutdownHook();
        PlainSqlExecutor plainSqlExecutor = context.getBean(PlainSqlExecutor.class);

        // Create, verify, drop table
        plainSqlExecutor.executeDdlStatement(String.format(SQL_CREATE_TABLE_STATEMENT, TABLE_NAME));
        plainSqlExecutor.executeDdlStatement(String.format(SQL_TABLE_VERIFICATION_STATEMENT, TABLE_NAME));
        plainSqlExecutor.executeDdlStatement(String.format(SQL_DROP_TABLE_STATEMENT, TABLE_NAME));
    }
}