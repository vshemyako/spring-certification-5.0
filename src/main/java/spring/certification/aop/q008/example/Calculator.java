package spring.certification.aop.q008.example;

import org.springframework.stereotype.Component;

/**
 * A device which performs mathematical calculations.
 */
@Component
public class Calculator {

    /**
     * Performs add math operation.
     */
    public int add(int left, int right) {
        return left + right;
    }
}
