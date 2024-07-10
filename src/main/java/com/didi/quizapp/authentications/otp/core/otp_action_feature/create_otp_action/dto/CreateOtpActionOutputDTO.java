package com.didi.quizapp.authentications.otp.core.otp_action_feature.create_otp_action.dto;

import java.math.BigDecimal;

import com.didi.quizapp.helpers.Equals;
import com.didi.quizapp.helpers.HashCode;
import com.didi.quizapp.helpers.ToString;
import com.didi.quizapp.authentications.shared.dto.MetaDataDTO;
import com.didi.quizapp.authentications.otp.core.otp_action_feature.shared.dto.OtpActionOutputDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;

public class CreateOtpActionOutputDTO {

    private OtpActionOutputDTO data;

    private MetaDataDTO metaData;

    private BigDecimal elapsedTime;

    public CreateOtpActionOutputDTO data(OtpActionOutputDTO data) {
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
    public OtpActionOutputDTO getData() {
        return data;
    }

    public void setData(OtpActionOutputDTO data) {
        this.data = data;
    }

    public CreateOtpActionOutputDTO metaData(MetaDataDTO metaData) {
        this.metaData = metaData;
        return this;
    }

    /**
     * Get metaData
     *
     * @return metaData
     */
    @Valid
    @Schema(name = "metaData", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("metaData")
    public MetaDataDTO getMetaData() {
        return metaData;
    }

    public void setMetaData(MetaDataDTO metaData) {
        this.metaData = metaData;
    }

    public CreateOtpActionOutputDTO elapsedTime(BigDecimal elapsedTime) {
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
