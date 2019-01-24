package spring.certification.test.q002.example;

import org.springframework.stereotype.Component;

/**
 * High-skill developer.
 */
@Component
public class SeniorDeveloper implements Developer {

    @Override
    public String position() {
        return "senior";
    }
}
