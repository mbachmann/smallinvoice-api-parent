package com.example.smallinvoicespringfeign.model;

import java.util.Objects;
import com.example.smallinvoicespringfeign.model.ContactAddressPOST;
import com.example.smallinvoicespringfeign.model.DescriptiveCustomFieldPOST;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;

/**
 * ContactPOST
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-11-30T10:06:31.741+01:00[Europe/Zurich]")
public class ContactPOST  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("number")
  private String number;

  /**
   * Gets or Sets relation
   */
  public enum RelationEnum {
    CL("CL"),
    
    CR("CR");

    private String value;

    RelationEnum(String value) {
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
    public static RelationEnum fromValue(String value) {
      for (RelationEnum b : RelationEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("relation")
  @Valid
  private List<RelationEnum> relation = new ArrayList<>();

  @JsonProperty("type")
  private String type;

  /**
   * gender of contact (required for P type); possible values: M - Male, F - Female
   */
  public enum GenderEnum {
    M("M"),
    
    F("F");

    private String value;

    GenderEnum(String value) {
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
    public static GenderEnum fromValue(String value) {
      for (GenderEnum b : GenderEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("gender")
  private GenderEnum gender;

  @JsonProperty("gender_salutation_active")
  private Boolean genderSalutationActive;

  @JsonProperty("name")
  private String name;

  @JsonProperty("name_addition")
  private String nameAddition;

  @JsonProperty("salutation")
  private String salutation;

  @JsonProperty("phone")
  private String phone;

  @JsonProperty("fax")
  private String fax;

  @JsonProperty("email")
  private String email;

  @JsonProperty("website")
  private String website;

  @JsonProperty("notes")
  private String notes;

  @JsonProperty("communication_language")
  private String communicationLanguage;

  /**
   * possible values: U - No preference, E - Documents by e-mail, P - Documents by post 
   */
  public enum CommunicationChannelEnum {
    U("U"),
    
    E("E"),
    
    P("P");

    private String value;

    CommunicationChannelEnum(String value) {
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
    public static CommunicationChannelEnum fromValue(String value) {
      for (CommunicationChannelEnum b : CommunicationChannelEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("communication_channel")
  private CommunicationChannelEnum communicationChannel = CommunicationChannelEnum.U;

  /**
   * possible values:   A - Send to main e-mail address and contacts,   M - Only send to main e-mail address,   N - No newsletter wanted 
   */
  public enum CommunicationNewsletterEnum {
    A("A"),
    
    M("M"),
    
    N("N");

    private String value;

    CommunicationNewsletterEnum(String value) {
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
    public static CommunicationNewsletterEnum fromValue(String value) {
      for (CommunicationNewsletterEnum b : CommunicationNewsletterEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("communication_newsletter")
  private CommunicationNewsletterEnum communicationNewsletter = CommunicationNewsletterEnum.N;

  @JsonProperty("currency")
  private String currency;

  @JsonProperty("ebill_account_id")
  private String ebillAccountId;

  @JsonProperty("vat_identification")
  private String vatIdentification;

  @JsonProperty("vat_rate")
  private Float vatRate;

  @JsonProperty("discount_rate")
  private Float discountRate;

  /**
   * default discount type; possible valuesP - in %, A - Amount 
   */
  public enum DiscountTypeEnum {
    P("P"),
    
    A("A");

    private String value;

    DiscountTypeEnum(String value) {
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
    public static DiscountTypeEnum fromValue(String value) {
      for (DiscountTypeEnum b : DiscountTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("discount_type")
  private DiscountTypeEnum discountType = DiscountTypeEnum.P;

  @JsonProperty("payment_grace")
  private Integer paymentGrace;

  @JsonProperty("hourly_rate")
  private Float hourlyRate;

  @JsonProperty("custom_fields")
  @Valid
  private List<DescriptiveCustomFieldPOST> customFields = null;

  @JsonProperty("main_address")
  private ContactAddressPOST mainAddress;

  public ContactPOST number(String number) {
    this.number = number;
    return this;
  }

  /**
   * unique number - default value: 'next free number'
   * @return number
  */
  @ApiModelProperty(value = "unique number - default value: 'next free number'")


  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public ContactPOST relation(List<RelationEnum> relation) {
    this.relation = relation;
    return this;
  }

  public ContactPOST addRelationItem(RelationEnum relationItem) {
    this.relation.add(relationItem);
    return this;
  }

  /**
   * type of contact's relation; possible values: CL - Customer, CR - Creditor 
   * @return relation
  */
  @ApiModelProperty(required = true, value = "type of contact's relation; possible values: CL - Customer, CR - Creditor ")
  @NotNull


  public List<RelationEnum> getRelation() {
    return relation;
  }

  public void setRelation(List<RelationEnum> relation) {
    this.relation = relation;
  }

  public ContactPOST type(String type) {
    this.type = type;
    return this;
  }

  /**
   * type of contact; possible values: C - Company, P - Private
   * @return type
  */
  @ApiModelProperty(required = true, value = "type of contact; possible values: C - Company, P - Private")
  @NotNull


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public ContactPOST gender(GenderEnum gender) {
    this.gender = gender;
    return this;
  }

  /**
   * gender of contact (required for P type); possible values: M - Male, F - Female
   * @return gender
  */
  @ApiModelProperty(value = "gender of contact (required for P type); possible values: M - Male, F - Female")


  public GenderEnum getGender() {
    return gender;
  }

  public void setGender(GenderEnum gender) {
    this.gender = gender;
  }

  public ContactPOST genderSalutationActive(Boolean genderSalutationActive) {
    this.genderSalutationActive = genderSalutationActive;
    return this;
  }

  /**
   * whether to show Mr./Ms. before contact name (for P type only) - default value: false
   * @return genderSalutationActive
  */
  @ApiModelProperty(value = "whether to show Mr./Ms. before contact name (for P type only) - default value: false")


  public Boolean getGenderSalutationActive() {
    return genderSalutationActive;
  }

  public void setGenderSalutationActive(Boolean genderSalutationActive) {
    this.genderSalutationActive = genderSalutationActive;
  }

  public ContactPOST name(String name) {
    this.name = name;
    return this;
  }

  /**
   * name of contact
   * @return name
  */
  @ApiModelProperty(required = true, value = "name of contact")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ContactPOST nameAddition(String nameAddition) {
    this.nameAddition = nameAddition;
    return this;
  }

  /**
   * additional text for contact name
   * @return nameAddition
  */
  @ApiModelProperty(value = "additional text for contact name")


  public String getNameAddition() {
    return nameAddition;
  }

  public void setNameAddition(String nameAddition) {
    this.nameAddition = nameAddition;
  }

  public ContactPOST salutation(String salutation) {
    this.salutation = salutation;
    return this;
  }

  /**
   * e.g. Dear Mr. Jones
   * @return salutation
  */
  @ApiModelProperty(value = "e.g. Dear Mr. Jones")


  public String getSalutation() {
    return salutation;
  }

  public void setSalutation(String salutation) {
    this.salutation = salutation;
  }

  public ContactPOST phone(String phone) {
    this.phone = phone;
    return this;
  }

  /**
   * contact phone number
   * @return phone
  */
  @ApiModelProperty(value = "contact phone number")


  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public ContactPOST fax(String fax) {
    this.fax = fax;
    return this;
  }

  /**
   * contact fax number
   * @return fax
  */
  @ApiModelProperty(value = "contact fax number")


  public String getFax() {
    return fax;
  }

  public void setFax(String fax) {
    this.fax = fax;
  }

  public ContactPOST email(String email) {
    this.email = email;
    return this;
  }

  /**
   * contact email address
   * @return email
  */
  @ApiModelProperty(value = "contact email address")


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public ContactPOST website(String website) {
    this.website = website;
    return this;
  }

  /**
   * contact website address
   * @return website
  */
  @ApiModelProperty(value = "contact website address")


  public String getWebsite() {
    return website;
  }

  public void setWebsite(String website) {
    this.website = website;
  }

  public ContactPOST notes(String notes) {
    this.notes = notes;
    return this;
  }

  /**
   * additional notes
   * @return notes
  */
  @ApiModelProperty(value = "additional notes")


  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public ContactPOST communicationLanguage(String communicationLanguage) {
    this.communicationLanguage = communicationLanguage;
    return this;
  }

  /**
   * main communication language - default value: 'default documents language'
   * @return communicationLanguage
  */
  @ApiModelProperty(value = "main communication language - default value: 'default documents language'")


  public String getCommunicationLanguage() {
    return communicationLanguage;
  }

  public void setCommunicationLanguage(String communicationLanguage) {
    this.communicationLanguage = communicationLanguage;
  }

  public ContactPOST communicationChannel(CommunicationChannelEnum communicationChannel) {
    this.communicationChannel = communicationChannel;
    return this;
  }

  /**
   * possible values: U - No preference, E - Documents by e-mail, P - Documents by post 
   * @return communicationChannel
  */
  @ApiModelProperty(value = "possible values: U - No preference, E - Documents by e-mail, P - Documents by post ")


  public CommunicationChannelEnum getCommunicationChannel() {
    return communicationChannel;
  }

  public void setCommunicationChannel(CommunicationChannelEnum communicationChannel) {
    this.communicationChannel = communicationChannel;
  }

  public ContactPOST communicationNewsletter(CommunicationNewsletterEnum communicationNewsletter) {
    this.communicationNewsletter = communicationNewsletter;
    return this;
  }

  /**
   * possible values:   A - Send to main e-mail address and contacts,   M - Only send to main e-mail address,   N - No newsletter wanted 
   * @return communicationNewsletter
  */
  @ApiModelProperty(value = "possible values:   A - Send to main e-mail address and contacts,   M - Only send to main e-mail address,   N - No newsletter wanted ")


  public CommunicationNewsletterEnum getCommunicationNewsletter() {
    return communicationNewsletter;
  }

  public void setCommunicationNewsletter(CommunicationNewsletterEnum communicationNewsletter) {
    this.communicationNewsletter = communicationNewsletter;
  }

  public ContactPOST currency(String currency) {
    this.currency = currency;
    return this;
  }

  /**
   * default currency
   * @return currency
  */
  @ApiModelProperty(value = "default currency")


  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public ContactPOST ebillAccountId(String ebillAccountId) {
    this.ebillAccountId = ebillAccountId;
    return this;
  }

  /**
   * e-bill account identification number
   * @return ebillAccountId
  */
  @ApiModelProperty(value = "e-bill account identification number")


  public String getEbillAccountId() {
    return ebillAccountId;
  }

  public void setEbillAccountId(String ebillAccountId) {
    this.ebillAccountId = ebillAccountId;
  }

  public ContactPOST vatIdentification(String vatIdentification) {
    this.vatIdentification = vatIdentification;
    return this;
  }

  /**
   * VAT identification number
   * @return vatIdentification
  */
  @ApiModelProperty(value = "VAT identification number")


  public String getVatIdentification() {
    return vatIdentification;
  }

  public void setVatIdentification(String vatIdentification) {
    this.vatIdentification = vatIdentification;
  }

  public ContactPOST vatRate(Float vatRate) {
    this.vatRate = vatRate;
    return this;
  }

  /**
   * default VAT rate
   * @return vatRate
  */
  @ApiModelProperty(value = "default VAT rate")


  public Float getVatRate() {
    return vatRate;
  }

  public void setVatRate(Float vatRate) {
    this.vatRate = vatRate;
  }

  public ContactPOST discountRate(Float discountRate) {
    this.discountRate = discountRate;
    return this;
  }

  /**
   * default discount rate - default value: 0
   * @return discountRate
  */
  @ApiModelProperty(value = "default discount rate - default value: 0")


  public Float getDiscountRate() {
    return discountRate;
  }

  public void setDiscountRate(Float discountRate) {
    this.discountRate = discountRate;
  }

  public ContactPOST discountType(DiscountTypeEnum discountType) {
    this.discountType = discountType;
    return this;
  }

  /**
   * default discount type; possible valuesP - in %, A - Amount 
   * @return discountType
  */
  @ApiModelProperty(value = "default discount type; possible valuesP - in %, A - Amount ")


  public DiscountTypeEnum getDiscountType() {
    return discountType;
  }

  public void setDiscountType(DiscountTypeEnum discountType) {
    this.discountType = discountType;
  }

  public ContactPOST paymentGrace(Integer paymentGrace) {
    this.paymentGrace = paymentGrace;
    return this;
  }

  /**
   * default payment deadline
   * @return paymentGrace
  */
  @ApiModelProperty(value = "default payment deadline")


  public Integer getPaymentGrace() {
    return paymentGrace;
  }

  public void setPaymentGrace(Integer paymentGrace) {
    this.paymentGrace = paymentGrace;
  }

  public ContactPOST hourlyRate(Float hourlyRate) {
    this.hourlyRate = hourlyRate;
    return this;
  }

  /**
   * cost per hour
   * @return hourlyRate
  */
  @ApiModelProperty(value = "cost per hour")


  public Float getHourlyRate() {
    return hourlyRate;
  }

  public void setHourlyRate(Float hourlyRate) {
    this.hourlyRate = hourlyRate;
  }

  public ContactPOST customFields(List<DescriptiveCustomFieldPOST> customFields) {
    this.customFields = customFields;
    return this;
  }

  public ContactPOST addCustomFieldsItem(DescriptiveCustomFieldPOST customFieldsItem) {
    if (this.customFields == null) {
      this.customFields = new ArrayList<>();
    }
    this.customFields.add(customFieldsItem);
    return this;
  }

  /**
   * custom fields values
   * @return customFields
  */
  @ApiModelProperty(value = "custom fields values")

  @Valid

  public List<DescriptiveCustomFieldPOST> getCustomFields() {
    return customFields;
  }

  public void setCustomFields(List<DescriptiveCustomFieldPOST> customFields) {
    this.customFields = customFields;
  }

  public ContactPOST mainAddress(ContactAddressPOST mainAddress) {
    this.mainAddress = mainAddress;
    return this;
  }

  /**
   * Get mainAddress
   * @return mainAddress
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public ContactAddressPOST getMainAddress() {
    return mainAddress;
  }

  public void setMainAddress(ContactAddressPOST mainAddress) {
    this.mainAddress = mainAddress;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContactPOST contactPOST = (ContactPOST) o;
    return Objects.equals(this.number, contactPOST.number) &&
        Objects.equals(this.relation, contactPOST.relation) &&
        Objects.equals(this.type, contactPOST.type) &&
        Objects.equals(this.gender, contactPOST.gender) &&
        Objects.equals(this.genderSalutationActive, contactPOST.genderSalutationActive) &&
        Objects.equals(this.name, contactPOST.name) &&
        Objects.equals(this.nameAddition, contactPOST.nameAddition) &&
        Objects.equals(this.salutation, contactPOST.salutation) &&
        Objects.equals(this.phone, contactPOST.phone) &&
        Objects.equals(this.fax, contactPOST.fax) &&
        Objects.equals(this.email, contactPOST.email) &&
        Objects.equals(this.website, contactPOST.website) &&
        Objects.equals(this.notes, contactPOST.notes) &&
        Objects.equals(this.communicationLanguage, contactPOST.communicationLanguage) &&
        Objects.equals(this.communicationChannel, contactPOST.communicationChannel) &&
        Objects.equals(this.communicationNewsletter, contactPOST.communicationNewsletter) &&
        Objects.equals(this.currency, contactPOST.currency) &&
        Objects.equals(this.ebillAccountId, contactPOST.ebillAccountId) &&
        Objects.equals(this.vatIdentification, contactPOST.vatIdentification) &&
        Objects.equals(this.vatRate, contactPOST.vatRate) &&
        Objects.equals(this.discountRate, contactPOST.discountRate) &&
        Objects.equals(this.discountType, contactPOST.discountType) &&
        Objects.equals(this.paymentGrace, contactPOST.paymentGrace) &&
        Objects.equals(this.hourlyRate, contactPOST.hourlyRate) &&
        Objects.equals(this.customFields, contactPOST.customFields) &&
        Objects.equals(this.mainAddress, contactPOST.mainAddress);
  }

  @Override
  public int hashCode() {
    return Objects.hash(number, relation, type, gender, genderSalutationActive, name, nameAddition, salutation, phone, fax, email, website, notes, communicationLanguage, communicationChannel, communicationNewsletter, currency, ebillAccountId, vatIdentification, vatRate, discountRate, discountType, paymentGrace, hourlyRate, customFields, mainAddress);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContactPOST {\n");
    
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
    sb.append("    relation: ").append(toIndentedString(relation)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    gender: ").append(toIndentedString(gender)).append("\n");
    sb.append("    genderSalutationActive: ").append(toIndentedString(genderSalutationActive)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    nameAddition: ").append(toIndentedString(nameAddition)).append("\n");
    sb.append("    salutation: ").append(toIndentedString(salutation)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
    sb.append("    fax: ").append(toIndentedString(fax)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    website: ").append(toIndentedString(website)).append("\n");
    sb.append("    notes: ").append(toIndentedString(notes)).append("\n");
    sb.append("    communicationLanguage: ").append(toIndentedString(communicationLanguage)).append("\n");
    sb.append("    communicationChannel: ").append(toIndentedString(communicationChannel)).append("\n");
    sb.append("    communicationNewsletter: ").append(toIndentedString(communicationNewsletter)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    ebillAccountId: ").append(toIndentedString(ebillAccountId)).append("\n");
    sb.append("    vatIdentification: ").append(toIndentedString(vatIdentification)).append("\n");
    sb.append("    vatRate: ").append(toIndentedString(vatRate)).append("\n");
    sb.append("    discountRate: ").append(toIndentedString(discountRate)).append("\n");
    sb.append("    discountType: ").append(toIndentedString(discountType)).append("\n");
    sb.append("    paymentGrace: ").append(toIndentedString(paymentGrace)).append("\n");
    sb.append("    hourlyRate: ").append(toIndentedString(hourlyRate)).append("\n");
    sb.append("    customFields: ").append(toIndentedString(customFields)).append("\n");
    sb.append("    mainAddress: ").append(toIndentedString(mainAddress)).append("\n");
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

