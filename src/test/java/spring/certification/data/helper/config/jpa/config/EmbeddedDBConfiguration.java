package spring.certification.data.helper.config.jpa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;
import spring.certification.data.helper.config.jpa.entity.Holiday;
import spring.certification.data.helper.config.jpa.instant.InstantHolidayRepository;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * Embedded database configuration to verify Spring Framework support for Java Persistence API.
 *
 * @author Valentine Shemyako
 * @since January 08, 2019
 */
@Configuration
@EnableJpaRepositories(basePackageClasses = InstantHolidayRepository.class)
@EnableTransactionManagement
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
     * Constructs template object over native java JDBC functionality.
     */
    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
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
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter());
        entityManagerFactoryBean.setPackagesToScan(Holiday.class.getPackage().getName());
        entityManagerFactoryBean.afterPropertiesSet();
        return entityManagerFactoryBean;
    }

    /**
     * Configures JPA specific {@link PlatformTransactionManager}.
     */
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

    /**
     * Configures simple {@link DataSource} {@Link PlatformTransactionManager}.
     */
    @Bean
    @Primary
    public PlatformTransactionManager dataSourceTransactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * Configures {@link TransactionTemplate} bean to participate in existing transaction
     * programmatically.
     */
    @Bean
    public TransactionTemplate transactionTemplate(PlatformTransactionManager transactionManager) {
        return new TransactionTemplate(transactionManager);
    }
}
