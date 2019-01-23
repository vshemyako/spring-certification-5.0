package spring.certification.ioc.q003.example;

/**
 * A domestic animal.
 */
public class Pet {

    /**
     * An owner of a pet.
     */
    private Human owner;

    /**
     * It's easy (and possible) to write code which relies on abstract types. Actual implementation
     * can be developed later, substituted with mocks or stubs at the test phase. Moreover our own
     * implementation details know nothing about actual implementation details of our dependencies.
     *
     * @param owner any sort of human who will be the owner of a pet.
     */
    public Pet(Human owner) {
        this.owner = owner;
    }

    /**
     * Pet is fed by an abstract human, concrete implementation of which can be changed at runtime
     * (for example injected by DI container).
     */
    public void eat() {
        this.owner.feed();
    }
}
