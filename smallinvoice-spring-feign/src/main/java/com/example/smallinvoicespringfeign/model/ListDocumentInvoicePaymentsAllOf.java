package com.example.smallinvoicespringfeign.model;

import java.util.Objects;
import com.example.smallinvoicespringfeign.model.DocumentInvoicePaymentGET;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;

/**
 * ListDocumentInvoicePaymentsAllOf
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-08-03T11:25:04.200+02:00[Europe/Zurich]")
public class ListDocumentInvoicePaymentsAllOf  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("items")
  @Valid
  private List<DocumentInvoicePaymentGET> items = null;

  public ListDocumentInvoicePaymentsAllOf items(List<DocumentInvoicePaymentGET> items) {
    this.items = items;
    return this;
  }

  public ListDocumentInvoicePaymentsAllOf addItemsItem(DocumentInvoicePaymentGET itemsItem) {
    if (this.items == null) {
      this.items = new ArrayList<>();
    }
    this.items.add(itemsItem);
    return this;
  }

  /**
   * Collection of DocumentInvoicePaymentGET objects
   * @return items
  */
  @ApiModelProperty(value = "Collection of DocumentInvoicePaymentGET objects")

  @Valid

  public List<DocumentInvoicePaymentGET> getItems() {
    return items;
  }

  public void setItems(List<DocumentInvoicePaymentGET> items) {
    this.items = items;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListDocumentInvoicePaymentsAllOf listDocumentInvoicePaymentsAllOf = (ListDocumentInvoicePaymentsAllOf) o;
    return Objects.equals(this.items, listDocumentInvoicePaymentsAllOf.items);
  }

  @Override
  public int hashCode() {
    return Objects.hash(items);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListDocumentInvoicePaymentsAllOf {\n");
    
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
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

