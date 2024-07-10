package com.didi.quizapp.authentications.otp.infra.otp_code_feature.entity;

import java.time.OffsetDateTime;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import com.didi.quizapp.authentications.shared.entity.BaseEntity;
import com.didi.quizapp.authentications.shared.utils.converters.GenericMapConverter;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Entity
@SuperBuilder
@Table(name = "otp_codes")
public class OtpCodeEntity extends BaseEntity {

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
