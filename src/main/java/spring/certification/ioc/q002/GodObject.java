package spring.certification.ioc.q002;

/**
 * An example of a class which offers too much non-related functionality which should
 * be separate into several separate classes:<br>
 * 1. Methods functionality of which is related to reading and writing from a file
 * {@link #writeToFile(String, String)}, {@link #readFromFile(String)}<br>
 * 2. Method functionality of which is related to string manipulation:
 * {@link #capitalize(String)}, {@link #toLowerCase(String)}
 * <p>
 * Demonstrates bad programming practice in regard of software design.
 */
public class GodObject {

    /**
     * Writes provided textual data {@code payload} to already existing {@code destination} file.
     *
     * @param payload     textual data to write.
     * @param destination already existing file.
     */
    public void writeToFile(String payload, String destination) {
        // Implementation omitted for brevity.
    }

    /**
     * Reads content of a file defined by {@code source} parameter.
     *
     * @param source file to read textual data from.
     * @return file contents read from {@code source} file.
     */
    public String readFromFile(String source) {
        // Implementation omitted for brevity.
        return null;
    }

    /**
     * Capitalizes the first letter of a {@code original} string.
     *
     * @param original string first letter of which to capitalize.
     * @return capitalized string.
     */
    public String capitalize(String original) {
        // Implementation omitted for brevity.
        return null;
    }

    /**
     * Converts all of the characters of {@code original} string to lower case.
     *
     * @param original string characters of which will be converted to lower case.
     * @return converted string.
     */
    public String toLowerCase(String original) {
        // Implementation omitted for brevity.
        return null;
    }
}
