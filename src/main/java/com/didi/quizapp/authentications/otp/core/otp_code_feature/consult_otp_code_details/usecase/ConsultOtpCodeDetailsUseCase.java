package com.didi.quizapp.authentications.otp.core.otp_code_feature.consult_otp_code_details.usecase;

import java.util.UUID;

import com.didi.quizapp.authentications.otp.core.otp_code_feature.consult_otp_code_details.dto.ConsultOtpCodeDetailsOutputDTO;

public interface ConsultOtpCodeDetailsUseCase {
    ConsultOtpCodeDetailsOutputDTO consultOtpCodeDetails(UUID otpCodeId);
}
