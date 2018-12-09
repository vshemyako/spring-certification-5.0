package spring.certification.aop.helper;

import org.springframework.stereotype.Component;

/**
 * Helper class to test workings of specified pointcut designators.
 *
 * @author Valentine Shemyako
 * @since December 09, 2018
 */
@Component
@WithinHelper
public class AnnotatedPointcutHelper {

    /**
     * Prints help message.
     */
    public void help() {
        System.out.println("Help");
    }
}
