package com.didi.quizapp.authentications.otp.app.otp_code_feature.consult_otp_code_details.controller;

import com.didi.quizapp.authentications.otp.app.otp_code_feature.consult_otp_code_details.api.ConsultOtpCodeDetailsApi;
import com.didi.quizapp.authentications.otp.app.otp_code_feature.consult_otp_code_details.dto.ConsultOtpCodeDetailsResponseDTO;
import com.didi.quizapp.authentications.otp.app.otp_code_feature.shared.mapper.OtpCodeAppMapper;
import com.didi.quizapp.authentications.otp.core.otp_code_feature.consult_otp_code_details.dto.ConsultOtpCodeDetailsOutputDTO;
import com.didi.quizapp.authentications.otp.core.otp_code_feature.consult_otp_code_details.handler.ConsultOtpCodeDetailsHandler;

import lombok.RequiredArgsConstructor;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ConsultOtpCodeDetailsApiController implements ConsultOtpCodeDetailsApi {

    @Autowired
    private ConsultOtpCodeDetailsHandler consultOtpCodeDetailsHandler;

    @Override
    public ResponseEntity<ConsultOtpCodeDetailsResponseDTO> _consultOtpCodeDetails(UUID id) {
        try {
            ConsultOtpCodeDetailsOutputDTO outputDTO = consultOtpCodeDetailsHandler.consultOtpCodeDetails(id);
            ConsultOtpCodeDetailsResponseDTO responseDTO = OtpCodeAppMapper.INSTANCE.map(outputDTO);
            return new ResponseEntity<ConsultOtpCodeDetailsResponseDTO>(responseDTO, HttpStatus.OK);
        } catch (IllegalArgumentException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
