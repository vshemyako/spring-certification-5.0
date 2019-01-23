package spring.certification.ioc.q018.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Building, containing collections of books.
 */
public class Library {

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
