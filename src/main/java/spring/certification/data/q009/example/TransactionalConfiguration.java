package spring.certification.data.q009.example;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Configuration marker class which enable transaction management.
 */
@Configuration
@ComponentScan
@EnableTransactionManagement
public class TransactionalConfiguration {
}
