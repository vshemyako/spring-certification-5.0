package spring.certification.ioc.q029;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import spring.certification.ioc.q029.example.DevelopmentConfiguration;
import spring.certification.ioc.q029.example.LeadDeveloperProductionConfiguration;

/**
 * Verifies basic functionality of {@link Profile} annotation.
 */
public class ProfileAnnotationFunctionalityTest {

    /**
     * Verifies that startupMessage bean is created by IoC container in case production profile is active.
     */
    @RunWith(SpringRunner.class)
    @ContextConfiguration(classes = DevelopmentConfiguration.class)
    @ActiveProfiles(profiles = "production")
    public static class ProductionActiveProfileTest {

        @Autowired
        private ApplicationContext context;

        /**
         * Verifies that startupMessage bean is created by IoC container in case production profile is active.
         */
        @Test
        public void shouldRegisterStartupMessage() {
            String startupMessage = context.getBean("startupMessage", String.class);
            assertThat("Success!").isEqualTo(startupMessage);
        }
    }

    /**
     * Verifies that startupMessage bean is not created by IoC container in case production profile is not set.
     */
    @RunWith(SpringRunner.class)
    @ContextConfiguration(classes = DevelopmentConfiguration.class)
    public static class NoProfileActiveTest {

        @Autowired
        private ApplicationContext context;

        /**
         * Verifies that startupMessage bean is created by IoC container in case production profile is active.
         */
        @Test(expected = NoSuchBeanDefinitionException.class)
        public void shouldNotRegisterStartupMessage() {
            context.getBean("startupMessage", String.class);
        }
    }

    /**
     * Verifies that password bean is registered only in case of more complex 'and' profile expression.
     */
    @RunWith(SpringRunner.class)
    @ContextConfiguration(classes = LeadDeveloperProductionConfiguration.class)
    @ActiveProfiles(profiles = {"production", "leadDeveloper"})
    public static class ProfileExpressionTest {

        @Autowired
        private ApplicationContext context;

        @Test
        public void shouldRegisterPasswordBean() {
            String password = context.getBean("password", String.class);
            assertThat("HighFive").isEqualTo(password);
        }
    }

    /**
     * Verifies that it's possible to specify default / active profile using properties.
     */
    @RunWith(SpringRunner.class)
    @ContextConfiguration(classes = DevelopmentConfiguration.class)
    @TestPropertySource(properties = "spring.profiles.active=production")
    public static class PropertiesProfileTest {

        @Autowired
        private ApplicationContext context;

        @Test
        public void shouldRegisterStartupMessage() {
            String startupMessage = context.getBean("startupMessage", String.class);
            assertThat("Success!").isEqualTo(startupMessage);
        }
    }
}