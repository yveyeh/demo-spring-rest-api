package com.didi.quizapp.authentications.otp.core.otp_code_feature.update_otp_code.usecase;

import com.didi.quizapp.authentications.otp.core.otp_code_feature.update_otp_code.dto.UpdateOtpCodeInputDTO;
import com.didi.quizapp.authentications.otp.core.otp_code_feature.update_otp_code.dto.UpdateOtpCodeOutputDTO;

import java.util.UUID;

public interface UpdateOtpCodeUseCase {
    UpdateOtpCodeOutputDTO update(UUID otpCodeId, UpdateOtpCodeInputDTO otpCodeInputDTO);
}
