package spring.certification.test.q002;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import spring.certification.test.q002.example.DevelopmentTeam;
import spring.certification.test.q002.example.JuniorDeveloper;
import spring.certification.test.q002.example.SeniorDeveloper;
import spring.certification.test.q002.example.SoftwareCompanyConfigurationMarker;

/**
 * Just a simple example of integration test support provided by Spring framework.
 * There's no another adequate possibility to test wiring of components without Spring framework.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SoftwareCompanyConfigurationMarker.class)
public class IntegrationTestSupportTest {

    @Autowired
    private DevelopmentTeam team;
    @Autowired
    private JuniorDeveloper junior;
    @Autowired
    private SeniorDeveloper senior;

    @Test
    public void shouldWireUpComponents() {
        assertThat(team.getDevelopers().size()).isEqualTo(2);
        assertThat(team.getDevelopers()).containsOnly(junior, senior);
    }
}