package com.example.smallinvoicespringfeign.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;

/**
 * DocumentOfferPreviewGET
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-31T13:05:18.255013+02:00[Europe/Zurich]")
public class DocumentOfferPreviewGET  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("page")
  private Integer page;

  /**
   * width in pixels; possible values: 240, 595, 600, 972, 1240 
   */
  public enum SizeEnum {
    NUMBER_240(240),
    
    NUMBER_595(595),
    
    NUMBER_600(600),
    
    NUMBER_972(972),
    
    NUMBER_1240(1240);

    private Integer value;

    SizeEnum(Integer value) {
      this.value = value;
    }

    @JsonValue
    public Integer getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static SizeEnum fromValue(Integer value) {
      for (SizeEnum b : SizeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("size")
  private SizeEnum size = SizeEnum.NUMBER_972;

  public DocumentOfferPreviewGET page(Integer page) {
    this.page = page;
    return this;
  }

  /**
   * page number; possible values: 1 .. page amount
   * @return page
  */
  @ApiModelProperty(value = "page number; possible values: 1 .. page amount")


  public Integer getPage() {
    return page;
  }

  public void setPage(Integer page) {
    this.page = page;
  }

  public DocumentOfferPreviewGET size(SizeEnum size) {
    this.size = size;
    return this;
  }

  /**
   * width in pixels; possible values: 240, 595, 600, 972, 1240 
   * @return size
  */
  @ApiModelProperty(value = "width in pixels; possible values: 240, 595, 600, 972, 1240 ")


  public SizeEnum getSize() {
    return size;
  }

  public void setSize(SizeEnum size) {
    this.size = size;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DocumentOfferPreviewGET documentOfferPreviewGET = (DocumentOfferPreviewGET) o;
    return Objects.equals(this.page, documentOfferPreviewGET.page) &&
        Objects.equals(this.size, documentOfferPreviewGET.size);
  }

  @Override
  public int hashCode() {
    return Objects.hash(page, size);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DocumentOfferPreviewGET {\n");
    
    sb.append("    page: ").append(toIndentedString(page)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
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

