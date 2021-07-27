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
 * ContactAddressPOST
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-27T20:43:02.724916+02:00[Europe/Zurich]")
public class ContactAddressPOST  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("default")
  private Boolean _default;

  @JsonProperty("country")
  private String country;

  @JsonProperty("street")
  private String street;

  @JsonProperty("street_no")
  private String streetNo;

  @JsonProperty("street2")
  private String street2;

  @JsonProperty("postcode")
  private String postcode;

  @JsonProperty("city")
  private String city;

  @JsonProperty("hide_on_documents")
  private Boolean hideOnDocuments;

  @JsonProperty("default_prepage")
  private Boolean defaultPrepage;

  public ContactAddressPOST _default(Boolean _default) {
    this._default = _default;
    return this;
  }

  /**
   * whether it is a default contact's address - default value: false
   * @return _default
  */
  @ApiModelProperty(value = "whether it is a default contact's address - default value: false")


  public Boolean getDefault() {
    return _default;
  }

  public void setDefault(Boolean _default) {
    this._default = _default;
  }

  public ContactAddressPOST country(String country) {
    this.country = country;
    return this;
  }

  /**
   * country ISO2 code (eg. CH)
   * @return country
  */
  @ApiModelProperty(required = true, value = "country ISO2 code (eg. CH)")
  @NotNull


  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public ContactAddressPOST street(String street) {
    this.street = street;
    return this;
  }

  /**
   * street
   * @return street
  */
  @ApiModelProperty(required = true, value = "street")
  @NotNull


  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public ContactAddressPOST streetNo(String streetNo) {
    this.streetNo = streetNo;
    return this;
  }

  /**
   * number of apartment
   * @return streetNo
  */
  @ApiModelProperty(value = "number of apartment")


  public String getStreetNo() {
    return streetNo;
  }

  public void setStreetNo(String streetNo) {
    this.streetNo = streetNo;
  }

  public ContactAddressPOST street2(String street2) {
    this.street2 = street2;
    return this;
  }

  /**
   * additional address information
   * @return street2
  */
  @ApiModelProperty(value = "additional address information")


  public String getStreet2() {
    return street2;
  }

  public void setStreet2(String street2) {
    this.street2 = street2;
  }

  public ContactAddressPOST postcode(String postcode) {
    this.postcode = postcode;
    return this;
  }

  /**
   * postcode
   * @return postcode
  */
  @ApiModelProperty(required = true, value = "postcode")
  @NotNull


  public String getPostcode() {
    return postcode;
  }

  public void setPostcode(String postcode) {
    this.postcode = postcode;
  }

  public ContactAddressPOST city(String city) {
    this.city = city;
    return this;
  }

  /**
   * city
   * @return city
  */
  @ApiModelProperty(required = true, value = "city")
  @NotNull


  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public ContactAddressPOST hideOnDocuments(Boolean hideOnDocuments) {
    this.hideOnDocuments = hideOnDocuments;
    return this;
  }

  /**
   * whether to hide this address on documents - default value: false
   * @return hideOnDocuments
  */
  @ApiModelProperty(value = "whether to hide this address on documents - default value: false")


  public Boolean getHideOnDocuments() {
    return hideOnDocuments;
  }

  public void setHideOnDocuments(Boolean hideOnDocuments) {
    this.hideOnDocuments = hideOnDocuments;
  }

  public ContactAddressPOST defaultPrepage(Boolean defaultPrepage) {
    this.defaultPrepage = defaultPrepage;
    return this;
  }

  /**
   * whether the address is a default postal address - default value: false
   * @return defaultPrepage
  */
  @ApiModelProperty(value = "whether the address is a default postal address - default value: false")


  public Boolean getDefaultPrepage() {
    return defaultPrepage;
  }

  public void setDefaultPrepage(Boolean defaultPrepage) {
    this.defaultPrepage = defaultPrepage;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContactAddressPOST contactAddressPOST = (ContactAddressPOST) o;
    return Objects.equals(this._default, contactAddressPOST._default) &&
        Objects.equals(this.country, contactAddressPOST.country) &&
        Objects.equals(this.street, contactAddressPOST.street) &&
        Objects.equals(this.streetNo, contactAddressPOST.streetNo) &&
        Objects.equals(this.street2, contactAddressPOST.street2) &&
        Objects.equals(this.postcode, contactAddressPOST.postcode) &&
        Objects.equals(this.city, contactAddressPOST.city) &&
        Objects.equals(this.hideOnDocuments, contactAddressPOST.hideOnDocuments) &&
        Objects.equals(this.defaultPrepage, contactAddressPOST.defaultPrepage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(_default, country, street, streetNo, street2, postcode, city, hideOnDocuments, defaultPrepage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContactAddressPOST {\n");
    
    sb.append("    _default: ").append(toIndentedString(_default)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    street: ").append(toIndentedString(street)).append("\n");
    sb.append("    streetNo: ").append(toIndentedString(streetNo)).append("\n");
    sb.append("    street2: ").append(toIndentedString(street2)).append("\n");
    sb.append("    postcode: ").append(toIndentedString(postcode)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    hideOnDocuments: ").append(toIndentedString(hideOnDocuments)).append("\n");
    sb.append("    defaultPrepage: ").append(toIndentedString(defaultPrepage)).append("\n");
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

