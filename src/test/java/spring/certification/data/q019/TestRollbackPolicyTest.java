package spring.certification.data.q019;

import static org.assertj.core.api.Assertions.assertThat;
import static spring.certification.data.helper.SqlQueries.HOLIDAYS_TABLE_NAME;
import static spring.certification.data.helper.SqlQueries.SQL_COUNT_QUERY;
import static spring.certification.data.helper.SqlQueries.SQL_INSERT_HOLIDAYS_STATEMENT;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import spring.certification.data.helper.config.jpa.config.EmbeddedDBConfiguration;
import spring.certification.data.q005.example.PlainSqlExecutor;

/**
 * Tests to verify default rollback policy of a JUnit test and ways to change this default behavior.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {PlainSqlExecutor.class, EmbeddedDBConfiguration.class})
public class TestRollbackPolicyTest {

    @Autowired
    private PlainSqlExecutor sqlExecutor;

    @Sql(scripts = {"classpath:drop-database.sql", "classpath:create-database.sql", "classpath:database-data.sql"})
    @BeforeClass
    public static void setUp() {
    }

    /**
     * Subsequent invocations verify that previous have not changed records count.
     */
    @Test
    @Repeat(10)
    @Transactional
    public void shouldRollback() {
        long defaultCount = 5;
        long initialCount = sqlExecutor.executeQuery(String.format(SQL_COUNT_QUERY, HOLIDAYS_TABLE_NAME), Long.class);
        assertThat(defaultCount).isEqualTo(initialCount);

        sqlExecutor.executeInsert(String.format(SQL_INSERT_HOLIDAYS_STATEMENT, "'FoolsDay'"));
    }
}