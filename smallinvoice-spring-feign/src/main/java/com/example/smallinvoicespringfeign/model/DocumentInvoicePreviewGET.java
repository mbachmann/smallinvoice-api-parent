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
 * DocumentInvoicePreviewGET
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-28T19:49:25.792053+02:00[Europe/Zurich]")
public class DocumentInvoicePreviewGET  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("page")
  private Integer page;

  @JsonProperty("size")
  private Integer size;

  public DocumentInvoicePreviewGET page(Integer page) {
    this.page = page;
    return this;
  }

  /**
   * page number; possible values: 1 .. page amount
   * @return page
  */
  @ApiModelProperty(value = "page number; possible values: 1 .. page amount")


  public Integer getPage() {
    return page;
  }

  public void setPage(Integer page) {
    this.page = page;
  }

  public DocumentInvoicePreviewGET size(Integer size) {
    this.size = size;
    return this;
  }

  /**
   * width in pixels; possible values: 240, 595, 600, 972, 1240 
   * @return size
  */
  @ApiModelProperty(value = "width in pixels; possible values: 240, 595, 600, 972, 1240 ")


  public Integer getSize() {
    return size;
  }

  public void setSize(Integer size) {
    this.size = size;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DocumentInvoicePreviewGET documentInvoicePreviewGET = (DocumentInvoicePreviewGET) o;
    return Objects.equals(this.page, documentInvoicePreviewGET.page) &&
        Objects.equals(this.size, documentInvoicePreviewGET.size);
  }

  @Override
  public int hashCode() {
    return Objects.hash(page, size);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DocumentInvoicePreviewGET {\n");
    
    sb.append("    page: ").append(toIndentedString(page)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
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

