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
 * ReportingEffortPOST
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-08-03T11:25:04.200+02:00[Europe/Zurich]")
public class ReportingEffortPOST  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("entity_type")
  private String entityType;

  @JsonProperty("entity_id")
  private Integer entityId;

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

  public ReportingEffortPOST entityType(String entityType) {
    this.entityType = entityType;
    return this;
  }

  /**
   * type of assigned entity, one of: P - project, CU - cost unit, C - contact
   * @return entityType
  */
  @ApiModelProperty(required = true, value = "type of assigned entity, one of: P - project, CU - cost unit, C - contact")
  @NotNull


  public String getEntityType() {
    return entityType;
  }

  public void setEntityType(String entityType) {
    this.entityType = entityType;
  }

  public ReportingEffortPOST entityId(Integer entityId) {
    this.entityId = entityId;
    return this;
  }

  /**
   * assigned entity id
   * @return entityId
  */
  @ApiModelProperty(required = true, value = "assigned entity id")
  @NotNull


  public Integer getEntityId() {
    return entityId;
  }

  public void setEntityId(Integer entityId) {
    this.entityId = entityId;
  }

  public ReportingEffortPOST duration(Float duration) {
    this.duration = duration;
    return this;
  }

  /**
   * duration of effort
   * @return duration
  */
  @ApiModelProperty(required = true, value = "duration of effort")
  @NotNull


  public Float getDuration() {
    return duration;
  }

  public void setDuration(Float duration) {
    this.duration = duration;
  }

  public ReportingEffortPOST date(LocalDate date) {
    this.date = date;
    return this;
  }

  /**
   * date
   * @return date
  */
  @ApiModelProperty(required = true, value = "date")
  @NotNull

  @Valid

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public ReportingEffortPOST activityId(Integer activityId) {
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

  public ReportingEffortPOST notes(String notes) {
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

  public ReportingEffortPOST isInvoiced(Boolean isInvoiced) {
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

  public ReportingEffortPOST hourlyRate(Float hourlyRate) {
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
    ReportingEffortPOST reportingEffortPOST = (ReportingEffortPOST) o;
    return Objects.equals(this.entityType, reportingEffortPOST.entityType) &&
        Objects.equals(this.entityId, reportingEffortPOST.entityId) &&
        Objects.equals(this.duration, reportingEffortPOST.duration) &&
        Objects.equals(this.date, reportingEffortPOST.date) &&
        Objects.equals(this.activityId, reportingEffortPOST.activityId) &&
        Objects.equals(this.notes, reportingEffortPOST.notes) &&
        Objects.equals(this.isInvoiced, reportingEffortPOST.isInvoiced) &&
        Objects.equals(this.hourlyRate, reportingEffortPOST.hourlyRate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(entityType, entityId, duration, date, activityId, notes, isInvoiced, hourlyRate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReportingEffortPOST {\n");
    
    sb.append("    entityType: ").append(toIndentedString(entityType)).append("\n");
    sb.append("    entityId: ").append(toIndentedString(entityId)).append("\n");
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

