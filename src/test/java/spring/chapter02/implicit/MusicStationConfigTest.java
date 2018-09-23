package spring.chapter02.implicit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * Tests implicit bean discovery functionality offered by Spring
 */
public class MusicStationConfigTest {

    /**
     * Fields to redefine system streams
     */
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream predefinedOutputStream = System.out;

    /**
     * Substitutes predefined {@link OutputStream} of a {@link System} class
     */
    @Before
    public void setUpStream() {
        System.setOut(new PrintStream(outputStream));
    }

    /**
     * Restores default streams
     */
    @After
    public void restoreStreams() {
        System.setOut(predefinedOutputStream);
    }

    /**
     * Verifies that implicit bean discovery indeed is performed after required
     * configuration steps are done (more specifically {@link org.springframework.context.annotation.ComponentScan}
     * annotation is defined)
     */
    @Test
    public void shouldCreateCompactDiscBean() {
        ApplicationContext context = new AnnotationConfigApplicationContext(MusicStationConfig.class);
        CompactDisc compactDisc = context.getBean(CompactDisc.class);

        Assert.assertNotNull(compactDisc);
    }

    /**
     * Verifies that Spring container creates {@link MediaPlayer} bean satisfying
     * all dependencies on another beans
     */
    @Test
    public void mediaPlayerShouldPlay() {
        ApplicationContext context = new AnnotationConfigApplicationContext(MusicStationConfig.class);
        MediaPlayer mediaPlayer = context.getBean(MediaPlayer.class);
        mediaPlayer.play();

        Assert.assertEquals("Linkin Park - Hybrid Theory" + System.lineSeparator(), outputStream.toString());
    }
}
