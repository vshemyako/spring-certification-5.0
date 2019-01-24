package spring.certification.ioc.q021.example;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Savage one-eyed giant.
 */
@Getter
@Component
public class Cyclops {

    private Heart heart;
    private Eye eye;

    @Autowired(required = false)
    public Cyclops(Heart heart) {
        this.heart = heart;
    }

    @Autowired(required = false)
    public Cyclops(Eye eye) {
        this.eye = eye;
    }

    @Autowired(required = false)
    public Cyclops(Heart heart, Eye eye) {
        this.heart = heart;
        this.eye = eye;
    }
}
