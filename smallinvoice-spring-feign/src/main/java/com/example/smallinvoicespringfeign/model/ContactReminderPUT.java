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
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;

/**
 * ContactReminderPUT
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-08-03T11:25:04.200+02:00[Europe/Zurich]")
public class ContactReminderPUT  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("contact_id")
  private Integer contactId;

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

  public ContactReminderPUT contactId(Integer contactId) {
    this.contactId = contactId;
    return this;
  }

  /**
   * id of a contact
   * @return contactId
  */
  @ApiModelProperty(value = "id of a contact")


  public Integer getContactId() {
    return contactId;
  }

  public void setContactId(Integer contactId) {
    this.contactId = contactId;
  }

  public ContactReminderPUT dateTime(LocalDateTime dateTime) {
    this.dateTime = dateTime;
    return this;
  }

  /**
   * date and time of event that should be reminded (format: Y-m-d H:i:s)
   * @return dateTime
  */
  @ApiModelProperty(value = "date and time of event that should be reminded (format: Y-m-d H:i:s)")

  @Valid

  public LocalDateTime getDateTime() {
    return dateTime;
  }

  public void setDateTime(LocalDateTime dateTime) {
    this.dateTime = dateTime;
  }

  public ContactReminderPUT title(String title) {
    this.title = title;
    return this;
  }

  /**
   * title of reminder
   * @return title
  */
  @ApiModelProperty(value = "title of reminder")


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public ContactReminderPUT description(String description) {
    this.description = description;
    return this;
  }

  /**
   * description of reminder
   * @return description
  */
  @ApiModelProperty(value = "description of reminder")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ContactReminderPUT intervalValue(Integer intervalValue) {
    this.intervalValue = intervalValue;
    return this;
  }

  /**
   * value of interval in which reminder will be activated
   * @return intervalValue
  */
  @ApiModelProperty(value = "value of interval in which reminder will be activated")


  public Integer getIntervalValue() {
    return intervalValue;
  }

  public void setIntervalValue(Integer intervalValue) {
    this.intervalValue = intervalValue;
  }

  public ContactReminderPUT intervalType(IntervalTypeEnum intervalType) {
    this.intervalType = intervalType;
    return this;
  }

  /**
   * one of: ['hour','day','month']
   * @return intervalType
  */
  @ApiModelProperty(value = "one of: ['hour','day','month']")


  public IntervalTypeEnum getIntervalType() {
    return intervalType;
  }

  public void setIntervalType(IntervalTypeEnum intervalType) {
    this.intervalType = intervalType;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContactReminderPUT contactReminderPUT = (ContactReminderPUT) o;
    return Objects.equals(this.contactId, contactReminderPUT.contactId) &&
        Objects.equals(this.dateTime, contactReminderPUT.dateTime) &&
        Objects.equals(this.title, contactReminderPUT.title) &&
        Objects.equals(this.description, contactReminderPUT.description) &&
        Objects.equals(this.intervalValue, contactReminderPUT.intervalValue) &&
        Objects.equals(this.intervalType, contactReminderPUT.intervalType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(contactId, dateTime, title, description, intervalValue, intervalType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContactReminderPUT {\n");
    
    sb.append("    contactId: ").append(toIndentedString(contactId)).append("\n");
    sb.append("    dateTime: ").append(toIndentedString(dateTime)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    intervalValue: ").append(toIndentedString(intervalValue)).append("\n");
    sb.append("    intervalType: ").append(toIndentedString(intervalType)).append("\n");
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

