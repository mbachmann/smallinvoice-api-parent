package com.example.smallinvoicespringfeign.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;

/**
 * Response403meta
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-29T19:43:05.733009+02:00[Europe/Zurich]")
public class Response403meta  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("feature")
  private String feature;

  @JsonProperty("plans")
  @Valid
  private List<String> plans = new ArrayList<>();

  public Response403meta feature(String feature) {
    this.feature = feature;
    return this;
  }

  /**
   * feature that is missing
   * @return feature
  */
  @ApiModelProperty(required = true, value = "feature that is missing")
  @NotNull


  public String getFeature() {
    return feature;
  }

  public void setFeature(String feature) {
    this.feature = feature;
  }

  public Response403meta plans(List<String> plans) {
    this.plans = plans;
    return this;
  }

  public Response403meta addPlansItem(String plansItem) {
    this.plans.add(plansItem);
    return this;
  }

  /**
   * plans that provide missing feature
   * @return plans
  */
  @ApiModelProperty(required = true, value = "plans that provide missing feature")
  @NotNull


  public List<String> getPlans() {
    return plans;
  }

  public void setPlans(List<String> plans) {
    this.plans = plans;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Response403meta response403meta = (Response403meta) o;
    return Objects.equals(this.feature, response403meta.feature) &&
        Objects.equals(this.plans, response403meta.plans);
  }

  @Override
  public int hashCode() {
    return Objects.hash(feature, plans);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Response403meta {\n");
    
    sb.append("    feature: ").append(toIndentedString(feature)).append("\n");
    sb.append("    plans: ").append(toIndentedString(plans)).append("\n");
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

