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
 * DocumentDeliveryNoteTextGET
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-27T20:43:02.724916+02:00[Europe/Zurich]")
public class DocumentDeliveryNoteTextGET  implements Serializable {
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

  @JsonProperty("title")
  private String title;

  @JsonProperty("introduction")
  private String introduction;

  @JsonProperty("conditions")
  private String conditions;

  public DocumentDeliveryNoteTextGET status(StatusEnum status) {
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

  public DocumentDeliveryNoteTextGET title(String title) {
    this.title = title;
    return this;
  }

  /**
   * text of title
   * @return title
  */
  @ApiModelProperty(required = true, value = "text of title")
  @NotNull


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public DocumentDeliveryNoteTextGET introduction(String introduction) {
    this.introduction = introduction;
    return this;
  }

  /**
   * text of introduction
   * @return introduction
  */
  @ApiModelProperty(required = true, value = "text of introduction")
  @NotNull


  public String getIntroduction() {
    return introduction;
  }

  public void setIntroduction(String introduction) {
    this.introduction = introduction;
  }

  public DocumentDeliveryNoteTextGET conditions(String conditions) {
    this.conditions = conditions;
    return this;
  }

  /**
   * text of conditions
   * @return conditions
  */
  @ApiModelProperty(required = true, value = "text of conditions")
  @NotNull


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
    DocumentDeliveryNoteTextGET documentDeliveryNoteTextGET = (DocumentDeliveryNoteTextGET) o;
    return Objects.equals(this.status, documentDeliveryNoteTextGET.status) &&
        Objects.equals(this.title, documentDeliveryNoteTextGET.title) &&
        Objects.equals(this.introduction, documentDeliveryNoteTextGET.introduction) &&
        Objects.equals(this.conditions, documentDeliveryNoteTextGET.conditions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, title, introduction, conditions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DocumentDeliveryNoteTextGET {\n");
    
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
