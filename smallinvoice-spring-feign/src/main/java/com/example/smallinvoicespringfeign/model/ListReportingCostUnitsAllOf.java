package com.example.smallinvoicespringfeign.model;

import java.util.Objects;
import com.example.smallinvoicespringfeign.model.ReportingCostUnitGET;
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
 * ListReportingCostUnitsAllOf
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-31T13:05:18.255013+02:00[Europe/Zurich]")
public class ListReportingCostUnitsAllOf  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("items")
  @Valid
  private List<ReportingCostUnitGET> items = null;

  public ListReportingCostUnitsAllOf items(List<ReportingCostUnitGET> items) {
    this.items = items;
    return this;
  }

  public ListReportingCostUnitsAllOf addItemsItem(ReportingCostUnitGET itemsItem) {
    if (this.items == null) {
      this.items = new ArrayList<>();
    }
    this.items.add(itemsItem);
    return this;
  }

  /**
   * Collection of ReportingCostUnitGET objects
   * @return items
  */
  @ApiModelProperty(value = "Collection of ReportingCostUnitGET objects")

  @Valid

  public List<ReportingCostUnitGET> getItems() {
    return items;
  }

  public void setItems(List<ReportingCostUnitGET> items) {
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
    ListReportingCostUnitsAllOf listReportingCostUnitsAllOf = (ListReportingCostUnitsAllOf) o;
    return Objects.equals(this.items, listReportingCostUnitsAllOf.items);
  }

  @Override
  public int hashCode() {
    return Objects.hash(items);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListReportingCostUnitsAllOf {\n");
    
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

