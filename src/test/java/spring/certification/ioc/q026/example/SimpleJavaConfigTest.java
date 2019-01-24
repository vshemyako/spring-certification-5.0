package spring.certification.ioc.q026.example;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import spring.certification.ioc.q026.BeanAnnotationFunctionality;

/**
 * Tests functionality of {@link Bean} annotation discussed in related question {@link BeanAnnotationFunctionality}.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SimpleJavaConfig.class)
public class SimpleJavaConfigTest {

    @Autowired
    private LocalDate actualChristmas;

    @Test
    public void shouldManageChristmas() {
        LocalDate expectedChristmas = LocalDate.of(LocalDate.now().getYear(), 12, 25);
        assertThat(expectedChristmas).isEqualTo(actualChristmas);
    }
}