package spring.certification.data.q002.example;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Integration tests which verify functionality of {@link DriverManagerDataSource} and {@link SingleConnectionDataSource} classes.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = PredefinedDataSourceConfiguration.class)
public class PredefinedDataSourceConfigurationTest {

    @Qualifier("driverManagerDataSource")
    @Autowired
    private DataSource driverManagerDataSource;
    @Qualifier("singleConnectionDataSource")
    @Autowired
    private DataSource singleConnectionDataSource;

    @Test
    public void shouldCreateNewConnectionForEachRequest() throws SQLException {
        Connection firstConnection = driverManagerDataSource.getConnection();
        Connection secondConnection = driverManagerDataSource.getConnection();
        assertThat(firstConnection).isNotSameAs(secondConnection);
    }

    @Test
    public void shouldManageTheSameConnectionForEachRequest() throws SQLException {
        Connection firstConnection = singleConnectionDataSource.getConnection();
        Connection secondConnection = singleConnectionDataSource.getConnection();
        assertThat(firstConnection).isSameAs(secondConnection);
    }
}