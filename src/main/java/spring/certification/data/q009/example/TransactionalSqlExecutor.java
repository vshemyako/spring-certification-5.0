package spring.certification.data.q009.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Basic class to verify transaction implementation details.
 */
@Service
@Transactional
public class TransactionalSqlExecutor {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public TransactionalSqlExecutor(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Simply delegates sql execution logic to underlying {@link JdbcTemplate} class.
     */
    public void execute(String sql) {
        jdbcTemplate.execute(sql);
    }
}
