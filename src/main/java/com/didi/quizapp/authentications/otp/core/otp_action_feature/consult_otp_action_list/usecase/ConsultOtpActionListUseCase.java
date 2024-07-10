package com.didi.quizapp.authentications.otp.core.otp_action_feature.consult_otp_action_list.usecase;

import com.didi.quizapp.authentications.otp.core.otp_action_feature.consult_otp_action_list.dto.ConsultOtpActionListOutputDTO;

public interface ConsultOtpActionListUseCase {
    ConsultOtpActionListOutputDTO consultOtpActionList(Integer page, Integer size);
}
