package spring.certification.aop.q003.example;

import org.springframework.stereotype.Component;

/**
 * A person who loves music.
 */
@Component
public class MusicFan {

    public void listenTo(Guitarist guitarist) {
        guitarist.playTheGuitar();
    }
}
