package spring.certification.ioc.q023.example;

/**
 * A motion picture.
 */
public class Film {

    private String filmName;

    public Film(String filmName) {
        this.filmName = filmName;
    }

    public String getFilmName() {
        return filmName;
    }
}
