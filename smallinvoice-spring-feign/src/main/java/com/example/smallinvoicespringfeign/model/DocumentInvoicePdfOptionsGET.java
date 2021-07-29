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
 * DocumentInvoicePdfOptionsGET
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-29T11:25:10.409375+02:00[Europe/Zurich]")
public class DocumentInvoicePdfOptionsGET  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("isr_ignore_custom_position")
  private Boolean isrIgnoreCustomPosition;

  @JsonProperty("isr_display_image")
  private Boolean isrDisplayImage;

  @JsonProperty("receipt")
  private Boolean receipt;

  public DocumentInvoicePdfOptionsGET isrIgnoreCustomPosition(Boolean isrIgnoreCustomPosition) {
    this.isrIgnoreCustomPosition = isrIgnoreCustomPosition;
    return this;
  }

  /**
   * whether to ignore ISR positioning set by user (false by default)
   * @return isrIgnoreCustomPosition
  */
  @ApiModelProperty(value = "whether to ignore ISR positioning set by user (false by default)")


  public Boolean getIsrIgnoreCustomPosition() {
    return isrIgnoreCustomPosition;
  }

  public void setIsrIgnoreCustomPosition(Boolean isrIgnoreCustomPosition) {
    this.isrIgnoreCustomPosition = isrIgnoreCustomPosition;
  }

  public DocumentInvoicePdfOptionsGET isrDisplayImage(Boolean isrDisplayImage) {
    this.isrDisplayImage = isrDisplayImage;
    return this;
  }

  /**
   * whether to print ISR background image (false by default)
   * @return isrDisplayImage
  */
  @ApiModelProperty(value = "whether to print ISR background image (false by default)")


  public Boolean getIsrDisplayImage() {
    return isrDisplayImage;
  }

  public void setIsrDisplayImage(Boolean isrDisplayImage) {
    this.isrDisplayImage = isrDisplayImage;
  }

  public DocumentInvoicePdfOptionsGET receipt(Boolean receipt) {
    this.receipt = receipt;
    return this;
  }

  /**
   * whether to get a receipt instead of an invoice (false by default)
   * @return receipt
  */
  @ApiModelProperty(value = "whether to get a receipt instead of an invoice (false by default)")


  public Boolean getReceipt() {
    return receipt;
  }

  public void setReceipt(Boolean receipt) {
    this.receipt = receipt;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DocumentInvoicePdfOptionsGET documentInvoicePdfOptionsGET = (DocumentInvoicePdfOptionsGET) o;
    return Objects.equals(this.isrIgnoreCustomPosition, documentInvoicePdfOptionsGET.isrIgnoreCustomPosition) &&
        Objects.equals(this.isrDisplayImage, documentInvoicePdfOptionsGET.isrDisplayImage) &&
        Objects.equals(this.receipt, documentInvoicePdfOptionsGET.receipt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(isrIgnoreCustomPosition, isrDisplayImage, receipt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DocumentInvoicePdfOptionsGET {\n");
    
    sb.append("    isrIgnoreCustomPosition: ").append(toIndentedString(isrIgnoreCustomPosition)).append("\n");
    sb.append("    isrDisplayImage: ").append(toIndentedString(isrDisplayImage)).append("\n");
    sb.append("    receipt: ").append(toIndentedString(receipt)).append("\n");
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

