package spring.certification.test.q007.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

    @GetMapping(value = "/respond")
    public String respond() {
        return "Dark. Darker. Darko.";
    }
}
