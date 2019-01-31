package spring.certification.ioc.advanced.ambiguity;

import org.springframework.stereotype.Component;

@Component
public class AutowireCandidate {

    public String isAutowired() {
        return "Indeed autowired";
    }
}
