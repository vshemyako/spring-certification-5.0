package spring.certification.ioc.advanced.q042;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Verifies the order of bean configuration and naming.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = NamingConflicts.class)
public class NamingConflictsTest {

    @Autowired
    private String dull;

    /**
     * The first bean has been removed from application-context.
     */
    @Test
    public void shouldInjectFirst() {
        assertThat(dull).isEqualTo("Second Dull Object");
    }
}