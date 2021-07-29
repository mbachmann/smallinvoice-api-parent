package com.example.smallinvoicespringfeign.model;

import java.util.Objects;
import com.example.smallinvoicespringfeign.model.CatalogConfigurationUnitGET;
import com.example.smallinvoicespringfeign.model.ListCatalogConfigurationUnitsAllOf;
import com.example.smallinvoicespringfeign.model.ListPagination;
import com.example.smallinvoicespringfeign.model.ListProductsCategoriesAllOf;
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
 * ListCatalogConfigurationUnits
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-29T11:25:10.409375+02:00[Europe/Zurich]")
public class ListCatalogConfigurationUnits  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("pagination")
  private ListPagination pagination;

  @JsonProperty("items")
  @Valid
  private List<CatalogConfigurationUnitGET> items = null;

  public ListCatalogConfigurationUnits pagination(ListPagination pagination) {
    this.pagination = pagination;
    return this;
  }

  /**
   * Get pagination
   * @return pagination
  */
  @ApiModelProperty(value = "")

  @Valid

  public ListPagination getPagination() {
    return pagination;
  }

  public void setPagination(ListPagination pagination) {
    this.pagination = pagination;
  }

  public ListCatalogConfigurationUnits items(List<CatalogConfigurationUnitGET> items) {
    this.items = items;
    return this;
  }

  public ListCatalogConfigurationUnits addItemsItem(CatalogConfigurationUnitGET itemsItem) {
    if (this.items == null) {
      this.items = new ArrayList<>();
    }
    this.items.add(itemsItem);
    return this;
  }

  /**
   * Collection of CatalogConfigurationUnitGET objects
   * @return items
  */
  @ApiModelProperty(value = "Collection of CatalogConfigurationUnitGET objects")

  @Valid

  public List<CatalogConfigurationUnitGET> getItems() {
    return items;
  }

  public void setItems(List<CatalogConfigurationUnitGET> items) {
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
    ListCatalogConfigurationUnits listCatalogConfigurationUnits = (ListCatalogConfigurationUnits) o;
    return Objects.equals(this.pagination, listCatalogConfigurationUnits.pagination) &&
        Objects.equals(this.items, listCatalogConfigurationUnits.items);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pagination, items);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListCatalogConfigurationUnits {\n");
    
    sb.append("    pagination: ").append(toIndentedString(pagination)).append("\n");
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

