package com.example.smallinvoicespringfeign.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;

/**
 * ReportingProjectPUT
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-08-03T10:50:58.837+02:00[Europe/Zurich]")
public class ReportingProjectPUT  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("number")
  private String number;

  @JsonProperty("contact_id")
  private Integer contactId;

  @JsonProperty("name")
  private String name;

  @JsonProperty("description")
  private String description;

  @JsonProperty("start_date")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE)
  private LocalDate startDate;

  @JsonProperty("hours_estimated")
  private Float hoursEstimated;

  @JsonProperty("hourly_rate")
  private Float hourlyRate;

  public ReportingProjectPUT number(String number) {
    this.number = number;
    return this;
  }

  /**
   * project's internal number
   * @return number
  */
  @ApiModelProperty(value = "project's internal number")


  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public ReportingProjectPUT contactId(Integer contactId) {
    this.contactId = contactId;
    return this;
  }

  /**
   * related contact's id
   * @return contactId
  */
  @ApiModelProperty(value = "related contact's id")


  public Integer getContactId() {
    return contactId;
  }

  public void setContactId(Integer contactId) {
    this.contactId = contactId;
  }

  public ReportingProjectPUT name(String name) {
    this.name = name;
    return this;
  }

  /**
   * project's name
   * @return name
  */
  @ApiModelProperty(value = "project's name")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ReportingProjectPUT description(String description) {
    this.description = description;
    return this;
  }

  /**
   * project's description
   * @return description
  */
  @ApiModelProperty(value = "project's description")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ReportingProjectPUT startDate(LocalDate startDate) {
    this.startDate = startDate;
    return this;
  }

  /**
   * project's start date
   * @return startDate
  */
  @ApiModelProperty(value = "project's start date")

  @Valid

  public LocalDate getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }

  public ReportingProjectPUT hoursEstimated(Float hoursEstimated) {
    this.hoursEstimated = hoursEstimated;
    return this;
  }

  /**
   * project's estimated maximum effort (in hours)
   * @return hoursEstimated
  */
  @ApiModelProperty(value = "project's estimated maximum effort (in hours)")


  public Float getHoursEstimated() {
    return hoursEstimated;
  }

  public void setHoursEstimated(Float hoursEstimated) {
    this.hoursEstimated = hoursEstimated;
  }

  public ReportingProjectPUT hourlyRate(Float hourlyRate) {
    this.hourlyRate = hourlyRate;
    return this;
  }

  /**
   * project's hourly rate
   * @return hourlyRate
  */
  @ApiModelProperty(value = "project's hourly rate")


  public Float getHourlyRate() {
    return hourlyRate;
  }

  public void setHourlyRate(Float hourlyRate) {
    this.hourlyRate = hourlyRate;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReportingProjectPUT reportingProjectPUT = (ReportingProjectPUT) o;
    return Objects.equals(this.number, reportingProjectPUT.number) &&
        Objects.equals(this.contactId, reportingProjectPUT.contactId) &&
        Objects.equals(this.name, reportingProjectPUT.name) &&
        Objects.equals(this.description, reportingProjectPUT.description) &&
        Objects.equals(this.startDate, reportingProjectPUT.startDate) &&
        Objects.equals(this.hoursEstimated, reportingProjectPUT.hoursEstimated) &&
        Objects.equals(this.hourlyRate, reportingProjectPUT.hourlyRate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(number, contactId, name, description, startDate, hoursEstimated, hourlyRate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReportingProjectPUT {\n");
    
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
    sb.append("    contactId: ").append(toIndentedString(contactId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    hoursEstimated: ").append(toIndentedString(hoursEstimated)).append("\n");
    sb.append("    hourlyRate: ").append(toIndentedString(hourlyRate)).append("\n");
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

