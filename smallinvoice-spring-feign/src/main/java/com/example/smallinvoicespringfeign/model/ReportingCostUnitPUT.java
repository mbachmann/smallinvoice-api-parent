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
 * ReportingCostUnitPUT
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-27T20:43:02.724916+02:00[Europe/Zurich]")
public class ReportingCostUnitPUT  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("number")
  private String number;

  @JsonProperty("name")
  private String name;

  @JsonProperty("description")
  private String description;

  @JsonProperty("type")
  private String type;

  public ReportingCostUnitPUT number(String number) {
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

  public ReportingCostUnitPUT name(String name) {
    this.name = name;
    return this;
  }

  /**
   * cost unit's name
   * @return name
  */
  @ApiModelProperty(value = "cost unit's name")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ReportingCostUnitPUT description(String description) {
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

  public ReportingCostUnitPUT type(String type) {
    this.type = type;
    return this;
  }

  /**
   * cost unit's type; one of: ['P','U']
   * @return type
  */
  @ApiModelProperty(value = "cost unit's type; one of: ['P','U']")


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
    ReportingCostUnitPUT reportingCostUnitPUT = (ReportingCostUnitPUT) o;
    return Objects.equals(this.number, reportingCostUnitPUT.number) &&
        Objects.equals(this.name, reportingCostUnitPUT.name) &&
        Objects.equals(this.description, reportingCostUnitPUT.description) &&
        Objects.equals(this.type, reportingCostUnitPUT.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(number, name, description, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReportingCostUnitPUT {\n");
    
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

