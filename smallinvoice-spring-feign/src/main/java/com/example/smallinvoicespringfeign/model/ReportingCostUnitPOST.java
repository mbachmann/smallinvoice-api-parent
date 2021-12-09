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
 * ReportingCostUnitPOST
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-12-09T09:40:26.748128+01:00[Europe/Zurich]")
public class ReportingCostUnitPOST  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("number")
  private String number;

  @JsonProperty("name")
  private String name;

  @JsonProperty("description")
  private String description;

  @JsonProperty("type")
  private String type;

  public ReportingCostUnitPOST number(String number) {
    this.number = number;
    return this;
  }

  /**
   * cost unit's internal number
   * @return number
  */
  @ApiModelProperty(value = "cost unit's internal number")


  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public ReportingCostUnitPOST name(String name) {
    this.name = name;
    return this;
  }

  /**
   * cost unit's name
   * @return name
  */
  @ApiModelProperty(required = true, value = "cost unit's name")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ReportingCostUnitPOST description(String description) {
    this.description = description;
    return this;
  }

  /**
   * cost unit's description
   * @return description
  */
  @ApiModelProperty(value = "cost unit's description")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ReportingCostUnitPOST type(String type) {
    this.type = type;
    return this;
  }

  /**
   * cost unit's type; one of: ['P','U']
   * @return type
  */
  @ApiModelProperty(required = true, value = "cost unit's type; one of: ['P','U']")
  @NotNull


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReportingCostUnitPOST reportingCostUnitPOST = (ReportingCostUnitPOST) o;
    return Objects.equals(this.number, reportingCostUnitPOST.number) &&
        Objects.equals(this.name, reportingCostUnitPOST.name) &&
        Objects.equals(this.description, reportingCostUnitPOST.description) &&
        Objects.equals(this.type, reportingCostUnitPOST.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(number, name, description, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReportingCostUnitPOST {\n");
    
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

