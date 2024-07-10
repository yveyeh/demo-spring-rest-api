package com.didi.quizapp.authentications.otp.core.otp_action_feature.consult_otp_action_details.handler;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.didi.quizapp.authentications.otp.core.otp_action_feature.consult_otp_action_details.dto.ConsultOtpActionDetailsOutputDTO;
import com.didi.quizapp.authentications.otp.core.otp_action_feature.consult_otp_action_details.usecase.ConsultOtpActionDetailsUseCase;
import com.didi.quizapp.authentications.otp.core.otp_action_feature.shared.dto.OtpActionOutputDTO;
import com.didi.quizapp.authentications.otp.core.otp_action_feature.shared.mapper.OtpActionCoreMapper;
import com.didi.quizapp.authentications.otp.core.otp_action_feature.shared.mapper.OtpActionCoreMapperImpl;
import com.didi.quizapp.authentications.otp.core.otp_action_feature.shared.model.OtpActionModel;
import com.didi.quizapp.authentications.otp.core.otp_action_feature.shared.repository.OtpActionRepositoryPort;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ConsultOtpActionDetailsHandler implements ConsultOtpActionDetailsUseCase {

    @Autowired
    private OtpActionRepositoryPort otpActionRepositoryPort;

    @Override
    public ConsultOtpActionDetailsOutputDTO consultOtpActionDetails(UUID otpActionId) {

        long startTime = System.currentTimeMillis();

        OtpActionModel otpActionModel = otpActionRepositoryPort.findById(otpActionId)
                .orElseThrow(() -> new IllegalArgumentException("OTP action not found"));

        ConsultOtpActionDetailsOutputDTO consultOtpActionDetailsOutputDTO = new ConsultOtpActionDetailsOutputDTO();

        OtpActionCoreMapper MAPPER = new OtpActionCoreMapperImpl();
        OtpActionOutputDTO otpActionOutputDTO = MAPPER.map(otpActionModel);

        consultOtpActionDetailsOutputDTO.setData(otpActionOutputDTO);

        long endTime = System.currentTimeMillis();

        consultOtpActionDetailsOutputDTO.setElapsedTime(BigDecimal.valueOf(endTime - startTime));

        return consultOtpActionDetailsOutputDTO;
    }

}
