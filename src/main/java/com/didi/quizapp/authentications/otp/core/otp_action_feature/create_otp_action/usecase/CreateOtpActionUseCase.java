package com.didi.quizapp.authentications.otp.core.otp_action_feature.create_otp_action.usecase;

import com.didi.quizapp.authentications.otp.core.otp_action_feature.create_otp_action.dto.CreateOtpActionInputDTO;
import com.didi.quizapp.authentications.otp.core.otp_action_feature.create_otp_action.dto.CreateOtpActionOutputDTO;

public interface CreateOtpActionUseCase {

    CreateOtpActionOutputDTO createOtpAction(CreateOtpActionInputDTO otpActionInputDTO);

}
