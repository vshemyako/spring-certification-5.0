package spring.certification.rest;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 022:<br>
 * What are the advantages of the RestTemplate?<br>
 * <p>
 * Answer:<br>
 * - Possibility to specify a different HTTP library which will be used by {@link RestTemplate}.<br>
 * - High level API with lots of convenient methods: {@link RestTemplate#getForObject}, {@link RestTemplate#postForLocation}, etc.<br>
 * - Support of URI templates and URI template variables (specified within curly braces, e.g. /{name}).<br>
 * - URIs are automatically encoded (e.g. /hotel list will be encoded to /hotel%20list).<br>
 * - Automatic conversion of raw content to Java types using {@link HttpMessageConverter message converters}.<br>
 * - Automatic classpath scan and registration of available {@link HttpMessageConverter message covnerters}.<br>
 * - No need to explicitly specify <b>Content-Type</b> and <b>Accept</b> headers, they are populated automatically by {@link HttpMessageConverter}.<br>
 * - Support of {@link JsonView}.<br>
 * - Convenient methods to build multipart requests using {@link MultipartBodyBuilder}.<br>
 *
 * @author Valentine Shemyako
 * @since January 21, 2019
 */
public class Q022advantages {
}
