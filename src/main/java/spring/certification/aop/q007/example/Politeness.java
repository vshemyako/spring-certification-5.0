package spring.certification.aop.q007.example;

import org.springframework.stereotype.Component;

/**
 * Prints simple polite messages.
 */
@Component
public class Politeness {

    /**
     * Prints out simple greeting message.
     */
    public void greet() {
        System.out.println("Greet");
    }

    /**
     * Prints out goodbye message.
     */
    protected void sayGoodbye() {
        System.out.println("Goodbye");
    }
}
