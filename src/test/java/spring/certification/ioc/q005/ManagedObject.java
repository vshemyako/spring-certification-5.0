package spring.certification.ioc.q005;

import static org.assertj.core.api.Assertions.assertThat;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ManagedObject implements ApplicationContextAware {

    @Value("${motto}")
    private String motto;

    public ManagedObject() {
        assertThat(motto).isNull();
        StringAccumulator.accumulate("Created");
    }

    @PostConstruct
    private void postConstruct() {
        StringAccumulator.accumulate("Post-constructed");
    }

    public void live() {
        StringAccumulator.accumulate(motto);
    }

    @PreDestroy
    private void preDestroy() {
        StringAccumulator.accumulate("Destroyed");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        assertThat(motto).isNotNull();
        StringAccumulator.accumulate("Injected");
        StringAccumulator.accumulate("Notified");
    }
}
