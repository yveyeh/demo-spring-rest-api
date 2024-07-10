package com.didi.quizapp.authentications.otp.core.otp_code_feature.consult_otp_code_list.usecase;

import com.didi.quizapp.authentications.otp.core.otp_code_feature.consult_otp_code_list.dto.ConsultOtpCodeListOutputDTO;

public interface ConsultOtpCodeListUseCase {
    ConsultOtpCodeListOutputDTO consultOtpCodeList(Integer page, Integer size);
}
