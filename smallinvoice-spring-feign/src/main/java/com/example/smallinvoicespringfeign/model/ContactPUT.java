package com.example.smallinvoicespringfeign.model;

import java.util.Objects;
import com.example.smallinvoicespringfeign.model.DescriptiveCustomFieldPUT;
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
 * ContactPUT
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-08-03T21:09:37.732+02:00[Europe/Zurich]")
public class ContactPUT  implements Serializable {
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
  private List<RelationEnum> relation = null;

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
  private List<DescriptiveCustomFieldPUT> customFields = null;

  public ContactPUT number(String number) {
    this.number = number;
    return this;
  }

  /**
   * unique number
   * @return number
  */
  @ApiModelProperty(value = "unique number")


  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public ContactPUT relation(List<RelationEnum> relation) {
    this.relation = relation;
    return this;
  }

  public ContactPUT addRelationItem(RelationEnum relationItem) {
    if (this.relation == null) {
      this.relation = new ArrayList<>();
    }
    this.relation.add(relationItem);
    return this;
  }

  /**
   * type of contact's relation; possible values: CL - Customer, CR - Creditor 
   * @return relation
  */
  @ApiModelProperty(value = "type of contact's relation; possible values: CL - Customer, CR - Creditor ")


  public List<RelationEnum> getRelation() {
    return relation;
  }

  public void setRelation(List<RelationEnum> relation) {
    this.relation = relation;
  }

  public ContactPUT type(String type) {
    this.type = type;
    return this;
  }

  /**
   * type of contact; possible values: C - Company, P - Private
   * @return type
  */
  @ApiModelProperty(value = "type of contact; possible values: C - Company, P - Private")


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public ContactPUT gender(GenderEnum gender) {
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

  public ContactPUT genderSalutationActive(Boolean genderSalutationActive) {
    this.genderSalutationActive = genderSalutationActive;
    return this;
  }

  /**
   * whether to show Mr./Ms. before contact name (for P type only)
   * @return genderSalutationActive
  */
  @ApiModelProperty(value = "whether to show Mr./Ms. before contact name (for P type only)")


  public Boolean getGenderSalutationActive() {
    return genderSalutationActive;
  }

  public void setGenderSalutationActive(Boolean genderSalutationActive) {
    this.genderSalutationActive = genderSalutationActive;
  }

  public ContactPUT name(String name) {
    this.name = name;
    return this;
  }

  /**
   * name of contact
   * @return name
  */
  @ApiModelProperty(value = "name of contact")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ContactPUT nameAddition(String nameAddition) {
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

  public ContactPUT salutation(String salutation) {
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

  public ContactPUT phone(String phone) {
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

  public ContactPUT fax(String fax) {
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

  public ContactPUT email(String email) {
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

  public ContactPUT website(String website) {
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

  public ContactPUT notes(String notes) {
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

  public ContactPUT communicationLanguage(String communicationLanguage) {
    this.communicationLanguage = communicationLanguage;
    return this;
  }

  /**
   * main communication language
   * @return communicationLanguage
  */
  @ApiModelProperty(value = "main communication language")


  public String getCommunicationLanguage() {
    return communicationLanguage;
  }

  public void setCommunicationLanguage(String communicationLanguage) {
    this.communicationLanguage = communicationLanguage;
  }

  public ContactPUT communicationChannel(CommunicationChannelEnum communicationChannel) {
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

  public ContactPUT communicationNewsletter(CommunicationNewsletterEnum communicationNewsletter) {
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

  public ContactPUT currency(String currency) {
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

  public ContactPUT ebillAccountId(String ebillAccountId) {
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

  public ContactPUT vatIdentification(String vatIdentification) {
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

  public ContactPUT vatRate(Float vatRate) {
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

  public ContactPUT discountRate(Float discountRate) {
    this.discountRate = discountRate;
    return this;
  }

  /**
   * default discount rate
   * @return discountRate
  */
  @ApiModelProperty(value = "default discount rate")


  public Float getDiscountRate() {
    return discountRate;
  }

  public void setDiscountRate(Float discountRate) {
    this.discountRate = discountRate;
  }

  public ContactPUT discountType(DiscountTypeEnum discountType) {
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

  public ContactPUT paymentGrace(Integer paymentGrace) {
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

  public ContactPUT hourlyRate(Float hourlyRate) {
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

  public ContactPUT customFields(List<DescriptiveCustomFieldPUT> customFields) {
    this.customFields = customFields;
    return this;
  }

  public ContactPUT addCustomFieldsItem(DescriptiveCustomFieldPUT customFieldsItem) {
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

  public List<DescriptiveCustomFieldPUT> getCustomFields() {
    return customFields;
  }

  public void setCustomFields(List<DescriptiveCustomFieldPUT> customFields) {
    this.customFields = customFields;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContactPUT contactPUT = (ContactPUT) o;
    return Objects.equals(this.number, contactPUT.number) &&
        Objects.equals(this.relation, contactPUT.relation) &&
        Objects.equals(this.type, contactPUT.type) &&
        Objects.equals(this.gender, contactPUT.gender) &&
        Objects.equals(this.genderSalutationActive, contactPUT.genderSalutationActive) &&
        Objects.equals(this.name, contactPUT.name) &&
        Objects.equals(this.nameAddition, contactPUT.nameAddition) &&
        Objects.equals(this.salutation, contactPUT.salutation) &&
        Objects.equals(this.phone, contactPUT.phone) &&
        Objects.equals(this.fax, contactPUT.fax) &&
        Objects.equals(this.email, contactPUT.email) &&
        Objects.equals(this.website, contactPUT.website) &&
        Objects.equals(this.notes, contactPUT.notes) &&
        Objects.equals(this.communicationLanguage, contactPUT.communicationLanguage) &&
        Objects.equals(this.communicationChannel, contactPUT.communicationChannel) &&
        Objects.equals(this.communicationNewsletter, contactPUT.communicationNewsletter) &&
        Objects.equals(this.currency, contactPUT.currency) &&
        Objects.equals(this.ebillAccountId, contactPUT.ebillAccountId) &&
        Objects.equals(this.vatIdentification, contactPUT.vatIdentification) &&
        Objects.equals(this.vatRate, contactPUT.vatRate) &&
        Objects.equals(this.discountRate, contactPUT.discountRate) &&
        Objects.equals(this.discountType, contactPUT.discountType) &&
        Objects.equals(this.paymentGrace, contactPUT.paymentGrace) &&
        Objects.equals(this.hourlyRate, contactPUT.hourlyRate) &&
        Objects.equals(this.customFields, contactPUT.customFields);
  }

  @Override
  public int hashCode() {
    return Objects.hash(number, relation, type, gender, genderSalutationActive, name, nameAddition, salutation, phone, fax, email, website, notes, communicationLanguage, communicationChannel, communicationNewsletter, currency, ebillAccountId, vatIdentification, vatRate, discountRate, discountType, paymentGrace, hourlyRate, customFields);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContactPUT {\n");
    
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

