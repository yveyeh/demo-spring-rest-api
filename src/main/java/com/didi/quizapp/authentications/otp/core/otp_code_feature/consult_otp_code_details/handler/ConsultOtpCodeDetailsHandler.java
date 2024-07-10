package com.didi.quizapp.authentications.otp.core.otp_code_feature.consult_otp_code_details.handler;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.didi.quizapp.authentications.otp.core.otp_code_feature.consult_otp_code_details.dto.ConsultOtpCodeDetailsOutputDTO;
import com.didi.quizapp.authentications.otp.core.otp_code_feature.consult_otp_code_details.usecase.ConsultOtpCodeDetailsUseCase;
import com.didi.quizapp.authentications.otp.core.otp_code_feature.shared.dto.OtpCodeOutputDTO;
import com.didi.quizapp.authentications.otp.core.otp_code_feature.shared.mapper.OtpCodeCoreMapper;
import com.didi.quizapp.authentications.otp.core.otp_code_feature.shared.mapper.OtpCodeCoreMapperImpl;
import com.didi.quizapp.authentications.otp.core.otp_code_feature.shared.model.OtpCodeModel;
import com.didi.quizapp.authentications.otp.core.otp_code_feature.shared.repository.OtpCodeRepositoryPort;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ConsultOtpCodeDetailsHandler implements ConsultOtpCodeDetailsUseCase {

    @Autowired
    private OtpCodeRepositoryPort otpCodeRepositoryPort;

    @Override
    public ConsultOtpCodeDetailsOutputDTO consultOtpCodeDetails(UUID otpCodeId) {

        long startTime = System.currentTimeMillis();

        OtpCodeModel otpCodeModel = otpCodeRepositoryPort.findById(otpCodeId)
                .orElseThrow(() -> new IllegalArgumentException("OTP code not found"));

        ConsultOtpCodeDetailsOutputDTO consultOtpCodeDetailsOutputDTO = new ConsultOtpCodeDetailsOutputDTO();

        OtpCodeCoreMapper MAPPER = new OtpCodeCoreMapperImpl();
        OtpCodeOutputDTO otpCodeOutputDTO = MAPPER.map(otpCodeModel);

        consultOtpCodeDetailsOutputDTO.setData(otpCodeOutputDTO);

        long endTime = System.currentTimeMillis();

        consultOtpCodeDetailsOutputDTO.setElapsedTime(BigDecimal.valueOf(endTime - startTime));

        return consultOtpCodeDetailsOutputDTO;
    }

}
