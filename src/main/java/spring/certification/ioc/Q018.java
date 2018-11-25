package spring.certification.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 018:<br>
 * What is an initialization method and how is it declared on a Spring bean?<br>
 * What is a destroy method, how is it declared and when is it called?<br>
 * <p>
 * Answer:<br>
 * An initialization method is a method which is invoked after a bean is fully initialized (bean is created and all its
 * properties were set). Common usage of an init-method: execute some logic which is dependent on bean's properties. To
 * specify init-method of a bean {@link Bean#initMethod()} annotation type element is used.<br>
 * <p>
 * A destroy method is a method which is invoked before application context is about to close. Common usage of a
 * destroy-method is to release resources that the bean was dependent on. To specify destroy-method of a bean
 * {@link Bean#destroyMethod()} annotation type element is used.<br.
 * Examples of mentioned terms:<br>
 * -
 *
 * @author Valentine Shemyako
 * @since November 24, 2018
 */
public class Q018 {

    /**
     * Java-based configuration meta-data provider to be loaded in Spring IoC container.
     */
    @Configuration
    public static class LibraryConfiguration {

        @Bean
        public BookProvider bookProvider() {
            return new BookProvider();
        }

        /**
         * Bean factory method with specified init and destroy methods.
         */
        @Bean(initMethod = "fillBookCollection", destroyMethod = "releaseBookCollection")
        public Library library(BookProvider bookProvider) {
            return new Library(bookProvider);
        }
    }

    /**
     * Building, containing collections of books.
     */
    public static class Library {

        /**
         * Source of new books.
         */
        private BookProvider bookProvider;

        /**
         * Book collection which library possess.
         */
        private List<Book> books;

        /**
         * Only provider is required property.<br>
         * Books collection will be filled during library lifecycle.
         */
        public Library(BookProvider bookProvider) {
            this.bookProvider = bookProvider;
            this.books = new ArrayList<>();
        }

        /**
         * Initialization method which fills library's book collection after
         * required {@code bookProvider} has been chosen.
         */
        private void fillBookCollection() {
            addBook("Thomas Harris", "The silence of the Lambs");
            addBook("Arkady and Boris Strugatsky", "Roadside Picnic");
        }

        /**
         * Distribute books to all those craving.
         */
        private void releaseBookCollection() {
            this.books.clear();
        }

        /**
         * Adds desired book to the collection.
         */
        private void addBook(String author, String title) {
            Book desiredBook = this.bookProvider.provide(author, title);
            this.books.add(desiredBook);
        }

        /**
         * @return all books stored in the library.
         */
        public List<Book> getBooks() {
            return books;
        }
    }

    /**
     * Sheets of paper with some text on them.
     */
    public static class Book {
        private String author;
        private String title;

        public Book(String author, String title) {
            this.author = author;
            this.title = title;
        }
    }

    /**
     * A person who offers and sells books.
     */
    public static class BookProvider {

        /**
         * @return new instance of a {@link Book}
         */
        public Book provide(String author, String title) {
            // Complex business logic to provide book is omitted.
            return new Book(author, title);
        }
    }
}
