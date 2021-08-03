package com.example.smallinvoicespringfeign.model;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
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
 * WorkingHoursPOST
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-08-03T17:15:13.630+02:00[Europe/Zurich]")
public class WorkingHoursPOST  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("user_id")
  private Integer userId;

  @JsonProperty("date")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE)
  private LocalDate date;

  @JsonProperty("time_start")
  @JsonFormat(pattern="HH:mm")
  private LocalTime timeStart;

  @JsonProperty("time_end")
  @JsonFormat(pattern="HH:mm")
  private LocalTime timeEnd;

  public WorkingHoursPOST userId(Integer userId) {
    this.userId = userId;
    return this;
  }

  /**
   * id of user - default value: 'user id of authenticated request'
   * @return userId
  */
  @ApiModelProperty(value = "id of user - default value: 'user id of authenticated request'")


  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public WorkingHoursPOST date(LocalDate date) {
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

  public WorkingHoursPOST timeStart(LocalTime timeStart) {
    if (timeStart != null) this.timeStart = timeStart.truncatedTo(ChronoUnit.MINUTES);
    return this;
  }

  /**
   * start of working hours time span (in HH:MM format)
   * @return timeStart
  */
  @ApiModelProperty(example = "HH:MM", required = true, value = "start of working hours time span (in HH:MM format)")
  @NotNull

  public LocalTime getTimeStart() {
    return timeStart;
  }

  public void setTimeStart(LocalTime timeStart) {
    if (timeStart != null) this.timeStart = timeStart.truncatedTo(ChronoUnit.MINUTES);
  }

  public WorkingHoursPOST timeEnd(LocalTime timeEnd) {
    if (timeEnd != null) this.timeEnd = timeEnd.truncatedTo(ChronoUnit.MINUTES);
    return this;
  }

  /**
   * end of working hours time span (in HH:MM format)
   * @return timeEnd
  */
  @ApiModelProperty(example = "HH:MM", required = true, value = "end of working hours time span (in HH:MM format)")
  @NotNull

  public LocalTime getTimeEnd() {
    return timeEnd;
  }

  public void setTimeEnd(LocalTime timeEnd) {
    if (timeEnd != null) this.timeEnd = timeEnd.truncatedTo(ChronoUnit.MINUTES);
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WorkingHoursPOST workingHoursPOST = (WorkingHoursPOST) o;
    return Objects.equals(this.userId, workingHoursPOST.userId) &&
        Objects.equals(this.date, workingHoursPOST.date) &&
        Objects.equals(this.timeStart, workingHoursPOST.timeStart) &&
        Objects.equals(this.timeEnd, workingHoursPOST.timeEnd);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, date, timeStart, timeEnd);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WorkingHoursPOST {\n");

    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    timeStart: ").append(toIndentedString(timeStart)).append("\n");
    sb.append("    timeEnd: ").append(toIndentedString(timeEnd)).append("\n");
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

