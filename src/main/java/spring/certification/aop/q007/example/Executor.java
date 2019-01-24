package spring.certification.aop.q007.example;

import org.springframework.stereotype.Component;

/**
 * Prints simple messages.
 */
@Component
public class Executor {

    /**
     * Prints 'execute' message.
     */
    public void execute() {
        System.out.println("Execute");
    }
}
