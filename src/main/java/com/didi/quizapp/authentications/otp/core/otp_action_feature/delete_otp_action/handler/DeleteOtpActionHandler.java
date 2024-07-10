package com.didi.quizapp.authentications.otp.core.otp_action_feature.delete_otp_action.handler;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.didi.quizapp.authentications.otp.core.otp_action_feature.delete_otp_action.usecase.DeleteOtpActionUseCase;
import com.didi.quizapp.authentications.otp.core.otp_action_feature.shared.model.OtpActionModel;
import com.didi.quizapp.authentications.otp.core.otp_action_feature.shared.repository.OtpActionRepositoryPort;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DeleteOtpActionHandler implements DeleteOtpActionUseCase {

    @Autowired
    private OtpActionRepositoryPort otpActionRepositoryPort;

    @Override
    public void deleteOtpActionDetails(UUID id) {

        OtpActionModel model = otpActionRepositoryPort.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("OTP action not found"));
        // 
        otpActionRepositoryPort.delete(model);
    }
}
