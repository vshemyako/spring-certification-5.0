package spring.certification.test.q002.example;

import org.springframework.stereotype.Component;

/**
 * Low-skill developer.
 */
@Component
public class JuniorDeveloper implements Developer {

    @Override
    public String position() {
        return "junior";
    }
}
