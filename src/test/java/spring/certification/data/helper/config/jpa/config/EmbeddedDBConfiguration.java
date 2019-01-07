package spring.certification.data.helper.config.jpa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import spring.certification.data.helper.config.jpa.entity.Holiday;

import javax.sql.DataSource;

/**
 * Embedded database configuration to verify Spring Framework support for Java Persistence API.
 *
 * @author Valentine Shemyako
 * @since January 08, 2019
 */
@Configuration
public class EmbeddedDBConfiguration {

    /**
     * Constructs data-source object to acquire connection to an embedded database.
     */
    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("create-database.sql")
                .addScript("database-data.sql")
                .build();
    }

    /**
     * Constructs ORM framework vendor adapter.
     */
    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setDatabase(Database.H2);
        jpaVendorAdapter.setShowSql(true);
        return jpaVendorAdapter;
    }

    /**
     * Configures container managed entity-manager factory. Central bean in JPA-related
     * database configuration.
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter());
        entityManagerFactoryBean.setPackagesToScan(Holiday.class.getPackage().getName());
        entityManagerFactoryBean.afterPropertiesSet();
        return entityManagerFactoryBean;
    }
}
