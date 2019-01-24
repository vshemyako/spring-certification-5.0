package spring.certification.ioc.q016.example;

/**
 * Celebration day.
 */
public class Holiday {

    /**
     * Name of a holiday.
     */
    private String name;

    /**
     * Instantiates {@link Holiday} objects, with required {@code name} parameter.
     */
    public Holiday(String name) {
        this.name = name;
    }

    /**
     * Allows to acquire {@code name} of the holiday.
     */
    public String getName() {
        return name;
    }
}
