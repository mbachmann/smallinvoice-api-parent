package com.example.smallinvoicespringfeign.model;

import java.util.Objects;
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
 * DocumentFreeTextGET
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-11-30T10:06:31.741+01:00[Europe/Zurich]")
public class DocumentFreeTextGET  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("text")
  private String text;

  @JsonProperty("font_size")
  private Integer fontSize;

  @JsonProperty("position_x")
  private Float positionX;

  @JsonProperty("position_y")
  private Float positionY;

  @JsonProperty("page")
  private Integer page;

  public DocumentFreeTextGET text(String text) {
    this.text = text;
    return this;
  }

  /**
   * displayed text
   * @return text
  */
  @ApiModelProperty(required = true, value = "displayed text")
  @NotNull


  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public DocumentFreeTextGET fontSize(Integer fontSize) {
    this.fontSize = fontSize;
    return this;
  }

  /**
   * font size of displayed text (min: 1; max: 50)
   * @return fontSize
  */
  @ApiModelProperty(required = true, value = "font size of displayed text (min: 1; max: 50)")
  @NotNull


  public Integer getFontSize() {
    return fontSize;
  }

  public void setFontSize(Integer fontSize) {
    this.fontSize = fontSize;
  }

  public DocumentFreeTextGET positionX(Float positionX) {
    this.positionX = positionX;
    return this;
  }

  /**
   * y coordinate of displayed text
   * @return positionX
  */
  @ApiModelProperty(required = true, value = "y coordinate of displayed text")
  @NotNull


  public Float getPositionX() {
    return positionX;
  }

  public void setPositionX(Float positionX) {
    this.positionX = positionX;
  }

  public DocumentFreeTextGET positionY(Float positionY) {
    this.positionY = positionY;
    return this;
  }

  /**
   * x coordinate of displayed text
   * @return positionY
  */
  @ApiModelProperty(required = true, value = "x coordinate of displayed text")
  @NotNull


  public Float getPositionY() {
    return positionY;
  }

  public void setPositionY(Float positionY) {
    this.positionY = positionY;
  }

  public DocumentFreeTextGET page(Integer page) {
    this.page = page;
    return this;
  }

  /**
   * which page text is displayed on
   * @return page
  */
  @ApiModelProperty(required = true, value = "which page text is displayed on")
  @NotNull


  public Integer getPage() {
    return page;
  }

  public void setPage(Integer page) {
    this.page = page;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DocumentFreeTextGET documentFreeTextGET = (DocumentFreeTextGET) o;
    return Objects.equals(this.text, documentFreeTextGET.text) &&
        Objects.equals(this.fontSize, documentFreeTextGET.fontSize) &&
        Objects.equals(this.positionX, documentFreeTextGET.positionX) &&
        Objects.equals(this.positionY, documentFreeTextGET.positionY) &&
        Objects.equals(this.page, documentFreeTextGET.page);
  }

  @Override
  public int hashCode() {
    return Objects.hash(text, fontSize, positionX, positionY, page);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DocumentFreeTextGET {\n");
    
    sb.append("    text: ").append(toIndentedString(text)).append("\n");
    sb.append("    fontSize: ").append(toIndentedString(fontSize)).append("\n");
    sb.append("    positionX: ").append(toIndentedString(positionX)).append("\n");
    sb.append("    positionY: ").append(toIndentedString(positionY)).append("\n");
    sb.append("    page: ").append(toIndentedString(page)).append("\n");
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

