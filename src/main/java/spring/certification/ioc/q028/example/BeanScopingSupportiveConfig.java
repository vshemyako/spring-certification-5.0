package spring.certification.ioc.q028.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Demonstrates inter-bean references.
 */
@Configuration
public class BeanScopingSupportiveConfig {

    /**
     * Factory method which produces instances of {@link CompactDisc} class.
     */
    @Bean
    public CompactDisc compactDisc() {
        return new CompactDisc();
    }

    /**
     * Factory method which produces instances of {@link MusicCenter} class.
     * Performs internal call to {@link #compactDisc()} factory method.
     */
    @Bean
    public MusicCenter musicCenter() {
        return new MusicCenter(compactDisc());
    }

    /**
     * Factory method which produces instances of {@link Walkman} class.
     * Performs internal call to {@link #compactDisc()} factory method.
     */
    @Bean
    public Walkman walkman() {
        return new Walkman(compactDisc());
    }
}
