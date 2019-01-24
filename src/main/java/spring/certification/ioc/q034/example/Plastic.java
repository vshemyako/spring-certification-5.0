package spring.certification.ioc.q034.example;

import lombok.Getter;
import org.springframework.stereotype.Component;

/**
 * A synthetic material.
 */
@Getter
@Component("plastic")
public class Plastic {
    private final String materialName = "plastic";
}
