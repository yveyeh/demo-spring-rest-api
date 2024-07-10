package com.didi.quizapp.authentications.otp.core.otp_code_feature.update_otp_code.dto;

import com.didi.quizapp.helpers.Equals;
import com.didi.quizapp.helpers.HashCode;
import com.didi.quizapp.helpers.ToString;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.validation.Valid;
import lombok.Builder;
import lombok.experimental.SuperBuilder;

import java.time.OffsetDateTime;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * UpdateOtpCodeInputDTO
 */

@SuperBuilder
public class UpdateOtpCodeInputDTO {

    private String value;

    private OffsetDateTime expiresAt;

    private Set<String> methods;

    private Map<String, Integer> attempts;

    private Map<String, String> messages;

    private String recipient;

    @Builder.Default
    private boolean isInvalid = false;

    private UUID otpActionId;

    private UUID userId;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime createdAt;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime updatedAt;


    /**
     * The creation date of the otp code
     * 
     * @return createdAt
     */
    @Valid
    @Schema(name = "created_at", description = "The creation date of the otp code", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("created_at")
    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("created_at")
    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public UpdateOtpCodeInputDTO updatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    /**
     * The last modified date of the otp code
     * 
     * @return updatedAt
     */
    @Valid
    @Schema(name = "updated_at", description = "The last modified date of the otp code", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("updated_at")
    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    @JsonProperty("updated_at")
    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public UpdateOtpCodeInputDTO value(String value) {
        this.value = value;
        return this;
    }

    /**
     * The otp code value
     * 
     * @return value
     */
    @Valid
    @Schema(name = "value", description = "The otp code value", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(String value) {
        this.value = value;
    }

    public UpdateOtpCodeInputDTO expiresAt(OffsetDateTime expiresAt) {
        this.expiresAt = expiresAt;
        return this;
    }

    /**
     * The expiration date of the otp code
     * 
     * @return expiresAt
     */
    @Valid
    @Schema(name = "expires_at", description = "The expiration date of the otp code", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("expires_at")
    public OffsetDateTime getExpiresAt() {
        return expiresAt;
    }

    @JsonProperty("expires_at")
    public void setExpiresAt(OffsetDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }

    public UpdateOtpCodeInputDTO methods(Set<String> methods) {
        this.methods = methods;
        return this;
    }

    /**
     * The methods that the otp code can be used
     * 
     * @return methods
     */
    @Valid
    @Schema(name = "methods", description = "The methods that the otp code can be used", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("methods")
    public Set<String> getMethods() {
        return methods;
    }

    @JsonProperty("methods")
    public void setMethods(Set<String> methods) {
        this.methods = methods;
    }

    public UpdateOtpCodeInputDTO attempts(Map<String, Integer> attempts) {
        this.attempts = attempts;
        return this;
    }

    /**
     * The number of attempts made to use the otp code
     * 
     * @return attempts
     */
    @Valid
    @Schema(name = "attempts", description = "The number of attempts made to use the otp code", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("attempts")
    public Map<String, Integer> getAttempts() {
        return attempts;
    }

    @JsonProperty("attempts")
    public void setAttempts(Map<String, Integer> attempts) {
        this.attempts = attempts;
    }

    public UpdateOtpCodeInputDTO messages(Map<String, String> messages) {
        this.messages = messages;
        return this;
    }

    /**
     * The messages associated with the otp code
     * 
     * @return messages
     */
    @Valid
    @Schema(name = "messages", description = "The messages associated with the otp code", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("messages")
    public Map<String, String> getMessages() {
        return messages;
    }

    @JsonProperty("messages")
    public void setMessages(Map<String, String> messages) {
        this.messages = messages;
    }

    public UpdateOtpCodeInputDTO recipient(String recipient) {
        this.recipient = recipient;
        return this;
    }

    /**
     * The recipient of the otp code
     * 
     * @return recipient
     */
    @Valid
    @Schema(name = "recipient", description = "The recipient of the otp code", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("recipient")
    public String getRecipient() {
        return recipient;
    }

    @JsonProperty("recipient")
    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public UpdateOtpCodeInputDTO isInvalid(Boolean isInvalid) {
        this.isInvalid = isInvalid;
        return this;
    }

    /**
     * Indicates whether the otp code is invalid
     * 
     * @return isInvalid
     */
    @Valid
    @Schema(name = "is_invalid", description = "Indicates whether the otp code is invalid", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("is_invalid")
    public Boolean isInvalid() {
        return isInvalid;
    }

    @JsonProperty("is_invalid")
    public void setInvalid(Boolean isInvalid) {
        this.isInvalid = isInvalid;
    }

    public UpdateOtpCodeInputDTO otpActionId(UUID otpActionId) {
        this.otpActionId = otpActionId;
        return this;
    }

    /**
     * The ID of the OTP action associated with the otp code
     * 
     * @return otpActionId
     */
    @Valid
    @Schema(name = "otp_action_id", description = "The ID of the OTP action associated with the otp code", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("otp_action_id")
    public UUID getOtpActionId() {
        return otpActionId;
    }

    @JsonProperty("otp_action_id")
    public void setOtpActionId(UUID otpActionId) {
        this.otpActionId = otpActionId;
    }

    public UpdateOtpCodeInputDTO userId(UUID userId) {
        this.userId = userId;
        return this;
    }

    /**
     * The ID of the user associated with the otp code
     * 
     * @return userId
     */
    @Valid
    @Schema(name = "user_id", description = "The ID of the user associated with the otp code", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("user_id")
    public UUID getUserId() {
        return userId;
    }

    @JsonProperty("user_id")
    public void setUserId(UUID userId) {
        this.userId = userId;
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
