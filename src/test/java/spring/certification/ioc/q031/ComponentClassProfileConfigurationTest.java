package spring.certification.ioc.q031;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import spring.certification.ioc.q031.example.Development;
import spring.certification.ioc.q031.example.Production;

/**
 * Verifies {@link Profile} annotation functionality applied at a class-level.
 */
public class ComponentClassProfileConfigurationTest {

    @RunWith(SpringRunner.class)
    @ContextConfiguration(classes = {Development.class, Production.class})
    @ActiveProfiles(profiles = {"production"})
    public static class ProductionProfileActiveTest {

        @Autowired
        private ApplicationContext context;

        @Test
        public void shouldRegisterProduction() {
            context.getBean("production", Production.class);

            try {
                context.getBean("development", Development.class);
                fail();
            } catch (NoSuchBeanDefinitionException ex) {
                // Legal to ignore.
            }
        }
    }

    @RunWith(SpringRunner.class)
    @ContextConfiguration(classes = {Development.class, Production.class})
    @ActiveProfiles(profiles = {"development"})
    public static class DevelopmentProfileActiveTest {

        @Autowired
        private ApplicationContext context;

        @Test
        public void shouldRegisterDevelopment() {
            context.getBean("development", Development.class);

            try {
                context.getBean("production", Production.class);
                fail();
            } catch (NoSuchBeanDefinitionException ex) {
                // Legal to ignore.
            }
        }
    }

    @RunWith(SpringRunner.class)
    @ContextConfiguration(classes = {Development.class, Production.class})
    @ActiveProfiles(profiles = {"development", "production"})
    public static class DevelopmentAndProductionProfilesActiveTest {

        @Autowired
        private ApplicationContext context;

        @Test
        public void shouldRegisterDevelopmentAndProduction() {
            context.getBean("development", Development.class);
            context.getBean("production", Production.class);
        }
    }
}