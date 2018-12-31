package spring.certification.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.env.MockEnvironment;

import static spring.certification.test.Q001unit.PropertyResolver;

/**
 * Demonstrates usage of Spring Framework support classes used in a unit test.
 *
 * @author Valentine Shemyako
 * @since December 31, 2018
 */
public class Q001unitTest {

    private static final String SPRING = "Spring";
    private static final String FRAMEWORK = "framework";

    private MockEnvironment environment;

    @Before
    public void init() {
        this.environment = new MockEnvironment();
        this.environment.setProperty(FRAMEWORK, SPRING);
    }

    /**
     * Verifies that property resolver indeed resolves property by name.
     */
    @Test
    public void shouldResolveProperty() {
        PropertyResolver propertyResolver = new PropertyResolver(environment);
        String value = propertyResolver.resolveProperty(FRAMEWORK);
        Assert.assertEquals(SPRING, value);
    }
}