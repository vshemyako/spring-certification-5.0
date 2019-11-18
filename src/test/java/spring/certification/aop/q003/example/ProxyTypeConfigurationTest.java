package spring.certification.aop.q003.example;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.aop.support.AopUtils.isAopProxy;
import static org.springframework.aop.support.AopUtils.isCglibProxy;
import static org.springframework.aop.support.AopUtils.isJdkDynamicProxy;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.AopTestUtils;

/**
 * Verifies different types of dynamic proxies created by Spring AOP.<br>
 * <b>Big Note:</b> Spring framework offers some utility classes which help to test AOP logic. Those are:<br>
 * - {@link AopUtils}<br>
 * - {@link AopTestUtils}<br>
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ProxyTypeConfiguration.class)
public class ProxyTypeConfigurationTest {

    @Autowired
    private Photographer photographer;
    @Autowired
    private Celebrity singer;
    @Autowired
    private Guitarist guitarist;
    @Autowired
    private MusicFan musicFan;

    /**
     * Verifies that interface method invocation leads to creation of {@link org.springframework.aop.framework.JdkDynamicAopProxy}.
     * Method invocation is intercepted by {@link MakeUpArtist#applyMakeUp} which performs assert logic.
     */
    @Test
    public void shouldCreateJdkDynamicProxy() {
        photographer.takePhotoOf(singer);
    }

    /**
     * Verifies that concrete method invocation leads to creation of {@link org.springframework.aop.framework.CglibAopProxy}.
     * Method invocation is intercepted by {@link Drummer#giveASignal} which performs assert logic.
     */
    @Test
    public void shouldCreateCglibProxy() {
        musicFan.listenTo(guitarist);
    }

    /**
     * A person who works with make-ups.
     */
    @Aspect
    @Component
    public static class MakeUpArtist {

        @Before("execution(public void poseForPhoto())")
        public void applyMakeUp(JoinPoint joinPoint) {
            Object actualProxy = joinPoint.getThis();
            assertThat(isAopProxy(actualProxy)).isTrue();
            assertThat(isJdkDynamicProxy(actualProxy)).isTrue();
        }
    }

    /**
     * A person who play drums.
     */
    @Aspect
    @Component
    public static class Drummer {

        @Before("execution(public void playTheGuitar())")
        public void giveASignal(JoinPoint joinpoint) {
            Object actualProxy = joinpoint.getThis();
            assertThat(isAopProxy(actualProxy)).isTrue();
            assertThat(isCglibProxy(actualProxy)).isTrue();
        }
    }
}
