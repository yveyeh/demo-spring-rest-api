package com.didi.quizapp.authentications.otp.infra.otp_action_feature.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.didi.quizapp.authentications.otp.core.otp_action_feature.shared.model.OtpActionModel;
import com.didi.quizapp.authentications.otp.infra.otp_action_feature.entity.OtpActionEntity;

@Mapper
public interface OtpActionInfraMapper {

    OtpActionInfraMapper INSTANCE = Mappers.getMapper(OtpActionInfraMapper.class);

    OtpActionModel map(OtpActionEntity otpActionEntity);

    OtpActionEntity map(OtpActionModel otpActionModel);

    List<OtpActionModel> _map(List<OtpActionEntity> otpActionEntities);

}

