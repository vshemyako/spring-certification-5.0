package spring.certification.test.q004;

import static org.junit.Assert.assertEquals;

import javax.sql.DataSource;
import org.junit.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * Demonstrates usage of test-transaction functionality offered by spring-test module.
 *
 * @author Valentine Shemyako
 * @since January 01, 2019
 */
public class TransactionalTestSupportTest {

    /**
     * Tests default transactional functionality of test-module.
     */
    @ContextConfiguration(classes = DatabaseConfiguration.class)
    public static class TransactionalUsage extends AbstractTransactionalJUnit4SpringContextTests {

        private static final String HOLIDAYS_TABLE_NAME = "holidays";

        /**
         * Setup method which runs before of a transaction.
         */
        @BeforeTransaction
        public void setUp() {
            executeSqlScript("create-database.sql", false);
        }

        /**
         * Tear down method which runs after a transaction.
         */
        @AfterTransaction
        public void tearDown() {
            int rowCount = countRowsInTable(HOLIDAYS_TABLE_NAME);
            assertEquals(0, rowCount);

            executeSqlScript("drop-database.sql", false);
        }

        /**
         * Verification that database set-up method works as expected.
         */
        @Test
        public void databaseShouldExist() {
            countRowsInTable(HOLIDAYS_TABLE_NAME);
        }

        /**
         * Verifies that changes are not committed to the database (default behavior). Verification
         * of rollback policy is performed in {@link #tearDown()} block of code.
         */
        @Test
        public void shouldRollbackTransaction() {
            jdbcTemplate.execute(String.format("INSERT INTO holidays (name) VALUES ('%s')", HOLIDAYS_TABLE_NAME));
            int rowsCount = countRowsInTable(HOLIDAYS_TABLE_NAME);
            assertEquals(1, rowsCount);
        }
    }

    /**
     * Simple configuration of an embedded database, with jdbc-transaction manager.
     */
    @Configuration
    public static class DatabaseConfiguration {

        @Bean
        public DataSource dataSource() {
            return new EmbeddedDatabaseBuilder()
                    .setType(EmbeddedDatabaseType.H2)
                    .build();
        }

        @Bean
        public PlatformTransactionManager transactionManager() {
            return new DataSourceTransactionManager(dataSource());
        }
    }
}