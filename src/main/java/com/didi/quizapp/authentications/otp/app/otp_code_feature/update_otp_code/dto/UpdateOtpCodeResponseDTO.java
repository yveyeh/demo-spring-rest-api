package com.didi.quizapp.authentications.otp.app.otp_code_feature.update_otp_code.dto;

import com.didi.quizapp.authentications.otp.app.otp_code_feature.shared.dto.OtpCodeResponseDTO;
import com.didi.quizapp.authentications.shared.dto.MetaDataDTO;
import java.util.Objects;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * UpdateOtpCodeResponseDTO
 */

public class UpdateOtpCodeResponseDTO {

  private OtpCodeResponseDTO data;

  private MetaDataDTO metadata;

  private BigDecimal elapsedTime;

  public UpdateOtpCodeResponseDTO data(OtpCodeResponseDTO data) {
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
  public OtpCodeResponseDTO getData() {
    return data;
  }

  public void setData(OtpCodeResponseDTO data) {
    this.data = data;
  }

  public UpdateOtpCodeResponseDTO metadata(MetaDataDTO metadata) {
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

  public UpdateOtpCodeResponseDTO elapsedTime(BigDecimal elapsedTime) {
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
    UpdateOtpCodeResponseDTO updateOtpCodeResponseDTO = (UpdateOtpCodeResponseDTO) o;
    return Objects.equals(this.data, updateOtpCodeResponseDTO.data) &&
        Objects.equals(this.metadata, updateOtpCodeResponseDTO.metadata) &&
        Objects.equals(this.elapsedTime, updateOtpCodeResponseDTO.elapsedTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, metadata, elapsedTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateOtpCodeResponseDTO {\n");
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
