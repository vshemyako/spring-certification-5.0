package spring.certification.ioc.q034;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import spring.certification.ioc.q034.example.Shelf;
import spring.certification.ioc.q034.example.ShelfConfiguration;

/**
 * Verifies functionality of {@link Value} annotation.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ShelfConfiguration.class)
public class ValueAnnotationFunctionalityTest {

    @Autowired
    private Shelf shelf;

    /**
     * Verifies that values were indeed injected directly into the field, via constructor and setter method.
     */
    @Test
    public void shouldUtilizeValueAnnotation() {
        assertThat(shelf.getLength()).isEqualTo(50);
        assertThat(shelf.getWidth()).isEqualTo(10);
        assertThat(shelf.getMaterial()).isEqualTo("plastic");
    }
}