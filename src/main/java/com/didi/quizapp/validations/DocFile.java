package com.didi.quizapp.validations;

import java.util.Date;
import java.util.UUID;

import com.didi.quizapp.utilities.storage.File;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class DocFile extends File {

    public static final DocFileStatusEnum DEFAULT_STATUS = DocFileStatusEnum.MISSING;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String description;

    private boolean verified = false;

    private Date verifiedAt;

    @Enumerated(EnumType.STRING)
    private DocFileStatusEnum verificationStatus;

    private UUID verifiedBy;

    private UUID docFileTypeId;

    private UUID idDocId;

    public DocFile() {
        super();
    }


    // 
    @Override
    protected File getFileProperties(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProperties'");
    }


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
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return String return the path
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path The path to set
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * @return float return the size
     */
    public float getSize() {
        return size;
    }

    /**
     * @param size The size to set
     */
    public void setSize(float size) {
        this.size = size;
    }

    /**
     * @return String return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return boolean return the verified
     */
    public boolean isVerified() {
        return verified;
    }

    /**
     * @param verified the verified to set
     */
    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    /**
     * @return Date return the verifiedAt
     */
    public Date getVerifiedAt() {
        return verifiedAt;
    }

    /**
     * @param verifiedAt the verifiedAt to set
     */
    public void setVerifiedAt(Date verifiedAt) {
        this.verifiedAt = verifiedAt;
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
     * @return UUID return the docFileTypeId
     */
    public UUID getDocFileTypeId() {
        return docFileTypeId;
    }

    /**
     * @param docFileTypeId the docFileTypeId to set
     */
    public void setDocFileTypeId(UUID docFileTypeId) {
        this.docFileTypeId = docFileTypeId;
    }

    /**
     * @return UUID return the idDocId
     */
    public UUID getIdDocId() {
        return idDocId;
    }

    /**
     * @param idDocId the idDocId to set
     */
    public void setIdDocId(UUID idDocId) {
        this.idDocId = idDocId;
    }

}
