package com.didi.quizapp.authentications.otp.core.otp_action_feature.shared.model;

import com.didi.quizapp.authentications.shared.model.BaseModel;
import com.didi.quizapp.authentications.shared.utils.converters.GenericMapConverter;
import com.didi.quizapp.authentications.shared.utils.converters.MethodSetConverter;

import jakarta.persistence.Convert;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import com.didi.quizapp.authentications.otp.infra.shared.enums.Method;
import com.didi.quizapp.authentications.otp.infra.shared.enums.OTPFormat;
import com.didi.quizapp.authentications.otp.infra.shared.enums.OTPType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import java.util.Map;
import java.util.Set;


@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
public class OtpActionModel extends BaseModel {

    @Enumerated(EnumType.STRING)
    private OTPType otpType;

    @Enumerated(EnumType.STRING)
    private OTPFormat otpFormat;

    @Convert(converter = MethodSetConverter.class)
    private Set<Method> authorizedMethods;

    private Integer duration; // in seconds

    @Convert(converter = GenericMapConverter.class)
    private Map<Method, Object> templates;

    @Convert(converter = GenericMapConverter.class)
    private Map<Method, Integer> maxAttempts;


    /**
     * @return OTPType return the otpType
     */
    public OTPType getOtpType() {
        return otpType;
    }

    /**
     * @param otpType the otpType to set
     */
    public void setOtpType(OTPType otpType) {
        this.otpType = otpType;
    }

    /**
     * @return OTPFormat return the otpFormat
     */
    public OTPFormat getOtpFormat() {
        return otpFormat;
    }

    /**
     * @param otpFormat the otpFormat to set
     */
    public void setOtpFormat(OTPFormat otpFormat) {
        this.otpFormat = otpFormat;
    }

    /**
     * @return Set<Method> return the authorizedMethods
     */
    public Set<Method> getAuthorizedMethods() {
        return authorizedMethods;
    }

    /**
     * @param authorizedMethods the authorizedMethods to set
     */
    public void setAuthorizedMethods(Set<Method> authorizedMethods) {
        this.authorizedMethods = authorizedMethods;
    }

    /**
     * @return Integer return the duration
     */
    public Integer getDuration() {
        return duration;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    /**
     * @return Map<Method, Object> return the templates
     */
    public Map<Method, Object> getTemplates() {
        return templates;
    }

    /**
     * @param templates the templates to set
     */
    public void setTemplates(Map<Method, Object> templates) {
        this.templates = templates;
    }

    /**
     * @return Map<Method, Integer> return the maxAttempts
     */
    public Map<Method, Integer> getMaxAttempts() {
        return maxAttempts;
    }

    /**
     * @param maxAttempts the maxAttempts to set
     */
    public void setMaxAttempts(Map<Method, Integer> maxAttempts) {
        this.maxAttempts = maxAttempts;
    }

}
