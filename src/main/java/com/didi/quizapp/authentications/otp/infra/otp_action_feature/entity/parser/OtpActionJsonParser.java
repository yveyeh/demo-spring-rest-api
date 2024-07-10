package com.didi.quizapp.authentications.otp.infra.otp_action_feature.entity.parser;

import com.didi.quizapp.authentications.otp.infra.otp_action_feature.entity.OtpActionEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class OtpActionJsonParser {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static OtpActionEntity parseOtpActionFromJson(String jsonString) throws Exception {
        try {
            return objectMapper.readValue(jsonString, OtpActionEntity.class);
        } catch (Exception e) {
            // Handle parsing exception gracefully
            throw new Exception("Error parsing OtpAction JSON: " + e.getMessage());
        }
    }

    public static String serializeOtpActionToJson(OtpActionEntity otpAction) throws JsonProcessingException {
        return objectMapper.writeValueAsString(otpAction);
    }
}
