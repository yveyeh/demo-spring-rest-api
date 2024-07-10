package com.didi.quizapp.authentications.otp.app.otp_action_feature.create_otp_action.dto;

import com.didi.quizapp.authentications.otp.infra.shared.enums.Method;
import com.didi.quizapp.authentications.otp.infra.shared.enums.OTPFormat;
import com.didi.quizapp.authentications.otp.infra.shared.enums.OTPType;
import com.didi.quizapp.authentications.shared.utils.converters.GenericMapConverter;
import com.didi.quizapp.helpers.Equals;
import com.didi.quizapp.helpers.HashCode;
import com.didi.quizapp.helpers.ToString;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Convert;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.Map;
import java.util.Set;
import org.springframework.format.annotation.DateTimeFormat;

public class CreateOtpActionRequestDTO {

    private OTPType otpType;

    private OTPFormat otpFormat;

    private Set<Method> authorizedMethods;

    private Integer duration;

    @Convert(converter = GenericMapConverter.class)
    private Map<Method, Object> templates;

    @Convert(converter = GenericMapConverter.class)
    private Map<Method, Integer> maxAttempts;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime createdAt;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime updatedAt;

    /**
     * Set the OTP type field.
     *
     * @param otpType The OTP type to set
     * @return The modified CreateOtpActionRequestDTO instance
     */
    public CreateOtpActionRequestDTO otpType(OTPType otpType) {
        this.otpType = otpType;
        return this;
    }

    /**
     * @return The OTP type
     */
    @Valid
    @Schema(name = "otp_type", description = "The OTP type", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("otp_type")
    public OTPType getOtpType() {
        return otpType;
    }

    /**
     * @param otpType the OTP type to set
     */
    @JsonProperty("otp_type")
    public void setOtpType(OTPType otpType) {
        this.otpType = otpType;
    }

    public CreateOtpActionRequestDTO createdAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * The creation date of the otp action
     * 
     * @return createdAt
     */
    @Valid
    @Schema(name = "created_at", description = "The creation date of the otp action", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("created_at")
    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("created_at")
    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public CreateOtpActionRequestDTO updatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    /**
     * The last modified date of the otp action
     * 
     * @return updatedAt
     */
    @Valid
    @Schema(name = "updated_at", description = "The last modified date of the otp action", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("updated_at")
    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    @JsonProperty("updated_at")
    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * Set the otp format field.
     *
     * @param otpFormat The otp format to set
     * @return The modified CreateOtpActionRequestDTO instance
     */
    public CreateOtpActionRequestDTO otpFormat(OTPFormat otpFormat) {
        this.otpFormat = otpFormat;
        return this;
    }

    /**
     * @return The OTP format
     */
    @Valid
    @Schema(name = "otp_format", description = "The OTP format", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("otp_format")
    public OTPFormat getOtpFormat() {
        return otpFormat;
    }

    /**
     * @param otpFormat the OTP format to set
     */
    @JsonProperty("otp_format")
    public void setOtpFormat(OTPFormat otpFormat) {
        this.otpFormat = otpFormat;
    }

    /**
     * Set the authorizedMethods field.
     *
     * @param authorizedMethods The authorizedMethods value to set
     * @return The modified CreateOtpActionRequestDTO instance
     */
    public CreateOtpActionRequestDTO authorizedMethods(Set<Method> authorizedMethods) {
        this.authorizedMethods = authorizedMethods;
        return this;
    }

    /**
     * @return The authorized methods
     */
    @Valid
    @Schema(name = "authorized_methods", description = "The authorized notification methods for an otp action", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("authorized_methods")
    public Set<Method> getAuthorizedMethods() {
        return authorizedMethods;
    }

    /**
     * @param authorizedMethods The authorizedMethods value to set
     */
    @JsonProperty("authorized_methods")
    public void setAuthorizedMethods(Set<Method> authorizedMethods) {
        this.authorizedMethods = authorizedMethods;
    }

    /**
     * Set the duration field.
     *
     * @param duration The duration in seconds to set
     * @return The modified CreateOtpActionRequestDTO instance
     */
    public CreateOtpActionRequestDTO duration(Integer duration) {
        this.duration = duration;
        return this;
    }

    /**
     * @return The duration in seconds
     */
    @Valid
    @Schema(name = "duration", description = "The OTP duration", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("duration")
    public Integer getDuration() {
        return duration;
    }

    /**
     * @param duration The duration in seconds to set
     */
    @JsonProperty("duration")
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    /**
     * Set the templates field.
     *
     * @param templates The templates to set
     * @return The modified CreateOtpActionRequestDTO instance
     */
    public CreateOtpActionRequestDTO templates(Map<Method, Object> templates) {
        this.templates = templates;
        return this;
    }

    /**
     * @return return the templates
     */
    @Valid
    @Schema(name = "templates", description = "The OTP message templates", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("templates")
    public Map<Method, Object> getTemplates() {
        return templates;
    }

    /**
     * @param templates The templates to set
     */
    @JsonProperty("templates")
    public void setTemplates(Map<Method, Object> templates) {
        this.templates = templates;
    }

    /**
     * Set the maxAttempts field.
     *
     * @param maxAttempts The maxAttempts value to set
     * @return The modified CreateOtpActionRequestDTO instance
     */
    public CreateOtpActionRequestDTO maxAttempts(Map<Method, Integer> maxAttempts) {
        this.maxAttempts = maxAttempts;
        return this;
    }

    /**
     * @return the max attempts allowed per method
     */
    @Valid
    @Schema(name = "max_attempts", description = "The maximum number of attempts to verify an OTP", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("max_attempts")
    public Map<Method, Integer> getMaxAttempts() {
        return maxAttempts;
    }

    /**
     * @param maxAttempts The maxAttempts value to set
     */
    @JsonProperty("max_attempts")
    public void setMaxAttempts(Map<Method, Integer> maxAttempts) {
        this.maxAttempts = maxAttempts;
    }

    @Override
    public boolean equals(Object object) {
        return Equals.equals(this, object);
    }

    @Override
    public int hashCode() {
        return HashCode.hashCode(this);
    }

    @Override
    public String toString() {
        return ToString.toString(this);
    }

}
