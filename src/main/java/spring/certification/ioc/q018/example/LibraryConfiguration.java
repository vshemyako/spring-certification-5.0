package spring.certification.ioc.q018.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Java-based configuration meta-data provider to be loaded in Spring IoC container.
 */
@Configuration
public class LibraryConfiguration {

    @Bean
    public BookProvider bookProvider() {
        return new BookProvider();
    }

    /**
     * Bean factory method with specified init and destroy methods.
     */
    @Bean(initMethod = "fillBookCollection", destroyMethod = "releaseBookCollection")
    public Library library(BookProvider bookProvider) {
        return new Library(bookProvider);
    }
}
