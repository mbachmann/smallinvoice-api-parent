package com.example.smallinvoicespringfeign.model;

import java.util.Objects;
import com.example.smallinvoicespringfeign.model.DocumentLetterGET;
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
 * ItemDocumentLetterGET
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-27T20:43:02.724916+02:00[Europe/Zurich]")
public class ItemDocumentLetterGET  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("item")
  private DocumentLetterGET item;

  public ItemDocumentLetterGET item(DocumentLetterGET item) {
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

  public DocumentLetterGET getItem() {
    return item;
  }

  public void setItem(DocumentLetterGET item) {
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
    ItemDocumentLetterGET itemDocumentLetterGET = (ItemDocumentLetterGET) o;
    return Objects.equals(this.item, itemDocumentLetterGET.item);
  }

  @Override
  public int hashCode() {
    return Objects.hash(item);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ItemDocumentLetterGET {\n");
    
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

