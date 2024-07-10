package com.didi.quizapp.authentications.otp.core.otp_code_feature.shared.mapper;

import com.didi.quizapp.authentications.otp.core.otp_code_feature.create_otp_code.dto.CreateOtpCodeInputDTO;
import com.didi.quizapp.authentications.otp.core.otp_code_feature.update_otp_code.dto.UpdateOtpCodeInputDTO;
import com.didi.quizapp.authentications.otp.core.otp_code_feature.shared.dto.OtpCodeOutputDTO;
import com.didi.quizapp.authentications.otp.core.otp_code_feature.shared.model.OtpCodeModel;
import java.util.List;

public interface OtpCodeCoreMapper {

    OtpCodeOutputDTO map(OtpCodeModel otpCodeModel);

    List<OtpCodeOutputDTO> map(List<OtpCodeModel> otpCodeModelList);

    OtpCodeModel map(CreateOtpCodeInputDTO otpCodeInputDTO);

    void map(UpdateOtpCodeInputDTO otpCodeInputDTO,
            OtpCodeModel otpCodeModel);

}
