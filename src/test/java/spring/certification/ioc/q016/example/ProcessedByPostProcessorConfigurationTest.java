package spring.certification.ioc.q016.example;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Verifies functionality offered by {@link BeanFactoryPostProcessor}.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ProcessedByPostProcessorConfiguration.class)
public class ProcessedByPostProcessorConfigurationTest {

    private static final String MERRY_CHRISTMAS = "Merry Christmas";

    @Autowired
    private Holiday holiday;

    /**
     * Verifies that {@link PropertySourcesPlaceholderConfigurer} substitutes properties placeholders with values
     * provided in property files.
     */
    @Test
    public void shouldReplaceParameterPlaceholder() {
        assertThat(holiday.getName()).isEqualTo(MERRY_CHRISTMAS);
    }
}