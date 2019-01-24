package spring.certification.test.q005.example;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 * Red liquid.
 */
@Setter
@Getter
@Component
public class Blood {
    private int oxygenRatio;
    private int carbonDioxideRatio;
}
