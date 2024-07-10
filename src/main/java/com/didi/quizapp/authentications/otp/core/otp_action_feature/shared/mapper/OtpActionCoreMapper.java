package com.didi.quizapp.authentications.otp.core.otp_action_feature.shared.mapper;

import com.didi.quizapp.authentications.otp.core.otp_action_feature.create_otp_action.dto.CreateOtpActionInputDTO;
import com.didi.quizapp.authentications.otp.core.otp_action_feature.shared.dto.OtpActionOutputDTO;
import com.didi.quizapp.authentications.otp.core.otp_action_feature.shared.model.OtpActionModel;
import com.didi.quizapp.authentications.otp.core.otp_action_feature.update_otp_action.dto.UpdateOtpActionInputDTO;

// import org.mapstruct.*;
// import org.mapstruct.factory.Mappers;
// import org.springframework.beans.factory.annotation.Autowired;

// import java.time.OffsetDateTime;
import java.util.List;
// import java.util.UUID;

// @Mapper(componentModel = MappingConstants.ComponentModel.SPRING, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface  OtpActionCoreMapper {
    // OtpActionCoreMapper INSTANCE = getMapper(OtpActionCoreMapper.class);

    OtpActionOutputDTO map(OtpActionModel otpActionModel);

    List<OtpActionOutputDTO> map(List<OtpActionModel> otpActionModelList);

    OtpActionModel map(CreateOtpActionInputDTO otpActionInputDTO);

    void updateOtpActionModelFromUpdateOtpActionInputDTO(UpdateOtpActionInputDTO otpActionInputDTO, OtpActionModel otpActionModel);

    // OtpActionModel otpActionModel = OtpActionModel.builder()
    //     .id(UUID.randomUUID())
    //     .otpType(otpActionInputDTO.getOtpType())
    //     .otpFormat(otpActionInputDTO.getOtpFormat())
    //     .authorizedMethods(otpActionInputDTO.getAuthorizedMethods())
    //     .duration(otpActionInputDTO.getDuration())
    //     .templates(otpActionInputDTO.getTemplates())
    //     .maxAttempts(otpActionInputDTO.getMaxAttempts())
    //     .createdAt(OffsetDateTime.now())
    //     .updatedAt(OffsetDateTime.now())
    //     .build();
}
