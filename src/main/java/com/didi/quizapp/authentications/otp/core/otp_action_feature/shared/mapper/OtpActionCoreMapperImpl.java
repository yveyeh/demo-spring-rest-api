package com.didi.quizapp.authentications.otp.core.otp_action_feature.shared.mapper;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.didi.quizapp.authentications.otp.core.otp_action_feature.create_otp_action.dto.CreateOtpActionInputDTO;
import com.didi.quizapp.authentications.otp.core.otp_action_feature.shared.dto.OtpActionOutputDTO;
import com.didi.quizapp.authentications.otp.core.otp_action_feature.shared.model.OtpActionModel;
import com.didi.quizapp.authentications.otp.core.otp_action_feature.update_otp_action.dto.UpdateOtpActionInputDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OtpActionCoreMapperImpl implements OtpActionCoreMapper {

    @Override
    public OtpActionOutputDTO map(OtpActionModel otpActionModel) {
        OtpActionOutputDTO outputDTO = new OtpActionOutputDTO();
        outputDTO.setId(otpActionModel.getId());
        outputDTO.setOtpType(otpActionModel.getOtpType());
        outputDTO.setOtpFormat(otpActionModel.getOtpFormat());
        outputDTO.setAuthorizedMethods(otpActionModel.getAuthorizedMethods());
        outputDTO.setDuration(otpActionModel.getDuration());
        outputDTO.setTemplates(otpActionModel.getTemplates());
        outputDTO.setMaxAttempts(otpActionModel.getMaxAttempts());
        outputDTO.setCreatedAt(otpActionModel.getCreatedAt());
        outputDTO.setUpdatedAt(otpActionModel.getUpdatedAt());
        return outputDTO;
    }

    @Override
    public List<OtpActionOutputDTO> map(List<OtpActionModel> otpActionModelList) {
        // Use Java Stream API for concise list mapping
        return otpActionModelList.stream()
                .map(this::map)  // Call map for each element
                .collect(Collectors.toList());
    }

    @Override
    public OtpActionModel map(CreateOtpActionInputDTO otpActionInputDTO) {
        return OtpActionModel.builder()
                .id(UUID.randomUUID())
                .otpType(otpActionInputDTO.getOtpType())
                .otpFormat(otpActionInputDTO.getOtpFormat())
                .authorizedMethods(otpActionInputDTO.getAuthorizedMethods())
                .duration(otpActionInputDTO.getDuration())
                .templates(otpActionInputDTO.getTemplates())
                .maxAttempts(otpActionInputDTO.getMaxAttempts())
                .createdAt(OffsetDateTime.now())
                .updatedAt(OffsetDateTime.now())
                .build();
    }

    @Override
    public void updateOtpActionModelFromUpdateOtpActionInputDTO(UpdateOtpActionInputDTO updateDto, OtpActionModel otpActionModel) {
        if (updateDto.getOtpType() != null) {
            otpActionModel.setOtpType(updateDto.getOtpType());
        }
        if (updateDto.getOtpFormat() != null) {
            otpActionModel.setOtpFormat(updateDto.getOtpFormat());
        }
        if (updateDto.getAuthorizedMethods() != null) {
            otpActionModel.setAuthorizedMethods(updateDto.getAuthorizedMethods());
        }
        if (updateDto.getDuration() != null) {
            otpActionModel.setDuration(updateDto.getDuration());
        }
        if (updateDto.getTemplates() != null) {
            otpActionModel.setTemplates(updateDto.getTemplates());
        }
        if (updateDto.getMaxAttempts() != null) {
            otpActionModel.setMaxAttempts(updateDto.getMaxAttempts());
        }
        otpActionModel.setUpdatedAt(OffsetDateTime.now());  // Update timestamp
    }
}
