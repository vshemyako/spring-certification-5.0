package spring.certification.ioc.q028.example;

/**
 * Portable media player.
 */
public class Walkman {

    private CompactDisc compactDisc;

    public Walkman(CompactDisc compactDisc) {
        this.compactDisc = compactDisc;
    }

    public CompactDisc extractDisc() {
        return compactDisc;
    }
}
