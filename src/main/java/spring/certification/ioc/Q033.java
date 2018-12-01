package spring.certification.ioc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 033:<br>
 * How do you inject scalar/literal values into Spring beans?<br>
 * <p>
 * Answer:<br>
 * Literal values can be injected into a Spring bean via {@link Value} annotation or using xml-based counterpart.<br>
 * It's important to remember that those values cannot be injected into {@link BeanPostProcessor} and
 * {@link BeanFactoryPostProcessor} type beans, because {@link Value} annotation processing is done by
 * {@link BeanPostProcessor} itself.<br>
 * <p>
 * Examples of mentioned terms:<br>
 * {@link Q033.LiteralConfiguration} - demonstrates injection of literal values using {@link Value} annotation and
 * external property file. The same can be done using SpEL.
 *
 * @author Valentine Shemyako
 * @since December 01, 2018
 */
public class Q033 {

    @ComponentScan
    @Configuration
    public static class LiteralConfiguration {
    }

    @PropertySource("classpath:literal.properties")
    @Component
    public static class ValueObject {

        @Value("${null}")
        private Object empty;
        @Value("${integral}")
        private Integer integral;
        @Value("${floating.point}")
        private Double floatingPoint;
        @Value("${word}")
        private String word;
        @Value("${hex}")
        private Integer hex;
        @Value("${predicate.result}")
        private boolean predicateResult;

        public Object getEmpty() {
            return empty;
        }

        public Integer getIntegral() {
            return integral;
        }

        public Double getFloatingPoint() {
            return floatingPoint;
        }

        public String getWord() {
            return word;
        }

        public Integer getHex() {
            return hex;
        }

        public boolean isPredicateResult() {
            return predicateResult;
        }
    }
}
