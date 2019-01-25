package spring.certification.ioc.advanced.q041.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * A person who likes alcohol too much. But is only given a single bottle for a lifetime.
 */
@Component
public class SadAlcoholic {

    private Alcohol alcohol;

    @Autowired
    public SadAlcoholic(Alcohol alcohol) {
        this.alcohol = alcohol;
    }

    public Alcohol getAlcohol() {
        return alcohol;
    }
}
