package spring.certification.data.q018;

@FunctionalInterface
public interface Thrower {
    <T extends Throwable> void doThrow(String name, T exceptionToThrow) throws T;
}
