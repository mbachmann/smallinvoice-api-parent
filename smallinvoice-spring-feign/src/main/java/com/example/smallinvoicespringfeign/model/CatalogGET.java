package com.example.smallinvoicespringfeign.model;

import java.util.Objects;
import com.example.smallinvoicespringfeign.model.DescriptiveCustomFieldGET;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;

/**
 * CatalogGET
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-28T19:49:25.792053+02:00[Europe/Zurich]")
public class CatalogGET  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("id")
  private Integer id;

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

  @JsonProperty("category_name")
  private String categoryName;

  @JsonProperty("including_vat")
  private Boolean includingVat;

  @JsonProperty("vat")
  private Float vat;

  @JsonProperty("unit_id")
  private Integer unitId;

  @JsonProperty("unit_name")
  private String unitName;

  @JsonProperty("price")
  private Float price;

  @JsonProperty("price_purchase")
  private Float pricePurchase;

  @JsonProperty("inventory_available")
  private Float inventoryAvailable;

  @JsonProperty("inventory_reserved")
  private Float inventoryReserved;

  @JsonProperty("default_amount")
  private Integer defaultAmount;

  @JsonProperty("custom_fields")
  @Valid
  private List<DescriptiveCustomFieldGET> customFields = null;

  @JsonProperty("created")
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
  private LocalDateTime created;

  /**
   * Gets or Sets permissions
   */
  public enum PermissionsEnum {
    VIEW("view"),
    
    EDIT("edit");

    private String value;

    PermissionsEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static PermissionsEnum fromValue(String value) {
      for (PermissionsEnum b : PermissionsEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("permissions")
  @Valid
  private List<PermissionsEnum> permissions = null;

  public CatalogGET id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public CatalogGET number(String number) {
    this.number = number;
    return this;
  }

  /**
   * Get number
   * @return number
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public CatalogGET name(String name) {
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

  public CatalogGET description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public CatalogGET notes(String notes) {
    this.notes = notes;
    return this;
  }

  /**
   * Get notes
   * @return notes
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public CatalogGET categoryId(Integer categoryId) {
    this.categoryId = categoryId;
    return this;
  }

  /**
   * Get categoryId
   * @return categoryId
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Integer getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Integer categoryId) {
    this.categoryId = categoryId;
  }

  public CatalogGET categoryName(String categoryName) {
    this.categoryName = categoryName;
    return this;
  }

  /**
   * Get categoryName
   * @return categoryName
  */
  @ApiModelProperty(value = "")


  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }

  public CatalogGET includingVat(Boolean includingVat) {
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

  public CatalogGET vat(Float vat) {
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

  public CatalogGET unitId(Integer unitId) {
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

  public CatalogGET unitName(String unitName) {
    this.unitName = unitName;
    return this;
  }

  /**
   * Get unitName
   * @return unitName
  */
  @ApiModelProperty(value = "")


  public String getUnitName() {
    return unitName;
  }

  public void setUnitName(String unitName) {
    this.unitName = unitName;
  }

  public CatalogGET price(Float price) {
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

  public CatalogGET pricePurchase(Float pricePurchase) {
    this.pricePurchase = pricePurchase;
    return this;
  }

  /**
   * Get pricePurchase
   * @return pricePurchase
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Float getPricePurchase() {
    return pricePurchase;
  }

  public void setPricePurchase(Float pricePurchase) {
    this.pricePurchase = pricePurchase;
  }

  public CatalogGET inventoryAvailable(Float inventoryAvailable) {
    this.inventoryAvailable = inventoryAvailable;
    return this;
  }

  /**
   * Get inventoryAvailable
   * @return inventoryAvailable
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Float getInventoryAvailable() {
    return inventoryAvailable;
  }

  public void setInventoryAvailable(Float inventoryAvailable) {
    this.inventoryAvailable = inventoryAvailable;
  }

  public CatalogGET inventoryReserved(Float inventoryReserved) {
    this.inventoryReserved = inventoryReserved;
    return this;
  }

  /**
   * Get inventoryReserved
   * @return inventoryReserved
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Float getInventoryReserved() {
    return inventoryReserved;
  }

  public void setInventoryReserved(Float inventoryReserved) {
    this.inventoryReserved = inventoryReserved;
  }

  public CatalogGET defaultAmount(Integer defaultAmount) {
    this.defaultAmount = defaultAmount;
    return this;
  }

  /**
   * Get defaultAmount
   * @return defaultAmount
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Integer getDefaultAmount() {
    return defaultAmount;
  }

  public void setDefaultAmount(Integer defaultAmount) {
    this.defaultAmount = defaultAmount;
  }

  public CatalogGET customFields(List<DescriptiveCustomFieldGET> customFields) {
    this.customFields = customFields;
    return this;
  }

  public CatalogGET addCustomFieldsItem(DescriptiveCustomFieldGET customFieldsItem) {
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

  public List<DescriptiveCustomFieldGET> getCustomFields() {
    return customFields;
  }

  public void setCustomFields(List<DescriptiveCustomFieldGET> customFields) {
    this.customFields = customFields;
  }

  public CatalogGET created(LocalDateTime created) {
    this.created = created;
    return this;
  }

  /**
   * Get created
   * @return created
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public LocalDateTime getCreated() {
    return created;
  }

  public void setCreated(LocalDateTime created) {
    this.created = created;
  }

  public CatalogGET permissions(List<PermissionsEnum> permissions) {
    this.permissions = permissions;
    return this;
  }

  public CatalogGET addPermissionsItem(PermissionsEnum permissionsItem) {
    if (this.permissions == null) {
      this.permissions = new ArrayList<>();
    }
    this.permissions.add(permissionsItem);
    return this;
  }

  /**
   * actions that can be performed on an item (possible values: view, edit) 
   * @return permissions
  */
  @ApiModelProperty(value = "actions that can be performed on an item (possible values: view, edit) ")


  public List<PermissionsEnum> getPermissions() {
    return permissions;
  }

  public void setPermissions(List<PermissionsEnum> permissions) {
    this.permissions = permissions;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CatalogGET catalogGET = (CatalogGET) o;
    return Objects.equals(this.id, catalogGET.id) &&
        Objects.equals(this.number, catalogGET.number) &&
        Objects.equals(this.name, catalogGET.name) &&
        Objects.equals(this.description, catalogGET.description) &&
        Objects.equals(this.notes, catalogGET.notes) &&
        Objects.equals(this.categoryId, catalogGET.categoryId) &&
        Objects.equals(this.categoryName, catalogGET.categoryName) &&
        Objects.equals(this.includingVat, catalogGET.includingVat) &&
        Objects.equals(this.vat, catalogGET.vat) &&
        Objects.equals(this.unitId, catalogGET.unitId) &&
        Objects.equals(this.unitName, catalogGET.unitName) &&
        Objects.equals(this.price, catalogGET.price) &&
        Objects.equals(this.pricePurchase, catalogGET.pricePurchase) &&
        Objects.equals(this.inventoryAvailable, catalogGET.inventoryAvailable) &&
        Objects.equals(this.inventoryReserved, catalogGET.inventoryReserved) &&
        Objects.equals(this.defaultAmount, catalogGET.defaultAmount) &&
        Objects.equals(this.customFields, catalogGET.customFields) &&
        Objects.equals(this.created, catalogGET.created) &&
        Objects.equals(this.permissions, catalogGET.permissions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, number, name, description, notes, categoryId, categoryName, includingVat, vat, unitId, unitName, price, pricePurchase, inventoryAvailable, inventoryReserved, defaultAmount, customFields, created, permissions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CatalogGET {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    notes: ").append(toIndentedString(notes)).append("\n");
    sb.append("    categoryId: ").append(toIndentedString(categoryId)).append("\n");
    sb.append("    categoryName: ").append(toIndentedString(categoryName)).append("\n");
    sb.append("    includingVat: ").append(toIndentedString(includingVat)).append("\n");
    sb.append("    vat: ").append(toIndentedString(vat)).append("\n");
    sb.append("    unitId: ").append(toIndentedString(unitId)).append("\n");
    sb.append("    unitName: ").append(toIndentedString(unitName)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    pricePurchase: ").append(toIndentedString(pricePurchase)).append("\n");
    sb.append("    inventoryAvailable: ").append(toIndentedString(inventoryAvailable)).append("\n");
    sb.append("    inventoryReserved: ").append(toIndentedString(inventoryReserved)).append("\n");
    sb.append("    defaultAmount: ").append(toIndentedString(defaultAmount)).append("\n");
    sb.append("    customFields: ").append(toIndentedString(customFields)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    permissions: ").append(toIndentedString(permissions)).append("\n");
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

