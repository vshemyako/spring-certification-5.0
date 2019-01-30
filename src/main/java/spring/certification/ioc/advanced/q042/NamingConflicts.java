package spring.certification.ioc.advanced.q042;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import({FirstConfigurationClass.class, SecondConfigurationClass.class})
@Configuration
public class NamingConflicts {
}
