package com.example.smallinvoicespringfeign.model;

import java.util.Objects;
import com.example.smallinvoicespringfeign.model.DescriptiveCustomFieldPUT;
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
 * CatalogServicePUT
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-29T19:43:05.733009+02:00[Europe/Zurich]")
public class CatalogServicePUT  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("number")
  private String number;

  @JsonProperty("name")
  private String name;

  @JsonProperty("description")
  private String description;

  @JsonProperty("notes")
  private String notes;

  @JsonProperty("category_id")
  private Integer categoryId;

  @JsonProperty("including_vat")
  private Boolean includingVat;

  @JsonProperty("vat")
  private Float vat;

  @JsonProperty("unit_id")
  private Integer unitId;

  @JsonProperty("price")
  private Float price;

  @JsonProperty("default_amount")
  private Integer defaultAmount;

  @JsonProperty("custom_fields")
  @Valid
  private List<DescriptiveCustomFieldPUT> customFields = null;

  public CatalogServicePUT number(String number) {
    this.number = number;
    return this;
  }

  /**
   * Get number
   * @return number
  */
  @ApiModelProperty(value = "")


  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public CatalogServicePUT name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @ApiModelProperty(value = "")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CatalogServicePUT description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
  */
  @ApiModelProperty(value = "")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public CatalogServicePUT notes(String notes) {
    this.notes = notes;
    return this;
  }

  /**
   * Get notes
   * @return notes
  */
  @ApiModelProperty(value = "")


  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public CatalogServicePUT categoryId(Integer categoryId) {
    this.categoryId = categoryId;
    return this;
  }

  /**
   * Get categoryId
   * @return categoryId
  */
  @ApiModelProperty(value = "")


  public Integer getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Integer categoryId) {
    this.categoryId = categoryId;
  }

  public CatalogServicePUT includingVat(Boolean includingVat) {
    this.includingVat = includingVat;
    return this;
  }

  /**
   * Get includingVat
   * @return includingVat
  */
  @ApiModelProperty(value = "")


  public Boolean getIncludingVat() {
    return includingVat;
  }

  public void setIncludingVat(Boolean includingVat) {
    this.includingVat = includingVat;
  }

  public CatalogServicePUT vat(Float vat) {
    this.vat = vat;
    return this;
  }

  /**
   * Get vat
   * @return vat
  */
  @ApiModelProperty(value = "")


  public Float getVat() {
    return vat;
  }

  public void setVat(Float vat) {
    this.vat = vat;
  }

  public CatalogServicePUT unitId(Integer unitId) {
    this.unitId = unitId;
    return this;
  }

  /**
   * Get unitId
   * @return unitId
  */
  @ApiModelProperty(value = "")


  public Integer getUnitId() {
    return unitId;
  }

  public void setUnitId(Integer unitId) {
    this.unitId = unitId;
  }

  public CatalogServicePUT price(Float price) {
    this.price = price;
    return this;
  }

  /**
   * Get price
   * @return price
  */
  @ApiModelProperty(value = "")


  public Float getPrice() {
    return price;
  }

  public void setPrice(Float price) {
    this.price = price;
  }

  public CatalogServicePUT defaultAmount(Integer defaultAmount) {
    this.defaultAmount = defaultAmount;
    return this;
  }

  /**
   * Get defaultAmount
   * @return defaultAmount
  */
  @ApiModelProperty(value = "")


  public Integer getDefaultAmount() {
    return defaultAmount;
  }

  public void setDefaultAmount(Integer defaultAmount) {
    this.defaultAmount = defaultAmount;
  }

  public CatalogServicePUT customFields(List<DescriptiveCustomFieldPUT> customFields) {
    this.customFields = customFields;
    return this;
  }

  public CatalogServicePUT addCustomFieldsItem(DescriptiveCustomFieldPUT customFieldsItem) {
    if (this.customFields == null) {
      this.customFields = new ArrayList<>();
    }
    this.customFields.add(customFieldsItem);
    return this;
  }

  /**
   * custom fields values
   * @return customFields
  */
  @ApiModelProperty(value = "custom fields values")

  @Valid

  public List<DescriptiveCustomFieldPUT> getCustomFields() {
    return customFields;
  }

  public void setCustomFields(List<DescriptiveCustomFieldPUT> customFields) {
    this.customFields = customFields;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CatalogServicePUT catalogServicePUT = (CatalogServicePUT) o;
    return Objects.equals(this.number, catalogServicePUT.number) &&
        Objects.equals(this.name, catalogServicePUT.name) &&
        Objects.equals(this.description, catalogServicePUT.description) &&
        Objects.equals(this.notes, catalogServicePUT.notes) &&
        Objects.equals(this.categoryId, catalogServicePUT.categoryId) &&
        Objects.equals(this.includingVat, catalogServicePUT.includingVat) &&
        Objects.equals(this.vat, catalogServicePUT.vat) &&
        Objects.equals(this.unitId, catalogServicePUT.unitId) &&
        Objects.equals(this.price, catalogServicePUT.price) &&
        Objects.equals(this.defaultAmount, catalogServicePUT.defaultAmount) &&
        Objects.equals(this.customFields, catalogServicePUT.customFields);
  }

  @Override
  public int hashCode() {
    return Objects.hash(number, name, description, notes, categoryId, includingVat, vat, unitId, price, defaultAmount, customFields);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CatalogServicePUT {\n");
    
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    notes: ").append(toIndentedString(notes)).append("\n");
    sb.append("    categoryId: ").append(toIndentedString(categoryId)).append("\n");
    sb.append("    includingVat: ").append(toIndentedString(includingVat)).append("\n");
    sb.append("    vat: ").append(toIndentedString(vat)).append("\n");
    sb.append("    unitId: ").append(toIndentedString(unitId)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    defaultAmount: ").append(toIndentedString(defaultAmount)).append("\n");
    sb.append("    customFields: ").append(toIndentedString(customFields)).append("\n");
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

