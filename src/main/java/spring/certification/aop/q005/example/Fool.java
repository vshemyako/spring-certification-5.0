package spring.certification.aop.q005.example;

import org.springframework.stereotype.Component;
import spring.certification.aop.q005.example.annotation.GiveMeAfterAnyCue;
import spring.certification.aop.q005.example.annotation.GiveMeAfterCue;
import spring.certification.aop.q005.example.annotation.GiveMeAroundCue;
import spring.certification.aop.q005.example.annotation.GiveMeBeforeCue;
import spring.certification.aop.q005.example.annotation.GiveMeExceptionalCue;

/**
 * A dumb person =).
 */
@Component
public class Fool {

    /**
     * A fool person is asked to name capital of a specified country.
     */
    @GiveMeBeforeCue
    public void nameCapital(String country) {
        System.out.println(String.format("Capital of %s unknown", country));
    }

    /**
     * A fool person is asked to name queen of a specified country.
     */
    @GiveMeAfterCue
    public void nameQueen(String country) {
        System.out.println(String.format("Queen of %s unknown", country));
    }

    /**
     * A fool person panics when he is asked about continents =).
     */
    @GiveMeExceptionalCue
    public void nameContinent(String country) {
        throw new PanicException(String.format("Continent of %s unknown", country));
    }

    /**
     * A fool person known something about currency. But sometimes also panics.
     */
    @GiveMeAfterAnyCue
    public void nameCurrency(String country) {
        if ("Russia".equals(country)) {
            throw new PanicException();
        }
        System.out.println("No money no honey");
    }

    /**
     * A fool person doesn't know anything about neighboring countries. Just panics.
     */
    @GiveMeAroundCue
    public void nameNeighboring(String country) {
        throw new PanicException("No idea");
    }
}
