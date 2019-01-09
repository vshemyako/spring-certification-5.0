package spring.certification.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import spring.certification.test.Q005mock.Blood;
import spring.certification.test.Q005mock.Vein;

/**
 * Demonstrates how to use mocking framework in order to substitute real collaborating objects.
 *
 * @author Valentine Shemyako
 * @since January 02, 2019
 */
@RunWith(MockitoJUnitRunner.class)
public class Q005mockTest {

    private Blood blood;

    @Before
    public void setUp() {
        this.blood = Mockito.mock(Blood.class);
        Mockito.when(this.blood.getOxygenRatio()).thenReturn(80);
        Mockito.when(this.blood.getCarbonDioxideRatio()).thenReturn(20);
    }

    @Test
    public void shouldUtilizeProvidedValues() {
        Assert.assertEquals(80, blood.getOxygenRatio());
        Assert.assertEquals(20, blood.getCarbonDioxideRatio());
    }

    /**
     * Verifies possibility to substitute collaborating object.
     */
    @Test
    public void shouldSubstituteCollaborator() {
        Vein vein = new Vein(this.blood);
        boolean freshBlood = vein.isFreshBlood();

        Assert.assertTrue(freshBlood);
        // Verification of inner method invocations.
        Mockito.verify(this.blood).getOxygenRatio();
        Mockito.verify(this.blood).getCarbonDioxideRatio();
    }
}