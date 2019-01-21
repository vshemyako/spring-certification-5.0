package spring.certification.rest;

import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ViewResolver;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 014:<br>
 * When do you need @ResponseBody?<br>
 * <p>
 * Answer:<br>
 * {@link ResponseBody} annotation is a step further from a classic MVC approach to a REST approach
 * when {@link ViewResolver} is not needed and request-handler result might be directly written
 * to the http-response body. {@link ResponseBody} annotation does exactly that, enabling functionality
 * offered by {@link HttpMessageConverter message-converters.}<br>
 * Note: {@link ResponseBody} annotation might be applied at a type level, thus all handler methods declared
 * within that type will inherit declared behavior.<br>
 *
 * @author Valentine Shemyako
 * @since January 19, 2019
 */
public class Q014responsebody {
}
