package spring.certification.data;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jndi.JndiObjectFactoryBean;

import javax.sql.DataSource;

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
 * <p>
 * Preferable development {@link DataSource} is a pooled-datasource obtained by JNDI lookup. For testing purposes
 * embedded datasource {@link org.springframework.jdbc.datasource.embedded.EmbeddedDatabase} is sometimes sufficient.<br>
 * Examples of mentioned terms:<br>
 * {@link DatabaseConfiguration} - basic example for configuring production/development datasources.
 *
 * @author Valentine Shemyako
 * @since December 16, 2018
 */
public class Q002datasource {

    /**
     * Configures several {@link DataSource} beans, each created for different active profile.
     */
    @Configuration
    public static class DatabaseConfiguration {

        /**
         * Obtains a {@link DataSource} instance using JNDI lookup.
         * Suitable production environment.
         */
        @Bean
        @Profile("production")
        public DataSource productionDataSource() {
            JndiObjectFactoryBean jndiObject = new JndiObjectFactoryBean();
            jndiObject.setJndiName("jdbc/database-name");
            jndiObject.setProxyInterface(DataSource.class);
            return (DataSource) jndiObject.getObject();
        }

        /**
         * Obtains an embedded {@link DataSource}. Only for development environment.
         */
        @Bean
        @Profile("development")
        public DataSource developmentDataSource() {
            return new EmbeddedDatabaseBuilder()
                    .setType(EmbeddedDatabaseType.H2)
                    .addScript("ddl.script")
                    .addScript("dml.script")
                    .build();
        }
    }
}
