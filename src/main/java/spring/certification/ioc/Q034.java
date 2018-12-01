package spring.certification.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 034:<br>
 * What is @Value used for?<br>
 * <p>
 * Answer:<br>
 * Simply put {@link Value} is used for injecting values into bean properties, method / constructor parameters.
 * Sources of those properties differ:<br>
 * 1. Constant, literal values<br>
 * 2. SpEL expressions<br>
 * 3. Environment variables, default property sources<br>
 * <p>
 * Examples of mentioned terms:<br>
 * {@link Q034.ShelfConfiguration} - an example of usage of {@link Value} annotation.
 *
 * @author Valentine Shemyako
 * @since December 01, 2018
 */
public class Q034 {

    /**
     * Demonstrates how a bean can be assembles with the help of {@link Value} annotation.
     */
    @PropertySource("classpath:construction.properties")
    @ComponentScan
    @Configuration
    public static class ShelfConfiguration {
    }

    /**
     * Piece of furniture.
     */
    @Component
    public static class Shelf {

        /**
         * Property injection, using literal value.
         */
        @Value("50")
        private int length;
        private int width;
        private String material;

        /**
         * Constructor parameter injection, using custom property source.
         */
        public Shelf(@Value("${shelf.width}") int width) {
            this.width = width;
        }

        /**
         * Setter parameter injection, using SpEL and referencing another bean property.
         * Note: {@link Autowired} is used here, because otherwise IoC container ignores autowiring config methods
         * (by default applies to a constructor)
         */
        @Autowired
        public void setMaterial(@Value("#{plastic.getMaterialName()}") String material) {
            this.material = material;
        }

        public int getLength() {
            return length;
        }

        public int getWidth() {
            return width;
        }

        public String getMaterial() {
            return material;
        }
    }

    /**
     * A synthetic material.
     */
    @Component("plastic")
    public static class Plastic {
        private String materialName = "plastic";

        public String getMaterialName() {
            return materialName;
        }
    }
}
