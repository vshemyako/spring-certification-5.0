package spring.certification.ioc.q038.example;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

@Component
public class Collaborator implements BeanNameAware {

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
