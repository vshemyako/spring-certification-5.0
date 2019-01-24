package spring.certification.ioc.q023.example;

/**
 * A movie theater.
 */
public class Cinema {

    private Film film;

    public Cinema(Film film) {
        this.film = film;
    }

    public Film getFilm() {
        return film;
    }
}
