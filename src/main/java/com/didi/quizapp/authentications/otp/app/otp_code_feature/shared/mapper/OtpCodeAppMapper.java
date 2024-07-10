package com.didi.quizapp.authentications.otp.app.otp_code_feature.shared.mapper;

import com.didi.quizapp.authentications.otp.app.otp_code_feature.consult_otp_code_details.dto.ConsultOtpCodeDetailsResponseDTO;
import com.didi.quizapp.authentications.otp.app.otp_code_feature.consult_otp_code_list.dto.ConsultOtpCodeListResponseDTO;
import com.didi.quizapp.authentications.otp.app.otp_code_feature.send_otp_code.dto.CreateOtpCodeRequestDTO;
import com.didi.quizapp.authentications.otp.app.otp_code_feature.send_otp_code.dto.CreateOtpCodeResponseDTO;
import com.didi.quizapp.authentications.otp.app.otp_code_feature.update_otp_code.dto.UpdateOtpCodeRequestDTO;
import com.didi.quizapp.authentications.otp.app.otp_code_feature.update_otp_code.dto.UpdateOtpCodeResponseDTO;
import com.didi.quizapp.authentications.otp.core.otp_code_feature.consult_otp_code_details.dto.ConsultOtpCodeDetailsOutputDTO;
import com.didi.quizapp.authentications.otp.core.otp_code_feature.consult_otp_code_list.dto.ConsultOtpCodeListOutputDTO;
import com.didi.quizapp.authentications.otp.core.otp_code_feature.create_otp_code.dto.CreateOtpCodeInputDTO;
import com.didi.quizapp.authentications.otp.core.otp_code_feature.create_otp_code.dto.CreateOtpCodeOutputDTO;
import com.didi.quizapp.authentications.otp.core.otp_code_feature.update_otp_code.dto.UpdateOtpCodeInputDTO;
import com.didi.quizapp.authentications.otp.core.otp_code_feature.update_otp_code.dto.UpdateOtpCodeOutputDTO;

import org.mapstruct.Mapper;
// import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface OtpCodeAppMapper {

    OtpCodeAppMapper INSTANCE = Mappers.getMapper(OtpCodeAppMapper.class);

    ConsultOtpCodeDetailsResponseDTO map(ConsultOtpCodeDetailsOutputDTO consultOtpCodeDetailsOutputDTO);

    ConsultOtpCodeListResponseDTO map(ConsultOtpCodeListOutputDTO consultOtpCodeListOutputDTO);

    CreateOtpCodeInputDTO map(CreateOtpCodeRequestDTO CreateOtpCodeRequestDTO);

    CreateOtpCodeResponseDTO map(CreateOtpCodeOutputDTO createOtpCodeOutputDTO);

    UpdateOtpCodeResponseDTO map(UpdateOtpCodeOutputDTO updateOtpCodeOutputDTO);

    UpdateOtpCodeInputDTO map(UpdateOtpCodeRequestDTO updateOtpCodeRequestDTO);

}
