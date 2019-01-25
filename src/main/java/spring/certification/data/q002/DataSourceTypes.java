package spring.certification.data.q002;

import javax.sql.DataSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import spring.certification.data.q002.example.SampleDataSourceConfiguration;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 002:<br>
 * How do you configure a DataSource in Spring?<br>
 * Which bean is very useful for development/test databases?<br>
 * <p>
 * Answer:<br>
 * {@link DataSource} is a factory to obtain database connections. There're several ways to create {@link DataSource}
 * beans in a Spring application:<br>
 * - using JNDI lookup<br>
 * - using jdbc {@link DataSource} vendors<br>
 * - using test-purpose {@link DataSource} implementations provided by Spring Framework (e.g. {@link DriverManagerDataSource},
 * {@link SingleConnectionDataSource}, embedded datasource created via {@link EmbeddedDatabaseBuilder} class).<br>
 * <p>
 * Preferable development {@link DataSource} is a pooled-datasource obtained by JNDI lookup. For testing purposes
 * embedded datasource {@link EmbeddedDatabase} is sometimes sufficient.<br>
 * Examples of mentioned terms:<br>
 * {@link SampleDataSourceConfiguration} - basic example for configuring production/development datasources.
 *
 * @author Valentine Shemyako
 * @since December 16, 2018
 */
public class DataSourceTypes {
}
