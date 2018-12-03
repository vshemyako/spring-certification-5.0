package spring.certification.ioc;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

/**
 * Verifies functionality offered by {@link Environment} interface.
 */
public class Q036Test {

    private static final String[] PROFILES = {"certification"};
    private AnnotationConfigApplicationContext context;

    /**
     * Register necessary profiles and refreshes application context.
     */
    @Before
    public void setUp() {
        context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles(PROFILES);
        context.register(Q036.EnvironmentAbstraction.class);
        context.refresh();
    }

    /**
     * Closes application context.
     */
    @After
    public void tearDown() {
        context.close();
    }

    /**
     * Verifies that is possible to access array of active profiles in which current application is running.
     */
    @Test
    public void shouldReturnActiveProfiles() {
        String[] activeProfiles = context.getBean("externalProfileConditions", String[].class);
        Assert.assertArrayEquals(PROFILES, activeProfiles);
    }

    /**
     * Verifies possibility to access JVM properties through {@link Environment} object injection by Spring IoC
     * container.
     */
    @Test
    public void shouldReturnJavaVersion() {
        String javaVersion = context.getBean("javaVersion", String.class);
        Assert.assertTrue(javaVersion.startsWith("1.8"));
    }
}