package spring.certification.ioc.q022.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

/**
 * Framework which simplifies java development.
 */
public class SpringFramework {

    /**
     * Chief executive officer.
     */
    @Autowired
    private String ceo;

    /**
     * Leading developer.
     */
    @Value("Juergen Hoeller")
    private String dev;

    public String getCeo() {
        return ceo;
    }

    public String getDev() {
        return dev;
    }
}
