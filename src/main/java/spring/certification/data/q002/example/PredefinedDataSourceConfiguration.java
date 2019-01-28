package spring.certification.data.q002.example;

import java.sql.Connection;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

/**
 * Configures two types of {@link DataSource datasources} which come with Spring Data framework.
 */
@Configuration
@PropertySource(value = "classpath:embedded.properties")
public class PredefinedDataSourceConfiguration {

    @Value("${jdbc.h2.class.name}")
    private String className;
    @Value("${jdbc.h2.url}")
    private String url;
    @Value("${jdbc.h2.user}")
    private String user;
    @Value("${jdbc.h2.password:}")
    private String password;

    /**
     * {@link DataSource} implementation class which creates new {@link Connection} on every request.
     * Does not support connection pooling (only for testing purposes).
     */
    @Bean
    @Qualifier("driverManager")
    public DataSource driverManagerDataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName(className);
        driverManagerDataSource.setUrl(url);
        driverManagerDataSource.setUsername(user);
        driverManagerDataSource.setPassword(password);
        return driverManagerDataSource;
    }

    /**
     * {@link DataSource} implementation class which returns the same {@link Connection} on every request.
     */
    @Bean
    @Qualifier("singleConnection")
    public DataSource singleConnectionDataSource() {
        SingleConnectionDataSource singleConnectionDataSource = new SingleConnectionDataSource();
        singleConnectionDataSource.setDriverClassName(className);
        singleConnectionDataSource.setUrl(url);
        singleConnectionDataSource.setUsername(user);
        singleConnectionDataSource.setPassword(password);
        return singleConnectionDataSource;
    }
}
