package com.example.smallinvoicespringfeign.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
 * ContactReminderGET
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-28T19:49:25.792053+02:00[Europe/Zurich]")
public class ContactReminderGET  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("id")
  private Integer id;

  @JsonProperty("contact_id")
  private Integer contactId;

  @JsonProperty("contact_name")
  private String contactName;

  @JsonProperty("date_time")
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
  private LocalDateTime dateTime;

  @JsonProperty("title")
  private String title;

  @JsonProperty("description")
  private String description;

  @JsonProperty("interval_value")
  private Integer intervalValue;

  /**
   * one of: ['hour','day','month']
   */
  public enum IntervalTypeEnum {
    HOUR("hour"),
    
    DAY("day"),
    
    MONTH("month");

    private String value;

    IntervalTypeEnum(String value) {
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
    public static IntervalTypeEnum fromValue(String value) {
      for (IntervalTypeEnum b : IntervalTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("interval_type")
  private IntervalTypeEnum intervalType;

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

  public ContactReminderGET id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * id of a reminder
   * @return id
  */
  @ApiModelProperty(required = true, value = "id of a reminder")
  @NotNull


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public ContactReminderGET contactId(Integer contactId) {
    this.contactId = contactId;
    return this;
  }

  /**
   * id of a contact
   * @return contactId
  */
  @ApiModelProperty(required = true, value = "id of a contact")
  @NotNull


  public Integer getContactId() {
    return contactId;
  }

  public void setContactId(Integer contactId) {
    this.contactId = contactId;
  }

  public ContactReminderGET contactName(String contactName) {
    this.contactName = contactName;
    return this;
  }

  /**
   * name of a contact
   * @return contactName
  */
  @ApiModelProperty(value = "name of a contact")


  public String getContactName() {
    return contactName;
  }

  public void setContactName(String contactName) {
    this.contactName = contactName;
  }

  public ContactReminderGET dateTime(LocalDateTime dateTime) {
    this.dateTime = dateTime;
    return this;
  }

  /**
   * date and time of event that should be reminded (format: Y-m-d H:i:s)
   * @return dateTime
  */
  @ApiModelProperty(required = true, value = "date and time of event that should be reminded (format: Y-m-d H:i:s)")
  @NotNull

  @Valid

  public LocalDateTime getDateTime() {
    return dateTime;
  }

  public void setDateTime(LocalDateTime dateTime) {
    this.dateTime = dateTime;
  }

  public ContactReminderGET title(String title) {
    this.title = title;
    return this;
  }

  /**
   * title of reminder
   * @return title
  */
  @ApiModelProperty(required = true, value = "title of reminder")
  @NotNull


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public ContactReminderGET description(String description) {
    this.description = description;
    return this;
  }

  /**
   * description of reminder
   * @return description
  */
  @ApiModelProperty(required = true, value = "description of reminder")
  @NotNull


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ContactReminderGET intervalValue(Integer intervalValue) {
    this.intervalValue = intervalValue;
    return this;
  }

  /**
   * value of interval in which reminder will be activated
   * @return intervalValue
  */
  @ApiModelProperty(required = true, value = "value of interval in which reminder will be activated")
  @NotNull


  public Integer getIntervalValue() {
    return intervalValue;
  }

  public void setIntervalValue(Integer intervalValue) {
    this.intervalValue = intervalValue;
  }

  public ContactReminderGET intervalType(IntervalTypeEnum intervalType) {
    this.intervalType = intervalType;
    return this;
  }

  /**
   * one of: ['hour','day','month']
   * @return intervalType
  */
  @ApiModelProperty(required = true, value = "one of: ['hour','day','month']")
  @NotNull


  public IntervalTypeEnum getIntervalType() {
    return intervalType;
  }

  public void setIntervalType(IntervalTypeEnum intervalType) {
    this.intervalType = intervalType;
  }

  public ContactReminderGET permissions(List<PermissionsEnum> permissions) {
    this.permissions = permissions;
    return this;
  }

  public ContactReminderGET addPermissionsItem(PermissionsEnum permissionsItem) {
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
    ContactReminderGET contactReminderGET = (ContactReminderGET) o;
    return Objects.equals(this.id, contactReminderGET.id) &&
        Objects.equals(this.contactId, contactReminderGET.contactId) &&
        Objects.equals(this.contactName, contactReminderGET.contactName) &&
        Objects.equals(this.dateTime, contactReminderGET.dateTime) &&
        Objects.equals(this.title, contactReminderGET.title) &&
        Objects.equals(this.description, contactReminderGET.description) &&
        Objects.equals(this.intervalValue, contactReminderGET.intervalValue) &&
        Objects.equals(this.intervalType, contactReminderGET.intervalType) &&
        Objects.equals(this.permissions, contactReminderGET.permissions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, contactId, contactName, dateTime, title, description, intervalValue, intervalType, permissions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContactReminderGET {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    contactId: ").append(toIndentedString(contactId)).append("\n");
    sb.append("    contactName: ").append(toIndentedString(contactName)).append("\n");
    sb.append("    dateTime: ").append(toIndentedString(dateTime)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    intervalValue: ").append(toIndentedString(intervalValue)).append("\n");
    sb.append("    intervalType: ").append(toIndentedString(intervalType)).append("\n");
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

