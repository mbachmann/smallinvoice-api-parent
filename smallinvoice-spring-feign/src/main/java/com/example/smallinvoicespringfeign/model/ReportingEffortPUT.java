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
 * ReportingEffortPUT
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-29T19:43:05.733009+02:00[Europe/Zurich]")
public class ReportingEffortPUT  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("duration")
  private Float duration;

  @JsonProperty("date")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE)
  private LocalDate date;

  @JsonProperty("activity_id")
  private Integer activityId;

  @JsonProperty("notes")
  private String notes;

  @JsonProperty("is_invoiced")
  private Boolean isInvoiced;

  @JsonProperty("hourly_rate")
  private Float hourlyRate;

  public ReportingEffortPUT duration(Float duration) {
    this.duration = duration;
    return this;
  }

  /**
   * duration of effort
   * @return duration
  */
  @ApiModelProperty(value = "duration of effort")


  public Float getDuration() {
    return duration;
  }

  public void setDuration(Float duration) {
    this.duration = duration;
  }

  public ReportingEffortPUT date(LocalDate date) {
    this.date = date;
    return this;
  }

  /**
   * date
   * @return date
  */
  @ApiModelProperty(value = "date")

  @Valid

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public ReportingEffortPUT activityId(Integer activityId) {
    this.activityId = activityId;
    return this;
  }

  /**
   * assigned activity id
   * @return activityId
  */
  @ApiModelProperty(value = "assigned activity id")


  public Integer getActivityId() {
    return activityId;
  }

  public void setActivityId(Integer activityId) {
    this.activityId = activityId;
  }

  public ReportingEffortPUT notes(String notes) {
    this.notes = notes;
    return this;
  }

  /**
   * notes
   * @return notes
  */
  @ApiModelProperty(value = "notes")


  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public ReportingEffortPUT isInvoiced(Boolean isInvoiced) {
    this.isInvoiced = isInvoiced;
    return this;
  }

  /**
   * if effort has been invoiced already
   * @return isInvoiced
  */
  @ApiModelProperty(value = "if effort has been invoiced already")


  public Boolean getIsInvoiced() {
    return isInvoiced;
  }

  public void setIsInvoiced(Boolean isInvoiced) {
    this.isInvoiced = isInvoiced;
  }

  public ReportingEffortPUT hourlyRate(Float hourlyRate) {
    this.hourlyRate = hourlyRate;
    return this;
  }

  /**
   * hourly rate
   * @return hourlyRate
  */
  @ApiModelProperty(value = "hourly rate")


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
    ReportingEffortPUT reportingEffortPUT = (ReportingEffortPUT) o;
    return Objects.equals(this.duration, reportingEffortPUT.duration) &&
        Objects.equals(this.date, reportingEffortPUT.date) &&
        Objects.equals(this.activityId, reportingEffortPUT.activityId) &&
        Objects.equals(this.notes, reportingEffortPUT.notes) &&
        Objects.equals(this.isInvoiced, reportingEffortPUT.isInvoiced) &&
        Objects.equals(this.hourlyRate, reportingEffortPUT.hourlyRate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(duration, date, activityId, notes, isInvoiced, hourlyRate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReportingEffortPUT {\n");
    
    sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    activityId: ").append(toIndentedString(activityId)).append("\n");
    sb.append("    notes: ").append(toIndentedString(notes)).append("\n");
    sb.append("    isInvoiced: ").append(toIndentedString(isInvoiced)).append("\n");
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

