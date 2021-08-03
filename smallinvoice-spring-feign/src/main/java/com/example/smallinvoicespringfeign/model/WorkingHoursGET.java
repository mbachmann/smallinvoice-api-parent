package com.example.smallinvoicespringfeign.model;

import java.time.LocalTime;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
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
 * WorkingHoursGET
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-08-03T17:15:13.630+02:00[Europe/Zurich]")
public class WorkingHoursGET  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("id")
  private Integer id;

  @JsonProperty("user_id")
  private Integer userId;

  @JsonProperty("user_name")
  private String userName;

  @JsonProperty("date")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE)
  private LocalDate date;

  @JsonProperty("time_start")
  @JsonFormat(pattern="HH:mm")
  private LocalTime timeStart;

  @JsonProperty("time_end")
  @JsonFormat(pattern="HH:mm")
  private LocalTime timeEnd;

  @JsonProperty("created")
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
  private LocalDateTime created;

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

  public WorkingHoursGET id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * working hours id
   * @return id
  */
  @ApiModelProperty(required = true, value = "working hours id")
  @NotNull


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public WorkingHoursGET userId(Integer userId) {
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

  public WorkingHoursGET userName(String userName) {
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

  public WorkingHoursGET date(LocalDate date) {
    this.date = date;
    return this;
  }

  /**
   * date of working hours time span
   * @return date
  */
  @ApiModelProperty(required = true, value = "date of working hours time span")
  @NotNull

  @Valid

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public WorkingHoursGET timeStart(LocalTime timeStart) {
    this.timeStart = timeStart;
    return this;
  }

  /**
   * start of working hours time span (in HH:MM format)
   * @return timeStart
  */
  @ApiModelProperty(example = "HH:MM", required = true, value = "start of working hours time span (in HH:MM format)")
  @NotNull

@Pattern(regexp="^\\d{2}:\\d{2}$")
  public LocalTime getTimeStart() {
    return timeStart;
  }

  public void setTimeStart(LocalTime timeStart) {
    this.timeStart = timeStart;
  }

  public WorkingHoursGET timeEnd(LocalTime timeEnd) {
    this.timeEnd = timeEnd;
    return this;
  }

  /**
   * end of working hours time span (in HH:MM format)
   * @return timeEnd
  */
  @ApiModelProperty(example = "HH:MM", required = true, value = "end of working hours time span (in HH:MM format)")
  @NotNull

@Pattern(regexp="^\\d{2}:\\d{2}$")
  public LocalTime getTimeEnd() {
    return timeEnd;
  }

  public void setTimeEnd(LocalTime timeEnd) {
    this.timeEnd = timeEnd;
  }

  public WorkingHoursGET created(LocalDateTime created) {
    this.created = created;
    return this;
  }

  /**
   * date when working hours entity was created
   * @return created
  */
  @ApiModelProperty(required = true, value = "date when working hours entity was created")
  @NotNull

  @Valid

  public LocalDateTime getCreated() {
    return created;
  }

  public void setCreated(LocalDateTime created) {
    this.created = created;
  }

  public WorkingHoursGET permissions(List<PermissionsEnum> permissions) {
    this.permissions = permissions;
    return this;
  }

  public WorkingHoursGET addPermissionsItem(PermissionsEnum permissionsItem) {
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
    WorkingHoursGET workingHoursGET = (WorkingHoursGET) o;
    return Objects.equals(this.id, workingHoursGET.id) &&
        Objects.equals(this.userId, workingHoursGET.userId) &&
        Objects.equals(this.userName, workingHoursGET.userName) &&
        Objects.equals(this.date, workingHoursGET.date) &&
        Objects.equals(this.timeStart, workingHoursGET.timeStart) &&
        Objects.equals(this.timeEnd, workingHoursGET.timeEnd) &&
        Objects.equals(this.created, workingHoursGET.created) &&
        Objects.equals(this.permissions, workingHoursGET.permissions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, userId, userName, date, timeStart, timeEnd, created, permissions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WorkingHoursGET {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    userName: ").append(toIndentedString(userName)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    timeStart: ").append(toIndentedString(timeStart)).append("\n");
    sb.append("    timeEnd: ").append(toIndentedString(timeEnd)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
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

