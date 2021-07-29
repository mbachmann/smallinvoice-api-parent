package com.example.smallinvoicespringfeign.model;

import java.util.Objects;
import com.example.smallinvoicespringfeign.model.ContactAddressGET;
import com.example.smallinvoicespringfeign.model.DescriptiveContactGroupGET;
import com.example.smallinvoicespringfeign.model.DescriptiveCustomFieldGET;
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
 * ContactGET
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-29T19:43:05.733009+02:00[Europe/Zurich]")
public class ContactGET  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("id")
  private Integer id;

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

  /**
   * type of contact; possible values: C - Company, P - Private 
   */
  public enum TypeEnum {
    C("C"),
    
    P("P");

    private String value;

    TypeEnum(String value) {
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
    public static TypeEnum fromValue(String value) {
      for (TypeEnum b : TypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("type")
  private TypeEnum type;

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

  @JsonProperty("created")
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
  private LocalDateTime created;

  @JsonProperty("custom_fields")
  @Valid
  private List<DescriptiveCustomFieldGET> customFields = null;

  @JsonProperty("main_address_id")
  private Integer mainAddressId;

  @JsonProperty("main_address")
  private ContactAddressGET mainAddress;

  @JsonProperty("groups")
  @Valid
  private List<DescriptiveContactGroupGET> groups = null;

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

  public ContactGET id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * id of a contact
   * @return id
  */
  @ApiModelProperty(required = true, value = "id of a contact")
  @NotNull


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public ContactGET number(String number) {
    this.number = number;
    return this;
  }

  /**
   * unique number
   * @return number
  */
  @ApiModelProperty(required = true, value = "unique number")
  @NotNull


  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public ContactGET relation(List<RelationEnum> relation) {
    this.relation = relation;
    return this;
  }

  public ContactGET addRelationItem(RelationEnum relationItem) {
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

  public ContactGET type(TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * type of contact; possible values: C - Company, P - Private 
   * @return type
  */
  @ApiModelProperty(required = true, value = "type of contact; possible values: C - Company, P - Private ")
  @NotNull


  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public ContactGET gender(GenderEnum gender) {
    this.gender = gender;
    return this;
  }

  /**
   * gender of contact (required for P type); possible values: M - Male, F - Female
   * @return gender
  */
  @ApiModelProperty(required = true, value = "gender of contact (required for P type); possible values: M - Male, F - Female")
  @NotNull


  public GenderEnum getGender() {
    return gender;
  }

  public void setGender(GenderEnum gender) {
    this.gender = gender;
  }

  public ContactGET genderSalutationActive(Boolean genderSalutationActive) {
    this.genderSalutationActive = genderSalutationActive;
    return this;
  }

  /**
   * whether to show Mr./Ms. before contact name (for P type only)
   * @return genderSalutationActive
  */
  @ApiModelProperty(required = true, value = "whether to show Mr./Ms. before contact name (for P type only)")
  @NotNull


  public Boolean getGenderSalutationActive() {
    return genderSalutationActive;
  }

  public void setGenderSalutationActive(Boolean genderSalutationActive) {
    this.genderSalutationActive = genderSalutationActive;
  }

  public ContactGET name(String name) {
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

  public ContactGET nameAddition(String nameAddition) {
    this.nameAddition = nameAddition;
    return this;
  }

  /**
   * additional text for contact name
   * @return nameAddition
  */
  @ApiModelProperty(required = true, value = "additional text for contact name")
  @NotNull


  public String getNameAddition() {
    return nameAddition;
  }

  public void setNameAddition(String nameAddition) {
    this.nameAddition = nameAddition;
  }

  public ContactGET salutation(String salutation) {
    this.salutation = salutation;
    return this;
  }

  /**
   * e.g. Dear Mr. Jones
   * @return salutation
  */
  @ApiModelProperty(required = true, value = "e.g. Dear Mr. Jones")
  @NotNull


  public String getSalutation() {
    return salutation;
  }

  public void setSalutation(String salutation) {
    this.salutation = salutation;
  }

  public ContactGET phone(String phone) {
    this.phone = phone;
    return this;
  }

  /**
   * contact phone number
   * @return phone
  */
  @ApiModelProperty(required = true, value = "contact phone number")
  @NotNull


  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public ContactGET fax(String fax) {
    this.fax = fax;
    return this;
  }

  /**
   * contact fax number
   * @return fax
  */
  @ApiModelProperty(required = true, value = "contact fax number")
  @NotNull


  public String getFax() {
    return fax;
  }

  public void setFax(String fax) {
    this.fax = fax;
  }

  public ContactGET email(String email) {
    this.email = email;
    return this;
  }

  /**
   * contact email address
   * @return email
  */
  @ApiModelProperty(required = true, value = "contact email address")
  @NotNull


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public ContactGET website(String website) {
    this.website = website;
    return this;
  }

  /**
   * contact website address
   * @return website
  */
  @ApiModelProperty(required = true, value = "contact website address")
  @NotNull


  public String getWebsite() {
    return website;
  }

  public void setWebsite(String website) {
    this.website = website;
  }

  public ContactGET notes(String notes) {
    this.notes = notes;
    return this;
  }

  /**
   * additional notes
   * @return notes
  */
  @ApiModelProperty(required = true, value = "additional notes")
  @NotNull


  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public ContactGET communicationLanguage(String communicationLanguage) {
    this.communicationLanguage = communicationLanguage;
    return this;
  }

  /**
   * main communication language - default value: 'default documents language'
   * @return communicationLanguage
  */
  @ApiModelProperty(required = true, value = "main communication language - default value: 'default documents language'")
  @NotNull


  public String getCommunicationLanguage() {
    return communicationLanguage;
  }

  public void setCommunicationLanguage(String communicationLanguage) {
    this.communicationLanguage = communicationLanguage;
  }

  public ContactGET communicationChannel(CommunicationChannelEnum communicationChannel) {
    this.communicationChannel = communicationChannel;
    return this;
  }

  /**
   * possible values: U - No preference, E - Documents by e-mail, P - Documents by post 
   * @return communicationChannel
  */
  @ApiModelProperty(required = true, value = "possible values: U - No preference, E - Documents by e-mail, P - Documents by post ")
  @NotNull


  public CommunicationChannelEnum getCommunicationChannel() {
    return communicationChannel;
  }

  public void setCommunicationChannel(CommunicationChannelEnum communicationChannel) {
    this.communicationChannel = communicationChannel;
  }

  public ContactGET communicationNewsletter(CommunicationNewsletterEnum communicationNewsletter) {
    this.communicationNewsletter = communicationNewsletter;
    return this;
  }

  /**
   * possible values:   A - Send to main e-mail address and contacts,   M - Only send to main e-mail address,   N - No newsletter wanted 
   * @return communicationNewsletter
  */
  @ApiModelProperty(required = true, value = "possible values:   A - Send to main e-mail address and contacts,   M - Only send to main e-mail address,   N - No newsletter wanted ")
  @NotNull


  public CommunicationNewsletterEnum getCommunicationNewsletter() {
    return communicationNewsletter;
  }

  public void setCommunicationNewsletter(CommunicationNewsletterEnum communicationNewsletter) {
    this.communicationNewsletter = communicationNewsletter;
  }

  public ContactGET currency(String currency) {
    this.currency = currency;
    return this;
  }

  /**
   * default currency
   * @return currency
  */
  @ApiModelProperty(required = true, value = "default currency")
  @NotNull


  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public ContactGET ebillAccountId(String ebillAccountId) {
    this.ebillAccountId = ebillAccountId;
    return this;
  }

  /**
   * e-bill account identification number
   * @return ebillAccountId
  */
  @ApiModelProperty(required = true, value = "e-bill account identification number")
  @NotNull


  public String getEbillAccountId() {
    return ebillAccountId;
  }

  public void setEbillAccountId(String ebillAccountId) {
    this.ebillAccountId = ebillAccountId;
  }

  public ContactGET vatIdentification(String vatIdentification) {
    this.vatIdentification = vatIdentification;
    return this;
  }

  /**
   * VAT identification number
   * @return vatIdentification
  */
  @ApiModelProperty(required = true, value = "VAT identification number")
  @NotNull


  public String getVatIdentification() {
    return vatIdentification;
  }

  public void setVatIdentification(String vatIdentification) {
    this.vatIdentification = vatIdentification;
  }

  public ContactGET vatRate(Float vatRate) {
    this.vatRate = vatRate;
    return this;
  }

  /**
   * default VAT rate
   * @return vatRate
  */
  @ApiModelProperty(required = true, value = "default VAT rate")
  @NotNull


  public Float getVatRate() {
    return vatRate;
  }

  public void setVatRate(Float vatRate) {
    this.vatRate = vatRate;
  }

  public ContactGET discountRate(Float discountRate) {
    this.discountRate = discountRate;
    return this;
  }

  /**
   * default discount rate
   * @return discountRate
  */
  @ApiModelProperty(required = true, value = "default discount rate")
  @NotNull


  public Float getDiscountRate() {
    return discountRate;
  }

  public void setDiscountRate(Float discountRate) {
    this.discountRate = discountRate;
  }

  public ContactGET discountType(DiscountTypeEnum discountType) {
    this.discountType = discountType;
    return this;
  }

  /**
   * default discount type; possible valuesP - in %, A - Amount 
   * @return discountType
  */
  @ApiModelProperty(required = true, value = "default discount type; possible valuesP - in %, A - Amount ")
  @NotNull


  public DiscountTypeEnum getDiscountType() {
    return discountType;
  }

  public void setDiscountType(DiscountTypeEnum discountType) {
    this.discountType = discountType;
  }

  public ContactGET paymentGrace(Integer paymentGrace) {
    this.paymentGrace = paymentGrace;
    return this;
  }

  /**
   * default payment deadline
   * @return paymentGrace
  */
  @ApiModelProperty(required = true, value = "default payment deadline")
  @NotNull


  public Integer getPaymentGrace() {
    return paymentGrace;
  }

  public void setPaymentGrace(Integer paymentGrace) {
    this.paymentGrace = paymentGrace;
  }

  public ContactGET hourlyRate(Float hourlyRate) {
    this.hourlyRate = hourlyRate;
    return this;
  }

  /**
   * cost per hour
   * @return hourlyRate
  */
  @ApiModelProperty(required = true, value = "cost per hour")
  @NotNull


  public Float getHourlyRate() {
    return hourlyRate;
  }

  public void setHourlyRate(Float hourlyRate) {
    this.hourlyRate = hourlyRate;
  }

  public ContactGET created(LocalDateTime created) {
    this.created = created;
    return this;
  }

  /**
   * when contact was created
   * @return created
  */
  @ApiModelProperty(required = true, value = "when contact was created")
  @NotNull

  @Valid

  public LocalDateTime getCreated() {
    return created;
  }

  public void setCreated(LocalDateTime created) {
    this.created = created;
  }

  public ContactGET customFields(List<DescriptiveCustomFieldGET> customFields) {
    this.customFields = customFields;
    return this;
  }

  public ContactGET addCustomFieldsItem(DescriptiveCustomFieldGET customFieldsItem) {
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

  public List<DescriptiveCustomFieldGET> getCustomFields() {
    return customFields;
  }

  public void setCustomFields(List<DescriptiveCustomFieldGET> customFields) {
    this.customFields = customFields;
  }

  public ContactGET mainAddressId(Integer mainAddressId) {
    this.mainAddressId = mainAddressId;
    return this;
  }

  /**
   * main address id
   * @return mainAddressId
  */
  @ApiModelProperty(required = true, value = "main address id")
  @NotNull


  public Integer getMainAddressId() {
    return mainAddressId;
  }

  public void setMainAddressId(Integer mainAddressId) {
    this.mainAddressId = mainAddressId;
  }

  public ContactGET mainAddress(ContactAddressGET mainAddress) {
    this.mainAddress = mainAddress;
    return this;
  }

  /**
   * Get mainAddress
   * @return mainAddress
  */
  @ApiModelProperty(value = "")

  @Valid

  public ContactAddressGET getMainAddress() {
    return mainAddress;
  }

  public void setMainAddress(ContactAddressGET mainAddress) {
    this.mainAddress = mainAddress;
  }

  public ContactGET groups(List<DescriptiveContactGroupGET> groups) {
    this.groups = groups;
    return this;
  }

  public ContactGET addGroupsItem(DescriptiveContactGroupGET groupsItem) {
    if (this.groups == null) {
      this.groups = new ArrayList<>();
    }
    this.groups.add(groupsItem);
    return this;
  }

  /**
   * groups assigned to contact
   * @return groups
  */
  @ApiModelProperty(value = "groups assigned to contact")

  @Valid

  public List<DescriptiveContactGroupGET> getGroups() {
    return groups;
  }

  public void setGroups(List<DescriptiveContactGroupGET> groups) {
    this.groups = groups;
  }

  public ContactGET permissions(List<PermissionsEnum> permissions) {
    this.permissions = permissions;
    return this;
  }

  public ContactGET addPermissionsItem(PermissionsEnum permissionsItem) {
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
    ContactGET contactGET = (ContactGET) o;
    return Objects.equals(this.id, contactGET.id) &&
        Objects.equals(this.number, contactGET.number) &&
        Objects.equals(this.relation, contactGET.relation) &&
        Objects.equals(this.type, contactGET.type) &&
        Objects.equals(this.gender, contactGET.gender) &&
        Objects.equals(this.genderSalutationActive, contactGET.genderSalutationActive) &&
        Objects.equals(this.name, contactGET.name) &&
        Objects.equals(this.nameAddition, contactGET.nameAddition) &&
        Objects.equals(this.salutation, contactGET.salutation) &&
        Objects.equals(this.phone, contactGET.phone) &&
        Objects.equals(this.fax, contactGET.fax) &&
        Objects.equals(this.email, contactGET.email) &&
        Objects.equals(this.website, contactGET.website) &&
        Objects.equals(this.notes, contactGET.notes) &&
        Objects.equals(this.communicationLanguage, contactGET.communicationLanguage) &&
        Objects.equals(this.communicationChannel, contactGET.communicationChannel) &&
        Objects.equals(this.communicationNewsletter, contactGET.communicationNewsletter) &&
        Objects.equals(this.currency, contactGET.currency) &&
        Objects.equals(this.ebillAccountId, contactGET.ebillAccountId) &&
        Objects.equals(this.vatIdentification, contactGET.vatIdentification) &&
        Objects.equals(this.vatRate, contactGET.vatRate) &&
        Objects.equals(this.discountRate, contactGET.discountRate) &&
        Objects.equals(this.discountType, contactGET.discountType) &&
        Objects.equals(this.paymentGrace, contactGET.paymentGrace) &&
        Objects.equals(this.hourlyRate, contactGET.hourlyRate) &&
        Objects.equals(this.created, contactGET.created) &&
        Objects.equals(this.customFields, contactGET.customFields) &&
        Objects.equals(this.mainAddressId, contactGET.mainAddressId) &&
        Objects.equals(this.mainAddress, contactGET.mainAddress) &&
        Objects.equals(this.groups, contactGET.groups) &&
        Objects.equals(this.permissions, contactGET.permissions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, number, relation, type, gender, genderSalutationActive, name, nameAddition, salutation, phone, fax, email, website, notes, communicationLanguage, communicationChannel, communicationNewsletter, currency, ebillAccountId, vatIdentification, vatRate, discountRate, discountType, paymentGrace, hourlyRate, created, customFields, mainAddressId, mainAddress, groups, permissions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContactGET {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    customFields: ").append(toIndentedString(customFields)).append("\n");
    sb.append("    mainAddressId: ").append(toIndentedString(mainAddressId)).append("\n");
    sb.append("    mainAddress: ").append(toIndentedString(mainAddress)).append("\n");
    sb.append("    groups: ").append(toIndentedString(groups)).append("\n");
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

