package spring.certification.ioc;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import spring.certification.ioc.Q011.Ink;
import spring.certification.ioc.Q011.Pen;

/**
 * Verifies functionality of bean auto detection described in {@link Q011}.
 */
public class Q011Test {

    /**
     * Verifies that {@link Configuration} class annotated with {@link ComponentScan} annotation is indeed
     * a marker of a package which is scanned recursively by application-context.
     */
    @Test
    public void shouldAutoDetectAndRegisterBeans() {
        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(Q011.ComponentScanPackageMarker.class)) {
            Pen pen = context.getBean(Pen.class);
            Assert.assertNotNull(pen);
            Ink ink = context.getBean(Ink.class);
            Assert.assertNotNull(ink);
        }
    }
}