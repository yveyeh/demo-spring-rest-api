package com.didi.quizapp.validations;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class DocFileVerification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private LocalDateTime verifiedAt;

    private UUID verifiedBy;

    @Enumerated(EnumType.STRING)
    private DocFileStatusEnum verificationStatus;

    private boolean callMade = false;

    private UUID rejectReasonId;

    private UUID docFileId;


    /**
     * @return UUID return the id
     */
    public UUID getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * @return LocalDateTime return the verifiedAt
     */
    public LocalDateTime getVerifiedAt() {
        return verifiedAt;
    }

    /**
     * @param verifiedAt the verifiedAt to set
     */
    public void setVerifiedAt(LocalDateTime verifiedAt) {
        this.verifiedAt = verifiedAt;
    }

    /**
     * @return UUID return the verifiedBy
     */
    public UUID getVerifiedBy() {
        return verifiedBy;
    }

    /**
     * @param verifiedBy the verifiedBy to set
     */
    public void setVerifiedBy(UUID verifiedBy) {
        this.verifiedBy = verifiedBy;
    }

    /**
     * @return DocFileStatusEnum return the verificationStatus
     */
    public DocFileStatusEnum getVerificationStatus() {
        return verificationStatus;
    }

    /**
     * @param verificationStatus the verificationStatus to set
     */
    public void setVerificationStatus(DocFileStatusEnum verificationStatus) {
        this.verificationStatus = verificationStatus;
    }

    /**
     * @return boolean return the callMade
     */
    public boolean isCallMade() {
        return callMade;
    }

    /**
     * @param callMade the callMade to set
     */
    public void setCallMade(boolean callMade) {
        this.callMade = callMade;
    }


    /**
     * @return UUID return the rejectReasonId
     */
    public UUID getRejectReasonId() {
        return rejectReasonId;
    }

    /**
     * @param rejectReasonId the rejectReasonId to set
     */
    public void setRejectReasonId(UUID rejectReasonId) {
        this.rejectReasonId = rejectReasonId;
    }

    /**
     * @return UUID return the docFileId
     */
    public UUID getDocFileId() {
        return docFileId;
    }

    /**
     * @param docFileId the docFileId to set
     */
    public void setDocFileId(UUID docFileId) {
        this.docFileId = docFileId;
    }

}
