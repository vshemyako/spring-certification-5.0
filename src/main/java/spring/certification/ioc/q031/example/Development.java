package spring.certification.ioc.q031.example;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile(value = "development")
@Component
public class Development {
}
