package spring.certification.ioc.q019.example;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * A movie theater.
 */
public class Cinema {

    private String filmName;
    private SloganMaker sloganMaker;
    private Signboard signboard;

    public Cinema(String filmName, SloganMaker sloganMaker) {
        this.filmName = filmName;
        this.sloganMaker = sloganMaker;
    }

    /**
     * Initialization callback which fills cinema's signboard.
     */
    @PostConstruct
    private void init() {
        String slogan = sloganMaker.composeSlogan(this.filmName);
        this.signboard = new Signboard(slogan);
    }

    /**
     * Destruction signboard which cleans up cinema's signboard.
     */
    @PreDestroy
    private void cleanUp() {
        this.signboard.clear();
    }

    public Signboard getSignboard() {
        return signboard;
    }
}
