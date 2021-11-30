package com.example.smallinvoicespringfeign.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;

/**
 * ReportingEffortGET
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-11-30T10:06:31.741+01:00[Europe/Zurich]")
public class ReportingEffortGET  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("id")
  private Integer id;

  @JsonProperty("user_id")
  private Integer userId;

  @JsonProperty("user_name")
  private String userName;

  /**
   * type of assigned entity, one of: P - project, CU - cost unit, C - contact
   */
  public enum EntityTypeEnum {
    P("P"),
    
    CU("CU"),
    
    C("C");

    private String value;

    EntityTypeEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static EntityTypeEnum fromValue(String value) {
      for (EntityTypeEnum b : EntityTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("entity_type")
  private EntityTypeEnum entityType;

  @JsonProperty("entity_id")
  private Integer entityId;

  @JsonProperty("duration")
  private Float duration;

  @JsonProperty("date")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE)
  private LocalDate date;

  @JsonProperty("activity_id")
  private Integer activityId;

  @JsonProperty("activity_name")
  private String activityName;

  @JsonProperty("notes")
  private String notes;

  @JsonProperty("is_invoiced")
  private Boolean isInvoiced;

  @JsonProperty("updated")
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
  private LocalDateTime updated;

  @JsonProperty("hourly_rate")
  private Float hourlyRate;

  /**
   * Gets or Sets permissions
   */
  public enum PermissionsEnum {
    VIEW("view"),
    
    EDIT("edit");

    private String value;

    PermissionsEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static PermissionsEnum fromValue(String value) {
      for (PermissionsEnum b : PermissionsEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("permissions")
  @Valid
  private List<PermissionsEnum> permissions = null;

  public ReportingEffortGET id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * effort id
   * @return id
  */
  @ApiModelProperty(required = true, value = "effort id")
  @NotNull


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public ReportingEffortGET userId(Integer userId) {
    this.userId = userId;
    return this;
  }

  /**
   * id of user
   * @return userId
  */
  @ApiModelProperty(required = true, value = "id of user")
  @NotNull


  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public ReportingEffortGET userName(String userName) {
    this.userName = userName;
    return this;
  }

  /**
   * full name of user
   * @return userName
  */
  @ApiModelProperty(value = "full name of user")


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public ReportingEffortGET entityType(EntityTypeEnum entityType) {
    this.entityType = entityType;
    return this;
  }

  /**
   * type of assigned entity, one of: P - project, CU - cost unit, C - contact
   * @return entityType
  */
  @ApiModelProperty(required = true, value = "type of assigned entity, one of: P - project, CU - cost unit, C - contact")
  @NotNull


  public EntityTypeEnum getEntityType() {
    return entityType;
  }

  public void setEntityType(EntityTypeEnum entityType) {
    this.entityType = entityType;
  }

  public ReportingEffortGET entityId(Integer entityId) {
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

  public ReportingEffortGET duration(Float duration) {
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

  public ReportingEffortGET date(LocalDate date) {
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

  public ReportingEffortGET activityId(Integer activityId) {
    this.activityId = activityId;
    return this;
  }

  /**
   * assigned activity id
   * @return activityId
  */
  @ApiModelProperty(required = true, value = "assigned activity id")
  @NotNull


  public Integer getActivityId() {
    return activityId;
  }

  public void setActivityId(Integer activityId) {
    this.activityId = activityId;
  }

  public ReportingEffortGET activityName(String activityName) {
    this.activityName = activityName;
    return this;
  }

  /**
   * full activity name
   * @return activityName
  */
  @ApiModelProperty(value = "full activity name")


  public String getActivityName() {
    return activityName;
  }

  public void setActivityName(String activityName) {
    this.activityName = activityName;
  }

  public ReportingEffortGET notes(String notes) {
    this.notes = notes;
    return this;
  }

  /**
   * notes
   * @return notes
  */
  @ApiModelProperty(required = true, value = "notes")
  @NotNull


  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public ReportingEffortGET isInvoiced(Boolean isInvoiced) {
    this.isInvoiced = isInvoiced;
    return this;
  }

  /**
   * if effort has been invoiced already
   * @return isInvoiced
  */
  @ApiModelProperty(required = true, value = "if effort has been invoiced already")
  @NotNull


  public Boolean getIsInvoiced() {
    return isInvoiced;
  }

  public void setIsInvoiced(Boolean isInvoiced) {
    this.isInvoiced = isInvoiced;
  }

  public ReportingEffortGET updated(LocalDateTime updated) {
    this.updated = updated;
    return this;
  }

  /**
   * updated
   * @return updated
  */
  @ApiModelProperty(required = true, value = "updated")
  @NotNull

  @Valid

  public LocalDateTime getUpdated() {
    return updated;
  }

  public void setUpdated(LocalDateTime updated) {
    this.updated = updated;
  }

  public ReportingEffortGET hourlyRate(Float hourlyRate) {
    this.hourlyRate = hourlyRate;
    return this;
  }

  /**
   * hourly rate
   * @return hourlyRate
  */
  @ApiModelProperty(required = true, value = "hourly rate")
  @NotNull


  public Float getHourlyRate() {
    return hourlyRate;
  }

  public void setHourlyRate(Float hourlyRate) {
    this.hourlyRate = hourlyRate;
  }

  public ReportingEffortGET permissions(List<PermissionsEnum> permissions) {
    this.permissions = permissions;
    return this;
  }

  public ReportingEffortGET addPermissionsItem(PermissionsEnum permissionsItem) {
    if (this.permissions == null) {
      this.permissions = new ArrayList<>();
    }
    this.permissions.add(permissionsItem);
    return this;
  }

  /**
   * actions that can be performed on an item (possible values: view, edit) 
   * @return permissions
  */
  @ApiModelProperty(value = "actions that can be performed on an item (possible values: view, edit) ")


  public List<PermissionsEnum> getPermissions() {
    return permissions;
  }

  public void setPermissions(List<PermissionsEnum> permissions) {
    this.permissions = permissions;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReportingEffortGET reportingEffortGET = (ReportingEffortGET) o;
    return Objects.equals(this.id, reportingEffortGET.id) &&
        Objects.equals(this.userId, reportingEffortGET.userId) &&
        Objects.equals(this.userName, reportingEffortGET.userName) &&
        Objects.equals(this.entityType, reportingEffortGET.entityType) &&
        Objects.equals(this.entityId, reportingEffortGET.entityId) &&
        Objects.equals(this.duration, reportingEffortGET.duration) &&
        Objects.equals(this.date, reportingEffortGET.date) &&
        Objects.equals(this.activityId, reportingEffortGET.activityId) &&
        Objects.equals(this.activityName, reportingEffortGET.activityName) &&
        Objects.equals(this.notes, reportingEffortGET.notes) &&
        Objects.equals(this.isInvoiced, reportingEffortGET.isInvoiced) &&
        Objects.equals(this.updated, reportingEffortGET.updated) &&
        Objects.equals(this.hourlyRate, reportingEffortGET.hourlyRate) &&
        Objects.equals(this.permissions, reportingEffortGET.permissions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, userId, userName, entityType, entityId, duration, date, activityId, activityName, notes, isInvoiced, updated, hourlyRate, permissions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReportingEffortGET {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    userName: ").append(toIndentedString(userName)).append("\n");
    sb.append("    entityType: ").append(toIndentedString(entityType)).append("\n");
    sb.append("    entityId: ").append(toIndentedString(entityId)).append("\n");
    sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    activityId: ").append(toIndentedString(activityId)).append("\n");
    sb.append("    activityName: ").append(toIndentedString(activityName)).append("\n");
    sb.append("    notes: ").append(toIndentedString(notes)).append("\n");
    sb.append("    isInvoiced: ").append(toIndentedString(isInvoiced)).append("\n");
    sb.append("    updated: ").append(toIndentedString(updated)).append("\n");
    sb.append("    hourlyRate: ").append(toIndentedString(hourlyRate)).append("\n");
    sb.append("    permissions: ").append(toIndentedString(permissions)).append("\n");
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

