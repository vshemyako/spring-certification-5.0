package spring.certification.ioc.q028.example;

/**
 * Audio system for home use.
 */
public class MusicCenter {

    private CompactDisc compactDisc;

    public MusicCenter(CompactDisc compactDisc) {
        this.compactDisc = compactDisc;
    }

    public CompactDisc extractDisc() {
        return compactDisc;
    }
}
