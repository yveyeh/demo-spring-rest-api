package com.didi.quizapp.authentications.otp.app.otp_code_feature.update_otp_code.controller;

import com.didi.quizapp.authentications.otp.app.otp_code_feature.shared.mapper.OtpCodeAppMapper;
import com.didi.quizapp.authentications.otp.app.otp_code_feature.update_otp_code.api.UpdateOtpCodeApi;
import com.didi.quizapp.authentications.otp.app.otp_code_feature.update_otp_code.dto.UpdateOtpCodeRequestDTO;
import com.didi.quizapp.authentications.otp.app.otp_code_feature.update_otp_code.dto.UpdateOtpCodeResponseDTO;
import com.didi.quizapp.authentications.otp.core.otp_code_feature.update_otp_code.handler.UpdateOtpCodeHandler;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
public class UpdateOtpCodeApiController implements UpdateOtpCodeApi {

    @Autowired
    private UpdateOtpCodeHandler UpdateOtpCodeHandler;

    @Override
    public ResponseEntity<UpdateOtpCodeResponseDTO> _updateOtpCodeDetails(UUID id,
            UpdateOtpCodeRequestDTO updateOtpCodeRequestDTO) {
        try {
            return new ResponseEntity<>(
                    OtpCodeAppMapper.INSTANCE.map(
                            UpdateOtpCodeHandler.update(
                                    id,
                                    OtpCodeAppMapper.INSTANCE.map(updateOtpCodeRequestDTO))),
                    HttpStatus.OK);
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
