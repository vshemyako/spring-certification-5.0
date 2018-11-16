package spring.certification.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 010:<br>
 * Describe dependency injection using Java annotations.<br>
 * <p>
 * Answer:
 * Dependency injection using Java annotation is based on two central annotations:<br>
 * 1. {@link Bean} - indicates that annotated method produces a bean to be managed by the Spring container<br>
 * 2. {@link Configuration} - indicates that a class declares one or more {@link Bean} methods<br>
 * <p>
 * For stand-alone applications such java-based configuration classes could be loaded into
 * {@link AnnotationConfigApplicationContext} class instance.
 * <p>
 * Therefore java-based DI is based on three steps:<br>
 * 1. Create configuration classes annotated with {@link Configuration} annotation.<br>
 * 2. Within created configuration classes define factory methods annotated with {@link Bean} annotation.<br>
 * 3. Load configuration classes in appropriated implementation of {@link ApplicationContext} instance.<br>
 * <p>
 * Example of mentioned java based configuration is located in counterpart test class.
 *
 * @author Valentine Shemyako
 * @since November 17, 2018
 */
public class Q010 {

    /**
     * Java-based DI bean configuration class.
     */
    @Configuration
    public static class JavaBasedConfiguration {

        /**
         * Simplistic factory method which provides bean-definition for Battery type.
         */
        @Bean
        public Battery battery() {
            return new Battery();
        }

        /**
         * More complex bean factory which produces bean-definition for {@link Smartphone} type.
         *
         * @param battery bean which is expected to be injection while {@link Smartphone} bean is instantiated.
         */
        @Bean
        public Smartphone smartphone(Battery battery) {
            return new Smartphone(battery);
        }
    }

    /**
     * Electrochemical cell which transforms chemical energy into electricity.
     */
    public static class Battery {
    }

    /**
     * Multi-purpose mobile device.
     */
    public static class Smartphone {

        private Battery battery;

        /**
         * No reason to use a smartphone without a battery.
         */
        public Smartphone(Battery battery) {
            this.battery = battery;
        }

        /**
         * Extract battery from mobile device.
         */
        public Battery extractBattery() {
            return this.battery;
        }
    }
}
