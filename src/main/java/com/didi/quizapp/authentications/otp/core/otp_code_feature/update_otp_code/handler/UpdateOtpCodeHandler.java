package com.didi.quizapp.authentications.otp.core.otp_code_feature.update_otp_code.handler;

import com.didi.quizapp.authentications.otp.core.otp_code_feature.shared.dto.OtpCodeOutputDTO;
import com.didi.quizapp.authentications.otp.core.otp_code_feature.shared.mapper.OtpCodeCoreMapper;
import com.didi.quizapp.authentications.otp.core.otp_code_feature.shared.mapper.OtpCodeCoreMapperImpl;
import com.didi.quizapp.authentications.otp.core.otp_code_feature.shared.model.OtpCodeModel;
import com.didi.quizapp.authentications.otp.core.otp_code_feature.shared.repository.OtpCodeRepositoryPort;
import com.didi.quizapp.authentications.otp.core.otp_code_feature.update_otp_code.dto.UpdateOtpCodeInputDTO;
import com.didi.quizapp.authentications.otp.core.otp_code_feature.update_otp_code.dto.UpdateOtpCodeOutputDTO;
import com.didi.quizapp.authentications.otp.core.otp_code_feature.update_otp_code.usecase.UpdateOtpCodeUseCase;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UpdateOtpCodeHandler implements UpdateOtpCodeUseCase {

    @Autowired
    private OtpCodeRepositoryPort OtpCodeRepositoryPort;

    @Override
    public UpdateOtpCodeOutputDTO update(UUID otpCodeId, UpdateOtpCodeInputDTO otpCodeInputDTO) {
        long startTime = System.currentTimeMillis();

        OtpCodeModel otpCodeModel = OtpCodeRepositoryPort.findById(otpCodeId)
                .orElseThrow(() -> new IllegalArgumentException("OTP Code not found"));

        OtpCodeCoreMapper MAPPER = new OtpCodeCoreMapperImpl();
        MAPPER.map(otpCodeInputDTO, otpCodeModel);

        OtpCodeRepositoryPort.saveAndFlush(otpCodeModel);

        UpdateOtpCodeOutputDTO updateOtpCodeOutputDTO = new UpdateOtpCodeOutputDTO();

        OtpCodeOutputDTO otpCodeOutputDTO = MAPPER.map(otpCodeModel);

        updateOtpCodeOutputDTO.setData(otpCodeOutputDTO);

        long endTime = System.currentTimeMillis();

        updateOtpCodeOutputDTO.setElapsedTime(BigDecimal.valueOf(endTime - startTime));

        return updateOtpCodeOutputDTO;
    }
}
