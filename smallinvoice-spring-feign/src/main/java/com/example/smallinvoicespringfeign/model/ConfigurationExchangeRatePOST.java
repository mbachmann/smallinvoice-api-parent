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
 * ConfigurationExchangeRatePOST
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-08-03T21:09:37.732+02:00[Europe/Zurich]")
public class ConfigurationExchangeRatePOST  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("currency_from")
  private String currencyFrom;

  @JsonProperty("currency_to")
  private String currencyTo;

  @JsonProperty("rate")
  private Float rate;

  public ConfigurationExchangeRatePOST currencyFrom(String currencyFrom) {
    this.currencyFrom = currencyFrom;
    return this;
  }

  /**
   * ISO currency name we are setting exchange from
   * @return currencyFrom
  */
  @ApiModelProperty(required = true, value = "ISO currency name we are setting exchange from")
  @NotNull


  public String getCurrencyFrom() {
    return currencyFrom;
  }

  public void setCurrencyFrom(String currencyFrom) {
    this.currencyFrom = currencyFrom;
  }

  public ConfigurationExchangeRatePOST currencyTo(String currencyTo) {
    this.currencyTo = currencyTo;
    return this;
  }

  /**
   * ISO currency name we are setting exchange to
   * @return currencyTo
  */
  @ApiModelProperty(required = true, value = "ISO currency name we are setting exchange to")
  @NotNull


  public String getCurrencyTo() {
    return currencyTo;
  }

  public void setCurrencyTo(String currencyTo) {
    this.currencyTo = currencyTo;
  }

  public ConfigurationExchangeRatePOST rate(Float rate) {
    this.rate = rate;
    return this;
  }

  /**
   * exchange rate value
   * @return rate
  */
  @ApiModelProperty(required = true, value = "exchange rate value")
  @NotNull


  public Float getRate() {
    return rate;
  }

  public void setRate(Float rate) {
    this.rate = rate;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConfigurationExchangeRatePOST configurationExchangeRatePOST = (ConfigurationExchangeRatePOST) o;
    return Objects.equals(this.currencyFrom, configurationExchangeRatePOST.currencyFrom) &&
        Objects.equals(this.currencyTo, configurationExchangeRatePOST.currencyTo) &&
        Objects.equals(this.rate, configurationExchangeRatePOST.rate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(currencyFrom, currencyTo, rate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConfigurationExchangeRatePOST {\n");
    
    sb.append("    currencyFrom: ").append(toIndentedString(currencyFrom)).append("\n");
    sb.append("    currencyTo: ").append(toIndentedString(currencyTo)).append("\n");
    sb.append("    rate: ").append(toIndentedString(rate)).append("\n");
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

