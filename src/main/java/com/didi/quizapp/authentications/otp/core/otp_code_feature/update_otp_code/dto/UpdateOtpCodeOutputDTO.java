package com.didi.quizapp.authentications.otp.core.otp_code_feature.update_otp_code.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.didi.quizapp.authentications.otp.core.otp_code_feature.shared.dto.OtpCodeOutputDTO;
import com.didi.quizapp.authentications.shared.dto.MetaDataDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * UpdateOtpCodeOutputDTO
 */

public class UpdateOtpCodeOutputDTO {

  private OtpCodeOutputDTO data;

  private MetaDataDTO metadata;

  private BigDecimal elapsedTime;

  public UpdateOtpCodeOutputDTO data(OtpCodeOutputDTO data) {
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

  public UpdateOtpCodeOutputDTO metadata(MetaDataDTO metadata) {
    this.metadata = metadata;
    return this;
  }

  /**
   * Get metadata
   * 
   * @return metadata
   */
  @Valid
  @Schema(name = "metadata", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("metadata")
  public MetaDataDTO getMetadata() {
    return metadata;
  }

  public void setMetadata(MetaDataDTO metadata) {
    this.metadata = metadata;
  }

  public UpdateOtpCodeOutputDTO elapsedTime(BigDecimal elapsedTime) {
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
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateOtpCodeOutputDTO updateOtpCodeOutputDTO = (UpdateOtpCodeOutputDTO) o;
    return Objects.equals(this.data, updateOtpCodeOutputDTO.data) &&
        Objects.equals(this.metadata, updateOtpCodeOutputDTO.metadata) &&
        Objects.equals(this.elapsedTime, updateOtpCodeOutputDTO.elapsedTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, metadata, elapsedTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateOtpCodeOutputDTO {\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    elapsedTime: ").append(toIndentedString(elapsedTime)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
