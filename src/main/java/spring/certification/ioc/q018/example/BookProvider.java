package spring.certification.ioc.q018.example;

/**
 * A person who offers and sells books.
 */
public class BookProvider {

    /**
     * @return new instance of a {@link Book}
     */
    public Book provide(String author, String title) {
        // Complex business logic to provide book is omitted.
        return new Book(author, title);
    }
}
