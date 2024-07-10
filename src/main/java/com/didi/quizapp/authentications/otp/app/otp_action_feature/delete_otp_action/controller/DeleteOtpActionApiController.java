package com.didi.quizapp.authentications.otp.app.otp_action_feature.delete_otp_action.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.didi.quizapp.authentications.otp.app.otp_action_feature.delete_otp_action.api.DeleteOtpActionApi;
import com.didi.quizapp.authentications.otp.core.otp_action_feature.delete_otp_action.handler.DeleteOtpActionHandler;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class DeleteOtpActionApiController implements DeleteOtpActionApi {

    @Autowired
    private DeleteOtpActionHandler deleteOtpActionHandler;

    @Override
    public ResponseEntity<String> _deleteOtpActionDetails(UUID id) {
        try {
            deleteOtpActionHandler.deleteOtpActionDetails(id);
            return new ResponseEntity<String>("Successfully deleted otp action", HttpStatus.NO_CONTENT);
        } catch (IllegalArgumentException exception) {
            return new ResponseEntity<String>("An error occured while trying to delete the otp action", HttpStatus.NOT_FOUND);
        }
    }

}
