package spring.certification.ioc.advanced.q041.example;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

/**
 * A person who likes alcohol too much. Has unlimited access to alcohol.
 */
@Component
public class HappyAlcoholic {

    private Alcohol alcohol;

    public HappyAlcoholic(Alcohol alcohol) {
        this.alcohol = alcohol;
    }

    /**
     * This method will be overridden by CGLIB library using byte-code generation.
     */
    @Lookup
    public Alcohol getAlcohol() {
        return null;
    }
}
