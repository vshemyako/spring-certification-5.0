package spring.certification.ioc.q017.example;

import spring.certification.ioc.q017.BeanCustomization;

/**
 * Bitter alcoholic drink made from grain.
 */
public class Beer implements Alcohol {

    @Override
    public String getName() {
        return "bear";
    }
}