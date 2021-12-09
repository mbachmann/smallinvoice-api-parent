package com.example.smallinvoicespringfeign.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;

/**
 * Response402meta
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-12-09T09:40:26.748128+01:00[Europe/Zurich]")
public class Response402meta  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("feature")
  private String feature;

  @JsonProperty("limit")
  private Integer limit;

  public Response402meta feature(String feature) {
    this.feature = feature;
    return this;
  }

  /**
   * feature that limit was reached
   * @return feature
  */
  @ApiModelProperty(required = true, value = "feature that limit was reached")
  @NotNull


  public String getFeature() {
    return feature;
  }

  public void setFeature(String feature) {
    this.feature = feature;
  }

  public Response402meta limit(Integer limit) {
    this.limit = limit;
    return this;
  }

  /**
   * reached limit value
   * @return limit
  */
  @ApiModelProperty(required = true, value = "reached limit value")
  @NotNull


  public Integer getLimit() {
    return limit;
  }

  public void setLimit(Integer limit) {
    this.limit = limit;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Response402meta response402meta = (Response402meta) o;
    return Objects.equals(this.feature, response402meta.feature) &&
        Objects.equals(this.limit, response402meta.limit);
  }

  @Override
  public int hashCode() {
    return Objects.hash(feature, limit);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Response402meta {\n");
    
    sb.append("    feature: ").append(toIndentedString(feature)).append("\n");
    sb.append("    limit: ").append(toIndentedString(limit)).append("\n");
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

