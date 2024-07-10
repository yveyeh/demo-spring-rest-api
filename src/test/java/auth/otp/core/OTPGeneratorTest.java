package auth.otp.core;

import com.didi.quizapp.authentications.otp.core.OTPGenerator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class OTPGeneratorTest {

    private final OTPGenerator generator = new OTPGenerator();

    @Test
    public void testGenerateAlphaCode_ValidLength_ReturnsAlphabeticString() {
        int length = 10;
        String code = generator.generateAlphaCode(length);
        assertNotNull(code, "Generated code should not be null");
        assertTrue(code.length() == length, "Generated code length should match requested length");
        assertTrue(code.matches("[a-zA-Z]+"), "Generated code should only contain alphabetic characters");
    }

    @Test
    public void testGenerateAlphaCode_InvalidLength_ReturnsNullAndLogsWarning() {
        int length = 3;  // Less than minimum allowed length
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String code = generator.generateAlphaCode(length);
        assertNull(code, "Generated code should be null for invalid length");
        String warningMessage = String.format("Alpha code length should be %d characters or greater.", generator.ALPHA_CODE_MIN_LENGTH());
        assertTrue(outContent.toString().contains(warningMessage), "Warning message should be logged for invalid length");
        System.setOut(System.out); // Restore standard output
    }

    @Test
    public void testGenerateNumericCode_ValidLength_ReturnsNumericString() {
        int length = 6;
        String code = generator.generateNumericCode(length);
        assertNotNull(code, "Generated code should not be null");
        assertTrue(code.length() == length, "Generated code length should match requested length");
        assertTrue(code.matches("[0-9]+"), "Generated code should only contain numeric characters");
    }

    @Test
    public void testGenerateNumericCode_InvalidLength_ReturnsNullAndLogsWarning() {
        int length = 2;  // Less than minimum allowed length
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String code = generator.generateNumericCode(length);
        assertNull(code, "Generated code should be null for invalid length");
        String warningMessage = String.format("Numeric code length should be %d characters or greater.", generator.NUMERIC_CODE_MIN_LENGTH());
        assertTrue(outContent.toString().contains(warningMessage), "Warning message should be logged for invalid length");
        System.setOut(System.out); // Restore standard output
    }

    @Test
    public void testGenerateAlphanumericCode_ValidLength_ReturnsAlphanumericString() {
        int length = 12;
        String code = generator.generateAlphanumericCode(length);
        assertNotNull(code, "Generated code should not be null");
        assertTrue(code.length() == length, "Generated code length should match requested length");
        assertTrue(code.matches("[a-zA-Z0-9]+"), "Generated code should contain alphanumeric characters");
        // Not guaranteed to be both numeric and alphabetic, but highly likely for longer lengths
    }

    @Test
    public void testGenerateAlphanumericCode_InvalidLength_ReturnsNullAndLogsWarning() {
        int length = 5;  // Less than minimum allowed length
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String code = generator.generateAlphanumericCode(length);
        assertNull(code, "Generated code should be null for invalid length");
        String warningMessage = String.format("Alphanumeric code length should be %d characters or greater.", generator.ALPHANUMERIC_CODE_MIN_LENGTH());
        assertTrue(outContent.toString().contains(warningMessage), "Warning message should be logged for invalid length");
        System.setOut(System.out); // Restore standard output
    }

    // @Test
    // public void testGenerateAlphanumericCode_EnsuresNotAllNumericOrAlpha() {
    //     int iterations = 100;  // Repeat test multiple times for higher chance of all-numeric/alpha cases
    //     for (int i = 0; i < iterations; i++) {
    //         String code = generator.generateAlphanumericCode(10);
    //         assertFalse(isAllNumeric(code) || isAllAlpha(code), "Generated code should not be all-numeric or all-alpha");
    //     }
    // }

}   
