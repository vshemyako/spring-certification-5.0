package spring.certification.ioc.advanced.circulardependencies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Egg {

    private Chicken chicken;

    public Chicken getChicken() {
        return chicken;
    }

    @Autowired
    public void setChicken(Chicken chicken) {
        this.chicken = chicken;
    }

    @Override
    public String toString() {
        return "Egg";
    }
}
