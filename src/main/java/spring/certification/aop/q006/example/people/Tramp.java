package spring.certification.aop.q006.example.people;

import org.springframework.stereotype.Component;

/**
 * A homeless person.
 */
@Component
public class Tramp {

    public void askForMoney() {
        System.out.println("Living on a prayer");
    }
}
