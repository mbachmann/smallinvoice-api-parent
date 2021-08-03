package com.example.smallinvoicespringfeign.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;

/**
 * AccountingOfferPOST
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-08-03T21:09:37.732+02:00[Europe/Zurich]")
public class AccountingOfferPOST  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("request_id")
  private Integer requestId;

  @JsonProperty("delivery_date")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE)
  private LocalDate deliveryDate;

  @JsonProperty("price_from")
  private Float priceFrom;

  @JsonProperty("price_to")
  private Float priceTo;

  @JsonProperty("price_currency")
  private String priceCurrency;

  @JsonProperty("comment")
  private String comment;

  @JsonProperty("terms_and_conditions")
  private String termsAndConditions;

  @JsonProperty("contact_person")
  private String contactPerson;

  @JsonProperty("contact_phone")
  private String contactPhone;

  @JsonProperty("contact_email")
  private String contactEmail;

  public AccountingOfferPOST requestId(Integer requestId) {
    this.requestId = requestId;
    return this;
  }

  /**
   * id of a requested that offer was made for
   * @return requestId
  */
  @ApiModelProperty(required = true, value = "id of a requested that offer was made for")
  @NotNull


  public Integer getRequestId() {
    return requestId;
  }

  public void setRequestId(Integer requestId) {
    this.requestId = requestId;
  }

  public AccountingOfferPOST deliveryDate(LocalDate deliveryDate) {
    this.deliveryDate = deliveryDate;
    return this;
  }

  /**
   * approximate delivery date
   * @return deliveryDate
  */
  @ApiModelProperty(required = true, value = "approximate delivery date")
  @NotNull

  @Valid

  public LocalDate getDeliveryDate() {
    return deliveryDate;
  }

  public void setDeliveryDate(LocalDate deliveryDate) {
    this.deliveryDate = deliveryDate;
  }

  public AccountingOfferPOST priceFrom(Float priceFrom) {
    this.priceFrom = priceFrom;
    return this;
  }

  /**
   * price range from
   * @return priceFrom
  */
  @ApiModelProperty(required = true, value = "price range from")
  @NotNull


  public Float getPriceFrom() {
    return priceFrom;
  }

  public void setPriceFrom(Float priceFrom) {
    this.priceFrom = priceFrom;
  }

  public AccountingOfferPOST priceTo(Float priceTo) {
    this.priceTo = priceTo;
    return this;
  }

  /**
   * price range to
   * @return priceTo
  */
  @ApiModelProperty(required = true, value = "price range to")
  @NotNull


  public Float getPriceTo() {
    return priceTo;
  }

  public void setPriceTo(Float priceTo) {
    this.priceTo = priceTo;
  }

  public AccountingOfferPOST priceCurrency(String priceCurrency) {
    this.priceCurrency = priceCurrency;
    return this;
  }

  /**
   * price currency
   * @return priceCurrency
  */
  @ApiModelProperty(required = true, value = "price currency")
  @NotNull


  public String getPriceCurrency() {
    return priceCurrency;
  }

  public void setPriceCurrency(String priceCurrency) {
    this.priceCurrency = priceCurrency;
  }

  public AccountingOfferPOST comment(String comment) {
    this.comment = comment;
    return this;
  }

  /**
   * optional comment
   * @return comment
  */
  @ApiModelProperty(value = "optional comment")


  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public AccountingOfferPOST termsAndConditions(String termsAndConditions) {
    this.termsAndConditions = termsAndConditions;
    return this;
  }

  /**
   * tems & conditions
   * @return termsAndConditions
  */
  @ApiModelProperty(required = true, value = "tems & conditions")
  @NotNull


  public String getTermsAndConditions() {
    return termsAndConditions;
  }

  public void setTermsAndConditions(String termsAndConditions) {
    this.termsAndConditions = termsAndConditions;
  }

  public AccountingOfferPOST contactPerson(String contactPerson) {
    this.contactPerson = contactPerson;
    return this;
  }

  /**
   * company contact person name
   * @return contactPerson
  */
  @ApiModelProperty(required = true, value = "company contact person name")
  @NotNull


  public String getContactPerson() {
    return contactPerson;
  }

  public void setContactPerson(String contactPerson) {
    this.contactPerson = contactPerson;
  }

  public AccountingOfferPOST contactPhone(String contactPhone) {
    this.contactPhone = contactPhone;
    return this;
  }

  /**
   * company contact phone number
   * @return contactPhone
  */
  @ApiModelProperty(required = true, value = "company contact phone number")
  @NotNull


  public String getContactPhone() {
    return contactPhone;
  }

  public void setContactPhone(String contactPhone) {
    this.contactPhone = contactPhone;
  }

  public AccountingOfferPOST contactEmail(String contactEmail) {
    this.contactEmail = contactEmail;
    return this;
  }

  /**
   * company contact email address
   * @return contactEmail
  */
  @ApiModelProperty(required = true, value = "company contact email address")
  @NotNull


  public String getContactEmail() {
    return contactEmail;
  }

  public void setContactEmail(String contactEmail) {
    this.contactEmail = contactEmail;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountingOfferPOST accountingOfferPOST = (AccountingOfferPOST) o;
    return Objects.equals(this.requestId, accountingOfferPOST.requestId) &&
        Objects.equals(this.deliveryDate, accountingOfferPOST.deliveryDate) &&
        Objects.equals(this.priceFrom, accountingOfferPOST.priceFrom) &&
        Objects.equals(this.priceTo, accountingOfferPOST.priceTo) &&
        Objects.equals(this.priceCurrency, accountingOfferPOST.priceCurrency) &&
        Objects.equals(this.comment, accountingOfferPOST.comment) &&
        Objects.equals(this.termsAndConditions, accountingOfferPOST.termsAndConditions) &&
        Objects.equals(this.contactPerson, accountingOfferPOST.contactPerson) &&
        Objects.equals(this.contactPhone, accountingOfferPOST.contactPhone) &&
        Objects.equals(this.contactEmail, accountingOfferPOST.contactEmail);
  }

  @Override
  public int hashCode() {
    return Objects.hash(requestId, deliveryDate, priceFrom, priceTo, priceCurrency, comment, termsAndConditions, contactPerson, contactPhone, contactEmail);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountingOfferPOST {\n");
    
    sb.append("    requestId: ").append(toIndentedString(requestId)).append("\n");
    sb.append("    deliveryDate: ").append(toIndentedString(deliveryDate)).append("\n");
    sb.append("    priceFrom: ").append(toIndentedString(priceFrom)).append("\n");
    sb.append("    priceTo: ").append(toIndentedString(priceTo)).append("\n");
    sb.append("    priceCurrency: ").append(toIndentedString(priceCurrency)).append("\n");
    sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
    sb.append("    termsAndConditions: ").append(toIndentedString(termsAndConditions)).append("\n");
    sb.append("    contactPerson: ").append(toIndentedString(contactPerson)).append("\n");
    sb.append("    contactPhone: ").append(toIndentedString(contactPhone)).append("\n");
    sb.append("    contactEmail: ").append(toIndentedString(contactEmail)).append("\n");
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

