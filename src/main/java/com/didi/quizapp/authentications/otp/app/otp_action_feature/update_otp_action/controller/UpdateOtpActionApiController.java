package com.didi.quizapp.authentications.otp.app.otp_action_feature.update_otp_action.controller;

import com.didi.quizapp.authentications.otp.app.otp_action_feature.shared.mapper.OtpActionAppMapper;
import com.didi.quizapp.authentications.otp.app.otp_action_feature.update_otp_action.api.UpdateOtpActionApi;
import com.didi.quizapp.authentications.otp.app.otp_action_feature.update_otp_action.dto.UpdateOtpActionRequestDTO;
import com.didi.quizapp.authentications.otp.app.otp_action_feature.update_otp_action.dto.UpdateOtpActionResponseDTO;
import com.didi.quizapp.authentications.otp.core.otp_action_feature.update_otp_action.handler.UpdateOtpActionHandler;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;


@RequiredArgsConstructor
@RestController
public class UpdateOtpActionApiController implements UpdateOtpActionApi {

    @Autowired
    private UpdateOtpActionHandler UpdateOtpActionHandler;

    @Override
    public ResponseEntity<UpdateOtpActionResponseDTO> _updateOtpActionDetails(UUID id, UpdateOtpActionRequestDTO updateOtpActionRequestDTO) {
        try {
            return new ResponseEntity<>(
                OtpActionAppMapper.INSTANCE.map(
                    UpdateOtpActionHandler.update(
                        id,
                        OtpActionAppMapper.INSTANCE.map(updateOtpActionRequestDTO)
                    )
                ),
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
