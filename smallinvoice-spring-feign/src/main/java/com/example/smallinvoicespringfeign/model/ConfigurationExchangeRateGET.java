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
 * ConfigurationExchangeRateGET
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-08-03T10:50:58.837+02:00[Europe/Zurich]")
public class ConfigurationExchangeRateGET  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("id")
  private Integer id;

  @JsonProperty("currency_from")
  private String currencyFrom;

  @JsonProperty("currency_to")
  private String currencyTo;

  @JsonProperty("rate")
  private Float rate;

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

  public ConfigurationExchangeRateGET id(Integer id) {
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

  public ConfigurationExchangeRateGET currencyFrom(String currencyFrom) {
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

  public ConfigurationExchangeRateGET currencyTo(String currencyTo) {
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

  public ConfigurationExchangeRateGET rate(Float rate) {
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

  public ConfigurationExchangeRateGET created(LocalDateTime created) {
    this.created = created;
    return this;
  }

  /**
   * when exchange was created
   * @return created
  */
  @ApiModelProperty(required = true, value = "when exchange was created")
  @NotNull

  @Valid

  public LocalDateTime getCreated() {
    return created;
  }

  public void setCreated(LocalDateTime created) {
    this.created = created;
  }

  public ConfigurationExchangeRateGET permissions(List<PermissionsEnum> permissions) {
    this.permissions = permissions;
    return this;
  }

  public ConfigurationExchangeRateGET addPermissionsItem(PermissionsEnum permissionsItem) {
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
    ConfigurationExchangeRateGET configurationExchangeRateGET = (ConfigurationExchangeRateGET) o;
    return Objects.equals(this.id, configurationExchangeRateGET.id) &&
        Objects.equals(this.currencyFrom, configurationExchangeRateGET.currencyFrom) &&
        Objects.equals(this.currencyTo, configurationExchangeRateGET.currencyTo) &&
        Objects.equals(this.rate, configurationExchangeRateGET.rate) &&
        Objects.equals(this.created, configurationExchangeRateGET.created) &&
        Objects.equals(this.permissions, configurationExchangeRateGET.permissions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, currencyFrom, currencyTo, rate, created, permissions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConfigurationExchangeRateGET {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    currencyFrom: ").append(toIndentedString(currencyFrom)).append("\n");
    sb.append("    currencyTo: ").append(toIndentedString(currencyTo)).append("\n");
    sb.append("    rate: ").append(toIndentedString(rate)).append("\n");
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

