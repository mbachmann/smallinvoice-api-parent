package com.example.smallinvoicespringfeign.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
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
 * AccountingOfferGET
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-27T20:43:02.724916+02:00[Europe/Zurich]")
public class AccountingOfferGET  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("id")
  private Integer id;

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

  @JsonProperty("contact_company")
  private String contactCompany;

  @JsonProperty("contact_address")
  private String contactAddress;

  @JsonProperty("contact_person")
  private String contactPerson;

  @JsonProperty("contact_phone")
  private String contactPhone;

  @JsonProperty("contact_email")
  private String contactEmail;

  /**
   * status of the offer; possible values: O - Open, A - Awarded, L - Not awarded
   */
  public enum StatusEnum {
    O("O"),
    
    A("A"),
    
    L("L");

    private String value;

    StatusEnum(String value) {
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
    public static StatusEnum fromValue(String value) {
      for (StatusEnum b : StatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("status")
  private StatusEnum status = StatusEnum.O;

  @JsonProperty("created")
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
  private LocalDateTime created;

  /**
   * Gets or Sets permissions
   */
  public enum PermissionsEnum {
    VIEW("view"),
    
    MANAGE("manage");

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

  public AccountingOfferGET id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * id of the offer
   * @return id
  */
  @ApiModelProperty(required = true, value = "id of the offer")
  @NotNull


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public AccountingOfferGET requestId(Integer requestId) {
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

  public AccountingOfferGET deliveryDate(LocalDate deliveryDate) {
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

  public AccountingOfferGET priceFrom(Float priceFrom) {
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

  public AccountingOfferGET priceTo(Float priceTo) {
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

  public AccountingOfferGET priceCurrency(String priceCurrency) {
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

  public AccountingOfferGET comment(String comment) {
    this.comment = comment;
    return this;
  }

  /**
   * optional comment
   * @return comment
  */
  @ApiModelProperty(required = true, value = "optional comment")
  @NotNull


  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public AccountingOfferGET termsAndConditions(String termsAndConditions) {
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

  public AccountingOfferGET contactCompany(String contactCompany) {
    this.contactCompany = contactCompany;
    return this;
  }

  /**
   * company name
   * @return contactCompany
  */
  @ApiModelProperty(required = true, value = "company name")
  @NotNull


  public String getContactCompany() {
    return contactCompany;
  }

  public void setContactCompany(String contactCompany) {
    this.contactCompany = contactCompany;
  }

  public AccountingOfferGET contactAddress(String contactAddress) {
    this.contactAddress = contactAddress;
    return this;
  }

  /**
   * company address
   * @return contactAddress
  */
  @ApiModelProperty(required = true, value = "company address")
  @NotNull


  public String getContactAddress() {
    return contactAddress;
  }

  public void setContactAddress(String contactAddress) {
    this.contactAddress = contactAddress;
  }

  public AccountingOfferGET contactPerson(String contactPerson) {
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

  public AccountingOfferGET contactPhone(String contactPhone) {
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

  public AccountingOfferGET contactEmail(String contactEmail) {
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

  public AccountingOfferGET status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * status of the offer; possible values: O - Open, A - Awarded, L - Not awarded
   * @return status
  */
  @ApiModelProperty(required = true, value = "status of the offer; possible values: O - Open, A - Awarded, L - Not awarded")
  @NotNull


  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public AccountingOfferGET created(LocalDateTime created) {
    this.created = created;
    return this;
  }

  /**
   * date & time of creating the offer
   * @return created
  */
  @ApiModelProperty(required = true, value = "date & time of creating the offer")
  @NotNull

  @Valid

  public LocalDateTime getCreated() {
    return created;
  }

  public void setCreated(LocalDateTime created) {
    this.created = created;
  }

  public AccountingOfferGET permissions(List<PermissionsEnum> permissions) {
    this.permissions = permissions;
    return this;
  }

  public AccountingOfferGET addPermissionsItem(PermissionsEnum permissionsItem) {
    if (this.permissions == null) {
      this.permissions = new ArrayList<>();
    }
    this.permissions.add(permissionsItem);
    return this;
  }

  /**
   * actions that can be performed on an item (possible values: view, manage) 
   * @return permissions
  */
  @ApiModelProperty(value = "actions that can be performed on an item (possible values: view, manage) ")


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
    AccountingOfferGET accountingOfferGET = (AccountingOfferGET) o;
    return Objects.equals(this.id, accountingOfferGET.id) &&
        Objects.equals(this.requestId, accountingOfferGET.requestId) &&
        Objects.equals(this.deliveryDate, accountingOfferGET.deliveryDate) &&
        Objects.equals(this.priceFrom, accountingOfferGET.priceFrom) &&
        Objects.equals(this.priceTo, accountingOfferGET.priceTo) &&
        Objects.equals(this.priceCurrency, accountingOfferGET.priceCurrency) &&
        Objects.equals(this.comment, accountingOfferGET.comment) &&
        Objects.equals(this.termsAndConditions, accountingOfferGET.termsAndConditions) &&
        Objects.equals(this.contactCompany, accountingOfferGET.contactCompany) &&
        Objects.equals(this.contactAddress, accountingOfferGET.contactAddress) &&
        Objects.equals(this.contactPerson, accountingOfferGET.contactPerson) &&
        Objects.equals(this.contactPhone, accountingOfferGET.contactPhone) &&
        Objects.equals(this.contactEmail, accountingOfferGET.contactEmail) &&
        Objects.equals(this.status, accountingOfferGET.status) &&
        Objects.equals(this.created, accountingOfferGET.created) &&
        Objects.equals(this.permissions, accountingOfferGET.permissions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, requestId, deliveryDate, priceFrom, priceTo, priceCurrency, comment, termsAndConditions, contactCompany, contactAddress, contactPerson, contactPhone, contactEmail, status, created, permissions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountingOfferGET {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    requestId: ").append(toIndentedString(requestId)).append("\n");
    sb.append("    deliveryDate: ").append(toIndentedString(deliveryDate)).append("\n");
    sb.append("    priceFrom: ").append(toIndentedString(priceFrom)).append("\n");
    sb.append("    priceTo: ").append(toIndentedString(priceTo)).append("\n");
    sb.append("    priceCurrency: ").append(toIndentedString(priceCurrency)).append("\n");
    sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
    sb.append("    termsAndConditions: ").append(toIndentedString(termsAndConditions)).append("\n");
    sb.append("    contactCompany: ").append(toIndentedString(contactCompany)).append("\n");
    sb.append("    contactAddress: ").append(toIndentedString(contactAddress)).append("\n");
    sb.append("    contactPerson: ").append(toIndentedString(contactPerson)).append("\n");
    sb.append("    contactPhone: ").append(toIndentedString(contactPhone)).append("\n");
    sb.append("    contactEmail: ").append(toIndentedString(contactEmail)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

