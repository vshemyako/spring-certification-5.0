package spring.certification.ioc.q030.example;

import static org.junit.Assert.fail;

import java.time.Instant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Verifies {@link Profile} annotation functionality applied on method-level.
 */
public class MethodLevelProfileConfigurationTest {

    @RunWith(SpringRunner.class)
    @ContextConfiguration(classes = MethodLevelProfileConfiguration.class)
    @ActiveProfiles(profiles = "qa")
    public static class QaActiveProfileTest {

        @Autowired
        private ApplicationContext context;

        @Test
        public void shouldRegisterStartupAndShutdownInstants() {
            context.getBean("startupInstant", Instant.class);
            context.getBean("shutdownInstant", Instant.class);

            try {
                context.getBean("epochInstant", Instant.class);
                fail();
            } catch (NoSuchBeanDefinitionException ex) {
                // Legal to ignore.
            }
        }
    }

    @RunWith(SpringRunner.class)
    @ContextConfiguration(classes = MethodLevelProfileConfiguration.class)
    @ActiveProfiles(profiles = {"develop", "production"})
    public static class MethodProfileExpressionTest {

        @Autowired
        private ApplicationContext context;

        @Test
        public void shouldRegisterShutdownAndEpochInstants() {
            context.getBean("epochInstant", Instant.class);
            context.getBean("shutdownInstant", Instant.class);

            try {
                context.getBean("startupInstant", Instant.class);
                fail();
            } catch (NoSuchBeanDefinitionException ex) {
                // Legal to ignore.
            }
        }
    }
}