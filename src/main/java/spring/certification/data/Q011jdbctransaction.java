package spring.certification.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import spring.certification.data.helper.Employee;
import spring.certification.data.helper.config.EmployeesDBConfiguration;
import spring.certification.data.q005.example.PlainSqlExecutor;

import static spring.certification.data.helper.SqlQueries.*;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 011:<br>
 * Is the JDBC template able to participate in an existing transaction?<br>
 * <p>
 * Answer:<br>
 * It's possible to participate in database transaction using {@link JdbcTemplate} both programmatically
 * and declaratively:<br>
 * - {@link EmployeeService#saveEmployeeErroneously(Employee)} - demonstrates how to participate in transaction
 * declaratively. Note that {@link EmployeesDBConfiguration} constructs {@link PlatformTransactionManager} bean and
 * is itself annotated with {@link EnableTransactionManagement}.<br>
 * - {@link EmployeeService#rollbackSavedEmployee(Employee)} - demonstrates how to participate in transaction
 * programmatically.
 *
 * @author Valentine Shemyako
 * @since January 05, 2019
 */
public class Q011jdbctransaction {

    @Import(AutoDetectionMarker.class)
    @ComponentScan
    public static class JdbcConfigMarker {
    }

    /**
     * Service component to work with 'employee' data stored into the database.
     */
    @Service
    public static class EmployeeService {

        private PlainSqlExecutor plainSqlExecutor;
        private TransactionTemplate transactionTemplate;

        @Autowired
        public EmployeeService(PlainSqlExecutor plainSqlExecutor, TransactionTemplate transactionTemplate) {
            this.plainSqlExecutor = plainSqlExecutor;
            this.transactionTemplate = transactionTemplate;
        }

        /**
         * Intentionally throws an exception after inserting {@code employee} into the database.
         * Method was implemented to verify workings of jdbc-transactions.
         */
        @Transactional
        public void saveEmployeeErroneously(Employee employee) {
            int nextNumber = generateNextNumber();
            employee.setNumber(nextNumber);

            plainSqlExecutor.executeInsertEmployee(employee);
            throw new IllegalStateException("Failed to insert employee");
        }

        /**
         * Intentionally rollbacks the transaction after inserting (@code employee) into the database.
         * Method was implemented to verify workings of programmatic jdbc-transactions.
         */
        public void rollbackSavedEmployee(Employee employee) {
            int nextNumber = generateNextNumber();
            employee.setNumber(nextNumber);

            TransactionCallback<Void> callback = status -> {
                plainSqlExecutor.executeInsertEmployee(employee);
                status.setRollbackOnly();
                return null;
            };

            transactionTemplate.execute(callback);
        }

        private int generateNextNumber() {
            int currentNumber = plainSqlExecutor.executeQuery(String.format(SQL_MAX_QUERY, EMPLOYEE_ID_COLUMN, EMPLOYEES_TABLE_NAME), Integer.class);
            return ++currentNumber;
        }

        /**
         * @return total number of employees stored in the database.
         */
        public long countEmployees() {
            return plainSqlExecutor.executeQuery(String.format(SQL_COUNT_QUERY, EMPLOYEES_TABLE_NAME), Long.class);
        }
    }
}
