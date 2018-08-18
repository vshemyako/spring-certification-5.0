package spring.chapter01;

import java.util.Arrays;

/**
 * Offers functionality to print custom user-specified greeting message
 */
public class HelloWorldCommandLine {

    /**
     * Prints custom predefined message in case {@code args} were not passed
     * by a user.
     * In case length of a {@code args} parameter is greater than zero - prints
     * each argument on a new line.
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Hello World!");
        } else {
            Arrays.stream(args).forEach(System.out::println);
        }
    }
}
