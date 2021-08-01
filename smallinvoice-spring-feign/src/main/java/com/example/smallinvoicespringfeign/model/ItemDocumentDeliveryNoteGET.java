package com.example.smallinvoicespringfeign.model;

import java.util.Objects;
import com.example.smallinvoicespringfeign.model.DocumentDeliveryNoteGET;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;

/**
 * ItemDocumentDeliveryNoteGET
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-31T13:05:18.255013+02:00[Europe/Zurich]")
public class ItemDocumentDeliveryNoteGET  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("item")
  private DocumentDeliveryNoteGET item;

  public ItemDocumentDeliveryNoteGET item(DocumentDeliveryNoteGET item) {
    this.item = item;
    return this;
  }

  /**
   * Get item
   * @return item
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public DocumentDeliveryNoteGET getItem() {
    return item;
  }

  public void setItem(DocumentDeliveryNoteGET item) {
    this.item = item;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ItemDocumentDeliveryNoteGET itemDocumentDeliveryNoteGET = (ItemDocumentDeliveryNoteGET) o;
    return Objects.equals(this.item, itemDocumentDeliveryNoteGET.item);
  }

  @Override
  public int hashCode() {
    return Objects.hash(item);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ItemDocumentDeliveryNoteGET {\n");
    
    sb.append("    item: ").append(toIndentedString(item)).append("\n");
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

