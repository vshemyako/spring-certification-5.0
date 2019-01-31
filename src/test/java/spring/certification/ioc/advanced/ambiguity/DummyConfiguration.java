package spring.certification.ioc.advanced.ambiguity;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan
@Configuration
public class DummyConfiguration implements InitializingBean {

    private AutowireCandidate candidate;

    @Autowired
    public DummyConfiguration(AutowireCandidate candidate) {
        this.candidate = candidate;
    }

    public String isAutowired() {
        return candidate.isAutowired();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (candidate == null) {
            throw new IllegalStateException("Required dependency wasn't resolved");
        }
    }
}
