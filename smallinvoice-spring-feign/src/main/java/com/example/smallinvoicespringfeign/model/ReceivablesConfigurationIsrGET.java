package com.example.smallinvoicespringfeign.model;

import java.util.Objects;
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
 * ReceivablesConfigurationIsrGET
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-11-30T10:06:31.741+01:00[Europe/Zurich]")
public class ReceivablesConfigurationIsrGET  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("id")
  private Integer id;

  @JsonProperty("default")
  private Boolean _default;

  /**
   * possible values: ISR - orange inpayment slip, ISR+ - orange inpayment slip plus, RIS - red inpayment slip 
   */
  public enum TypeEnum {
    ISR("ISR"),
    
    ISR_("ISR+"),
    
    RIS("RIS");

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
   * possible values: A - additional page, F - first page, L - last page 
   */
  public enum PositionEnum {
    A("A"),
    
    F("F"),
    
    L("L");

    private String value;

    PositionEnum(String value) {
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
    public static PositionEnum fromValue(String value) {
      for (PositionEnum b : PositionEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("position")
  private PositionEnum position;

  @JsonProperty("name")
  private String name;

  @JsonProperty("bank_name")
  private String bankName;

  @JsonProperty("bank_address")
  private String bankAddress;

  @JsonProperty("recipient_name")
  private String recipientName;

  @JsonProperty("recipient_addition")
  private String recipientAddition;

  @JsonProperty("recipient_street")
  private String recipientStreet;

  @JsonProperty("recipient_city")
  private String recipientCity;

  @JsonProperty("delivery_number")
  private String deliveryNumber;

  @JsonProperty("iban")
  private String iban;

  @JsonProperty("subscriber_number")
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
  private LocalDateTime subscriberNumber;

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

  public ReceivablesConfigurationIsrGET id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * ISR id
   * @return id
  */
  @ApiModelProperty(required = true, value = "ISR id")
  @NotNull


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public ReceivablesConfigurationIsrGET _default(Boolean _default) {
    this._default = _default;
    return this;
  }

  /**
   * whether ISR is a default one
   * @return _default
  */
  @ApiModelProperty(required = true, value = "whether ISR is a default one")
  @NotNull


  public Boolean getDefault() {
    return _default;
  }

  public void setDefault(Boolean _default) {
    this._default = _default;
  }

  public ReceivablesConfigurationIsrGET type(TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * possible values: ISR - orange inpayment slip, ISR+ - orange inpayment slip plus, RIS - red inpayment slip 
   * @return type
  */
  @ApiModelProperty(required = true, value = "possible values: ISR - orange inpayment slip, ISR+ - orange inpayment slip plus, RIS - red inpayment slip ")
  @NotNull


  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public ReceivablesConfigurationIsrGET position(PositionEnum position) {
    this.position = position;
    return this;
  }

  /**
   * possible values: A - additional page, F - first page, L - last page 
   * @return position
  */
  @ApiModelProperty(required = true, value = "possible values: A - additional page, F - first page, L - last page ")
  @NotNull


  public PositionEnum getPosition() {
    return position;
  }

  public void setPosition(PositionEnum position) {
    this.position = position;
  }

  public ReceivablesConfigurationIsrGET name(String name) {
    this.name = name;
    return this;
  }

  /**
   * optional ISR name (for internal system use only)
   * @return name
  */
  @ApiModelProperty(required = true, value = "optional ISR name (for internal system use only)")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ReceivablesConfigurationIsrGET bankName(String bankName) {
    this.bankName = bankName;
    return this;
  }

  /**
   * Get bankName
   * @return bankName
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getBankName() {
    return bankName;
  }

  public void setBankName(String bankName) {
    this.bankName = bankName;
  }

  public ReceivablesConfigurationIsrGET bankAddress(String bankAddress) {
    this.bankAddress = bankAddress;
    return this;
  }

  /**
   * Get bankAddress
   * @return bankAddress
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getBankAddress() {
    return bankAddress;
  }

  public void setBankAddress(String bankAddress) {
    this.bankAddress = bankAddress;
  }

  public ReceivablesConfigurationIsrGET recipientName(String recipientName) {
    this.recipientName = recipientName;
    return this;
  }

  /**
   * Get recipientName
   * @return recipientName
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getRecipientName() {
    return recipientName;
  }

  public void setRecipientName(String recipientName) {
    this.recipientName = recipientName;
  }

  public ReceivablesConfigurationIsrGET recipientAddition(String recipientAddition) {
    this.recipientAddition = recipientAddition;
    return this;
  }

  /**
   * Get recipientAddition
   * @return recipientAddition
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getRecipientAddition() {
    return recipientAddition;
  }

  public void setRecipientAddition(String recipientAddition) {
    this.recipientAddition = recipientAddition;
  }

  public ReceivablesConfigurationIsrGET recipientStreet(String recipientStreet) {
    this.recipientStreet = recipientStreet;
    return this;
  }

  /**
   * Get recipientStreet
   * @return recipientStreet
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getRecipientStreet() {
    return recipientStreet;
  }

  public void setRecipientStreet(String recipientStreet) {
    this.recipientStreet = recipientStreet;
  }

  public ReceivablesConfigurationIsrGET recipientCity(String recipientCity) {
    this.recipientCity = recipientCity;
    return this;
  }

  /**
   * Get recipientCity
   * @return recipientCity
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getRecipientCity() {
    return recipientCity;
  }

  public void setRecipientCity(String recipientCity) {
    this.recipientCity = recipientCity;
  }

  public ReceivablesConfigurationIsrGET deliveryNumber(String deliveryNumber) {
    this.deliveryNumber = deliveryNumber;
    return this;
  }

  /**
   * Get deliveryNumber
   * @return deliveryNumber
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getDeliveryNumber() {
    return deliveryNumber;
  }

  public void setDeliveryNumber(String deliveryNumber) {
    this.deliveryNumber = deliveryNumber;
  }

  public ReceivablesConfigurationIsrGET iban(String iban) {
    this.iban = iban;
    return this;
  }

  /**
   * Get iban
   * @return iban
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getIban() {
    return iban;
  }

  public void setIban(String iban) {
    this.iban = iban;
  }

  public ReceivablesConfigurationIsrGET subscriberNumber(LocalDateTime subscriberNumber) {
    this.subscriberNumber = subscriberNumber;
    return this;
  }

  /**
   * date that ISR was created
   * @return subscriberNumber
  */
  @ApiModelProperty(required = true, value = "date that ISR was created")
  @NotNull

  @Valid

  public LocalDateTime getSubscriberNumber() {
    return subscriberNumber;
  }

  public void setSubscriberNumber(LocalDateTime subscriberNumber) {
    this.subscriberNumber = subscriberNumber;
  }

  public ReceivablesConfigurationIsrGET permissions(List<PermissionsEnum> permissions) {
    this.permissions = permissions;
    return this;
  }

  public ReceivablesConfigurationIsrGET addPermissionsItem(PermissionsEnum permissionsItem) {
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
    ReceivablesConfigurationIsrGET receivablesConfigurationIsrGET = (ReceivablesConfigurationIsrGET) o;
    return Objects.equals(this.id, receivablesConfigurationIsrGET.id) &&
        Objects.equals(this._default, receivablesConfigurationIsrGET._default) &&
        Objects.equals(this.type, receivablesConfigurationIsrGET.type) &&
        Objects.equals(this.position, receivablesConfigurationIsrGET.position) &&
        Objects.equals(this.name, receivablesConfigurationIsrGET.name) &&
        Objects.equals(this.bankName, receivablesConfigurationIsrGET.bankName) &&
        Objects.equals(this.bankAddress, receivablesConfigurationIsrGET.bankAddress) &&
        Objects.equals(this.recipientName, receivablesConfigurationIsrGET.recipientName) &&
        Objects.equals(this.recipientAddition, receivablesConfigurationIsrGET.recipientAddition) &&
        Objects.equals(this.recipientStreet, receivablesConfigurationIsrGET.recipientStreet) &&
        Objects.equals(this.recipientCity, receivablesConfigurationIsrGET.recipientCity) &&
        Objects.equals(this.deliveryNumber, receivablesConfigurationIsrGET.deliveryNumber) &&
        Objects.equals(this.iban, receivablesConfigurationIsrGET.iban) &&
        Objects.equals(this.subscriberNumber, receivablesConfigurationIsrGET.subscriberNumber) &&
        Objects.equals(this.permissions, receivablesConfigurationIsrGET.permissions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, _default, type, position, name, bankName, bankAddress, recipientName, recipientAddition, recipientStreet, recipientCity, deliveryNumber, iban, subscriberNumber, permissions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReceivablesConfigurationIsrGET {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    _default: ").append(toIndentedString(_default)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    position: ").append(toIndentedString(position)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    bankName: ").append(toIndentedString(bankName)).append("\n");
    sb.append("    bankAddress: ").append(toIndentedString(bankAddress)).append("\n");
    sb.append("    recipientName: ").append(toIndentedString(recipientName)).append("\n");
    sb.append("    recipientAddition: ").append(toIndentedString(recipientAddition)).append("\n");
    sb.append("    recipientStreet: ").append(toIndentedString(recipientStreet)).append("\n");
    sb.append("    recipientCity: ").append(toIndentedString(recipientCity)).append("\n");
    sb.append("    deliveryNumber: ").append(toIndentedString(deliveryNumber)).append("\n");
    sb.append("    iban: ").append(toIndentedString(iban)).append("\n");
    sb.append("    subscriberNumber: ").append(toIndentedString(subscriberNumber)).append("\n");
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

