package com.example.smallinvoicespringfeign.model;

import java.util.Objects;
import com.example.smallinvoicespringfeign.model.ConfigurationBankAccountGET;
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
 * ListConfigurationBankAccountsAllOf
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-08-03T21:09:37.732+02:00[Europe/Zurich]")
public class ListConfigurationBankAccountsAllOf  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("items")
  @Valid
  private List<ConfigurationBankAccountGET> items = null;

  public ListConfigurationBankAccountsAllOf items(List<ConfigurationBankAccountGET> items) {
    this.items = items;
    return this;
  }

  public ListConfigurationBankAccountsAllOf addItemsItem(ConfigurationBankAccountGET itemsItem) {
    if (this.items == null) {
      this.items = new ArrayList<>();
    }
    this.items.add(itemsItem);
    return this;
  }

  /**
   * Collection of ConfigurationBankAccountGET objects
   * @return items
  */
  @ApiModelProperty(value = "Collection of ConfigurationBankAccountGET objects")

  @Valid

  public List<ConfigurationBankAccountGET> getItems() {
    return items;
  }

  public void setItems(List<ConfigurationBankAccountGET> items) {
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
    ListConfigurationBankAccountsAllOf listConfigurationBankAccountsAllOf = (ListConfigurationBankAccountsAllOf) o;
    return Objects.equals(this.items, listConfigurationBankAccountsAllOf.items);
  }

  @Override
  public int hashCode() {
    return Objects.hash(items);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListConfigurationBankAccountsAllOf {\n");
    
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

