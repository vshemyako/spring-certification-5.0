package spring.certification.ioc;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.certification.ioc.Q028.CompactDisc;
import spring.certification.ioc.Q028.MusicCenter;
import spring.certification.ioc.Q028.Walkman;

import java.util.Objects;

/**
 * Verifies that internal bean factory method calls are intercepted by Spring IoC container thus respecting bean scopes.
 * This functionality is discussed in details in question {@link Q028}.
 */
public class Q028Test {

    /**
     * Verifies that {@link MusicCenter} bean and {@link Walkman} bean are referencing the same {@link CompactDisc}
     * bean.
     */
    @Test
    public void shouldRespectBeanScope() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(Q028.BeanScopingSupportiveConfig.class);
        context.refresh();

        MusicCenter musicCenter = context.getBean(MusicCenter.class);
        Walkman walkman = context.getBean(Walkman.class);
        boolean sameCompactDisc = Objects.equals(musicCenter.extractDisc(), walkman.extractDisc());

        Assert.assertTrue(sameCompactDisc);
    }
}