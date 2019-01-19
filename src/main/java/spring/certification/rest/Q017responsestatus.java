package spring.certification.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 017:<br>
 * When do you need @ResponseStatus?<br>
 * <p>
 * Answer:<br>
 * {@link ResponseStatus} annotation is useful when additional http-status info is needed to be attached
 * to the response object which client receives. The problem with simplistic approach, when entity
 * is directly converted by one of the message-converters, is that http-status code is always <b>200</b>.<br>
 * As an alternative to the {@link ResponseStatus} annotation {@link ResponseEntity} or {@link ExceptionHandler}
 * might be used.<br>
 *
 * @author Valentine Shemyako
 * @since January 19, 2019
 */
public class Q017responsestatus {
}
