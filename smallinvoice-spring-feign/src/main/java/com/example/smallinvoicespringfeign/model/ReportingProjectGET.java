package com.example.smallinvoicespringfeign.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;

/**
 * ReportingProjectGET
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-11-30T10:06:31.741+01:00[Europe/Zurich]")
public class ReportingProjectGET  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("id")
  private Integer id;

  @JsonProperty("number")
  private String number;

  @JsonProperty("contact_id")
  private Integer contactId;

  @JsonProperty("contact_name")
  private String contactName;

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

  /**
   * status to be set, on of:  ['O' - open, 'C' - closed, 'B' - billed, 'P' - pending]
   */
  public enum StatusEnum {
    O("O"),
    
    C("C"),
    
    B("B"),
    
    P("P");

    private String value;

    StatusEnum(String value) {
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
    public static StatusEnum fromValue(String value) {
      for (StatusEnum b : StatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("status")
  private StatusEnum status;

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

  public ReportingProjectGET id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * project's ID
   * @return id
  */
  @ApiModelProperty(required = true, value = "project's ID")
  @NotNull


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public ReportingProjectGET number(String number) {
    this.number = number;
    return this;
  }

  /**
   * project's internal number
   * @return number
  */
  @ApiModelProperty(required = true, value = "project's internal number")
  @NotNull


  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public ReportingProjectGET contactId(Integer contactId) {
    this.contactId = contactId;
    return this;
  }

  /**
   * related contact's id
   * @return contactId
  */
  @ApiModelProperty(required = true, value = "related contact's id")
  @NotNull


  public Integer getContactId() {
    return contactId;
  }

  public void setContactId(Integer contactId) {
    this.contactId = contactId;
  }

  public ReportingProjectGET contactName(String contactName) {
    this.contactName = contactName;
    return this;
  }

  /**
   * related contact's name
   * @return contactName
  */
  @ApiModelProperty(value = "related contact's name")


  public String getContactName() {
    return contactName;
  }

  public void setContactName(String contactName) {
    this.contactName = contactName;
  }

  public ReportingProjectGET name(String name) {
    this.name = name;
    return this;
  }

  /**
   * project's name
   * @return name
  */
  @ApiModelProperty(required = true, value = "project's name")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ReportingProjectGET description(String description) {
    this.description = description;
    return this;
  }

  /**
   * project's description
   * @return description
  */
  @ApiModelProperty(required = true, value = "project's description")
  @NotNull


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ReportingProjectGET startDate(LocalDate startDate) {
    this.startDate = startDate;
    return this;
  }

  /**
   * project's start date
   * @return startDate
  */
  @ApiModelProperty(required = true, value = "project's start date")
  @NotNull

  @Valid

  public LocalDate getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }

  public ReportingProjectGET hoursEstimated(Float hoursEstimated) {
    this.hoursEstimated = hoursEstimated;
    return this;
  }

  /**
   * project's estimated maximum effort (in hours)
   * @return hoursEstimated
  */
  @ApiModelProperty(required = true, value = "project's estimated maximum effort (in hours)")
  @NotNull


  public Float getHoursEstimated() {
    return hoursEstimated;
  }

  public void setHoursEstimated(Float hoursEstimated) {
    this.hoursEstimated = hoursEstimated;
  }

  public ReportingProjectGET hourlyRate(Float hourlyRate) {
    this.hourlyRate = hourlyRate;
    return this;
  }

  /**
   * project's hourly rate
   * @return hourlyRate
  */
  @ApiModelProperty(required = true, value = "project's hourly rate")
  @NotNull


  public Float getHourlyRate() {
    return hourlyRate;
  }

  public void setHourlyRate(Float hourlyRate) {
    this.hourlyRate = hourlyRate;
  }

  public ReportingProjectGET status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * status to be set, on of:  ['O' - open, 'C' - closed, 'B' - billed, 'P' - pending]
   * @return status
  */
  @ApiModelProperty(required = true, value = "status to be set, on of:  ['O' - open, 'C' - closed, 'B' - billed, 'P' - pending]")
  @NotNull


  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public ReportingProjectGET permissions(List<PermissionsEnum> permissions) {
    this.permissions = permissions;
    return this;
  }

  public ReportingProjectGET addPermissionsItem(PermissionsEnum permissionsItem) {
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
    ReportingProjectGET reportingProjectGET = (ReportingProjectGET) o;
    return Objects.equals(this.id, reportingProjectGET.id) &&
        Objects.equals(this.number, reportingProjectGET.number) &&
        Objects.equals(this.contactId, reportingProjectGET.contactId) &&
        Objects.equals(this.contactName, reportingProjectGET.contactName) &&
        Objects.equals(this.name, reportingProjectGET.name) &&
        Objects.equals(this.description, reportingProjectGET.description) &&
        Objects.equals(this.startDate, reportingProjectGET.startDate) &&
        Objects.equals(this.hoursEstimated, reportingProjectGET.hoursEstimated) &&
        Objects.equals(this.hourlyRate, reportingProjectGET.hourlyRate) &&
        Objects.equals(this.status, reportingProjectGET.status) &&
        Objects.equals(this.permissions, reportingProjectGET.permissions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, number, contactId, contactName, name, description, startDate, hoursEstimated, hourlyRate, status, permissions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReportingProjectGET {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
    sb.append("    contactId: ").append(toIndentedString(contactId)).append("\n");
    sb.append("    contactName: ").append(toIndentedString(contactName)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    hoursEstimated: ").append(toIndentedString(hoursEstimated)).append("\n");
    sb.append("    hourlyRate: ").append(toIndentedString(hourlyRate)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

