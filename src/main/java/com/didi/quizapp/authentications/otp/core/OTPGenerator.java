package com.didi.quizapp.authentications.otp.core;

import java.util.Random;
import java.util.logging.Logger;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class OTPGenerator {

    private static final String CHARSET_NUMERIC = "0123456789";
    private static final String CHARSET_ALPHA = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final int ALPHA_CODE_MIN_LENGTH = 6;
    private static final int NUMERIC_CODE_MIN_LENGTH = 4;
    private static final int ALPHANUMERIC_CODE_MIN_LENGTH = 8;
    private static final Logger LOGGER = Logger.getLogger(OTPGenerator.class.getName());

    public int ALPHA_CODE_MIN_LENGTH() {
        return ALPHA_CODE_MIN_LENGTH;
    }

    public int NUMERIC_CODE_MIN_LENGTH() {
        return NUMERIC_CODE_MIN_LENGTH;
    }

    public int ALPHANUMERIC_CODE_MIN_LENGTH() {
        return ALPHANUMERIC_CODE_MIN_LENGTH;
    }

    /**
     * Generates a random alphabetic code with a specified length.
     * The minimum valid length is {@link #ALPHA_CODE_MIN_LENGTH} characters.
     * If a length less than the minimum is provided, a warning message is logged
     * and null is returned.
     *
     * @param length The desired length of the alphabetic code.
     * @return A random alphabetic string, or null if length is invalid.
     */
    public String generateAlphaCode(int length) {
        if (length < ALPHA_CODE_MIN_LENGTH) {
            LOGGER.warning(String.format("Alpha code length should be %d characters or greater.", ALPHA_CODE_MIN_LENGTH));
            return null;
        }
        
        return this.generateRandomString(length, CHARSET_ALPHA);
    }

    /**
     * Generates a random numeric code (One-Time Password) with a specified length.
     * The minimum valid length is {@link #NUMERIC_CODE_MIN_LENGTH} characters.
     * If a length less than the minimum is provided, a warning message is logged
     * and null is returned.
     *
     * @param length The desired length of the numeric code (OTP).
     * @return A random numeric string representing the OTP, or null if length is invalid.
     */
    public String generateNumericCode(int length) {
        if (length < NUMERIC_CODE_MIN_LENGTH) {
            LOGGER.warning(String.format("Numeric code length should be %d characters or greater.", NUMERIC_CODE_MIN_LENGTH));
            return null;
        }

        Random random = new Random();
        StringBuilder code = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            code.append(CHARSET_NUMERIC.charAt(random.nextInt(CHARSET_NUMERIC.length())));
        }

        return code.toString();
    }

    /**
     * Generates a random alphanumeric code with a specified length.
     * The minimum valid length is {@link #ALPHANUMERIC_CODE_MIN_LENGTH} characters.
     * If a length less than the minimum is provided, a warning message is logged
     * and null is returned. The generated code is guaranteed to be alphanumeric
     * (not all numeric or all alphabetic).
     *
     * @param length The desired length of the alphanumeric code.
     * @return A random alphanumeric string, or null if length is invalid.
     */
    public String generateAlphanumericCode(int length) {
        if (length < ALPHANUMERIC_CODE_MIN_LENGTH) {
            LOGGER.warning(String.format("Alphanumeric code length should be %d characters or greater.", ALPHANUMERIC_CODE_MIN_LENGTH));
            return null;
        }

        String code;
        do {
            code = generateRandomString(length, CHARSET_ALPHA + CHARSET_NUMERIC);
        } while (isAllNumeric(code) || isAllAlpha(code));

        return code;
    }

    /**
     * Generates a full token string by combining a prefix, alphanumeric code
     * (generated using generateAlphanumericCode), delimiter, and suffix.
     *
     * @param prefix The prefix to be prepended to the code.
     * @param suffix The suffix to be appended to the code.
     * @param delimiter The delimiter used to separate prefix, code, and suffix.
     * @param codeLength The desired length of the alphanumeric code within the token.
     * @return A complete token string in the format prefix-code-suffix.
     */
    public String generateFullToken(String prefix, String suffix, String delimiter, int codeLength) {
        String code = generateAlphanumericCode(codeLength);
        StringBuilder sb = new StringBuilder();
        sb.append(prefix).append(delimiter).append(code).append(delimiter).append(suffix);
        return sb.toString();
    }

    /**
     * Generates a link for OTP verification based on a base URL, action, token, and recipient.
     * The specific logic for constructing the link depends on the notification service
     * and API design. This method now includes a recipient parameter as a query parameter.
     *
     * @param baseUrl The base URL of the verification service.
     * @param action The specific action associated with the OTP verification (e.g., verify, resend).
     * @param token The unique token used for verification.
     * @param recipient The recipient for whom the OTP is generated.
     * @return A URL for OTP verification with recipient included.
     */
    public String generateOtpLink(String baseUrl, String action, String token, String recipient) {
        StringBuilder urlBuilder = new StringBuilder(baseUrl);
        urlBuilder.append("/otp/verify?");
        urlBuilder.append("action=").append(action).append("&");
        urlBuilder.append("token=").append(token).append("&");
        urlBuilder.append("recipient=").append(recipient);
        return urlBuilder.toString();
    }

    /**
     * Generates a random string of a specified length using the provided character set.
     * This method throws an IndexOutOfBoundsException if the character set length
     * is less than the requested string length.
     *
     * @param length The desired length of the random string.
     * @param charset The character set to use for generating the random string.
     * @return A random string of the specified length.
     * @throws IndexOutOfBoundsException if the charset length is less than the requested string length.
     */
    private String generateRandomString(int length, String charset) throws IndexOutOfBoundsException {
        try {
            Random random = new Random();
            StringBuilder code = new StringBuilder(length);
            for (int i = 0; i < length; i++) {
                code.append(charset.charAt(random.nextInt(charset.length())));
            }
            return code.toString();
        } catch (IndexOutOfBoundsException e) {
            LOGGER.severe(String.format("Error generating random string: %s", e ));
            throw e;
        }
    }

    /**
     * Checks if the provided string consists only of numeric characters (0-9).
     * This method uses a regular expression for efficient matching.
     *
     * @param str The string to check for numeric characters only.
     * @return true if the string contains only numeric characters, false otherwise.
     */
    private boolean isAllNumeric(String str) {
        return str.matches("[0-9]+");
    }

    /**
     * Checks if the provided string consists only of alpha characters (a-z and A-Z).
     * This method uses a regular expression for efficient matching.
     *
     * @param str The string to check for alpha characters only.
     * @return true if the string contains only alpha characters, false otherwise.
     */
    private boolean isAllAlpha(String str) {
        return str.matches("[a-zA-Z]+");
    }
}
