package spring.certification.test.q007.example;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * An example of how Spring Boot makes web-layer testing easier.
 * Pay attention that {@link MockMvc} object has been implicitly configured.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = BasicController.class, secure = false)
public class BasicControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void shouldRespond() throws Exception {
        mvc.perform(get("/respond"))
                .andExpect(status().isOk())
                .andExpect(content().string("Dark. Darker. Darko."));
    }
}