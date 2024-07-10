package com.didi.quizapp.authentications.shared.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import jakarta.validation.Valid;

import io.swagger.v3.oas.annotations.media.Schema;


/**
 * ResponseErrorDTO
 */

public class ResponseErrorDTO {

  private ErrorDTO error;

  private BigDecimal elapsedTime;

  public ResponseErrorDTO error(ErrorDTO error) {
    this.error = error;
    return this;
  }

  /**
   * Get error
   * @return error
  */
  @Valid 
  @Schema(name = "error", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("error")
  public ErrorDTO getError() {
    return error;
  }

  public void setError(ErrorDTO error) {
    this.error = error;
  }

  public ResponseErrorDTO elapsedTime(BigDecimal elapsedTime) {
    this.elapsedTime = elapsedTime;
    return this;
  }

  /**
   * Time elapsed between the start and the end of request
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
    ResponseErrorDTO responseErrorDTO = (ResponseErrorDTO) o;
    return Objects.equals(this.error, responseErrorDTO.error) &&
        Objects.equals(this.elapsedTime, responseErrorDTO.elapsedTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(error, elapsedTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResponseErrorDTO {\n");
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
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

