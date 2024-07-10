package com.didi.quizapp.authentications.otp.app.otp_action_feature.consult_otp_action_details.controller;

import com.didi.quizapp.authentications.otp.app.otp_action_feature.consult_otp_action_details.api.ConsultOtpActionDetailsApi;
import com.didi.quizapp.authentications.otp.app.otp_action_feature.consult_otp_action_details.dto.ConsultOtpActionDetailsResponseDTO;
import com.didi.quizapp.authentications.otp.app.otp_action_feature.shared.mapper.OtpActionAppMapper;
import com.didi.quizapp.authentications.otp.core.otp_action_feature.consult_otp_action_details.dto.ConsultOtpActionDetailsOutputDTO;
import com.didi.quizapp.authentications.otp.core.otp_action_feature.consult_otp_action_details.handler.ConsultOtpActionDetailsHandler;

import lombok.RequiredArgsConstructor;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ConsultOtpActionDetailsApiController implements ConsultOtpActionDetailsApi {

    @Autowired
    private ConsultOtpActionDetailsHandler consultOtpActionDetailsHandler;

    @Override
    public ResponseEntity<ConsultOtpActionDetailsResponseDTO> _consultOtpActionDetails(UUID id) {
        try {
            ConsultOtpActionDetailsOutputDTO outputDTO = consultOtpActionDetailsHandler.consultOtpActionDetails(id);
            ConsultOtpActionDetailsResponseDTO responseDTO = OtpActionAppMapper.INSTANCE.map(outputDTO);
            return new ResponseEntity<ConsultOtpActionDetailsResponseDTO>(responseDTO, HttpStatus.OK);
        } catch (IllegalArgumentException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
