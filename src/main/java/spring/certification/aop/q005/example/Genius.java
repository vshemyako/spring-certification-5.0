package spring.certification.aop.q005.example;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * A smart person.
 */
@Aspect
@Component
public class Genius {

    /**
     * Gives a cue about asked question before someone answered.
     */
    @Before(value = "@annotation(spring.certification.aop.q005.example.annotation.GiveMeBeforeCue) && args(country)")
    public void giveBeforeCue(String country) {
        String capital;
        switch (country) {
            case "Germany":
                capital = "Berlin";
                break;
            case "Italy":
                capital = "Rome";
                break;
            default:
                capital = "New York";
                break;
        }
        System.out.println(capital);
    }

    /**
     * Gives a cue about asked question after some answered.
     */
    @AfterReturning(value = "@annotation(spring.certification.aop.q005.example.annotation.GiveMeAfterCue) && args(country)")
    public void giveAfterCue(String country) {
        String queen;
        switch (country) {
            case "England":
                queen = "Elizabeth";
                break;
            default:
                queen = "Margrethe";
                break;
        }
        System.out.println(queen);
    }

    /**
     * Gives a cue after someone panics =).
     */
    @AfterThrowing(value = "@annotation(spring.certification.aop.q005.example.annotation.GiveMeExceptionalCue) && args(country)")
    public void giveExceptionalCue(String country) {
        String continent;
        switch (country) {
            case "China":
                continent = "Asia";
                break;
            default:
                continent = "Africa";
                break;
        }
        System.out.println(continent);
    }

    /**
     * Gives a cue regardless of exceptional or normal flow.
     */
    @After(value = "@annotation(spring.certification.aop.q005.example.annotation.GiveMeAfterAnyCue) && args(country)")
    public void giveAnyCue(String country) {
        String currency;
        switch (country) {
            case "Russia":
                currency = "Russian ruble";
                break;
            default:
                currency = "The euro";
                break;
        }
        System.out.println(currency);
    }

    @Around(value = "@annotation(spring.certification.aop.q005.example.annotation.GiveMeAroundCue) && args(country)")
    public void giveAroundCue(ProceedingJoinPoint joinPoint, String country) {
        String neighbor;
        switch (country) {
            case "Belarus":
                neighbor = "Poland";
                break;
            default:
                // Don't judge me =).
                neighbor = "Vatican";
                break;
        }
        System.out.println(neighbor);

        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            System.out.println(throwable.getMessage());
            System.out.println("Ukraine");
        }
    }
}
