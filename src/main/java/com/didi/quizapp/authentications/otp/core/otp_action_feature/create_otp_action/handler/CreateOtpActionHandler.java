package com.didi.quizapp.authentications.otp.core.otp_action_feature.create_otp_action.handler;

import com.didi.quizapp.authentications.otp.core.otp_action_feature.create_otp_action.dto.CreateOtpActionInputDTO;
import com.didi.quizapp.authentications.otp.core.otp_action_feature.create_otp_action.dto.CreateOtpActionOutputDTO;
import com.didi.quizapp.authentications.otp.core.otp_action_feature.create_otp_action.usecase.CreateOtpActionUseCase;
import com.didi.quizapp.authentications.otp.core.otp_action_feature.shared.dto.OtpActionOutputDTO;
import com.didi.quizapp.authentications.otp.core.otp_action_feature.shared.mapper.OtpActionCoreMapper;
import com.didi.quizapp.authentications.otp.core.otp_action_feature.shared.mapper.OtpActionCoreMapperImpl;
import com.didi.quizapp.authentications.otp.core.otp_action_feature.shared.model.OtpActionModel;
import com.didi.quizapp.authentications.otp.core.otp_action_feature.shared.repository.OtpActionRepositoryPort;

import org.springframework.beans.factory.annotation.Autowired;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Service
public class CreateOtpActionHandler implements CreateOtpActionUseCase {

    @Autowired
    private OtpActionRepositoryPort otpActionRepositoryPort;
        
    @Override
    public CreateOtpActionOutputDTO createOtpAction(CreateOtpActionInputDTO otpActionInputDTO) {

        long startTime = System.currentTimeMillis();

        OtpActionCoreMapper MAPPER = new OtpActionCoreMapperImpl();

        OtpActionModel otpActionModel = otpActionRepositoryPort.save(MAPPER.map(otpActionInputDTO));
        OtpActionOutputDTO outputDTO = MAPPER.map(otpActionModel);

        CreateOtpActionOutputDTO createOtpActionOutputDTO = new CreateOtpActionOutputDTO();
        createOtpActionOutputDTO.setData(outputDTO);

        long endTime = System.currentTimeMillis();

        createOtpActionOutputDTO.setElapsedTime(BigDecimal.valueOf(endTime - startTime));

        return createOtpActionOutputDTO;
    }
}
