package com.example.smallinvoicespringfeign.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonCreator;
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
 * DocumentChangeStatusPATCH
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-28T19:49:25.792053+02:00[Europe/Zurich]")
public class DocumentChangeStatusPATCH  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("status")
  private String status;

  @JsonProperty("date_time")
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
  private LocalDateTime dateTime;

  public DocumentChangeStatusPATCH status(String status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public DocumentChangeStatusPATCH dateTime(LocalDateTime dateTime) {
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
    DocumentChangeStatusPATCH documentChangeStatusPATCH = (DocumentChangeStatusPATCH) o;
    return Objects.equals(this.status, documentChangeStatusPATCH.status) &&
        Objects.equals(this.dateTime, documentChangeStatusPATCH.dateTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, dateTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DocumentChangeStatusPATCH {\n");
    
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

