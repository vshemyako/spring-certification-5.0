package spring.certification.test.q003;

import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;

/**
 * Demonstrates different possibilities to create shared application context to be used in integration tests.
 *
 * @author Valentine Shemyako
 * @since December 31, 2018
 */
public class SharedApplicationContextTest {

    /**
     * Context is injected via means of {@link SpringRunner} class which as actually an alias for
     * {@link SpringJUnit4ClassRunner} class.
     */
    @RunWith(SpringRunner.class)
    @ContextConfiguration(classes = BeanConfiguration.class)
    public static class SpringRunnerUsage {

        @Autowired
        private ApplicationContext context;

        @Test
        public void shouldInjectContext() {
            InjectionAssert.assertContextInjected(context);
        }
    }

    /**
     * Context is injected via means of {@link SpringJUnit4ClassRunner} class.
     */
    @RunWith(SpringJUnit4ClassRunner.class)
    @ContextConfiguration(classes = BeanConfiguration.class)
    public static class SpringJUnit4ClassRunnerUsage {

        @Autowired
        private ApplicationContext context;

        @Test
        public void shouldInjectContext() {
            InjectionAssert.assertContextInjected(context);
        }
    }

    /**
     * Context is injected via means of {@link ApplicationContextAware} interface. As an alternative
     * test class might extend one of predefined spring-test classes:<br>
     * - {@link org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests}<br>
     * - {@link org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests}<br>
     */
    @RunWith(SpringRunner.class)
    @ContextConfiguration(classes = BeanConfiguration.class)
    public static class ContextAwareUsage implements ApplicationContextAware {

        private ApplicationContext context;

        @Override
        public void setApplicationContext(ApplicationContext context) throws BeansException {
            this.context = context;
        }

        @Test
        public void shouldInjectContext() {
            InjectionAssert.assertContextInjected(context);
        }
    }

    /**
     * Context is injected via means of {@link SpringMethodRule} and {@link SpringClassRule}.
     */
    @ContextConfiguration(classes = BeanConfiguration.class)
    public static class SpringRuleUsage {

        @ClassRule
        public static final SpringClassRule springClassRule = new SpringClassRule();

        @Rule
        public final SpringMethodRule springMethodRule = new SpringMethodRule();

        @Autowired
        private ApplicationContext context;

        @Test
        public void shouldInjectContext() {
            InjectionAssert.assertContextInjected(context);
        }
    }

    private static class InjectionAssert {

        private static void assertContextInjected(ApplicationContext context) {
            Assert.assertNotNull(context);
            Assert.assertNotNull(context.getBean("holidayMessage"));
        }
    }

    @Configuration
    public static class BeanConfiguration {

        @Bean
        public String holidayMessage() {
            return "Merry Christmas!";
        }
    }
}