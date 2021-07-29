package com.example.smallinvoicespringfeign.model;

import java.util.Objects;
import com.example.smallinvoicespringfeign.model.DocumentInvoiceStandardGET;
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
 * ListInvoicesStandardAllOf
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-29T11:25:10.409375+02:00[Europe/Zurich]")
public class ListInvoicesStandardAllOf  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("items")
  @Valid
  private List<DocumentInvoiceStandardGET> items = null;

  public ListInvoicesStandardAllOf items(List<DocumentInvoiceStandardGET> items) {
    this.items = items;
    return this;
  }

  public ListInvoicesStandardAllOf addItemsItem(DocumentInvoiceStandardGET itemsItem) {
    if (this.items == null) {
      this.items = new ArrayList<>();
    }
    this.items.add(itemsItem);
    return this;
  }

  /**
   * Collection of DocumentInvoiceStandardGET objects
   * @return items
  */
  @ApiModelProperty(value = "Collection of DocumentInvoiceStandardGET objects")

  @Valid

  public List<DocumentInvoiceStandardGET> getItems() {
    return items;
  }

  public void setItems(List<DocumentInvoiceStandardGET> items) {
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
    ListInvoicesStandardAllOf listInvoicesStandardAllOf = (ListInvoicesStandardAllOf) o;
    return Objects.equals(this.items, listInvoicesStandardAllOf.items);
  }

  @Override
  public int hashCode() {
    return Objects.hash(items);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListInvoicesStandardAllOf {\n");
    
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

