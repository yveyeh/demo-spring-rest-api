package com.didi.quizapp.authentications.otp.infra.otp_action_feature.entity;

// import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import com.didi.quizapp.authentications.shared.entity.BaseEntity;
// import com.didi.quizapp.authentications.shared.utils.converters.EnumToStringConverter;
import com.didi.quizapp.authentications.shared.utils.converters.GenericMapConverter;
import com.didi.quizapp.authentications.shared.utils.converters.MethodSetConverter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.didi.quizapp.authentications.otp.infra.otp_action_feature.entity.parser.EnumTypeDeserializer;
import com.didi.quizapp.authentications.otp.infra.shared.enums.Method;
import com.didi.quizapp.authentications.otp.infra.shared.enums.OTPFormat;
import com.didi.quizapp.authentications.otp.infra.shared.enums.OTPType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SuperBuilder
@Table(name = "otp_actions")
public class OtpActionEntity extends BaseEntity {

    @Enumerated(EnumType.STRING)
    // @JsonDeserialize(using = EnumTypeDeserializer.class)
    @Column(name = "otp_type")
    private OTPType otpType;

    @Enumerated(EnumType.STRING)
    // @JsonDeserialize(using = EnumTypeDeserializer.class)
    @Column(name = "otp_format")
    private OTPFormat otpFormat;

    @Column(name = "authorized_methods")
    @Convert(converter = MethodSetConverter.class)
    private Set<Method> authorizedMethods;

    @Column(name = "duration")
    private Integer duration; // in seconds

    @Column(name = "templates", columnDefinition = "TEXT")
    @Convert(converter = GenericMapConverter.class)
    private Map<Method, Object> templates; // stored as a json string

    @Column(name = "max_attempts", columnDefinition = "TEXT")
    @Convert(converter = GenericMapConverter.class)
    private Map<Method, Integer> maxAttempts; // stored as a json string


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

