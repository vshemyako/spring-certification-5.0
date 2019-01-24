package spring.certification.aop.q003.example;

import org.springframework.stereotype.Component;

/**
 * A person who sings.
 */
@Component
public class Singer implements Celebrity {

    @Override
    public void poseForPhoto() {
    }

    public void sing() {
    }
}
