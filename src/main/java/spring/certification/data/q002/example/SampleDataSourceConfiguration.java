package spring.certification.data.q002.example;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jndi.JndiObjectFactoryBean;

/**
 * Configures several {@link DataSource} beans, each created for different active profile.
 */
@Configuration
public class SampleDataSourceConfiguration {

    /**
     * Obtains a {@link DataSource} instance using JNDI lookup.
     * Suitable for production environment.
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
     * Obtains an embedded {@link DataSource}.
     * Only for development environment.
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
