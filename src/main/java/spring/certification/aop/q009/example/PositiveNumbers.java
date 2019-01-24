package spring.certification.aop.q009.example;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * A wrapper object which collects only positive numbers.
 */
@Component
public class PositiveNumbers {

    /**
     * A collection of positive numbers.
     */
    private List<Integer> numbers;

    /**
     * Although class java-docs state that object collects only positive numbers there's no validation
     * of input parameters.
     */
    public void addNumber(Integer number) {
        if (numbers == null) {
            this.numbers = new ArrayList<>();
        }
        numbers.add(number);
    }

    /**
     * @return the first element in the collection.
     */
    public int getFirst() {
        if (numbers.isEmpty()) {
            throw new IllegalStateException("Collection is empty");
        }
        return numbers.get(0);
    }
}
