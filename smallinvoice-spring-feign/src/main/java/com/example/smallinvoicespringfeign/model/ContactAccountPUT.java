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
 * ContactAccountPUT
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-27T20:43:02.724916+02:00[Europe/Zurich]")
public class ContactAccountPUT  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("default")
  private Boolean _default;

  @JsonProperty("type")
  private String type;

  @JsonProperty("number")
  private String number;

  @JsonProperty("bic")
  private String bic;

  @JsonProperty("description")
  private String description;

  public ContactAccountPUT _default(Boolean _default) {
    this._default = _default;
    return this;
  }

  /**
   * whether it is a default contact's account
   * @return _default
  */
  @ApiModelProperty(value = "whether it is a default contact's account")


  public Boolean getDefault() {
    return _default;
  }

  public void setDefault(Boolean _default) {
    this._default = _default;
  }

  public ContactAccountPUT type(String type) {
    this.type = type;
    return this;
  }

  /**
   * type (possible values: IBAN, ISR)
   * @return type
  */
  @ApiModelProperty(value = "type (possible values: IBAN, ISR)")


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public ContactAccountPUT number(String number) {
    this.number = number;
    return this;
  }

  /**
   * IBAN or ISR number (depends on the type)
   * @return number
  */
  @ApiModelProperty(value = "IBAN or ISR number (depends on the type)")


  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public ContactAccountPUT bic(String bic) {
    this.bic = bic;
    return this;
  }

  /**
   * BIC number
   * @return bic
  */
  @ApiModelProperty(value = "BIC number")


  public String getBic() {
    return bic;
  }

  public void setBic(String bic) {
    this.bic = bic;
  }

  public ContactAccountPUT description(String description) {
    this.description = description;
    return this;
  }

  /**
   * internal description
   * @return description
  */
  @ApiModelProperty(value = "internal description")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContactAccountPUT contactAccountPUT = (ContactAccountPUT) o;
    return Objects.equals(this._default, contactAccountPUT._default) &&
        Objects.equals(this.type, contactAccountPUT.type) &&
        Objects.equals(this.number, contactAccountPUT.number) &&
        Objects.equals(this.bic, contactAccountPUT.bic) &&
        Objects.equals(this.description, contactAccountPUT.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(_default, type, number, bic, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContactAccountPUT {\n");
    
    sb.append("    _default: ").append(toIndentedString(_default)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
    sb.append("    bic: ").append(toIndentedString(bic)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

