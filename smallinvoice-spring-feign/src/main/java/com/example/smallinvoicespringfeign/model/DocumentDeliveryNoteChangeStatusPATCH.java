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
 * DocumentDeliveryNoteChangeStatusPATCH
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-29T19:43:05.733009+02:00[Europe/Zurich]")
public class DocumentDeliveryNoteChangeStatusPATCH  implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * status of delivery note, possible values: DR - draft, S - sent, B - billed, D - deleted (but still visible)
   */
  public enum StatusEnum {
    DR("DR"),
    
    S("S"),
    
    B("B"),
    
    D("D");

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
  private StatusEnum status = StatusEnum.DR;

  @JsonProperty("date_time")
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
  private LocalDateTime dateTime;

  public DocumentDeliveryNoteChangeStatusPATCH status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * status of delivery note, possible values: DR - draft, S - sent, B - billed, D - deleted (but still visible)
   * @return status
  */
  @ApiModelProperty(required = true, value = "status of delivery note, possible values: DR - draft, S - sent, B - billed, D - deleted (but still visible)")
  @NotNull


  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public DocumentDeliveryNoteChangeStatusPATCH dateTime(LocalDateTime dateTime) {
    this.dateTime = dateTime;
    return this;
  }

  /**
   * optional date time of a change in Y-m-d H:i:s format (if none specified current date time will be taken)
   * @return dateTime
  */
  @ApiModelProperty(value = "optional date time of a change in Y-m-d H:i:s format (if none specified current date time will be taken)")

  @Valid

  public LocalDateTime getDateTime() {
    return dateTime;
  }

  public void setDateTime(LocalDateTime dateTime) {
    this.dateTime = dateTime;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DocumentDeliveryNoteChangeStatusPATCH documentDeliveryNoteChangeStatusPATCH = (DocumentDeliveryNoteChangeStatusPATCH) o;
    return Objects.equals(this.status, documentDeliveryNoteChangeStatusPATCH.status) &&
        Objects.equals(this.dateTime, documentDeliveryNoteChangeStatusPATCH.dateTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, dateTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DocumentDeliveryNoteChangeStatusPATCH {\n");
    
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    dateTime: ").append(toIndentedString(dateTime)).append("\n");
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

