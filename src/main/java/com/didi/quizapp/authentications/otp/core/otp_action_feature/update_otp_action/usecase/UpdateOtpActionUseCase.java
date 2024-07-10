package com.didi.quizapp.authentications.otp.core.otp_action_feature.update_otp_action.usecase;

import com.didi.quizapp.authentications.otp.core.otp_action_feature.update_otp_action.dto.UpdateOtpActionInputDTO;
import com.didi.quizapp.authentications.otp.core.otp_action_feature.update_otp_action.dto.UpdateOtpActionOutputDTO;

import java.util.UUID;

public interface UpdateOtpActionUseCase {
    UpdateOtpActionOutputDTO update(UUID otpActionId, UpdateOtpActionInputDTO otpActionInputDTO);
}
