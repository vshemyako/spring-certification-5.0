package spring.certification.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Spring v5.0 Professional Certification.
 * <p>
 * Question 005:<br>
 * How are mock frameworks such as Mockito or EasyMock used?<br>
 * <p>
 * Answer:<br>
 * Mocking frameworks are usually used to isolate unit of code being tested. This isolation is achieved by replacing
 * real collaborators with <b>dummy</b> objects. Thus it's possible to verify whether an inner method call was made or
 * not, number of such calls, return predefined value from a collaborator's method, etc.<br>
 * Mocking frameworks successfully complement IoC pattern (utilized by Spring Framework) which supplies dependencies to
 * objects through setters or constructors, thus it's very easy to substitute those dependencies with mocks.<br>
 *
 * @author Valentine Shemyako
 * @since January 02, 2019
 */
public class Q005mock {

    /**
     * Tube for carrying blood.
     */
    @Component
    public static class Vein {

        /**
         * {@link Vein} class is dependent on {@link Blood} class.
         * With mocking framework we can easily substitute this instance to test
         * {@link Vein} class in isolation.
         */
        private Blood blood;

        @Autowired
        public Vein(Blood blood) {
            this.blood = blood;
        }

        public Blood getBlood() {
            return blood;
        }

        public void setBlood(Blood blood) {
            this.blood = blood;
        }

        public boolean isFreshBlood() {
            return this.blood.getOxygenRatio() > this.blood.getCarbonDioxideRatio();
        }
    }

    /**
     * Red liquid.
     */
    @Component
    public static class Blood {

        private int oxygenRatio;
        private int carbonDioxideRatio;

        public int getOxygenRatio() {
            return oxygenRatio;
        }

        public void setOxygenRatio(int oxygenRatio) {
            this.oxygenRatio = oxygenRatio;
        }

        public int getCarbonDioxideRatio() {
            return carbonDioxideRatio;
        }

        public void setCarbonDioxideRatio(int carbonDioxideRatio) {
            this.carbonDioxideRatio = carbonDioxideRatio;
        }
    }
}
