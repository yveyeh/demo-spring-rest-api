package com.didi.quizapp.authentications.shared.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Objects;

/**
 * MetaDataDTO
 */

public class MetaDataDTO {

  private Integer page;

  private Integer count;

  private Integer size;

  private Integer totalCount;

  private Integer totalPages;

  public MetaDataDTO page(Integer page) {
    this.page = page + 1;
    return this;
  }

  /**
   * Numeric position of the current page
   * @return page
  */
  
  @Schema(name = "page", description = "Numeric position of the current page", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("page")
  public Integer getPage() {
    return page + 1;
  }

  public void setPage(Integer page) {
    this.page = page;
  }

  public MetaDataDTO count(Integer count) {
    this.count = count;
    return this;
  }

  /**
   * Number of items on the current page
   * @return count
  */
  
  @Schema(name = "count", description = "Number of items on the current page", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("count")
  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }

  public MetaDataDTO size(Integer size) {
    this.size = size;
    return this;
  }

  /**
   * Maximum number of items configured to have on each page
   * @return size
  */
  
  @Schema(name = "size", description = "Maximum number of items configured to have on each page", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("size")
  public Integer getSize() {
    return size;
  }

  public void setSize(Integer size) {
    this.size = size;
  }

  public MetaDataDTO totalCount(Integer totalCount) {
    this.totalCount = totalCount;
    return this;
  }

  /**
   * Total number of items concerning by the initial request
   * @return totalCount
  */
  
  @Schema(name = "total_count", description = "Total number of items concerning by the initial request", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("total_count")
  public Integer getTotalCount() {
    return totalCount;
  }

  public void setTotalCount(Integer totalCount) {
    this.totalCount = totalCount;
  }

  public MetaDataDTO totalPages(Integer totalPages) {
    this.totalPages = totalPages;
    return this;
  }

  /**
   * Total number of pages concerning by the initial request
   * @return totalPages
  */
  
  @Schema(name = "total_pages", description = "Total number of pages concerning by the initial request", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("total_pages")
  public Integer getTotalPages() {
    return totalPages;
  }

  public void setTotalPages(Integer totalPages) {
    this.totalPages = totalPages;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MetaDataDTO metaDataDTO = (MetaDataDTO) o;
    return Objects.equals(this.page, metaDataDTO.page) &&
        Objects.equals(this.count, metaDataDTO.count) &&
        Objects.equals(this.size, metaDataDTO.size) &&
        Objects.equals(this.totalCount, metaDataDTO.totalCount) &&
        Objects.equals(this.totalPages, metaDataDTO.totalPages);
  }

  @Override
  public int hashCode() {
    return Objects.hash(page, count, size, totalCount, totalPages);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MetaDataDTO {\n");
    sb.append("    page: ").append(toIndentedString(page)).append("\n");
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
    sb.append("    totalCount: ").append(toIndentedString(totalCount)).append("\n");
    sb.append("    totalPages: ").append(toIndentedString(totalPages)).append("\n");
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

