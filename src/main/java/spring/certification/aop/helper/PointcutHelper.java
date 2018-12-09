package spring.certification.aop.helper;

import org.springframework.stereotype.Component;

/**
 * Helper class to tests workings of pointcut designators.
 *
 * @author Valentine Shemyako
 * @since December 09, 2018
 */
@Component
public class PointcutHelper {

    /**
     * Prints ignore message.
     */
    public void ignore() {
        System.out.println("Ignore");
    }

    /**
     * Prints specified message.
     *
     * @param message to print.
     */
    public void printOut(String message) {
        System.out.println(message);
    }
}
