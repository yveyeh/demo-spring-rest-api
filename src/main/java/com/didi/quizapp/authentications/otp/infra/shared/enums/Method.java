package com.didi.quizapp.authentications.otp.infra.shared.enums;

import com.didi.quizapp.authentications.shared.utils.converters.EnumConverter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public enum Method {
    @JsonSerialize(using = EnumConverter.Serializer.class)
    @JsonDeserialize(using = EnumConverter.Deserializer.class)
    SMS,

    @JsonSerialize(using = EnumConverter.Serializer.class)
    @JsonDeserialize(using = EnumConverter.Deserializer.class)
    EMAIL,

    @JsonSerialize(using = EnumConverter.Serializer.class)
    @JsonDeserialize(using = EnumConverter.Deserializer.class)
    CALL, // VOICE

    @JsonSerialize(using = EnumConverter.Serializer.class)
    @JsonDeserialize(using = EnumConverter.Deserializer.class)
    PUSH // APP
}

