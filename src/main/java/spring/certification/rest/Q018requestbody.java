package spring.certification.rest;

import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 019:<br>
 * Where do you need @ResponseBody?<br>
 * What about @RequestBody?<br>
 * <p>
 * Answer:<br>
 * Both {@link RequestBody} and {@link ResponseBody} annotations rely on functionality of
 * {@link HttpMessageConverter message converters} to convert raw data into java type or vice versa:<br>
 * - {@link RequestBody} might be applied to a handler method argument type, thus allowing for a
 * message-converter to convert raw request data to a java-type.<br>
 * - {@link ResponseBody} might be applied to a handler method return type, thus allowing for a
 * message-converter to convert java-type into raw data of required media-type (JSON, XML, etc.).<br>
 *
 * @author Valentine Shemyako
 * @since January 19, 2019
 */
public class Q018requestbody {
}
