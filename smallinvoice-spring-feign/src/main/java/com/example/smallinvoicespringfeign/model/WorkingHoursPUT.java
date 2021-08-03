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
 * WorkingHoursPUT
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-08-03T10:50:58.837+02:00[Europe/Zurich]")
public class WorkingHoursPUT  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("user_id")
  private Integer userId;

  @JsonProperty("date")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE)
  private LocalDate date;

  @JsonProperty("time_start")
  private String timeStart;

  @JsonProperty("time_end")
  private String timeEnd;

  public WorkingHoursPUT userId(Integer userId) {
    this.userId = userId;
    return this;
  }

  /**
   * id of user
   * @return userId
  */
  @ApiModelProperty(value = "id of user")


  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public WorkingHoursPUT date(LocalDate date) {
    this.date = date;
    return this;
  }

  /**
   * date of working hours time span
   * @return date
  */
  @ApiModelProperty(value = "date of working hours time span")

  @Valid

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public WorkingHoursPUT timeStart(String timeStart) {
    this.timeStart = timeStart;
    return this;
  }

  /**
   * start of working hours time span (in HH:MM format)
   * @return timeStart
  */
  @ApiModelProperty(example = "HH:MM", value = "start of working hours time span (in HH:MM format)")

@Pattern(regexp="^\\d{2}:\\d{2}$") 
  public String getTimeStart() {
    return timeStart;
  }

  public void setTimeStart(String timeStart) {
    this.timeStart = timeStart;
  }

  public WorkingHoursPUT timeEnd(String timeEnd) {
    this.timeEnd = timeEnd;
    return this;
  }

  /**
   * end of working hours time span (in HH:MM format)
   * @return timeEnd
  */
  @ApiModelProperty(example = "HH:MM", value = "end of working hours time span (in HH:MM format)")

@Pattern(regexp="^\\d{2}:\\d{2}$") 
  public String getTimeEnd() {
    return timeEnd;
  }

  public void setTimeEnd(String timeEnd) {
    this.timeEnd = timeEnd;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WorkingHoursPUT workingHoursPUT = (WorkingHoursPUT) o;
    return Objects.equals(this.userId, workingHoursPUT.userId) &&
        Objects.equals(this.date, workingHoursPUT.date) &&
        Objects.equals(this.timeStart, workingHoursPUT.timeStart) &&
        Objects.equals(this.timeEnd, workingHoursPUT.timeEnd);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, date, timeStart, timeEnd);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WorkingHoursPUT {\n");
    
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

