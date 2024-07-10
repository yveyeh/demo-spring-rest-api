package com.didi.quizapp.authentications.otp.core.otp_code_feature.consult_otp_code_details.dto;

import com.didi.quizapp.helpers.Equals;
import com.didi.quizapp.helpers.HashCode;
import com.didi.quizapp.helpers.ToString;
import com.didi.quizapp.authentications.otp.core.otp_code_feature.shared.dto.OtpCodeOutputDTO;
import com.didi.quizapp.authentications.shared.dto.MetaDataDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import java.math.BigDecimal;

public class ConsultOtpCodeDetailsOutputDTO {

    private OtpCodeOutputDTO data;

    private MetaDataDTO metaData;

    private BigDecimal elapsedTime;

    public ConsultOtpCodeDetailsOutputDTO data(OtpCodeOutputDTO data) {
        this.data = data;
        return this;
    }

    /**
     * Get data
     * 
     * @return data
     */
    @Valid
    @Schema(name = "data", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("data")
    public OtpCodeOutputDTO getData() {
        return data;
    }

    public void setData(OtpCodeOutputDTO data) {
        this.data = data;
    }

    public ConsultOtpCodeDetailsOutputDTO metaData(MetaDataDTO metaData) {
        this.metaData = metaData;
        return this;
    }

    /**
     * Get meta_data
     * 
     * @return meta_data
     */
    @Valid
    @Schema(name = "meta_data", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("meta_data")
    public MetaDataDTO getMetaData() {
        return metaData;
    }

    public void setMetaData(MetaDataDTO metaData) {
        this.metaData = metaData;
    }

    public ConsultOtpCodeDetailsOutputDTO elapsedTime(BigDecimal elapsedTime) {
        this.elapsedTime = elapsedTime;
        return this;
    }

    /**
     * Time elapsed between the start and the end of request
     * 
     * @return elapsedTime
     */
    @Valid
    @Schema(name = "elapsed_time", description = "Time elapsed between the start and the end of request", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("elapsed_time")
    public BigDecimal getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(BigDecimal elapsedTime) {
        this.elapsedTime = elapsedTime;
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
