package com.example.smallinvoicespringfeign.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
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
 * ContactAccountGET
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-11-30T10:06:31.741+01:00[Europe/Zurich]")
public class ContactAccountGET  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("id")
  private Integer id;

  @JsonProperty("default")
  private Boolean _default;

  /**
   * type (possible values: IBAN, ISR, QR, QRREF)
   */
  public enum TypeEnum {
    IBAN("IBAN"),
    
    ISR("ISR"),
    
    QR("QR"),
    
    QRREF("QRREF");

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

  @JsonProperty("number")
  private String number;

  @JsonProperty("bic")
  private String bic;

  @JsonProperty("description")
  private String description;

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

  public ContactAccountGET id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * id of an account
   * @return id
  */
  @ApiModelProperty(required = true, value = "id of an account")
  @NotNull


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public ContactAccountGET _default(Boolean _default) {
    this._default = _default;
    return this;
  }

  /**
   * whether it is a default contact's account
   * @return _default
  */
  @ApiModelProperty(required = true, value = "whether it is a default contact's account")
  @NotNull


  public Boolean getDefault() {
    return _default;
  }

  public void setDefault(Boolean _default) {
    this._default = _default;
  }

  public ContactAccountGET type(TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * type (possible values: IBAN, ISR, QR, QRREF)
   * @return type
  */
  @ApiModelProperty(required = true, value = "type (possible values: IBAN, ISR, QR, QRREF)")
  @NotNull


  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public ContactAccountGET number(String number) {
    this.number = number;
    return this;
  }

  /**
   * IBAN or ISR or QR IBAN (3xxxxx) number (depends on the type)
   * @return number
  */
  @ApiModelProperty(required = true, value = "IBAN or ISR or QR IBAN (3xxxxx) number (depends on the type)")
  @NotNull


  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public ContactAccountGET bic(String bic) {
    this.bic = bic;
    return this;
  }

  /**
   * BIC number
   * @return bic
  */
  @ApiModelProperty(required = true, value = "BIC number")
  @NotNull


  public String getBic() {
    return bic;
  }

  public void setBic(String bic) {
    this.bic = bic;
  }

  public ContactAccountGET description(String description) {
    this.description = description;
    return this;
  }

  /**
   * internal description
   * @return description
  */
  @ApiModelProperty(required = true, value = "internal description")
  @NotNull


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ContactAccountGET permissions(List<PermissionsEnum> permissions) {
    this.permissions = permissions;
    return this;
  }

  public ContactAccountGET addPermissionsItem(PermissionsEnum permissionsItem) {
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
    ContactAccountGET contactAccountGET = (ContactAccountGET) o;
    return Objects.equals(this.id, contactAccountGET.id) &&
        Objects.equals(this._default, contactAccountGET._default) &&
        Objects.equals(this.type, contactAccountGET.type) &&
        Objects.equals(this.number, contactAccountGET.number) &&
        Objects.equals(this.bic, contactAccountGET.bic) &&
        Objects.equals(this.description, contactAccountGET.description) &&
        Objects.equals(this.permissions, contactAccountGET.permissions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, _default, type, number, bic, description, permissions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContactAccountGET {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    _default: ").append(toIndentedString(_default)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
    sb.append("    bic: ").append(toIndentedString(bic)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

