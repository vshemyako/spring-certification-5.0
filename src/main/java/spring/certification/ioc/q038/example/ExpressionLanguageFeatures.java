package spring.certification.ioc.q038.example;

import java.util.List;
import java.util.Map;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.expression.spel.standard.SpelExpression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Component;

/**
 * Demonstrates functionality offered by SpEL. Underneath SpEL is parsed and evaluated by
 * {@link SpelExpressionParser} and {@link SpelExpression} respectively.
 */
@Getter
@Component
public class ExpressionLanguageFeatures {

    @Value("#{911}")
    private int literalExpression;

    /**
     * Though SpEL reference documentation states that another bean properties
     * should be referenced with '@' symbol - plain name reference also works.
     */
    @Value("#{collaborator.name}")
    private String collaboratorBeanProperty;

    /**
     * Though not demonstrated, it's even possible to specify list of lists.
     */
    @Value("#{{true, false}}")
    private List<Boolean> inlineList;

    /**
     * Inline map syntax allows to omit single quotes for declared keys.
     */
    @Value("#{{one:1, two:2}}")
    private Map<String, Integer> inlineMap;

    @Value("#{new Character[]{'a', 'b', 'c'}}")
    private Character[] inlineArray;

    @Value("#{'Hello'.concat(' ').concat('SpEL')}")
    private String methodInvocation;

    @Value("#{1 > 0}")
    private Boolean comparisonResult;

    @Value("#{T(String)}")
    private Class<String> stringType;
}
