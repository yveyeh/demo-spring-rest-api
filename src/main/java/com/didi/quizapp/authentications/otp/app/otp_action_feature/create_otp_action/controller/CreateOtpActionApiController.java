package com.didi.quizapp.authentications.otp.app.otp_action_feature.create_otp_action.controller;

import com.didi.quizapp.authentications.otp.app.otp_action_feature.create_otp_action.api.CreateOtpActionApi;
import com.didi.quizapp.authentications.otp.app.otp_action_feature.create_otp_action.dto.CreateOtpActionRequestDTO;
import com.didi.quizapp.authentications.otp.app.otp_action_feature.create_otp_action.dto.CreateOtpActionResponseDTO;
import com.didi.quizapp.authentications.otp.app.otp_action_feature.shared.mapper.OtpActionAppMapper;
import com.didi.quizapp.authentications.otp.core.otp_action_feature.create_otp_action.dto.CreateOtpActionInputDTO;
import com.didi.quizapp.authentications.otp.core.otp_action_feature.create_otp_action.dto.CreateOtpActionOutputDTO;
import com.didi.quizapp.authentications.otp.core.otp_action_feature.create_otp_action.handler.CreateOtpActionHandler;

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
public class CreateOtpActionApiController implements CreateOtpActionApi {

    @Autowired
    private CreateOtpActionHandler createOtpActionHandler;

    @Override
    public ResponseEntity<CreateOtpActionResponseDTO> _createOtpAction(CreateOtpActionRequestDTO createOtpActionRequestDTO) {
        System.out.println(createOtpActionRequestDTO);
        try {
            CreateOtpActionInputDTO requestDTO = OtpActionAppMapper.INSTANCE.map(createOtpActionRequestDTO);
            CreateOtpActionOutputDTO outputDTO = createOtpActionHandler.createOtpAction(requestDTO);
            CreateOtpActionResponseDTO responseDTO = OtpActionAppMapper.INSTANCE.map(outputDTO);
            return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
        } catch (IllegalArgumentException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
