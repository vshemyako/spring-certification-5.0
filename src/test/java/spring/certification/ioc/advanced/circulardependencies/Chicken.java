package spring.certification.ioc.advanced.circulardependencies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Chicken {

    private Egg egg;

    public Egg getEgg() {
        return egg;
    }

    @Autowired
    public void setEgg(Egg egg) {
        this.egg = egg;
    }

    @Override
    public String toString() {
        return "Chicken";
    }
}
