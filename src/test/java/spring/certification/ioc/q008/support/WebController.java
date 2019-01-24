package spring.certification.ioc.q008.support;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Simplistic class to demonstrate configuration of web-application context in integration test.
 */
@RestController
@RequestMapping(value = "/test")
public class WebController {

    @GetMapping(value = "/smile")
    public String smile() {
        return "Smile";
    }
}
