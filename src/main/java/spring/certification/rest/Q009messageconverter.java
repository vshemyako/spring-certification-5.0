package spring.certification.rest;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageConverter;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 009:<br>
 * What is an HttpMessageConverter?<br>
 * <p>
 * Answer:<br>
 * {@link HttpMessageConverter} is an object for converting {@link HttpInputMessage} to an object of required type, and for converting
 * arbitrary object to required {@link HttpOutputMessage} type. Message-converters are heavily used by Spring REST framework to
 * process web-requests and implicitly convert their request-body to an object of specified method argument type, and to implicitly convert
 * web-controllers' return types to response-body which is of accepted client media-type formats.<br>
 *
 * @author Valentine Shemyako
 * @since January 18, 2019
 */
public class Q009messageconverter {
}
