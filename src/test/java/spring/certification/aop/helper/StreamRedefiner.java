package spring.certification.aop.helper;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;

public class StreamRedefiner {

    /**
     * Fields to redefine system streams.
     */
    protected final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    protected final PrintStream predefinedOutputStream = System.out;

    /**
     * Substitutes system stream with 'dummy' byte array stream.
     */
    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    /**
     * Set previously changed system stream back.
     */
    @After
    public void tearDown() {
        System.setOut(predefinedOutputStream);
    }
}
