package com.example.smallinvoicespringfeign.model;

import java.util.Objects;
import com.example.smallinvoicespringfeign.model.CatalogCategoryGET;
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
 * ListProductsCategoriesAllOf1
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-29T19:43:05.733009+02:00[Europe/Zurich]")
public class ListProductsCategoriesAllOf1  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("items")
  @Valid
  private List<CatalogCategoryGET> items = null;

  public ListProductsCategoriesAllOf1 items(List<CatalogCategoryGET> items) {
    this.items = items;
    return this;
  }

  public ListProductsCategoriesAllOf1 addItemsItem(CatalogCategoryGET itemsItem) {
    if (this.items == null) {
      this.items = new ArrayList<>();
    }
    this.items.add(itemsItem);
    return this;
  }

  /**
   * Collection of CatalogCategoryGET objects
   * @return items
  */
  @ApiModelProperty(value = "Collection of CatalogCategoryGET objects")

  @Valid

  public List<CatalogCategoryGET> getItems() {
    return items;
  }

  public void setItems(List<CatalogCategoryGET> items) {
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
    ListProductsCategoriesAllOf1 listProductsCategoriesAllOf1 = (ListProductsCategoriesAllOf1) o;
    return Objects.equals(this.items, listProductsCategoriesAllOf1.items);
  }

  @Override
  public int hashCode() {
    return Objects.hash(items);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListProductsCategoriesAllOf1 {\n");
    
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

