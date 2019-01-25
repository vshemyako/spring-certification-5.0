package spring.certification.ioc.advanced.q041.example;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * A colorless flammable liquid.
 */
@Scope(scopeName = "prototype")
@Component
public class Alcohol {
}
