package com.didi.quizapp.authentications.otp.app.otp_action_feature.update_otp_action.dto;

import com.didi.quizapp.authentications.otp.app.otp_action_feature.shared.dto.OtpActionResponseDTO;
import com.didi.quizapp.authentications.shared.dto.MetaDataDTO;
import java.util.Objects;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * UpdateOtpActionResponseDTO
 */

public class UpdateOtpActionResponseDTO {

  private OtpActionResponseDTO data;

  private MetaDataDTO metadata;

  private BigDecimal elapsedTime;

  public UpdateOtpActionResponseDTO data(OtpActionResponseDTO data) {
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
  public OtpActionResponseDTO getData() {
    return data;
  }

  public void setData(OtpActionResponseDTO data) {
    this.data = data;
  }

  public UpdateOtpActionResponseDTO metadata(MetaDataDTO metadata) {
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

  public UpdateOtpActionResponseDTO elapsedTime(BigDecimal elapsedTime) {
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
    UpdateOtpActionResponseDTO updateOtpActionResponseDTO = (UpdateOtpActionResponseDTO) o;
    return Objects.equals(this.data, updateOtpActionResponseDTO.data) &&
        Objects.equals(this.metadata, updateOtpActionResponseDTO.metadata) &&
        Objects.equals(this.elapsedTime, updateOtpActionResponseDTO.elapsedTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, metadata, elapsedTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateOtpActionResponseDTO {\n");
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
