package com.example.smallinvoicespringfeign.model;

import java.util.Objects;
import com.example.smallinvoicespringfeign.model.DescriptiveCustomFieldPOST;
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
 * CatalogServicePOST
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-28T19:49:25.792053+02:00[Europe/Zurich]")
public class CatalogServicePOST  implements Serializable {
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
  private List<DescriptiveCustomFieldPOST> customFields = null;

  public CatalogServicePOST number(String number) {
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

  public CatalogServicePOST name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CatalogServicePOST description(String description) {
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

  public CatalogServicePOST notes(String notes) {
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

  public CatalogServicePOST categoryId(Integer categoryId) {
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

  public CatalogServicePOST includingVat(Boolean includingVat) {
    this.includingVat = includingVat;
    return this;
  }

  /**
   * Get includingVat
   * @return includingVat
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Boolean getIncludingVat() {
    return includingVat;
  }

  public void setIncludingVat(Boolean includingVat) {
    this.includingVat = includingVat;
  }

  public CatalogServicePOST vat(Float vat) {
    this.vat = vat;
    return this;
  }

  /**
   * Get vat
   * @return vat
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Float getVat() {
    return vat;
  }

  public void setVat(Float vat) {
    this.vat = vat;
  }

  public CatalogServicePOST unitId(Integer unitId) {
    this.unitId = unitId;
    return this;
  }

  /**
   * Get unitId
   * @return unitId
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Integer getUnitId() {
    return unitId;
  }

  public void setUnitId(Integer unitId) {
    this.unitId = unitId;
  }

  public CatalogServicePOST price(Float price) {
    this.price = price;
    return this;
  }

  /**
   * Get price
   * @return price
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Float getPrice() {
    return price;
  }

  public void setPrice(Float price) {
    this.price = price;
  }

  public CatalogServicePOST defaultAmount(Integer defaultAmount) {
    this.defaultAmount = defaultAmount;
    return this;
  }

  /**
   * default value: 1
   * @return defaultAmount
  */
  @ApiModelProperty(value = "default value: 1")


  public Integer getDefaultAmount() {
    return defaultAmount;
  }

  public void setDefaultAmount(Integer defaultAmount) {
    this.defaultAmount = defaultAmount;
  }

  public CatalogServicePOST customFields(List<DescriptiveCustomFieldPOST> customFields) {
    this.customFields = customFields;
    return this;
  }

  public CatalogServicePOST addCustomFieldsItem(DescriptiveCustomFieldPOST customFieldsItem) {
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

  public List<DescriptiveCustomFieldPOST> getCustomFields() {
    return customFields;
  }

  public void setCustomFields(List<DescriptiveCustomFieldPOST> customFields) {
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
    CatalogServicePOST catalogServicePOST = (CatalogServicePOST) o;
    return Objects.equals(this.number, catalogServicePOST.number) &&
        Objects.equals(this.name, catalogServicePOST.name) &&
        Objects.equals(this.description, catalogServicePOST.description) &&
        Objects.equals(this.notes, catalogServicePOST.notes) &&
        Objects.equals(this.categoryId, catalogServicePOST.categoryId) &&
        Objects.equals(this.includingVat, catalogServicePOST.includingVat) &&
        Objects.equals(this.vat, catalogServicePOST.vat) &&
        Objects.equals(this.unitId, catalogServicePOST.unitId) &&
        Objects.equals(this.price, catalogServicePOST.price) &&
        Objects.equals(this.defaultAmount, catalogServicePOST.defaultAmount) &&
        Objects.equals(this.customFields, catalogServicePOST.customFields);
  }

  @Override
  public int hashCode() {
    return Objects.hash(number, name, description, notes, categoryId, includingVat, vat, unitId, price, defaultAmount, customFields);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CatalogServicePOST {\n");
    
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

