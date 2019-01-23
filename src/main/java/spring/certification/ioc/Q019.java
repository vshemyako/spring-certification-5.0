package spring.certification.ioc;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.context.annotation.Configuration;
import spring.certification.ioc.q018.BeanLifecycleCallbacks;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 019:<br>
 * Consider how you enable JSR-250 annotations like @PostConstruct and @PreDestroy? When/how will they get called?<br>
 * How else can you define an initialization or destruction method for a Spring bean?<br>
 * <p>
 * Answer:<br>
 * Scanning and processing of <b>JSR-250</b> {@link PostConstruct} and {@link PreDestroy} annotations is done by
 * {@link CommonAnnotationBeanPostProcessor} class which is registered automatically in case of annotation-based
 * context configuration. Therefore some manual registering and enabling isn't required.<br>
 * Those annotation are invoked at the same lifecycle phases as {@link Bean#initMethod()} and {@link Bean#destroyMethod()}
 * respectively (discussed in details in {@link BeanLifecycleCallbacks}).
 * <p>
 * Another possibility to define init and destroy methods is to implement {@link InitializingBean} and {@link DisposableBean}
 * interfaces. The logic behind implemented methods is the same.
 * <p>
 * Examples of mentioned terms:<br>
 * {@link Q019.CinemaConfiguration} - demonstrates basic usage of {@link PostConstruct} and {@link PreDestroy}
 * annotations.
 *
 * @author Valentine Shemyako
 * @since November 25, 2018
 */
public class Q019 {

    /**
     * Java-based config class to be processed by Spring IoC container.
     */
    @Configuration
    public static class CinemaConfiguration {

        @Bean
        public SloganMaker sloganMaker() {
            return new SloganMaker();
        }

        @Bean
        public Cinema cinema(@Value("The Shawshank Redemption") String filmName, SloganMaker sloganMaker) {
            return new Cinema(filmName, sloganMaker);
        }
    }

    /**
     * A movie theater.
     */
    public static class Cinema {

        private String filmName;
        private SloganMaker sloganMaker;
        private Signboard signboard;

        public Cinema(String filmName, SloganMaker sloganMaker) {
            this.filmName = filmName;
            this.sloganMaker = sloganMaker;
        }

        /**
         * Initialization callback which fills cinema's signboard.
         */
        @PostConstruct
        private void init() {
            String slogan = sloganMaker.composeSlogan(this.filmName);
            this.signboard = new Signboard(slogan);
        }

        /**
         * Destruction signboard which cleans up cinema's signboard.
         */
        @PreDestroy
        private void cleanUp() {
            this.signboard.clear();
        }

        public Signboard getSignboard() {
            return signboard;
        }
    }

    /**
     * A board which displays something.
     */
    public static class Signboard {
        private String title;

        public Signboard(String title) {
            this.title = title;
        }

        public void clear() {
            this.title = null;
        }

        public String getTitle() {
            return title;
        }
    }

    /**
     * A person who writes slogans.
     */
    public static class SloganMaker {

        /**
         * Composes slogan based on a film {@link SloganMaker} has watched.
         */
        public String composeSlogan(String filmTitle) {
            // Some magic happens here
            switch (filmTitle) {
                case "The Shawshank Redemption":
                    return "Fear can hold you prisoner. Hope can set you free.";
                case "El Maquinista":
                    return "How do you wake up from a nightmare if you're not asleep?";
                default:
                    return "There can be only one.";
            }
        }
    }
}
