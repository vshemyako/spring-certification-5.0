package spring.certification.data.q001;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import spring.certification.data.helper.config.jpa.config.EmbeddedDBConfiguration;

/**
 * Verifies that native JDBC exception hierarchy is indeed wrapped into vendor-agnostic Spring exception hierarchy.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = EmbeddedDBConfiguration.class)
public class ExceptionHierarchyTest {

    private static final String INVALID_INSERT_STATEMENT = "INSERT INTO cities (name) VALUES ('Minsk')";

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private DataSource dataSource;

    @Test(expected = BadSqlGrammarException.class) // SQLException is wrapped...
    public void shouldBeMappedToVendorAgnosticType() {
        // Note that data-base operations do not require exception-handling.
        jdbcTemplate.execute(INVALID_INSERT_STATEMENT);
    }

    @Test
    public void shouldThrowJdbcNativeException() {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(INVALID_INSERT_STATEMENT)) {
            statement.executeUpdate();
            fail();
        } catch (SQLException ex) {
            // Have to handle it...
        }
    }
}