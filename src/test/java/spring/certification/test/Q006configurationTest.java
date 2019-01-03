package spring.certification.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Tests usage of {@link ContextConfiguration} annotation.
 *
 * @author Valentine Shemyako
 * @since January 03, 2019
 */
public class Q006configurationTest {

    /**
     * Demonstrates usage of {@link ContextConfiguration} annotation applied to {@link Component} class.
     */
    @ContextConfiguration(classes = {FirTree.class, OakTree.class})
    public static class ComponentConfigurationUsage extends BaseConfigurationClass {
    }

    /**
     * Demonstrates usage of {@link ContextConfiguration} annotation applied to {@link Configuration} class.
     */
    @ContextConfiguration(classes = ForestConfiguration.class)
    public static class ConfigurationClassUsage extends BaseConfigurationClass {
    }

    /**
     * Demonstrates usage of {@link ContextConfiguration} annotation applied to simple factory class.
     */
    @ContextConfiguration(classes = ForestFactory.class)
    public static class FactoryUsage extends BaseConfigurationClass {
    }

    @RunWith(SpringRunner.class)
    public static abstract class BaseConfigurationClass {
        @Autowired
        private FirTree firTree;
        @Autowired
        private OakTree oakTree;

        @Test
        public void shouldInitializeContext() {
            Assert.assertNotNull(firTree);
            Assert.assertNotNull(oakTree);
        }
    }

    @Component
    public static class FirTree {
    }

    @Component
    public static class OakTree {
    }

    @Configuration
    public static class ForestConfiguration extends ForestFactory {
    }

    public static class ForestFactory {

        @Bean
        public FirTree firTree() {
            return new FirTree();
        }

        @Bean
        public OakTree oakTree() {
            return new OakTree();
        }
    }
}