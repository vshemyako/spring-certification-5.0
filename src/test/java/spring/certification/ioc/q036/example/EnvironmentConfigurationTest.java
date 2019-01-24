package spring.certification.ioc.q036.example;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Verifies functionality offered by {@link Environment} interface.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = EnvironmentConfiguration.class)
@ActiveProfiles(profiles = "certification")
public class EnvironmentConfigurationTest {

    @Autowired
    @Qualifier(value = "externalProfileConditions")
    private String[] activeProfiles;
    @Autowired
    private String javaVersion;

    /**
     * Verifies that is possible to access array of active profiles in which current application is running.
     */
    @Test
    public void shouldReturnActiveProfiles() {
        assertArrayEquals(new String[]{"certification"}, activeProfiles);
    }

    /**
     * Verifies possibility to access JVM properties through {@link Environment} object injection by Spring IoC
     * container.
     */
    @Test
    public void shouldReturnJavaVersion() {
        assertTrue(javaVersion.startsWith("1.8"));
    }
}