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
 * CatalogCategoryPUT
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-12-09T09:40:26.748128+01:00[Europe/Zurich]")
public class CatalogCategoryPUT  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("name")
  private String name;

  @JsonProperty("accounting_account_number")
  private String accountingAccountNumber;

  public CatalogCategoryPUT name(String name) {
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

  public CatalogCategoryPUT accountingAccountNumber(String accountingAccountNumber) {
    this.accountingAccountNumber = accountingAccountNumber;
    return this;
  }

  /**
   * Get accountingAccountNumber
   * @return accountingAccountNumber
  */
  @ApiModelProperty(value = "")


  public String getAccountingAccountNumber() {
    return accountingAccountNumber;
  }

  public void setAccountingAccountNumber(String accountingAccountNumber) {
    this.accountingAccountNumber = accountingAccountNumber;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CatalogCategoryPUT catalogCategoryPUT = (CatalogCategoryPUT) o;
    return Objects.equals(this.name, catalogCategoryPUT.name) &&
        Objects.equals(this.accountingAccountNumber, catalogCategoryPUT.accountingAccountNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, accountingAccountNumber);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CatalogCategoryPUT {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    accountingAccountNumber: ").append(toIndentedString(accountingAccountNumber)).append("\n");
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

