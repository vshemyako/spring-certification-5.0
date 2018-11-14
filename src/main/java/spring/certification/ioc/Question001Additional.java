package spring.certification.ioc;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Additional information related to <b>Inversion of Control</b> design principle.
 * <p>
 * There's also another flavour of Inversion of Control design pattern which is called <b>Dependency Lookup</b>.
 * This kind of IoC implementation implies that dependent object retrieves required components (collaborators) from
 * the IoC container which manages those components by itself. Though this kind of design pattern is easier to
 * implement, it clutters up application with wiring code.
 * <p>
 * Examples of mentioned terms:
 * {@link Question001Additional.DependencyLookUp} - simplistic example of <b>Dependency Lookup</b> design pattern.
 *
 * @author Valentine Shemyako
 * @since November 14, 2018
 */
public class Question001Additional {

    /**
     * Example of an object looking up for it dependencies by itself.
     */
    public static class DependencyLookUp {

        /**
         * Required dependency.
         */
        private String secretOfLife;

        /**
         * Main logic related to Dependency Lookup pattern is displayed by this constructor:
         * object being created looks for required dependency by itself.
         */
        public DependencyLookUp() {
            InversionOfControlContainer container = InversionOfControlContainer.getContainer();
            this.secretOfLife = container.lookUpDependency("lifeSecret", String.class);
        }
    }

    /**
     * Simplistic interface to communicate with IoC container
     */
    public interface InversionOfControlContainer {

        /**
         * Looks up for dependency in the IoC container uniquely identified by {@code dependencyName}.
         *
         * @param dependencyName - unique name of an object, managed by IoC container.
         * @param dependencyType - expected type of an object, managed by IoC container.
         * @param <T>            - reference type of an object, which is expected to be found.
         * @return managed object or {@code null} if such doesn't exist.
         */
        <T> T lookUpDependency(String dependencyName, Class<T> dependencyType);

        /**
         * Exposed getter method to acquire unique instance of IoC container.
         *
         * @return InversionOfControlContainer instance.
         */
        static InversionOfControlContainer getContainer() {
            // Implementation details omitted for brevity.
            return null;
        }
    }
}
