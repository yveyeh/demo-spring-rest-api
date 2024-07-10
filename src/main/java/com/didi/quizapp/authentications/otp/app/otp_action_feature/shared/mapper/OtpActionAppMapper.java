package com.didi.quizapp.authentications.otp.app.otp_action_feature.shared.mapper;

import com.didi.quizapp.authentications.otp.app.otp_action_feature.consult_otp_action_details.dto.ConsultOtpActionDetailsResponseDTO;
import com.didi.quizapp.authentications.otp.app.otp_action_feature.consult_otp_action_list.dto.ConsultOtpActionListResponseDTO;
import com.didi.quizapp.authentications.otp.app.otp_action_feature.create_otp_action.dto.CreateOtpActionRequestDTO;
import com.didi.quizapp.authentications.otp.app.otp_action_feature.create_otp_action.dto.CreateOtpActionResponseDTO;
import com.didi.quizapp.authentications.otp.app.otp_action_feature.update_otp_action.dto.UpdateOtpActionRequestDTO;
import com.didi.quizapp.authentications.otp.app.otp_action_feature.update_otp_action.dto.UpdateOtpActionResponseDTO;
import com.didi.quizapp.authentications.otp.core.otp_action_feature.consult_otp_action_details.dto.ConsultOtpActionDetailsOutputDTO;
import com.didi.quizapp.authentications.otp.core.otp_action_feature.consult_otp_action_list.dto.ConsultOtpActionListOutputDTO;
import com.didi.quizapp.authentications.otp.core.otp_action_feature.create_otp_action.dto.CreateOtpActionInputDTO;
import com.didi.quizapp.authentications.otp.core.otp_action_feature.create_otp_action.dto.CreateOtpActionOutputDTO;
import com.didi.quizapp.authentications.otp.core.otp_action_feature.update_otp_action.dto.UpdateOtpActionInputDTO;
import com.didi.quizapp.authentications.otp.core.otp_action_feature.update_otp_action.dto.UpdateOtpActionOutputDTO;

import org.mapstruct.Mapper;
// import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface OtpActionAppMapper {

    OtpActionAppMapper INSTANCE = Mappers.getMapper(OtpActionAppMapper.class);

    ConsultOtpActionDetailsResponseDTO map(ConsultOtpActionDetailsOutputDTO consultOtpActionDetailsOutputDTO);

    ConsultOtpActionListResponseDTO map(ConsultOtpActionListOutputDTO consultOtpActionListOutputDTO);

    CreateOtpActionInputDTO map(CreateOtpActionRequestDTO CreateOtpActionRequestDTO);

    CreateOtpActionResponseDTO map(CreateOtpActionOutputDTO createOtpActionOutputDTO);

    UpdateOtpActionResponseDTO map(UpdateOtpActionOutputDTO updateOtpActionOutputDTO);

    UpdateOtpActionInputDTO map(UpdateOtpActionRequestDTO updateOtpActionRequestDTO);
    
}
