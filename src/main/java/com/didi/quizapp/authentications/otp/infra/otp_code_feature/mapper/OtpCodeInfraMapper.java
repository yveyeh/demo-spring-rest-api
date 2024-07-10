package com.didi.quizapp.authentications.otp.infra.otp_code_feature.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.didi.quizapp.authentications.otp.core.otp_code_feature.shared.model.OtpCodeModel;
import com.didi.quizapp.authentications.otp.infra.otp_code_feature.entity.OtpCodeEntity;

@Mapper
public interface OtpCodeInfraMapper {

    OtpCodeInfraMapper INSTANCE = Mappers.getMapper(OtpCodeInfraMapper.class);

    OtpCodeModel map(OtpCodeEntity otpCodeEntity);

    OtpCodeEntity map(OtpCodeModel otpCodeModel);

    List<OtpCodeModel> map(List<OtpCodeEntity> otpCodeEntities);

}
