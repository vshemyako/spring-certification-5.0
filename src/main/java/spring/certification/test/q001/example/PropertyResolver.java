package spring.certification.test.q001.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * Demonstrates a simple class which depends on {@link Environment} abstraction.
 */
@Component
public class PropertyResolver {

    private Environment environment;

    @Autowired
    public PropertyResolver(Environment environment) {
        this.environment = environment;
    }

    /**
     * @param name of a property to resolve.
     * @return resolved value of a property.
     */
    public String resolveProperty(String name) {
        return this.environment.getProperty(name);
    }
}
