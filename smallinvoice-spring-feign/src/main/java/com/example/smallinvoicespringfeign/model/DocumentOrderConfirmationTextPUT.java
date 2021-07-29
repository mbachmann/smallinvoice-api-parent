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
 * DocumentOrderConfirmationTextPUT
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-29T19:43:05.733009+02:00[Europe/Zurich]")
public class DocumentOrderConfirmationTextPUT  implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * status of order confirmation, possible values: DR - draft, S - sent, B - billed, D - deleted (but still visible)
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

  @JsonProperty("title")
  private String title;

  @JsonProperty("introduction")
  private String introduction;

  @JsonProperty("conditions")
  private String conditions;

  public DocumentOrderConfirmationTextPUT status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * status of order confirmation, possible values: DR - draft, S - sent, B - billed, D - deleted (but still visible)
   * @return status
  */
  @ApiModelProperty(required = true, value = "status of order confirmation, possible values: DR - draft, S - sent, B - billed, D - deleted (but still visible)")
  @NotNull


  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public DocumentOrderConfirmationTextPUT title(String title) {
    this.title = title;
    return this;
  }

  /**
   * text of title
   * @return title
  */
  @ApiModelProperty(value = "text of title")


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public DocumentOrderConfirmationTextPUT introduction(String introduction) {
    this.introduction = introduction;
    return this;
  }

  /**
   * text of introduction
   * @return introduction
  */
  @ApiModelProperty(value = "text of introduction")


  public String getIntroduction() {
    return introduction;
  }

  public void setIntroduction(String introduction) {
    this.introduction = introduction;
  }

  public DocumentOrderConfirmationTextPUT conditions(String conditions) {
    this.conditions = conditions;
    return this;
  }

  /**
   * text of conditions
   * @return conditions
  */
  @ApiModelProperty(value = "text of conditions")


  public String getConditions() {
    return conditions;
  }

  public void setConditions(String conditions) {
    this.conditions = conditions;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DocumentOrderConfirmationTextPUT documentOrderConfirmationTextPUT = (DocumentOrderConfirmationTextPUT) o;
    return Objects.equals(this.status, documentOrderConfirmationTextPUT.status) &&
        Objects.equals(this.title, documentOrderConfirmationTextPUT.title) &&
        Objects.equals(this.introduction, documentOrderConfirmationTextPUT.introduction) &&
        Objects.equals(this.conditions, documentOrderConfirmationTextPUT.conditions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, title, introduction, conditions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DocumentOrderConfirmationTextPUT {\n");
    
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    introduction: ").append(toIndentedString(introduction)).append("\n");
    sb.append("    conditions: ").append(toIndentedString(conditions)).append("\n");
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

