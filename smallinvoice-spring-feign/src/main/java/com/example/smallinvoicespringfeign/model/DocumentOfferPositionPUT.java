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
 * DocumentOfferPositionPUT
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-08-03T21:09:37.732+02:00[Europe/Zurich]")
public class DocumentOfferPositionPUT  implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * position type; possible values: N - normal, T - text, PB - page break, H - header, SI - subtotal (incremental), SNI - subtotal (non incremental) 
   */
  public enum TypeEnum {
    N("N"),
    
    T("T"),
    
    PB("PB"),
    
    H("H"),
    
    SI("SI"),
    
    SNI("SNI");

    private String value;

    TypeEnum(String value) {
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
    public static TypeEnum fromValue(String value) {
      for (TypeEnum b : TypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("type")
  private TypeEnum type;

  /**
   * position catalog type; possible values: P - product, S - service 
   */
  public enum CatalogTypeEnum {
    P("P"),
    
    S("S");

    private String value;

    CatalogTypeEnum(String value) {
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
    public static CatalogTypeEnum fromValue(String value) {
      for (CatalogTypeEnum b : CatalogTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("catalog_type")
  private CatalogTypeEnum catalogType;

  @JsonProperty("number")
  private String number;

  @JsonProperty("name")
  private String name;

  @JsonProperty("description")
  private String description;

  @JsonProperty("price")
  private Float price;

  @JsonProperty("vat")
  private Float vat;

  @JsonProperty("amount")
  private Float amount;

  @JsonProperty("unit_id")
  private Integer unitId;

  @JsonProperty("discount_rate")
  private Float discountRate;

  /**
   * optional discount type; possible values: A - amount, P - in % 
   */
  public enum DiscountTypeEnum {
    A("A"),
    
    P("P");

    private String value;

    DiscountTypeEnum(String value) {
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
    public static DiscountTypeEnum fromValue(String value) {
      for (DiscountTypeEnum b : DiscountTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("discount_type")
  private DiscountTypeEnum discountType = DiscountTypeEnum.P;

  @JsonProperty("show_only_total")
  private Boolean showOnlyTotal;

  public DocumentOfferPositionPUT type(TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * position type; possible values: N - normal, T - text, PB - page break, H - header, SI - subtotal (incremental), SNI - subtotal (non incremental) 
   * @return type
  */
  @ApiModelProperty(required = true, value = "position type; possible values: N - normal, T - text, PB - page break, H - header, SI - subtotal (incremental), SNI - subtotal (non incremental) ")
  @NotNull


  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public DocumentOfferPositionPUT catalogType(CatalogTypeEnum catalogType) {
    this.catalogType = catalogType;
    return this;
  }

  /**
   * position catalog type; possible values: P - product, S - service 
   * @return catalogType
  */
  @ApiModelProperty(required = true, value = "position catalog type; possible values: P - product, S - service ")
  @NotNull


  public CatalogTypeEnum getCatalogType() {
    return catalogType;
  }

  public void setCatalogType(CatalogTypeEnum catalogType) {
    this.catalogType = catalogType;
  }

  public DocumentOfferPositionPUT number(String number) {
    this.number = number;
    return this;
  }

  /**
   * catalog unique number
   * @return number
  */
  @ApiModelProperty(value = "catalog unique number")


  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public DocumentOfferPositionPUT name(String name) {
    this.name = name;
    return this;
  }

  /**
   * name
   * @return name
  */
  @ApiModelProperty(value = "name")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public DocumentOfferPositionPUT description(String description) {
    this.description = description;
    return this;
  }

  /**
   * description
   * @return description
  */
  @ApiModelProperty(value = "description")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public DocumentOfferPositionPUT price(Float price) {
    this.price = price;
    return this;
  }

  /**
   * price per unit; required for N type
   * @return price
  */
  @ApiModelProperty(value = "price per unit; required for N type")


  public Float getPrice() {
    return price;
  }

  public void setPrice(Float price) {
    this.price = price;
  }

  public DocumentOfferPositionPUT vat(Float vat) {
    this.vat = vat;
    return this;
  }

  /**
   * VAT rate; required for N type
   * @return vat
  */
  @ApiModelProperty(value = "VAT rate; required for N type")


  public Float getVat() {
    return vat;
  }

  public void setVat(Float vat) {
    this.vat = vat;
  }

  public DocumentOfferPositionPUT amount(Float amount) {
    this.amount = amount;
    return this;
  }

  /**
   * amount; required for N type
   * @return amount
  */
  @ApiModelProperty(value = "amount; required for N type")


  public Float getAmount() {
    return amount;
  }

  public void setAmount(Float amount) {
    this.amount = amount;
  }

  public DocumentOfferPositionPUT unitId(Integer unitId) {
    this.unitId = unitId;
    return this;
  }

  /**
   * id of the unit; required for N type
   * @return unitId
  */
  @ApiModelProperty(value = "id of the unit; required for N type")


  public Integer getUnitId() {
    return unitId;
  }

  public void setUnitId(Integer unitId) {
    this.unitId = unitId;
  }

  public DocumentOfferPositionPUT discountRate(Float discountRate) {
    this.discountRate = discountRate;
    return this;
  }

  /**
   * optional discount rate
   * @return discountRate
  */
  @ApiModelProperty(value = "optional discount rate")


  public Float getDiscountRate() {
    return discountRate;
  }

  public void setDiscountRate(Float discountRate) {
    this.discountRate = discountRate;
  }

  public DocumentOfferPositionPUT discountType(DiscountTypeEnum discountType) {
    this.discountType = discountType;
    return this;
  }

  /**
   * optional discount type; possible values: A - amount, P - in % 
   * @return discountType
  */
  @ApiModelProperty(value = "optional discount type; possible values: A - amount, P - in % ")


  public DiscountTypeEnum getDiscountType() {
    return discountType;
  }

  public void setDiscountType(DiscountTypeEnum discountType) {
    this.discountType = discountType;
  }

  public DocumentOfferPositionPUT showOnlyTotal(Boolean showOnlyTotal) {
    this.showOnlyTotal = showOnlyTotal;
    return this;
  }

  /**
   * whether to show only total on invoice
   * @return showOnlyTotal
  */
  @ApiModelProperty(value = "whether to show only total on invoice")


  public Boolean getShowOnlyTotal() {
    return showOnlyTotal;
  }

  public void setShowOnlyTotal(Boolean showOnlyTotal) {
    this.showOnlyTotal = showOnlyTotal;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DocumentOfferPositionPUT documentOfferPositionPUT = (DocumentOfferPositionPUT) o;
    return Objects.equals(this.type, documentOfferPositionPUT.type) &&
        Objects.equals(this.catalogType, documentOfferPositionPUT.catalogType) &&
        Objects.equals(this.number, documentOfferPositionPUT.number) &&
        Objects.equals(this.name, documentOfferPositionPUT.name) &&
        Objects.equals(this.description, documentOfferPositionPUT.description) &&
        Objects.equals(this.price, documentOfferPositionPUT.price) &&
        Objects.equals(this.vat, documentOfferPositionPUT.vat) &&
        Objects.equals(this.amount, documentOfferPositionPUT.amount) &&
        Objects.equals(this.unitId, documentOfferPositionPUT.unitId) &&
        Objects.equals(this.discountRate, documentOfferPositionPUT.discountRate) &&
        Objects.equals(this.discountType, documentOfferPositionPUT.discountType) &&
        Objects.equals(this.showOnlyTotal, documentOfferPositionPUT.showOnlyTotal);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, catalogType, number, name, description, price, vat, amount, unitId, discountRate, discountType, showOnlyTotal);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DocumentOfferPositionPUT {\n");
    
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    catalogType: ").append(toIndentedString(catalogType)).append("\n");
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    vat: ").append(toIndentedString(vat)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    unitId: ").append(toIndentedString(unitId)).append("\n");
    sb.append("    discountRate: ").append(toIndentedString(discountRate)).append("\n");
    sb.append("    discountType: ").append(toIndentedString(discountType)).append("\n");
    sb.append("    showOnlyTotal: ").append(toIndentedString(showOnlyTotal)).append("\n");
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

