package spring.certification.aop.helper;

import org.springframework.stereotype.Component;

/**
 * Helper class which helps us to demonstrate functionality
 * of pointcut expression which matches getters and setters.
 *
 * @author Valentine Shemyako
 * @since December 09, 2018
 */
@Component
public class Pojo {

    private long count;

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
