package com.example.smallinvoicespringfeign.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;

/**
 * DocumentInvoiceTextPOST
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-27T20:43:02.724916+02:00[Europe/Zurich]")
public class DocumentInvoiceTextPOST  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("status")
  private String status;

  @JsonProperty("title")
  private String title;

  @JsonProperty("introduction")
  private String introduction;

  @JsonProperty("conditions")
  private String conditions;

  public DocumentInvoiceTextPOST status(String status) {
    this.status = status;
    return this;
  }

  /**
   * status of a document that the texts are for; possible values: D - default, R - payment reminder, R1 - 1st reminder, R2 - 2nd reminder, R3 - 3rd reminder, DC - debt collection, RE - receipt
   * @return status
  */
  @ApiModelProperty(required = true, value = "status of a document that the texts are for; possible values: D - default, R - payment reminder, R1 - 1st reminder, R2 - 2nd reminder, R3 - 3rd reminder, DC - debt collection, RE - receipt")
  @NotNull


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public DocumentInvoiceTextPOST title(String title) {
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

  public DocumentInvoiceTextPOST introduction(String introduction) {
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

  public DocumentInvoiceTextPOST conditions(String conditions) {
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
    DocumentInvoiceTextPOST documentInvoiceTextPOST = (DocumentInvoiceTextPOST) o;
    return Objects.equals(this.status, documentInvoiceTextPOST.status) &&
        Objects.equals(this.title, documentInvoiceTextPOST.title) &&
        Objects.equals(this.introduction, documentInvoiceTextPOST.introduction) &&
        Objects.equals(this.conditions, documentInvoiceTextPOST.conditions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, title, introduction, conditions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DocumentInvoiceTextPOST {\n");
    
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

