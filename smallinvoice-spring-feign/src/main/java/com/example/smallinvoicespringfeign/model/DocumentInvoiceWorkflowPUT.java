package com.example.smallinvoicespringfeign.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;

/**
 * DocumentInvoiceWorkflowPUT
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-27T20:43:02.724916+02:00[Europe/Zurich]")
public class DocumentInvoiceWorkflowPUT  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("active")
  private Boolean active;

  @JsonProperty("status")
  private String status;

  @JsonProperty("overdue_days")
  private Integer overdueDays;

  /**
   * action that should be taken; possible values: M - remind me, CE - remind contact by email, CP - remind contact by post 
   */
  public enum ActionEnum {
    M("M"),
    
    CE("CE"),
    
    CP("CP");

    private String value;

    ActionEnum(String value) {
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
    public static ActionEnum fromValue(String value) {
      for (ActionEnum b : ActionEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("action")
  private ActionEnum action;

  @JsonProperty("contact_email")
  private String contactEmail;

  /**
   * post speed for reminding contact (valid only when action is CP); possible values: P - priority, E - economy 
   */
  public enum SpeedEnum {
    P("P"),
    
    E("E");

    private String value;

    SpeedEnum(String value) {
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
    public static SpeedEnum fromValue(String value) {
      for (SpeedEnum b : SpeedEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("speed")
  private SpeedEnum speed;

  public DocumentInvoiceWorkflowPUT active(Boolean active) {
    this.active = active;
    return this;
  }

  /**
   * whether workflow is active
   * @return active
  */
  @ApiModelProperty(value = "whether workflow is active")


  public Boolean getActive() {
    return active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }

  public DocumentInvoiceWorkflowPUT status(String status) {
    this.status = status;
    return this;
  }

  /**
   * status of a document that the workflow is for; possible values: R - payment reminder, R1 - 1st reminder, R2 - 2nd reminder, R3 - 3rd reminder
   * @return status
  */
  @ApiModelProperty(required = true, value = "status of a document that the workflow is for; possible values: R - payment reminder, R1 - 1st reminder, R2 - 2nd reminder, R3 - 3rd reminder")
  @NotNull


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public DocumentInvoiceWorkflowPUT overdueDays(Integer overdueDays) {
    this.overdueDays = overdueDays;
    return this;
  }

  /**
   * how many days after due date action should be taken
   * @return overdueDays
  */
  @ApiModelProperty(required = true, value = "how many days after due date action should be taken")
  @NotNull


  public Integer getOverdueDays() {
    return overdueDays;
  }

  public void setOverdueDays(Integer overdueDays) {
    this.overdueDays = overdueDays;
  }

  public DocumentInvoiceWorkflowPUT action(ActionEnum action) {
    this.action = action;
    return this;
  }

  /**
   * action that should be taken; possible values: M - remind me, CE - remind contact by email, CP - remind contact by post 
   * @return action
  */
  @ApiModelProperty(required = true, value = "action that should be taken; possible values: M - remind me, CE - remind contact by email, CP - remind contact by post ")
  @NotNull


  public ActionEnum getAction() {
    return action;
  }

  public void setAction(ActionEnum action) {
    this.action = action;
  }

  public DocumentInvoiceWorkflowPUT contactEmail(String contactEmail) {
    this.contactEmail = contactEmail;
    return this;
  }

  /**
   * email address for reminding contact (valid only when action is CE)
   * @return contactEmail
  */
  @ApiModelProperty(value = "email address for reminding contact (valid only when action is CE)")


  public String getContactEmail() {
    return contactEmail;
  }

  public void setContactEmail(String contactEmail) {
    this.contactEmail = contactEmail;
  }

  public DocumentInvoiceWorkflowPUT speed(SpeedEnum speed) {
    this.speed = speed;
    return this;
  }

  /**
   * post speed for reminding contact (valid only when action is CP); possible values: P - priority, E - economy 
   * @return speed
  */
  @ApiModelProperty(value = "post speed for reminding contact (valid only when action is CP); possible values: P - priority, E - economy ")


  public SpeedEnum getSpeed() {
    return speed;
  }

  public void setSpeed(SpeedEnum speed) {
    this.speed = speed;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DocumentInvoiceWorkflowPUT documentInvoiceWorkflowPUT = (DocumentInvoiceWorkflowPUT) o;
    return Objects.equals(this.active, documentInvoiceWorkflowPUT.active) &&
        Objects.equals(this.status, documentInvoiceWorkflowPUT.status) &&
        Objects.equals(this.overdueDays, documentInvoiceWorkflowPUT.overdueDays) &&
        Objects.equals(this.action, documentInvoiceWorkflowPUT.action) &&
        Objects.equals(this.contactEmail, documentInvoiceWorkflowPUT.contactEmail) &&
        Objects.equals(this.speed, documentInvoiceWorkflowPUT.speed);
  }

  @Override
  public int hashCode() {
    return Objects.hash(active, status, overdueDays, action, contactEmail, speed);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DocumentInvoiceWorkflowPUT {\n");
    
    sb.append("    active: ").append(toIndentedString(active)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    overdueDays: ").append(toIndentedString(overdueDays)).append("\n");
    sb.append("    action: ").append(toIndentedString(action)).append("\n");
    sb.append("    contactEmail: ").append(toIndentedString(contactEmail)).append("\n");
    sb.append("    speed: ").append(toIndentedString(speed)).append("\n");
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

