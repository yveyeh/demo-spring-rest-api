package com.didi.quizapp.authentications.otp.app.otp_code_feature.delete_otp_code.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.didi.quizapp.authentications.otp.app.otp_code_feature.delete_otp_code.api.DeleteOtpCodeApi;
import com.didi.quizapp.authentications.otp.core.otp_code_feature.delete_otp_code.handler.DeleteOtpCodeHandler;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class DeleteOtpCodeApiController implements DeleteOtpCodeApi {

    @Autowired
    private DeleteOtpCodeHandler deleteOtpCodeHandler;

    @Override
    public ResponseEntity<String> _deleteOtpCodeDetails(UUID id) {
        try {
            deleteOtpCodeHandler.deleteOtpCodeDetails(id);
            return new ResponseEntity<String>("Successfully deleted otp code", HttpStatus.NO_CONTENT);
        } catch (IllegalArgumentException exception) {
            return new ResponseEntity<String>("An error occured while trying to delete the otp code",
                    HttpStatus.NOT_FOUND);
        }
    }

}
