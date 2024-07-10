package com.didi.quizapp.authentications.otp.core.otp_action_feature.update_otp_action.handler;

import com.didi.quizapp.authentications.otp.core.otp_action_feature.shared.dto.OtpActionOutputDTO;
import com.didi.quizapp.authentications.otp.core.otp_action_feature.shared.mapper.OtpActionCoreMapper;
import com.didi.quizapp.authentications.otp.core.otp_action_feature.shared.mapper.OtpActionCoreMapperImpl;
import com.didi.quizapp.authentications.otp.core.otp_action_feature.shared.model.OtpActionModel;
import com.didi.quizapp.authentications.otp.core.otp_action_feature.shared.repository.OtpActionRepositoryPort;
import com.didi.quizapp.authentications.otp.core.otp_action_feature.update_otp_action.dto.UpdateOtpActionInputDTO;
import com.didi.quizapp.authentications.otp.core.otp_action_feature.update_otp_action.dto.UpdateOtpActionOutputDTO;
import com.didi.quizapp.authentications.otp.core.otp_action_feature.update_otp_action.usecase.UpdateOtpActionUseCase;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UpdateOtpActionHandler implements UpdateOtpActionUseCase {

    @Autowired
    private OtpActionRepositoryPort OtpActionRepositoryPort;

    @Override
    public UpdateOtpActionOutputDTO update(UUID otpActionId, UpdateOtpActionInputDTO otpActionInputDTO) {
        long startTime = System.currentTimeMillis();

        OtpActionModel otpActionModel = OtpActionRepositoryPort.findById(otpActionId)
                .orElseThrow(() -> new IllegalArgumentException("OTP Action not found"));

        OtpActionCoreMapper MAPPER = new OtpActionCoreMapperImpl();
        MAPPER.updateOtpActionModelFromUpdateOtpActionInputDTO(otpActionInputDTO, otpActionModel);

        OtpActionRepositoryPort.saveAndFlush(otpActionModel);

        UpdateOtpActionOutputDTO updateOtpActionOutputDTO = new UpdateOtpActionOutputDTO();

        OtpActionOutputDTO otpActionOutputDTO = MAPPER.map(otpActionModel);

        updateOtpActionOutputDTO.setData(otpActionOutputDTO);

        long endTime = System.currentTimeMillis();

        updateOtpActionOutputDTO.setElapsedTime(BigDecimal.valueOf(endTime - startTime));

        return updateOtpActionOutputDTO;
    }
}
