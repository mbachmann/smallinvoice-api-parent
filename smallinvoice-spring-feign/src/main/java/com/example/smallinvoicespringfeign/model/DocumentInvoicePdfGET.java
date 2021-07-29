package com.example.smallinvoicespringfeign.model;

import java.util.Objects;
import com.example.smallinvoicespringfeign.model.DocumentInvoicePdfOptionsGET;
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
 * DocumentInvoicePdfGET
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-29T19:43:05.733009+02:00[Europe/Zurich]")
public class DocumentInvoicePdfGET  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("options")
  private DocumentInvoicePdfOptionsGET options;

  public DocumentInvoicePdfGET options(DocumentInvoicePdfOptionsGET options) {
    this.options = options;
    return this;
  }

  /**
   * Get options
   * @return options
  */
  @ApiModelProperty(value = "")

  @Valid

  public DocumentInvoicePdfOptionsGET getOptions() {
    return options;
  }

  public void setOptions(DocumentInvoicePdfOptionsGET options) {
    this.options = options;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DocumentInvoicePdfGET documentInvoicePdfGET = (DocumentInvoicePdfGET) o;
    return Objects.equals(this.options, documentInvoicePdfGET.options);
  }

  @Override
  public int hashCode() {
    return Objects.hash(options);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DocumentInvoicePdfGET {\n");
    
    sb.append("    options: ").append(toIndentedString(options)).append("\n");
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

