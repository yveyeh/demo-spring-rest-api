package com.didi.quizapp.utilities;

import java.util.Random;
import java.util.logging.Logger;

import org.springframework.stereotype.Component;

@Component
public class OTPGenerator {
    private static final String CHARSET = "0123456789";
    private static final Logger LOGGER = Logger.getLogger(OTPGenerator.class.getName());

    public String generateOTP(int length) {
        if (length < 4) {
            LOGGER.warning("OTP length should be 4 or greater.");
            return null;
        }

        Random random = new Random();
        StringBuilder otp = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            otp.append(CHARSET.charAt(random.nextInt(CHARSET.length())));
        }

        return otp.toString();
    }

}
