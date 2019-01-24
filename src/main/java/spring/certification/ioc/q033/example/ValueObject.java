package spring.certification.ioc.q033.example;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Getter
@Component
@PropertySource("classpath:literal.properties")
public class ValueObject {
    @Value("${integral}")
    private Integer integral;
    @Value("${floating.point}")
    private Double floatingPoint;
    @Value("${word}")
    private String word;
    @Value("${hex}")
    private Integer hex;
    @Value("${predicate.result}")
    private boolean predicateResult;
    @Value("no placeholder")
    private String withoutPlaceholder;
}
