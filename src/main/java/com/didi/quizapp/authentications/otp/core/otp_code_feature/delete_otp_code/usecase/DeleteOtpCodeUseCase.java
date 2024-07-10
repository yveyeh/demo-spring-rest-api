package com.didi.quizapp.authentications.otp.core.otp_code_feature.delete_otp_code.usecase;

import java.util.UUID;

public interface DeleteOtpCodeUseCase {
    void deleteOtpCodeDetails(UUID id);
}
