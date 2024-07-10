package com.didi.quizapp.authentications.otp.core.otp_code_feature.create_otp_code.usecase;

import com.didi.quizapp.authentications.otp.core.otp_code_feature.create_otp_code.dto.CreateOtpCodeInputDTO;
import com.didi.quizapp.authentications.otp.core.otp_code_feature.create_otp_code.dto.CreateOtpCodeOutputDTO;

public interface CreateOtpCodeUseCase {

    CreateOtpCodeOutputDTO createOtpCode(CreateOtpCodeInputDTO otpCodeInputDTO);

}
