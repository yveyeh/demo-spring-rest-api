package com.didi.quizapp.authentications.otp.core.otp_code_feature.shared.mapper;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import com.didi.quizapp.authentications.otp.core.otp_code_feature.create_otp_code.dto.CreateOtpCodeInputDTO;
import com.didi.quizapp.authentications.otp.core.otp_code_feature.update_otp_code.dto.UpdateOtpCodeInputDTO;
import com.didi.quizapp.authentications.otp.core.otp_code_feature.shared.dto.OtpCodeOutputDTO;
import com.didi.quizapp.authentications.otp.core.otp_code_feature.shared.model.OtpCodeModel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OtpCodeCoreMapperImpl implements OtpCodeCoreMapper {

    @Override
    public OtpCodeOutputDTO map(OtpCodeModel otpCodeModel) {
        OtpCodeOutputDTO outputDTO = new OtpCodeOutputDTO();
        outputDTO.setId(otpCodeModel.getId());
        outputDTO.setValue(otpCodeModel.getValue());
        outputDTO.setExpiresAt(otpCodeModel.getExpiresAt());
        outputDTO.setMethods(otpCodeModel.getMethods());
        outputDTO.setAttempts(otpCodeModel.getAttempts());
        outputDTO.setMessages(otpCodeModel.getMessages());
        outputDTO.setRecipient(otpCodeModel.getRecipient());
        outputDTO.setInvalid(otpCodeModel.isInvalid());
        outputDTO.setOtpActionId(otpCodeModel.getOtpActionId());
        outputDTO.setUserId(otpCodeModel.getUserId());
        return outputDTO;
    }

    @Override
    public List<OtpCodeOutputDTO> map(List<OtpCodeModel> otpCodeModelList) {
        // Use Java Stream API for concise list mapping
        return otpCodeModelList.stream()
                .map(this::map) // Call map for each element
                .collect(Collectors.toList());
    }

    @Override
    public OtpCodeModel map(CreateOtpCodeInputDTO otpCodeInputDTO) {
        return OtpCodeModel.builder()
                .id(UUID.randomUUID())
                .value(otpCodeInputDTO.getValue())
                .expiresAt(otpCodeInputDTO.getExpiresAt())
                .methods(otpCodeInputDTO.getMethods())
                .attempts(otpCodeInputDTO.getAttempts())
                .messages(otpCodeInputDTO.getMessages())
                .recipient(otpCodeInputDTO.getRecipient())
                .isInvalid(otpCodeInputDTO.isInvalid())
                .otpActionId(otpCodeInputDTO.getOtpActionId())
                .userId(otpCodeInputDTO.getUserId())
                .createdAt(OffsetDateTime.now())
                .updatedAt(OffsetDateTime.now())
                .build();
    }

    @Override
    public void map(UpdateOtpCodeInputDTO updateDto,
            OtpCodeModel otpCodeModel) {
        if (updateDto.getValue() != null) {
            otpCodeModel.setValue(updateDto.getValue());
        }
        if (updateDto.getExpiresAt() != null) {
            otpCodeModel.setExpiresAt(updateDto.getExpiresAt());
        }
        if (updateDto.getAttempts() != null) {
            otpCodeModel.setAttempts(updateDto.getAttempts());
        }
        if (updateDto.getMessages() != null) {
            otpCodeModel.setMessages(updateDto.getMessages());
        }
        if (updateDto.isInvalid() != null) {
            otpCodeModel.setInvalid(updateDto.isInvalid());
        }
        
        otpCodeModel.setUpdatedAt(OffsetDateTime.now()); // Update timestamp
    }
}
