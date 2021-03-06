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
 * ConfigurationBankAccountPUT
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-12-09T09:40:26.748128+01:00[Europe/Zurich]")
public class ConfigurationBankAccountPUT  implements Serializable {
  private static final long serialVersionUID = 1L;

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

  public ConfigurationBankAccountPUT _default(Boolean _default) {
    this._default = _default;
    return this;
  }

  /**
   * whether it is a default bank account
   * @return _default
  */
  @ApiModelProperty(value = "whether it is a default bank account")


  public Boolean getDefault() {
    return _default;
  }

  public void setDefault(Boolean _default) {
    this._default = _default;
  }

  public ConfigurationBankAccountPUT description(String description) {
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

  public ConfigurationBankAccountPUT bankName(String bankName) {
    this.bankName = bankName;
    return this;
  }

  /**
   * name of the bank
   * @return bankName
  */
  @ApiModelProperty(value = "name of the bank")


  public String getBankName() {
    return bankName;
  }

  public void setBankName(String bankName) {
    this.bankName = bankName;
  }

  public ConfigurationBankAccountPUT number(String number) {
    this.number = number;
    return this;
  }

  /**
   * bank account number
   * @return number
  */
  @ApiModelProperty(value = "bank account number")


  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public ConfigurationBankAccountPUT iban(String iban) {
    this.iban = iban;
    return this;
  }

  /**
   * IBAN
   * @return iban
  */
  @ApiModelProperty(value = "IBAN")


  public String getIban() {
    return iban;
  }

  public void setIban(String iban) {
    this.iban = iban;
  }

  public ConfigurationBankAccountPUT bic(String bic) {
    this.bic = bic;
    return this;
  }

  /**
   * BIC
   * @return bic
  */
  @ApiModelProperty(value = "BIC")


  public String getBic() {
    return bic;
  }

  public void setBic(String bic) {
    this.bic = bic;
  }

  public ConfigurationBankAccountPUT postAccount(String postAccount) {
    this.postAccount = postAccount;
    return this;
  }

  /**
   * bank???s postal account
   * @return postAccount
  */
  @ApiModelProperty(value = "bank???s postal account")


  public String getPostAccount() {
    return postAccount;
  }

  public void setPostAccount(String postAccount) {
    this.postAccount = postAccount;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConfigurationBankAccountPUT configurationBankAccountPUT = (ConfigurationBankAccountPUT) o;
    return Objects.equals(this._default, configurationBankAccountPUT._default) &&
        Objects.equals(this.description, configurationBankAccountPUT.description) &&
        Objects.equals(this.bankName, configurationBankAccountPUT.bankName) &&
        Objects.equals(this.number, configurationBankAccountPUT.number) &&
        Objects.equals(this.iban, configurationBankAccountPUT.iban) &&
        Objects.equals(this.bic, configurationBankAccountPUT.bic) &&
        Objects.equals(this.postAccount, configurationBankAccountPUT.postAccount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(_default, description, bankName, number, iban, bic, postAccount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConfigurationBankAccountPUT {\n");
    
    sb.append("    _default: ").append(toIndentedString(_default)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    bankName: ").append(toIndentedString(bankName)).append("\n");
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
    sb.append("    iban: ").append(toIndentedString(iban)).append("\n");
    sb.append("    bic: ").append(toIndentedString(bic)).append("\n");
    sb.append("    postAccount: ").append(toIndentedString(postAccount)).append("\n");
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

