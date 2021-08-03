package com.example.smallinvoicespringfeign.model;

import java.util.Objects;
import com.example.smallinvoicespringfeign.model.ReceivablesConfigurationIsrGET;
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
 * ListReceivablesConfigurationIsrsAllOf
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-08-03T10:50:58.837+02:00[Europe/Zurich]")
public class ListReceivablesConfigurationIsrsAllOf  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("items")
  @Valid
  private List<ReceivablesConfigurationIsrGET> items = null;

  public ListReceivablesConfigurationIsrsAllOf items(List<ReceivablesConfigurationIsrGET> items) {
    this.items = items;
    return this;
  }

  public ListReceivablesConfigurationIsrsAllOf addItemsItem(ReceivablesConfigurationIsrGET itemsItem) {
    if (this.items == null) {
      this.items = new ArrayList<>();
    }
    this.items.add(itemsItem);
    return this;
  }

  /**
   * Collection of ReceivablesConfigurationIsrGET objects
   * @return items
  */
  @ApiModelProperty(value = "Collection of ReceivablesConfigurationIsrGET objects")

  @Valid

  public List<ReceivablesConfigurationIsrGET> getItems() {
    return items;
  }

  public void setItems(List<ReceivablesConfigurationIsrGET> items) {
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
    ListReceivablesConfigurationIsrsAllOf listReceivablesConfigurationIsrsAllOf = (ListReceivablesConfigurationIsrsAllOf) o;
    return Objects.equals(this.items, listReceivablesConfigurationIsrsAllOf.items);
  }

  @Override
  public int hashCode() {
    return Objects.hash(items);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListReceivablesConfigurationIsrsAllOf {\n");
    
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

