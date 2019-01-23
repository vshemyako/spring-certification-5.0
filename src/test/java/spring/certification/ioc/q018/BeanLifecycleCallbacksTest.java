package spring.certification.ioc.q018;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import spring.certification.ioc.q018.example.Book;
import spring.certification.ioc.q018.example.Library;
import spring.certification.ioc.q018.example.LibraryConfiguration;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Verifies functionality offered by {@link Bean} annotation, more specifically possibility to specify init and destroy
 * methods of a bean.
 */
public class BeanLifecycleCallbacksTest {

    private AnnotationConfigApplicationContext context;
    private Library library;

    @Before
    public void setUp() {
        context = new AnnotationConfigApplicationContext(LibraryConfiguration.class);
        library = context.getBean(Library.class);
    }

    /**
     * Verifies that init-method as well as destroy-method specified in {@link Bean} annotation are picked up and
     * executed by Spring IoC container.
     */
    @Test
    public void shouldInvokeInitAndDestroyMethods() {
        // Verify that book collection has been filled - thus init-method indeed has been invoked
        List<Book> books = library.getBooks();
        assertThat(books.size()).isEqualTo(2);

        // Verify that book collection has been cleaned - thus destroy-method indeed has been invoked
        context.close();
        assertThat(books).isEmpty();
    }
}