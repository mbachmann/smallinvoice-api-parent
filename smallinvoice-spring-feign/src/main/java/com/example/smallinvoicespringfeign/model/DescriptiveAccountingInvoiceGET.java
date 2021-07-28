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
 * DescriptiveAccountingInvoiceGET
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-28T19:49:25.792053+02:00[Europe/Zurich]")
public class DescriptiveAccountingInvoiceGET  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("amount")
  private Float amount;

  @JsonProperty("currency")
  private String currency;

  @JsonProperty("count")
  private Integer count;

  public DescriptiveAccountingInvoiceGET amount(Float amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Get amount
   * @return amount
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Float getAmount() {
    return amount;
  }

  public void setAmount(Float amount) {
    this.amount = amount;
  }

  public DescriptiveAccountingInvoiceGET currency(String currency) {
    this.currency = currency;
    return this;
  }

  /**
   * Get currency
   * @return currency
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public DescriptiveAccountingInvoiceGET count(Integer count) {
    this.count = count;
    return this;
  }

  /**
   * Get count
   * @return count
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DescriptiveAccountingInvoiceGET descriptiveAccountingInvoiceGET = (DescriptiveAccountingInvoiceGET) o;
    return Objects.equals(this.amount, descriptiveAccountingInvoiceGET.amount) &&
        Objects.equals(this.currency, descriptiveAccountingInvoiceGET.currency) &&
        Objects.equals(this.count, descriptiveAccountingInvoiceGET.count);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, currency, count);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DescriptiveAccountingInvoiceGET {\n");
    
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
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

