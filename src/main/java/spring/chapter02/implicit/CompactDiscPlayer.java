package spring.chapter02.implicit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Media player which allows to play {@link CompactDisc}s
 */
@Component
public class CompactDiscPlayer implements MediaPlayer {

    private CompactDisc compactDisc;

    @Autowired
    public CompactDiscPlayer(CompactDisc compactDisc) {
        this.compactDisc = compactDisc;
    }

    @Override
    public void play() {
        this.compactDisc.play();
    }
}
