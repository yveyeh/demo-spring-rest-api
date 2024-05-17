package com.didi.quizapp.validations.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.didi.quizapp.validations.OTP;
import com.didi.quizapp.validations.services.OTPService;

@RestController
@RequestMapping("/iam/identities/otp")
public class OTPController {

    @Autowired
    private OTPService otpService;

    @PostMapping("/generate")
    public ResponseEntity<OTP> generateOtp(@RequestParam String recipient) {
        return otpService.generateOtp(recipient);
    }

    @GetMapping("/{recipient}")
    public ResponseEntity<String> getOtpByRecipient(@PathVariable String recipient) {
        return otpService.getOtpByRecipient(recipient);
    }

    @PostMapping("/validate")
    public ResponseEntity<String> validateOtp(@RequestBody Map<String, String> otp) {
        return otpService.validateOtp(otp);
    }

    @DeleteMapping("/{recipient}")
    public void deleteOtp(@PathVariable String recipient) {
        otpService.deleteOTP(recipient);
    }

    @GetMapping("/check")
    public String checkExpiry(@RequestParam String recipient) {
        return "DAMN!!!" + recipient;
        // return otpService.checkExpiry(recipient);
    }
}
