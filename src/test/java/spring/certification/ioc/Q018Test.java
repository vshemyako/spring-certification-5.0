package spring.certification.ioc;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;

/**
 * Verifies functionality offered by {@link Bean} annotation, more specifically possibility to specify init and destroy
 * methods of a bean.
 */
public class Q018Test {

    /**
     * Verifies that init-method as well as destroy-method specified in {@link Bean} annotation are picked up and
     * executed by Spring IoC container.
     */
    @Test
    public void shouldInvokeInitAndDestroyMethods() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Q018.LibraryConfiguration.class);
        Q018.Library library = context.getBean(Q018.Library.class);

        // Verify that book collection has been filled - thus init-method indeed has been invoked
        List<Q018.Book> books = library.getBooks();
        Assert.assertEquals(2, books.size());

        // Verify that book collection has been cleaned - thus destroy-method indeed has been invoked
        context.close();
        Assert.assertTrue(books.isEmpty());
    }
}