package spring.chapter02.implicit;

import org.springframework.stereotype.Component;

/**
 * Hybrid Theory compact disc originally release by LP band
 */
@Component
public final class HybridTheory implements CompactDisc {

    private static final String BAND_NAME = "Linkin Park";
    private static final String ALBUM_NAME = "Hybrid Theory";

    @Override
    public final void play() {
            System.out.println(BAND_NAME + " - " + ALBUM_NAME);
    }
}
