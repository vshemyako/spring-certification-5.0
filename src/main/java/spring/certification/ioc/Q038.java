package spring.certification.ioc;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.expression.spel.standard.SpelExpression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 038:<br>
 * What can you reference using SpEL?<br>
 * <p>
 * Answer:<br>
 * SpEL is very powerful language, functionality of which grows as Spring framework grows. The following things
 * can be referenced ATM:<br>
 * - literal expressions<br>
 * - bean properties<br>
 * - inline lists<br>
 * - inline maps<br>
 * - inline arrays<br>
 * - methods<br>
 * - operators (relational, logical, mathematical, assignment)<br>
 * - types<br>
 * - constructors (actually methods special case)<br>
 * - variables<br>
 * - user defined functions<br>
 * - ternary operators<br>
 * - elvis operators (ternary operator special case)<br>
 * - safe navigation possibility<br>
 * - collections transformation<br>
 * - expression templating<br>
 * <p>
 * Examples of mentioned terms:<br>
 * {@link Q038.ExpressionLanguageFeatures} - demonstrates different types of references.
 *
 * @author Valentine Shemyako
 * @since December 01, 2018
 */
public class Q038 {

    /**
     * Component scan marker class to reference to more type safely.
     */
    @ComponentScan
    public static class ComponentScanMarker {
    }

    /**
     * Demonstrates functionality offered by SpEL. Underneath SpEL is parsed and evaluated by
     * {@link SpelExpressionParser} and {@link SpelExpression} respectively.
     */
    @Component
    public static class ExpressionLanguageFeatures {

        @Value("#{911}")
        private int literalExpression;

        /**
         * Though SpEL reference documentation states that another bean properties
         * should be referenced with '@' symbol plain name reference also works.
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

        // Getters to verify SpEL functionality in unit tests.

        public int getLiteralExpression() {
            return literalExpression;
        }

        public String getCollaboratorBeanProperty() {
            return collaboratorBeanProperty;
        }

        public List<Boolean> getInlineList() {
            return inlineList;
        }

        public Map<String, Integer> getInlineMap() {
            return inlineMap;
        }

        public Character[] getInlineArray() {
            return inlineArray;
        }

        public String getMethodInvocation() {
            return methodInvocation;
        }

        public Boolean getComparisonResult() {
            return comparisonResult;
        }

        public Class<String> getStringType() {
            return stringType;
        }
    }

    /**
     * Have to specify name explicitly to avoid naming overhead with inner classes.
     */
    @Component("collaborator")
    public static class ReferencedBean implements BeanNameAware {

        private String name;

        /**
         * SpEL is limited to access non-private properties. Therefore getter is written.
         */
        public String getName() {
            return name;
        }

        @Override
        public void setBeanName(String name) {
            this.name = name;
        }
    }
}
