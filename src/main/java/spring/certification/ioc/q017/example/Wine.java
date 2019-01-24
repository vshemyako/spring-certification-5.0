package spring.certification.ioc.q017.example;

/**
 * Alcoholic drink made of fermented grapes.
 */
public class Wine implements Alcohol {

    @Override
    public String getName() {
        return "wine";
    }
}