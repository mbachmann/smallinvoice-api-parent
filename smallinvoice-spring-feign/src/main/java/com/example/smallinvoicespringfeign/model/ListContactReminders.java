package com.example.smallinvoicespringfeign.model;

import java.util.Objects;
import com.example.smallinvoicespringfeign.model.ContactReminderGET;
import com.example.smallinvoicespringfeign.model.ListContactRemindersAllOf;
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
 * ListContactReminders
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-28T19:49:25.792053+02:00[Europe/Zurich]")
public class ListContactReminders  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("pagination")
  private ListPagination pagination;

  @JsonProperty("items")
  @Valid
  private List<ContactReminderGET> items = null;

  public ListContactReminders pagination(ListPagination pagination) {
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

  public ListContactReminders items(List<ContactReminderGET> items) {
    this.items = items;
    return this;
  }

  public ListContactReminders addItemsItem(ContactReminderGET itemsItem) {
    if (this.items == null) {
      this.items = new ArrayList<>();
    }
    this.items.add(itemsItem);
    return this;
  }

  /**
   * Collection of ContactReminderGET objects
   * @return items
  */
  @ApiModelProperty(value = "Collection of ContactReminderGET objects")

  @Valid

  public List<ContactReminderGET> getItems() {
    return items;
  }

  public void setItems(List<ContactReminderGET> items) {
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
    ListContactReminders listContactReminders = (ListContactReminders) o;
    return Objects.equals(this.pagination, listContactReminders.pagination) &&
        Objects.equals(this.items, listContactReminders.items);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pagination, items);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListContactReminders {\n");
    
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

