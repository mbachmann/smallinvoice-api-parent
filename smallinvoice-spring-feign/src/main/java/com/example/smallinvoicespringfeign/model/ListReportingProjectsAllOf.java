package com.example.smallinvoicespringfeign.model;

import java.util.Objects;
import com.example.smallinvoicespringfeign.model.ReportingProjectGET;
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
 * ListReportingProjectsAllOf
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-31T13:05:18.255013+02:00[Europe/Zurich]")
public class ListReportingProjectsAllOf  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("items")
  @Valid
  private List<ReportingProjectGET> items = null;

  public ListReportingProjectsAllOf items(List<ReportingProjectGET> items) {
    this.items = items;
    return this;
  }

  public ListReportingProjectsAllOf addItemsItem(ReportingProjectGET itemsItem) {
    if (this.items == null) {
      this.items = new ArrayList<>();
    }
    this.items.add(itemsItem);
    return this;
  }

  /**
   * Collection of ReportingProjectGET objects
   * @return items
  */
  @ApiModelProperty(value = "Collection of ReportingProjectGET objects")

  @Valid

  public List<ReportingProjectGET> getItems() {
    return items;
  }

  public void setItems(List<ReportingProjectGET> items) {
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
    ListReportingProjectsAllOf listReportingProjectsAllOf = (ListReportingProjectsAllOf) o;
    return Objects.equals(this.items, listReportingProjectsAllOf.items);
  }

  @Override
  public int hashCode() {
    return Objects.hash(items);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListReportingProjectsAllOf {\n");
    
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

