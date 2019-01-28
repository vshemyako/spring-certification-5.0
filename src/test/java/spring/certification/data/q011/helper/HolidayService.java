package spring.certification.data.q011.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import spring.certification.data.helper.config.jpa.entity.Holiday;
import spring.certification.data.q005.example.PlainSqlExecutor;

import static spring.certification.data.helper.SqlQueries.*;

@Service
public class HolidayService {

    private PlainSqlExecutor plainSqlExecutor;
    private TransactionTemplate transactionTemplate;

    @Autowired
    public HolidayService(PlainSqlExecutor plainSqlExecutor, TransactionTemplate transactionTemplate) {
        this.plainSqlExecutor = plainSqlExecutor;
        this.transactionTemplate = transactionTemplate;
    }

    /**
     * Intentionally throws an exception after inserting {@code holiday} into the database.
     * Method was implemented to verify workings of jdbc-transactions.
     */
    @Transactional
    public void rollbackSavedHolidayDeclaratively(String holidayName) {
        plainSqlExecutor.executeInsert(String.format(SQL_INSERT_HOLIDAYS_STATEMENT, holidayName));
        throw new IllegalStateException("An unexpected error occurred");
    }

    /**
     * Intentionally rollbacks the transaction after inserting {@code holidayName} into the database.
     * Method was implemented to verify workings of programmatic jdbc-transactions.
     */
    public void rollbackSavedHolidayProgrammatically(String holidayName) {
        TransactionCallback<Void> callback = status -> {
            plainSqlExecutor.executeInsert(String.format(SQL_INSERT_HOLIDAYS_STATEMENT, holidayName));
            status.setRollbackOnly();
            return null;
        };
        transactionTemplate.execute(callback);
    }

    /**
     * @return total number of {@link Holiday} records stored in the database.
     */
    public long countHolidays() {
        return plainSqlExecutor.executeQuery(String.format(SQL_COUNT_QUERY, HOLIDAYS_TABLE_NAME), Long.class);
    }
}
