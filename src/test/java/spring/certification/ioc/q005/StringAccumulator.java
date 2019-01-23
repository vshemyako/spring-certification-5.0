package spring.certification.ioc.q005;

import java.util.ArrayList;
import java.util.List;

public class StringAccumulator {
    static final List<String> lifeCycleSteps = new ArrayList<>();

    static void accumulate(String words) {
        lifeCycleSteps.add(words);
    }
}
