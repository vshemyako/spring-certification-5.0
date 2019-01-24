package spring.certification.ioc.q011;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import spring.certification.ioc.q011.example.ComponentScanPackageMarker;
import spring.certification.ioc.q011.example.Ink;
import spring.certification.ioc.q011.example.Pen;
import spring.certification.ioc.q011.example.PlainPackageMarker;

/**
 * Verifies functionality of bean auto detection described in {@link DependencyInjectionAnnotationConfig}.
 */
public class DependencyInjectionAnnotationConfigTest {

    /**
     * Verifies that {@link Configuration} class annotated with {@link ComponentScan} annotation is indeed
     * a marker of a package which is scanned recursively by application-context.
     */
    @Test
    public void shouldAutoDetectAndRegisterBeans() {
        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(ComponentScanPackageMarker.class)) {

            assertBeanDetectionAndWiring(context);
        }
    }

    /**
     * Verifies usage of annotation free Java class.
     */
    @Test
    public void shouldAutoDetectAndRegisterBeansWithPlainJavaClass() {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
            context.scan(PlainPackageMarker.class.getPackage().getName());
            context.refresh();
            assertBeanDetectionAndWiring(context);
        }
    }

    private void assertBeanDetectionAndWiring(ApplicationContext context) {
        Pen pen = context.getBean(Pen.class);
        assertThat(pen).isNotNull();
        Ink ink = context.getBean(Ink.class);
        assertThat(ink).isNotNull();
        assertThat(ink).isEqualTo(pen.getInk());
    }
}