package spring.chapter02.implicit;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Tests implicit bean discovery functionality offered by Spring
 */
public class MusicStationConfigTest {

    /**
     * Verifies that implicit bean discovery indeed is performed after required
     * configuration steps are done (more specifically {@link org.springframework.context.annotation.ComponentScan}
     * annotation is defined)
     */
    @Test
    public void shouldCreateCompactDiscBean() {
        ApplicationContext context = new AnnotationConfigApplicationContext(MusicStationConfig.class);
        CompactDisc compactDisc = context.getBean(CompactDisc.class);

        Assert.assertNotNull(compactDisc);
    }
}
