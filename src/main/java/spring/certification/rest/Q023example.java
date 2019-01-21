package spring.certification.rest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import lombok.Getter;
import lombok.Setter;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 023:<br>
 * If you saw an example using RestTemplate would you understand what it is doing?<br>
 * <p>
 * Answer:<br>
 * {@link RestTemplate} usage example is provided below.<br>
 *
 * @author Valentine Shemyako
 * @since January 21, 2019
 */
public class Q023example {

    /**
     * Demonstrates basic usage of {@link RestTemplate} web-client.
     * {@link Test} annotations are used for convenient execution of specific methods.
     */
    public static class RestTemplateExample {

        /**
         * API which returns random quote from Spring Boot reference documentation.
         */
        private static final String API_QUOTES = "https://gturnquist-quoters.cfapps.io/api/random";


        /**
         * Demonstrates how to perform basic GET request which returns raw data.
         */
        @Test
        public void getRawData() {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> responseEntity = restTemplate.getForEntity(API_QUOTES, String.class);
            assertNotNull(responseEntity.getBody());
            assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
        }

        /**
         * Demonstrates how to perform basic GET request which is mapped to predefined java type.
         */
        @Test
        public void getMappedJavaType() {
            RestTemplate restTemplate = new RestTemplate();
            ValueWrapper valueWrapper = restTemplate.getForObject(API_QUOTES, ValueWrapper.class);
            assertNotNull(valueWrapper);
            assertNotNull(valueWrapper.getValue());
        }
    }

    @Getter
    @Setter
    public static class ValueWrapper {
        private String type;
        private Value value;
    }

    @Getter
    @Setter
    public static class Value {
        private long id;
        private String quote;
    }
}
