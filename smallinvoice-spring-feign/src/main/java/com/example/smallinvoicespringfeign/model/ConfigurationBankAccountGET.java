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
 * ConfigurationBankAccountGET
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-31T13:05:18.255013+02:00[Europe/Zurich]")
public class ConfigurationBankAccountGET  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("id")
  private Integer id;

  @JsonProperty("default")
  private Boolean _default;

  @JsonProperty("description")
  private String description;

  @JsonProperty("bank_name")
  private String bankName;

  @JsonProperty("number")
  private String number;

  @JsonProperty("iban")
  private String iban;

  @JsonProperty("bic")
  private String bic;

  @JsonProperty("post_account")
  private String postAccount;

  /**
   * one of: [active, inactive, requested]
   */
  public enum AutoSyncEnum {
    ACTIVE("active"),
    
    INACTIVE("inactive"),
    
    REQUESTED("requested");

    private String value;

    AutoSyncEnum(String value) {
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
    public static AutoSyncEnum fromValue(String value) {
      for (AutoSyncEnum b : AutoSyncEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("auto_sync")
  private AutoSyncEnum autoSync;

  /**
   * one of: [in, out, null (means no direction specified)]
   */
  public enum AutoSyncDirectionEnum {
    IN("in"),
    
    OUT("out"),
    
    NULL("null");

    private String value;

    AutoSyncDirectionEnum(String value) {
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
    public static AutoSyncDirectionEnum fromValue(String value) {
      for (AutoSyncDirectionEnum b : AutoSyncDirectionEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("auto_sync_direction")
  private AutoSyncDirectionEnum autoSyncDirection;

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

  public ConfigurationBankAccountGET id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * id of a bank account
   * @return id
  */
  @ApiModelProperty(required = true, value = "id of a bank account")
  @NotNull


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public ConfigurationBankAccountGET _default(Boolean _default) {
    this._default = _default;
    return this;
  }

  /**
   * whether it is a default bank account
   * @return _default
  */
  @ApiModelProperty(required = true, value = "whether it is a default bank account")
  @NotNull


  public Boolean getDefault() {
    return _default;
  }

  public void setDefault(Boolean _default) {
    this._default = _default;
  }

  public ConfigurationBankAccountGET description(String description) {
    this.description = description;
    return this;
  }

  /**
   * description
   * @return description
  */
  @ApiModelProperty(required = true, value = "description")
  @NotNull


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ConfigurationBankAccountGET bankName(String bankName) {
    this.bankName = bankName;
    return this;
  }

  /**
   * name of the bank
   * @return bankName
  */
  @ApiModelProperty(required = true, value = "name of the bank")
  @NotNull


  public String getBankName() {
    return bankName;
  }

  public void setBankName(String bankName) {
    this.bankName = bankName;
  }

  public ConfigurationBankAccountGET number(String number) {
    this.number = number;
    return this;
  }

  /**
   * bank account number
   * @return number
  */
  @ApiModelProperty(required = true, value = "bank account number")
  @NotNull


  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public ConfigurationBankAccountGET iban(String iban) {
    this.iban = iban;
    return this;
  }

  /**
   * IBAN
   * @return iban
  */
  @ApiModelProperty(required = true, value = "IBAN")
  @NotNull


  public String getIban() {
    return iban;
  }

  public void setIban(String iban) {
    this.iban = iban;
  }

  public ConfigurationBankAccountGET bic(String bic) {
    this.bic = bic;
    return this;
  }

  /**
   * BIC
   * @return bic
  */
  @ApiModelProperty(required = true, value = "BIC")
  @NotNull


  public String getBic() {
    return bic;
  }

  public void setBic(String bic) {
    this.bic = bic;
  }

  public ConfigurationBankAccountGET postAccount(String postAccount) {
    this.postAccount = postAccount;
    return this;
  }

  /**
   * bank’s postal account
   * @return postAccount
  */
  @ApiModelProperty(required = true, value = "bank’s postal account")
  @NotNull


  public String getPostAccount() {
    return postAccount;
  }

  public void setPostAccount(String postAccount) {
    this.postAccount = postAccount;
  }

  public ConfigurationBankAccountGET autoSync(AutoSyncEnum autoSync) {
    this.autoSync = autoSync;
    return this;
  }

  /**
   * one of: [active, inactive, requested]
   * @return autoSync
  */
  @ApiModelProperty(required = true, value = "one of: [active, inactive, requested]")
  @NotNull


  public AutoSyncEnum getAutoSync() {
    return autoSync;
  }

  public void setAutoSync(AutoSyncEnum autoSync) {
    this.autoSync = autoSync;
  }

  public ConfigurationBankAccountGET autoSyncDirection(AutoSyncDirectionEnum autoSyncDirection) {
    this.autoSyncDirection = autoSyncDirection;
    return this;
  }

  /**
   * one of: [in, out, null (means no direction specified)]
   * @return autoSyncDirection
  */
  @ApiModelProperty(required = true, value = "one of: [in, out, null (means no direction specified)]")
  @NotNull


  public AutoSyncDirectionEnum getAutoSyncDirection() {
    return autoSyncDirection;
  }

  public void setAutoSyncDirection(AutoSyncDirectionEnum autoSyncDirection) {
    this.autoSyncDirection = autoSyncDirection;
  }

  public ConfigurationBankAccountGET permissions(List<PermissionsEnum> permissions) {
    this.permissions = permissions;
    return this;
  }

  public ConfigurationBankAccountGET addPermissionsItem(PermissionsEnum permissionsItem) {
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
    ConfigurationBankAccountGET configurationBankAccountGET = (ConfigurationBankAccountGET) o;
    return Objects.equals(this.id, configurationBankAccountGET.id) &&
        Objects.equals(this._default, configurationBankAccountGET._default) &&
        Objects.equals(this.description, configurationBankAccountGET.description) &&
        Objects.equals(this.bankName, configurationBankAccountGET.bankName) &&
        Objects.equals(this.number, configurationBankAccountGET.number) &&
        Objects.equals(this.iban, configurationBankAccountGET.iban) &&
        Objects.equals(this.bic, configurationBankAccountGET.bic) &&
        Objects.equals(this.postAccount, configurationBankAccountGET.postAccount) &&
        Objects.equals(this.autoSync, configurationBankAccountGET.autoSync) &&
        Objects.equals(this.autoSyncDirection, configurationBankAccountGET.autoSyncDirection) &&
        Objects.equals(this.permissions, configurationBankAccountGET.permissions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, _default, description, bankName, number, iban, bic, postAccount, autoSync, autoSyncDirection, permissions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConfigurationBankAccountGET {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    _default: ").append(toIndentedString(_default)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    bankName: ").append(toIndentedString(bankName)).append("\n");
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
    sb.append("    iban: ").append(toIndentedString(iban)).append("\n");
    sb.append("    bic: ").append(toIndentedString(bic)).append("\n");
    sb.append("    postAccount: ").append(toIndentedString(postAccount)).append("\n");
    sb.append("    autoSync: ").append(toIndentedString(autoSync)).append("\n");
    sb.append("    autoSyncDirection: ").append(toIndentedString(autoSyncDirection)).append("\n");
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

