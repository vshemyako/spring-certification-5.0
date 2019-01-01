package spring.certification.test;

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

import javax.sql.DataSource;

/**
 * Demonstrates usage of test-transaction functionality offered by spring-test module.
 *
 * @author Valentine Shemyako
 * @since January 01, 2019
 */
public class Q004transactionTest {

    /**
     * Tests default transactional functionality of test-module.
     */
    @ContextConfiguration(classes = DatabaseConfiguration.class)
    public static class TransactionalUsage extends AbstractTransactionalJUnit4SpringContextTests {

        private static final String TABLE_NAME = "holidays";

        /**
         * Setup method which runs out of a transaction.
         */
        @BeforeTransaction
        public void setUp() {
            executeSqlScript("create-database.sql", false);
        }

        /**
         * Verification that database set-up method works as expected.
         */
        @Test
        public void databaseShouldExist() {
            countRowsInTable(TABLE_NAME);
        }

        /**
         * Tear down method which runs out of a transaction.
         */
        @AfterTransaction
        public void tearDown() {
            executeSqlScript("drop-database.sql", false);
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