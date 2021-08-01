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
 * AuthProfileGET
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-31T13:05:18.255013+02:00[Europe/Zurich]")
public class AuthProfileGET  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("id")
  private Integer id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("surname")
  private String surname;

  @JsonProperty("email")
  private String email;

  @JsonProperty("language")
  private String language;

  @JsonProperty("company_name")
  private String companyName;

  @JsonProperty("company_addition")
  private String companyAddition;

  @JsonProperty("company_country")
  private String companyCountry;

  @JsonProperty("company_street")
  private String companyStreet;

  @JsonProperty("company_street_no")
  private String companyStreetNo;

  @JsonProperty("company_street2")
  private String companyStreet2;

  @JsonProperty("company_postcode")
  private String companyPostcode;

  @JsonProperty("company_city")
  private String companyCity;

  @JsonProperty("company_phone")
  private String companyPhone;

  @JsonProperty("company_fax")
  private String companyFax;

  @JsonProperty("company_email")
  private String companyEmail;

  @JsonProperty("company_website")
  private String companyWebsite;

  @JsonProperty("company_vat_id")
  private String companyVatId;

  @JsonProperty("company_currency")
  private String companyCurrency;

  public AuthProfileGET id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * user id
   * @return id
  */
  @ApiModelProperty(required = true, value = "user id")
  @NotNull


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public AuthProfileGET name(String name) {
    this.name = name;
    return this;
  }

  /**
   * user name
   * @return name
  */
  @ApiModelProperty(required = true, value = "user name")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public AuthProfileGET surname(String surname) {
    this.surname = surname;
    return this;
  }

  /**
   * user surname
   * @return surname
  */
  @ApiModelProperty(required = true, value = "user surname")
  @NotNull


  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public AuthProfileGET email(String email) {
    this.email = email;
    return this;
  }

  /**
   * user email address
   * @return email
  */
  @ApiModelProperty(required = true, value = "user email address")
  @NotNull


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public AuthProfileGET language(String language) {
    this.language = language;
    return this;
  }

  /**
   * communication language
   * @return language
  */
  @ApiModelProperty(required = true, value = "communication language")
  @NotNull


  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public AuthProfileGET companyName(String companyName) {
    this.companyName = companyName;
    return this;
  }

  /**
   * company name
   * @return companyName
  */
  @ApiModelProperty(required = true, value = "company name")
  @NotNull


  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  public AuthProfileGET companyAddition(String companyAddition) {
    this.companyAddition = companyAddition;
    return this;
  }

  /**
   * another company name line
   * @return companyAddition
  */
  @ApiModelProperty(required = true, value = "another company name line")
  @NotNull


  public String getCompanyAddition() {
    return companyAddition;
  }

  public void setCompanyAddition(String companyAddition) {
    this.companyAddition = companyAddition;
  }

  public AuthProfileGET companyCountry(String companyCountry) {
    this.companyCountry = companyCountry;
    return this;
  }

  /**
   * company address: country (ISO2)
   * @return companyCountry
  */
  @ApiModelProperty(required = true, value = "company address: country (ISO2)")
  @NotNull


  public String getCompanyCountry() {
    return companyCountry;
  }

  public void setCompanyCountry(String companyCountry) {
    this.companyCountry = companyCountry;
  }

  public AuthProfileGET companyStreet(String companyStreet) {
    this.companyStreet = companyStreet;
    return this;
  }

  /**
   * company address: street
   * @return companyStreet
  */
  @ApiModelProperty(required = true, value = "company address: street")
  @NotNull


  public String getCompanyStreet() {
    return companyStreet;
  }

  public void setCompanyStreet(String companyStreet) {
    this.companyStreet = companyStreet;
  }

  public AuthProfileGET companyStreetNo(String companyStreetNo) {
    this.companyStreetNo = companyStreetNo;
    return this;
  }

  /**
   * company address: street number
   * @return companyStreetNo
  */
  @ApiModelProperty(required = true, value = "company address: street number")
  @NotNull


  public String getCompanyStreetNo() {
    return companyStreetNo;
  }

  public void setCompanyStreetNo(String companyStreetNo) {
    this.companyStreetNo = companyStreetNo;
  }

  public AuthProfileGET companyStreet2(String companyStreet2) {
    this.companyStreet2 = companyStreet2;
    return this;
  }

  /**
   * company address: another street line
   * @return companyStreet2
  */
  @ApiModelProperty(required = true, value = "company address: another street line")
  @NotNull


  public String getCompanyStreet2() {
    return companyStreet2;
  }

  public void setCompanyStreet2(String companyStreet2) {
    this.companyStreet2 = companyStreet2;
  }

  public AuthProfileGET companyPostcode(String companyPostcode) {
    this.companyPostcode = companyPostcode;
    return this;
  }

  /**
   * company address: postcode
   * @return companyPostcode
  */
  @ApiModelProperty(required = true, value = "company address: postcode")
  @NotNull


  public String getCompanyPostcode() {
    return companyPostcode;
  }

  public void setCompanyPostcode(String companyPostcode) {
    this.companyPostcode = companyPostcode;
  }

  public AuthProfileGET companyCity(String companyCity) {
    this.companyCity = companyCity;
    return this;
  }

  /**
   * company address: city
   * @return companyCity
  */
  @ApiModelProperty(required = true, value = "company address: city")
  @NotNull


  public String getCompanyCity() {
    return companyCity;
  }

  public void setCompanyCity(String companyCity) {
    this.companyCity = companyCity;
  }

  public AuthProfileGET companyPhone(String companyPhone) {
    this.companyPhone = companyPhone;
    return this;
  }

  /**
   * phone number
   * @return companyPhone
  */
  @ApiModelProperty(required = true, value = "phone number")
  @NotNull


  public String getCompanyPhone() {
    return companyPhone;
  }

  public void setCompanyPhone(String companyPhone) {
    this.companyPhone = companyPhone;
  }

  public AuthProfileGET companyFax(String companyFax) {
    this.companyFax = companyFax;
    return this;
  }

  /**
   * fax number
   * @return companyFax
  */
  @ApiModelProperty(required = true, value = "fax number")
  @NotNull


  public String getCompanyFax() {
    return companyFax;
  }

  public void setCompanyFax(String companyFax) {
    this.companyFax = companyFax;
  }

  public AuthProfileGET companyEmail(String companyEmail) {
    this.companyEmail = companyEmail;
    return this;
  }

  /**
   * email address
   * @return companyEmail
  */
  @ApiModelProperty(required = true, value = "email address")
  @NotNull


  public String getCompanyEmail() {
    return companyEmail;
  }

  public void setCompanyEmail(String companyEmail) {
    this.companyEmail = companyEmail;
  }

  public AuthProfileGET companyWebsite(String companyWebsite) {
    this.companyWebsite = companyWebsite;
    return this;
  }

  /**
   * website URL
   * @return companyWebsite
  */
  @ApiModelProperty(required = true, value = "website URL")
  @NotNull


  public String getCompanyWebsite() {
    return companyWebsite;
  }

  public void setCompanyWebsite(String companyWebsite) {
    this.companyWebsite = companyWebsite;
  }

  public AuthProfileGET companyVatId(String companyVatId) {
    this.companyVatId = companyVatId;
    return this;
  }

  /**
   * VAT/EU VAT ID no.
   * @return companyVatId
  */
  @ApiModelProperty(required = true, value = "VAT/EU VAT ID no.")
  @NotNull


  public String getCompanyVatId() {
    return companyVatId;
  }

  public void setCompanyVatId(String companyVatId) {
    this.companyVatId = companyVatId;
  }

  public AuthProfileGET companyCurrency(String companyCurrency) {
    this.companyCurrency = companyCurrency;
    return this;
  }

  /**
   * default billing currency
   * @return companyCurrency
  */
  @ApiModelProperty(required = true, value = "default billing currency")
  @NotNull


  public String getCompanyCurrency() {
    return companyCurrency;
  }

  public void setCompanyCurrency(String companyCurrency) {
    this.companyCurrency = companyCurrency;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AuthProfileGET authProfileGET = (AuthProfileGET) o;
    return Objects.equals(this.id, authProfileGET.id) &&
        Objects.equals(this.name, authProfileGET.name) &&
        Objects.equals(this.surname, authProfileGET.surname) &&
        Objects.equals(this.email, authProfileGET.email) &&
        Objects.equals(this.language, authProfileGET.language) &&
        Objects.equals(this.companyName, authProfileGET.companyName) &&
        Objects.equals(this.companyAddition, authProfileGET.companyAddition) &&
        Objects.equals(this.companyCountry, authProfileGET.companyCountry) &&
        Objects.equals(this.companyStreet, authProfileGET.companyStreet) &&
        Objects.equals(this.companyStreetNo, authProfileGET.companyStreetNo) &&
        Objects.equals(this.companyStreet2, authProfileGET.companyStreet2) &&
        Objects.equals(this.companyPostcode, authProfileGET.companyPostcode) &&
        Objects.equals(this.companyCity, authProfileGET.companyCity) &&
        Objects.equals(this.companyPhone, authProfileGET.companyPhone) &&
        Objects.equals(this.companyFax, authProfileGET.companyFax) &&
        Objects.equals(this.companyEmail, authProfileGET.companyEmail) &&
        Objects.equals(this.companyWebsite, authProfileGET.companyWebsite) &&
        Objects.equals(this.companyVatId, authProfileGET.companyVatId) &&
        Objects.equals(this.companyCurrency, authProfileGET.companyCurrency);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, surname, email, language, companyName, companyAddition, companyCountry, companyStreet, companyStreetNo, companyStreet2, companyPostcode, companyCity, companyPhone, companyFax, companyEmail, companyWebsite, companyVatId, companyCurrency);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AuthProfileGET {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    surname: ").append(toIndentedString(surname)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    language: ").append(toIndentedString(language)).append("\n");
    sb.append("    companyName: ").append(toIndentedString(companyName)).append("\n");
    sb.append("    companyAddition: ").append(toIndentedString(companyAddition)).append("\n");
    sb.append("    companyCountry: ").append(toIndentedString(companyCountry)).append("\n");
    sb.append("    companyStreet: ").append(toIndentedString(companyStreet)).append("\n");
    sb.append("    companyStreetNo: ").append(toIndentedString(companyStreetNo)).append("\n");
    sb.append("    companyStreet2: ").append(toIndentedString(companyStreet2)).append("\n");
    sb.append("    companyPostcode: ").append(toIndentedString(companyPostcode)).append("\n");
    sb.append("    companyCity: ").append(toIndentedString(companyCity)).append("\n");
    sb.append("    companyPhone: ").append(toIndentedString(companyPhone)).append("\n");
    sb.append("    companyFax: ").append(toIndentedString(companyFax)).append("\n");
    sb.append("    companyEmail: ").append(toIndentedString(companyEmail)).append("\n");
    sb.append("    companyWebsite: ").append(toIndentedString(companyWebsite)).append("\n");
    sb.append("    companyVatId: ").append(toIndentedString(companyVatId)).append("\n");
    sb.append("    companyCurrency: ").append(toIndentedString(companyCurrency)).append("\n");
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

