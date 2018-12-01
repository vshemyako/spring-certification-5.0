package spring.certification.ioc;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Verifies functionality of {@link Value} annotation.
 */
public class Q034Test {


    /**
     * Verifies that values were indeed injected directly into the field, via constructor and setter method.
     */
    @Test
    public void shouldUtilizeValueAnnotation() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Q034.ShelfConfiguration.class);
        context.registerShutdownHook();

        Q034.Shelf shelf = context.getBean(Q034.Shelf.class);
        Assert.assertEquals(50, shelf.getLength());
        Assert.assertEquals(10, shelf.getWidth());
        Assert.assertEquals("plastic", shelf.getMaterial());
    }
}