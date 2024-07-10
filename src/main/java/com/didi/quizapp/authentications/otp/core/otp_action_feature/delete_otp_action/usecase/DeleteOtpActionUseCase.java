package com.didi.quizapp.authentications.otp.core.otp_action_feature.delete_otp_action.usecase;

import java.util.UUID;

public interface DeleteOtpActionUseCase {
    void deleteOtpActionDetails(UUID id);
}
