package spring.certification.data.helper.config;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Configures {@link javax.sql.DataSource} bean to sample official MySQL database.
 */
@PropertySource("classpath:employees.properties")
@Configuration
public class EmployeesDBConfiguration {

    @Value("${db.server}")
    private String serverName;
    @Value("${db.port}")
    private int port;
    @Value("${db.name}")
    private String databaseName;
    @Value("${db.user}")
    private String user;
    @Value("${db.password}")
    private String password;
    @Value("${db.timezone}")
    private String timezone;

    /**
     * Configures {@link DataSource} bean with parameters specified in separate properties file.
     */
    @Bean
    public DataSource employeesDatasource() throws SQLException {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setServerName(serverName);
        dataSource.setPort(port);
        dataSource.setDatabaseName(databaseName);
        dataSource.setServerTimezone(timezone);
        dataSource.setUser(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    /**
     * Configures {@link JdbcTemplate} bean which is used for low-level db data access.
     */
    @Bean
    public JdbcTemplate jdbcTemplate() throws SQLException {
        return new JdbcTemplate(employeesDatasource());
    }
}
