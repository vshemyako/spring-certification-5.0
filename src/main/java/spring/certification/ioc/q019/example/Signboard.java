package spring.certification.ioc.q019.example;

/**
 * A board which displays something.
 */
public class Signboard {

    private String title;

    public Signboard(String title) {
        this.title = title;
    }

    public void clear() {
        this.title = null;
    }

    public String getTitle() {
        return title;
    }
}
