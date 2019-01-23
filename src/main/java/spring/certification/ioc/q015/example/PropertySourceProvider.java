package spring.certification.ioc.q015.example;

import java.util.HashMap;
import java.util.Map;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.StandardEnvironment;

/**
 * {@link EnvironmentAware} class which will register a new custom source of properties once
 * notified about {@link Environment} it runs within.
 */
public class PropertySourceProvider implements EnvironmentAware {

    @Override
    public void setEnvironment(Environment environment) {
        // Compose a source of key/value pairs
        Map<String, Object> seasonEmotions = new HashMap<>();
        seasonEmotions.put("summer", "joy");
        seasonEmotions.put("autumn", "sadness");
        seasonEmotions.put("winter", "surprise");
        seasonEmotions.put("spring", "love");

        // Create instance property source instance
        MapPropertySource emotionsSource = new MapPropertySource("seasonEmotions", seasonEmotions);

        // Put new property source in existing environment
        ((StandardEnvironment) environment).getPropertySources().addLast(emotionsSource);
    }
}
