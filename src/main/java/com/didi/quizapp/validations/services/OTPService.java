package com.didi.quizapp.validations.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.didi.quizapp.utilities.OTPGenerator;
import com.didi.quizapp.validations.OTP;
import com.didi.quizapp.validations.data.OtpDTO;

import java.time.LocalDateTime;
import java.util.Map;

@Service
public class OTPService {

    @Autowired
    private OtpDTO otpDTO;

    @Autowired
    private OTPGenerator otpGenerator;

    public ResponseEntity<OTP> generateOtp(String recipient) {
        try {
            final String code = otpGenerator.generateOTP(6);

            LocalDateTime expiryTime = LocalDateTime.now().plusMinutes(3);

            OTP otp = otpDTO.findByRecipient(recipient);

            if (otp != null && !(otp.getExpiryTime().isBefore(LocalDateTime.now()))) {
                return new ResponseEntity<>(otp, HttpStatus.CREATED);
            }

            if (otp != null && otp.getExpiryTime().isBefore(LocalDateTime.now())) {
                otpDTO.delete(otp); // Delete if expired without being used
            }

            // Persist to database
            OTP OTP = new OTP();

            OTP.setRecipient(recipient);
            OTP.setCode(code);
            OTP.setExpiryTime(expiryTime);

            otpDTO.save(OTP);

            // Send OTP to recipient with a given mechanism
            // ============================================

            return new ResponseEntity<>(OTP, HttpStatus.CREATED);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResponseEntity<String> getOtpByRecipient(String recipient) {
        OTP otp = new OTP();
        try {
            otp = otpDTO.findByRecipient(recipient);
            if (otp != null) {
                return new ResponseEntity<String>(otp.toString(), HttpStatus.OK);
            } else {
                return new ResponseEntity<String>("OTP not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String>("An error occured while fetching OTP", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<String> validateOtp(Map<String, String> _otp) {
        String recipient = _otp.get("recipient");
        String code = _otp.get("otp");

        OTP otp = otpDTO.findByRecipient(recipient);

        if (otp == null) {
            return new ResponseEntity<String>("OTP not found for the recipient " + recipient, HttpStatus.NOT_FOUND);
        }

        if (otp.getExpiryTime().isBefore(LocalDateTime.now())) {
            return new ResponseEntity<String>("OTP has expired", HttpStatus.FORBIDDEN);
        }

        if (!otp.getCode().equals(code)) {
            return new ResponseEntity<String>("Invalid OTP", HttpStatus.NOT_FOUND);
        }

        // Execution reaches here if otp is valid, thus delete now. 
        otpDTO.delete(otp);

        return new ResponseEntity<String>("OTP validated successfully", HttpStatus.OK);
    }

    public void deleteOTP(String recipient) {
        try {
            OTP otp = otpDTO.findByRecipient(recipient);
            otpDTO.delete(otp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResponseEntity<String> checkExpiry(String recipient) {
        // try {
        //     OTP otp = otpDTO.findByRecipient(recipient);
        //     return new ResponseEntity<String>("NOTHING", HttpStatus.OK);
        //     // if (otp == null) {
        //     //     return new ResponseEntity<String>("OTP not found for the recipient", HttpStatus.NOT_FOUND);
        //     // }

        //     // boolean expired = otp.getExpiryTime().isBefore(LocalDateTime.now());
        //     // String response = "OTP expired: " + expired + ", Expiry time: " + otp.getExpiryTime();

        //     // return new ResponseEntity<String>(response, HttpStatus.OK);
        // } catch (Exception e) {
        //     e.printStackTrace();
        //     return new ResponseEntity<String>("An error occured while checking OTP expiry", HttpStatus.INTERNAL_SERVER_ERROR);
        // }
        return new ResponseEntity<String>(recipient, HttpStatus.OK);
    }

}
