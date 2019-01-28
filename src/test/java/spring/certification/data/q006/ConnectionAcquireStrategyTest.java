package spring.certification.data.q006;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Verifies that per each JDBC template method execution connection is acquired and realised.
 */
@RunWith(MockitoJUnitRunner.class)
public class ConnectionAcquireStrategyTest {

    @Mock
    private DataSource dataSource;
    @Mock
    private Connection connection;
    @Mock
    private ConnectionCallback<Connection> connectionCallback;

    private JdbcTemplate jdbcTemplate;

    @Before
    public void setUp() throws SQLException {
        when(dataSource.getConnection()).thenReturn(connection);
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Test
    public void shouldAcquireAndReleaseConnection() throws SQLException {
        jdbcTemplate.execute(connectionCallback);
        verify(dataSource).getConnection();
        verify(connection).close();
    }
}