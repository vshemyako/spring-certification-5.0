package spring.certification.test.q005;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import spring.certification.test.q005.example.Blood;
import spring.certification.test.q005.example.Vein;

/**
 * Demonstrates how to use mocking framework in order to substitute real collaborating objects.
 *
 * @author Valentine Shemyako
 * @since January 02, 2019
 */
@RunWith(MockitoJUnitRunner.class)
public class MockingSupportTest {

    private Blood blood;

    @Before
    public void setUp() {
        this.blood = mock(Blood.class);
        when(this.blood.getOxygenRatio()).thenReturn(80);
        when(this.blood.getCarbonDioxideRatio()).thenReturn(20);
    }

    @Test
    public void shouldUtilizeProvidedValues() {
        assertEquals(80, blood.getOxygenRatio());
        assertEquals(20, blood.getCarbonDioxideRatio());
    }

    /**
     * Verifies possibility to substitute collaborating object.
     */
    @Test
    public void shouldSubstituteCollaborator() {
        Vein vein = new Vein(this.blood);
        boolean freshBlood = vein.isFreshBlood();

        assertTrue(freshBlood);
        // Verification of inner method invocations.
        verify(this.blood).getOxygenRatio();
        verify(this.blood).getCarbonDioxideRatio();
    }
}