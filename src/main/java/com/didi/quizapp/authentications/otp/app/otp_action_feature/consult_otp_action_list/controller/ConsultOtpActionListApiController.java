package com.didi.quizapp.authentications.otp.app.otp_action_feature.consult_otp_action_list.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.didi.quizapp.authentications.otp.app.otp_action_feature.consult_otp_action_list.api.ConsultOtpActionListApi;
import com.didi.quizapp.authentications.otp.app.otp_action_feature.consult_otp_action_list.dto.ConsultOtpActionListResponseDTO;
import com.didi.quizapp.authentications.otp.app.otp_action_feature.shared.mapper.OtpActionAppMapper;
import com.didi.quizapp.authentications.otp.core.otp_action_feature.consult_otp_action_list.dto.ConsultOtpActionListOutputDTO;
import com.didi.quizapp.authentications.otp.core.otp_action_feature.consult_otp_action_list.handler.ConsultOtpActionListHandler;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ConsultOtpActionListApiController implements ConsultOtpActionListApi {

    @Autowired
    private ConsultOtpActionListHandler consultOtpActionListHandler;

    @Override
    public ResponseEntity<ConsultOtpActionListResponseDTO> _consultOtpActionList(Integer page, Integer size) {
        // System.out.println("HEY");
        try {
            // System.out.println("GOT IN AT LEAST " + page);
            ConsultOtpActionListOutputDTO outputDTO = consultOtpActionListHandler.consultOtpActionList(page, size);
            System.out.println(outputDTO);
            System.out.println("mmmmmmmmmmmmmmmm");
            ConsultOtpActionListResponseDTO responseDTO = OtpActionAppMapper.INSTANCE.map(outputDTO);
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}