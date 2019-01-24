package spring.certification.test.q001.example;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.env.MockEnvironment;

/**
 * Demonstrates usage of Spring Framework support classes used in a unit test.
 *
 * @author Valentine Shemyako
 * @since December 31, 2018
 */
public class PropertyResolverTest {

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

        String actualValue = propertyResolver.resolveProperty(FRAMEWORK);
        assertThat(SPRING).isEqualTo(actualValue);
    }
}