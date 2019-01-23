package spring.certification.ioc.q008;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import spring.certification.ioc.q006.example.standalone.JavaBasedConfiguration;
import spring.certification.ioc.q006.example.standalone.MessageProvider;
import spring.certification.ioc.q008.support.WebController;

/**
 * Demonstrates different possibilities for creation of application contexts in integration tests.
 */
public class ApplicationContextConstructionTest {

    @RunWith(SpringRunner.class)
    @ContextConfiguration(classes = JavaBasedConfiguration.class)
    public static class JavaBased {

        @Autowired
        private ApplicationContext applicationContext;

        @Test
        public void shouldAutoConfigure() {
            assertThat(applicationContext).isNotNull();
            MessageProvider messageProvider = applicationContext.getBean(MessageProvider.class);
            assertThat(messageProvider).isNotNull();
        }
    }

    @RunWith(SpringRunner.class)
    @ContextConfiguration(locations = "classpath:/config-metadata.xml")
    public static class XmlBased {

        @Autowired
        private ApplicationContext applicationContext;

        @Test
        public void shouldAutoConfigure() {
            assertThat(applicationContext).isNotNull();
            MessageProvider messageProvider = applicationContext.getBean(MessageProvider.class);
            assertThat(messageProvider).isNotNull();
        }
    }

    @RunWith(SpringRunner.class)
    @ContextConfiguration(classes = WebController.class)
    @WebAppConfiguration
    public static class WebBased {

        @Autowired
        private WebApplicationContext webApplicationContext;
        private MockMvc mockMvc;

        @Before
        public void setUp() {
            mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        }

        @Test
        public void shouldProcessWebRequest() throws Exception {
            mockMvc.perform(get("/test/smile"))
                    .andExpect(content().string("Smile"));
        }
    }
}