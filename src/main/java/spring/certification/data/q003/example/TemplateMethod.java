package spring.certification.data.q003.example;

/**
 * Demonstrates series of steps which can be altered but order of which cannot be changed.
 */
public class TemplateMethod {

    /**
     * Main design pattern method cannot be overridden - it defines skeleton of program flow.
     */
    public final void dailyRoutine() {
        wakeUp();
        work();
        sleep();
    }

    /**
     * A person wakes up.
     */
    public void wakeUp() {
    }

    /**
     * A person works. Method will throw an exception in case not overridden.
     */
    public void work() {
        throw new IllegalStateException("Working routine is not defined");
    }

    /**
     * A person has a rest.
     */
    public void sleep() {
    }
}
