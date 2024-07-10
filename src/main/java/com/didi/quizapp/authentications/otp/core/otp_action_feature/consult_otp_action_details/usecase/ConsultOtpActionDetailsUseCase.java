package com.didi.quizapp.authentications.otp.core.otp_action_feature.consult_otp_action_details.usecase;

import java.util.UUID;

import com.didi.quizapp.authentications.otp.core.otp_action_feature.consult_otp_action_details.dto.ConsultOtpActionDetailsOutputDTO;

public interface ConsultOtpActionDetailsUseCase {
    ConsultOtpActionDetailsOutputDTO consultOtpActionDetails(UUID otpActionId);
}
