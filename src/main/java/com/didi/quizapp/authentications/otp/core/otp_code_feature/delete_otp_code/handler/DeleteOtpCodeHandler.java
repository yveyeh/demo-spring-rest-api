package com.didi.quizapp.authentications.otp.core.otp_code_feature.delete_otp_code.handler;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.didi.quizapp.authentications.otp.core.otp_code_feature.delete_otp_code.usecase.DeleteOtpCodeUseCase;
import com.didi.quizapp.authentications.otp.core.otp_code_feature.shared.model.OtpCodeModel;
import com.didi.quizapp.authentications.otp.core.otp_code_feature.shared.repository.OtpCodeRepositoryPort;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DeleteOtpCodeHandler implements DeleteOtpCodeUseCase {

    @Autowired
    private OtpCodeRepositoryPort otpCodeRepositoryPort;

    @Override
    public void deleteOtpCodeDetails(UUID id) {

        OtpCodeModel model = otpCodeRepositoryPort.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("OTP code not found"));
        //
        otpCodeRepositoryPort.delete(model);
    }
}
