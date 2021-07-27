package com.example.smallinvoicespringfeign.model;

import java.util.Objects;
import com.example.smallinvoicespringfeign.model.ContactReminderGET;
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
 * ListContactRemindersAllOf
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-27T20:43:02.724916+02:00[Europe/Zurich]")
public class ListContactRemindersAllOf  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("items")
  @Valid
  private List<ContactReminderGET> items = null;

  public ListContactRemindersAllOf items(List<ContactReminderGET> items) {
    this.items = items;
    return this;
  }

  public ListContactRemindersAllOf addItemsItem(ContactReminderGET itemsItem) {
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
    ListContactRemindersAllOf listContactRemindersAllOf = (ListContactRemindersAllOf) o;
    return Objects.equals(this.items, listContactRemindersAllOf.items);
  }

  @Override
  public int hashCode() {
    return Objects.hash(items);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListContactRemindersAllOf {\n");
    
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

