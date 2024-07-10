package com.didi.quizapp.authentications.otp.app.otp_code_feature.send_otp_code.controller;

import com.didi.quizapp.authentications.otp.app.otp_code_feature.send_otp_code.api.SendOtpCodeApi;
import com.didi.quizapp.authentications.otp.app.otp_code_feature.send_otp_code.dto.CreateOtpCodeRequestDTO;
import com.didi.quizapp.authentications.otp.app.otp_code_feature.send_otp_code.dto.CreateOtpCodeResponseDTO;
import com.didi.quizapp.authentications.otp.app.otp_code_feature.shared.mapper.OtpCodeAppMapper;
import com.didi.quizapp.authentications.otp.core.otp_code_feature.create_otp_code.dto.CreateOtpCodeInputDTO;
import com.didi.quizapp.authentications.otp.core.otp_code_feature.create_otp_code.dto.CreateOtpCodeOutputDTO;
import com.didi.quizapp.authentications.otp.core.otp_code_feature.create_otp_code.handler.CreateOtpCodeHandler;

// import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

// import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CreateOtpCodeApiController implements SendOtpCodeApi {

    @Autowired
    private CreateOtpCodeHandler createOtpCodeHandler;

    @Override
    public ResponseEntity<CreateOtpCodeResponseDTO> _createOtpCode(CreateOtpCodeRequestDTO createOtpCodeRequestDTO) {
        try {
            CreateOtpCodeInputDTO requestDTO = OtpCodeAppMapper.INSTANCE.map(createOtpCodeRequestDTO);
            CreateOtpCodeOutputDTO outputDTO = createOtpCodeHandler.createOtpCode(requestDTO);
            CreateOtpCodeResponseDTO responseDTO = OtpCodeAppMapper.INSTANCE.map(outputDTO);
            return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
        } catch (IllegalArgumentException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
