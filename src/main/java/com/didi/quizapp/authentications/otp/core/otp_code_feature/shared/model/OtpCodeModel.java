package com.didi.quizapp.authentications.otp.core.otp_code_feature.shared.model;

import com.didi.quizapp.authentications.shared.model.BaseModel;
import com.didi.quizapp.authentications.shared.utils.converters.GenericMapConverter;

import jakarta.persistence.Convert;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import java.time.OffsetDateTime;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
public class OtpCodeModel extends BaseModel {

    private String value;

    private OffsetDateTime expiresAt;

    private Set<String> methods;

    @Convert(converter = GenericMapConverter.class)
    private Map<String, Integer> attempts;

    @Convert(converter = GenericMapConverter.class)
    private Map<String, String> messages;

    private String recipient;

    @Builder.Default
    private boolean isInvalid = false;

    private UUID otpActionId;

    private UUID userId;


    /**
     * @return String return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * @return OffsetDateTime return the expiresAt
     */
    public OffsetDateTime getExpiresAt() {
        return expiresAt;
    }

    /**
     * @param expiresAt the expiresAt to set
     */
    public void setExpiresAt(OffsetDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }

    /**
     * @return Set<String> return the methods
     */
    public Set<String> getMethods() {
        return methods;
    }

    /**
     * @param methods the methods to set
     */
    public void setMethods(Set<String> methods) {
        this.methods = methods;
    }

    /**
     * @return Map<String, Integer> return the attempts
     */
    public Map<String, Integer> getAttempts() {
        return attempts;
    }

    /**
     * @param attempts the attempts to set
     */
    public void setAttempts(Map<String, Integer> attempts) {
        this.attempts = attempts;
    }

    /**
     * @return Map<String, String> return the messages
     */
    public Map<String, String> getMessages() {
        return messages;
    }

    /**
     * @param messages the messages to set
     */
    public void setMessages(Map<String, String> messages) {
        this.messages = messages;
    }

    /**
     * @return String return the recipient
     */
    public String getRecipient() {
        return recipient;
    }

    /**
     * @param recipient the recipient to set
     */
    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    /**
     * @return boolean return the isInvalid
     */
    public boolean isInvalid() {
        return isInvalid;
    }

    /**
     * @param isInvalid the isInvalid to set
     */
    public void setInvalid(boolean isInvalid) {
        this.isInvalid = isInvalid;
    }

    /**
     * @return UUID return the otpActionId
     */
    public UUID getOtpActionId() {
        return otpActionId;
    }

    /**
     * @param otpActionId the otpActionId to set
     */
    public void setOtpActionId(UUID otpActionId) {
        this.otpActionId = otpActionId;
    }

    /**
     * @return UUID return the userId
     */
    public UUID getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(UUID userId) {
        this.userId = userId;
    }

}
