package com.didi.quizapp.authentications.otp.app.otp_code_feature.consult_otp_code_list.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.didi.quizapp.authentications.otp.app.otp_code_feature.consult_otp_code_list.api.ConsultOtpCodeListApi;
import com.didi.quizapp.authentications.otp.app.otp_code_feature.consult_otp_code_list.dto.ConsultOtpCodeListResponseDTO;
import com.didi.quizapp.authentications.otp.app.otp_code_feature.shared.mapper.OtpCodeAppMapper;
import com.didi.quizapp.authentications.otp.core.otp_code_feature.consult_otp_code_list.dto.ConsultOtpCodeListOutputDTO;
import com.didi.quizapp.authentications.otp.core.otp_code_feature.consult_otp_code_list.handler.ConsultOtpCodeListHandler;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ConsultOtpCodeListApiController implements ConsultOtpCodeListApi {

    @Autowired
    private ConsultOtpCodeListHandler consultOtpCodeListHandler;

    @Override
    public ResponseEntity<ConsultOtpCodeListResponseDTO> _consultOtpCodeList(Integer page, Integer size) {
        // System.out.println("HEY");
        try {
            // System.out.println("GOT IN AT LEAST " + page);
            ConsultOtpCodeListOutputDTO outputDTO = consultOtpCodeListHandler.consultOtpCodeList(page, size);
            System.out.println(outputDTO);
            System.out.println("mmmmmmmmmmmmmmmm");
            ConsultOtpCodeListResponseDTO responseDTO = OtpCodeAppMapper.INSTANCE.map(outputDTO);
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}