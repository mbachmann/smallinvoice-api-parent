package com.example.smallinvoicespringfeign.model;

import java.util.Objects;
import com.example.smallinvoicespringfeign.model.ContactAddressGET;
import com.example.smallinvoicespringfeign.model.ContactGET;
import com.example.smallinvoicespringfeign.model.ContactPeopleGET;
import com.example.smallinvoicespringfeign.model.DescriptiveCustomFieldGET;
import com.example.smallinvoicespringfeign.model.DocumentDeliveryNotePositionGET;
import com.example.smallinvoicespringfeign.model.DocumentDeliveryNoteTextGET;
import com.example.smallinvoicespringfeign.model.DocumentFreeTextGET;
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
 * DocumentDeliveryNoteGET
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-31T13:05:18.255013+02:00[Europe/Zurich]")
public class DocumentDeliveryNoteGET  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("id")
  private Integer id;

  @JsonProperty("number")
  private String number;

  @JsonProperty("contact_id")
  private Integer contactId;

  @JsonProperty("contact_name")
  private String contactName;

  @JsonProperty("contact")
  private ContactGET contact;

  @JsonProperty("contact_address_id")
  private Integer contactAddressId;

  @JsonProperty("contact_address")
  private ContactAddressGET contactAddress;

  @JsonProperty("contact_prepage_address_id")
  private Integer contactPrepageAddressId;

  @JsonProperty("contact_prepage_address")
  private ContactAddressGET contactPrepageAddress;

  @JsonProperty("contact_person_id")
  private Integer contactPersonId;

  @JsonProperty("contact_person")
  private ContactPeopleGET contactPerson;

  @JsonProperty("date")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE)
  private LocalDate date;

  @JsonProperty("period_text")
  private String periodText;

  @JsonProperty("currency")
  private String currency;

  @JsonProperty("total")
  private Float total;

  @JsonProperty("vat_included")
  private Boolean vatIncluded;

  @JsonProperty("discount_rate")
  private Float discountRate;

  /**
   * optional discount type; possible values: A - amount, P - in % 
   */
  public enum DiscountTypeEnum {
    A("A"),
    
    P("P");

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

  /**
   * language; possible values: de, en, es, fr, it 
   */
  public enum LanguageEnum {
    DE("de"),
    
    EN("en"),
    
    ES("es"),
    
    FR("fr"),
    
    IT("it");

    private String value;

    LanguageEnum(String value) {
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
    public static LanguageEnum fromValue(String value) {
      for (LanguageEnum b : LanguageEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("language")
  private LanguageEnum language;

  @JsonProperty("signature_id")
  private Integer signatureId;

  @JsonProperty("layout_id")
  private Integer layoutId;

  @JsonProperty("page_amount")
  private Integer pageAmount;

  @JsonProperty("notes")
  private String notes;

  /**
   * status of delivery note, possible values: DR - draft, S - sent, B - billed, D - deleted (but still visible)
   */
  public enum StatusEnum {
    DR("DR"),
    
    S("S"),
    
    B("B"),
    
    D("D");

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
  private StatusEnum status = StatusEnum.DR;

  @JsonProperty("created")
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
  private LocalDateTime created;

  @JsonProperty("custom_fields")
  @Valid
  private List<DescriptiveCustomFieldGET> customFields = null;

  @JsonProperty("positions")
  @Valid
  private List<DocumentDeliveryNotePositionGET> positions = null;

  @JsonProperty("texts")
  @Valid
  private List<DocumentDeliveryNoteTextGET> texts = null;

  @JsonProperty("free_texts")
  @Valid
  private List<DocumentFreeTextGET> freeTexts = null;

  /**
   * Gets or Sets permissions
   */
  public enum PermissionsEnum {
    VIEW("view"),
    
    EDIT("edit"),
    
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

  public DocumentDeliveryNoteGET id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * delivery note id
   * @return id
  */
  @ApiModelProperty(required = true, value = "delivery note id")
  @NotNull


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public DocumentDeliveryNoteGET number(String number) {
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

  public DocumentDeliveryNoteGET contactId(Integer contactId) {
    this.contactId = contactId;
    return this;
  }

  /**
   * id of a contact
   * @return contactId
  */
  @ApiModelProperty(required = true, value = "id of a contact")
  @NotNull


  public Integer getContactId() {
    return contactId;
  }

  public void setContactId(Integer contactId) {
    this.contactId = contactId;
  }

  public DocumentDeliveryNoteGET contactName(String contactName) {
    this.contactName = contactName;
    return this;
  }

  /**
   * name of a contact
   * @return contactName
  */
  @ApiModelProperty(value = "name of a contact")


  public String getContactName() {
    return contactName;
  }

  public void setContactName(String contactName) {
    this.contactName = contactName;
  }

  public DocumentDeliveryNoteGET contact(ContactGET contact) {
    this.contact = contact;
    return this;
  }

  /**
   * Get contact
   * @return contact
  */
  @ApiModelProperty(value = "")

  @Valid

  public ContactGET getContact() {
    return contact;
  }

  public void setContact(ContactGET contact) {
    this.contact = contact;
  }

  public DocumentDeliveryNoteGET contactAddressId(Integer contactAddressId) {
    this.contactAddressId = contactAddressId;
    return this;
  }

  /**
   * id of a contact's address
   * @return contactAddressId
  */
  @ApiModelProperty(required = true, value = "id of a contact's address")
  @NotNull


  public Integer getContactAddressId() {
    return contactAddressId;
  }

  public void setContactAddressId(Integer contactAddressId) {
    this.contactAddressId = contactAddressId;
  }

  public DocumentDeliveryNoteGET contactAddress(ContactAddressGET contactAddress) {
    this.contactAddress = contactAddress;
    return this;
  }

  /**
   * Get contactAddress
   * @return contactAddress
  */
  @ApiModelProperty(value = "")

  @Valid

  public ContactAddressGET getContactAddress() {
    return contactAddress;
  }

  public void setContactAddress(ContactAddressGET contactAddress) {
    this.contactAddress = contactAddress;
  }

  public DocumentDeliveryNoteGET contactPrepageAddressId(Integer contactPrepageAddressId) {
    this.contactPrepageAddressId = contactPrepageAddressId;
    return this;
  }

  /**
   * id of a contact's prepage address
   * @return contactPrepageAddressId
  */
  @ApiModelProperty(required = true, value = "id of a contact's prepage address")
  @NotNull


  public Integer getContactPrepageAddressId() {
    return contactPrepageAddressId;
  }

  public void setContactPrepageAddressId(Integer contactPrepageAddressId) {
    this.contactPrepageAddressId = contactPrepageAddressId;
  }

  public DocumentDeliveryNoteGET contactPrepageAddress(ContactAddressGET contactPrepageAddress) {
    this.contactPrepageAddress = contactPrepageAddress;
    return this;
  }

  /**
   * Get contactPrepageAddress
   * @return contactPrepageAddress
  */
  @ApiModelProperty(value = "")

  @Valid

  public ContactAddressGET getContactPrepageAddress() {
    return contactPrepageAddress;
  }

  public void setContactPrepageAddress(ContactAddressGET contactPrepageAddress) {
    this.contactPrepageAddress = contactPrepageAddress;
  }

  public DocumentDeliveryNoteGET contactPersonId(Integer contactPersonId) {
    this.contactPersonId = contactPersonId;
    return this;
  }

  /**
   * id of a contact's person
   * @return contactPersonId
  */
  @ApiModelProperty(required = true, value = "id of a contact's person")
  @NotNull


  public Integer getContactPersonId() {
    return contactPersonId;
  }

  public void setContactPersonId(Integer contactPersonId) {
    this.contactPersonId = contactPersonId;
  }

  public DocumentDeliveryNoteGET contactPerson(ContactPeopleGET contactPerson) {
    this.contactPerson = contactPerson;
    return this;
  }

  /**
   * Get contactPerson
   * @return contactPerson
  */
  @ApiModelProperty(value = "")

  @Valid

  public ContactPeopleGET getContactPerson() {
    return contactPerson;
  }

  public void setContactPerson(ContactPeopleGET contactPerson) {
    this.contactPerson = contactPerson;
  }

  public DocumentDeliveryNoteGET date(LocalDate date) {
    this.date = date;
    return this;
  }

  /**
   * date of the delivery note
   * @return date
  */
  @ApiModelProperty(required = true, value = "date of the delivery note")
  @NotNull

  @Valid

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public DocumentDeliveryNoteGET periodText(String periodText) {
    this.periodText = periodText;
    return this;
  }

  /**
   * service/delivery
   * @return periodText
  */
  @ApiModelProperty(required = true, value = "service/delivery")
  @NotNull


  public String getPeriodText() {
    return periodText;
  }

  public void setPeriodText(String periodText) {
    this.periodText = periodText;
  }

  public DocumentDeliveryNoteGET currency(String currency) {
    this.currency = currency;
    return this;
  }

  /**
   * currency (e.g. CHF, EUR)
   * @return currency
  */
  @ApiModelProperty(required = true, value = "currency (e.g. CHF, EUR)")
  @NotNull


  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public DocumentDeliveryNoteGET total(Float total) {
    this.total = total;
    return this;
  }

  /**
   * total amount of the delivery note
   * @return total
  */
  @ApiModelProperty(required = true, value = "total amount of the delivery note")
  @NotNull


  public Float getTotal() {
    return total;
  }

  public void setTotal(Float total) {
    this.total = total;
  }

  public DocumentDeliveryNoteGET vatIncluded(Boolean vatIncluded) {
    this.vatIncluded = vatIncluded;
    return this;
  }

  /**
   * whether prices in delivery note include VAT
   * @return vatIncluded
  */
  @ApiModelProperty(required = true, value = "whether prices in delivery note include VAT")
  @NotNull


  public Boolean getVatIncluded() {
    return vatIncluded;
  }

  public void setVatIncluded(Boolean vatIncluded) {
    this.vatIncluded = vatIncluded;
  }

  public DocumentDeliveryNoteGET discountRate(Float discountRate) {
    this.discountRate = discountRate;
    return this;
  }

  /**
   * optional discount rate
   * @return discountRate
  */
  @ApiModelProperty(required = true, value = "optional discount rate")
  @NotNull


  public Float getDiscountRate() {
    return discountRate;
  }

  public void setDiscountRate(Float discountRate) {
    this.discountRate = discountRate;
  }

  public DocumentDeliveryNoteGET discountType(DiscountTypeEnum discountType) {
    this.discountType = discountType;
    return this;
  }

  /**
   * optional discount type; possible values: A - amount, P - in % 
   * @return discountType
  */
  @ApiModelProperty(required = true, value = "optional discount type; possible values: A - amount, P - in % ")
  @NotNull


  public DiscountTypeEnum getDiscountType() {
    return discountType;
  }

  public void setDiscountType(DiscountTypeEnum discountType) {
    this.discountType = discountType;
  }

  public DocumentDeliveryNoteGET language(LanguageEnum language) {
    this.language = language;
    return this;
  }

  /**
   * language; possible values: de, en, es, fr, it 
   * @return language
  */
  @ApiModelProperty(required = true, value = "language; possible values: de, en, es, fr, it ")
  @NotNull


  public LanguageEnum getLanguage() {
    return language;
  }

  public void setLanguage(LanguageEnum language) {
    this.language = language;
  }

  public DocumentDeliveryNoteGET signatureId(Integer signatureId) {
    this.signatureId = signatureId;
    return this;
  }

  /**
   * signature id
   * @return signatureId
  */
  @ApiModelProperty(required = true, value = "signature id")
  @NotNull


  public Integer getSignatureId() {
    return signatureId;
  }

  public void setSignatureId(Integer signatureId) {
    this.signatureId = signatureId;
  }

  public DocumentDeliveryNoteGET layoutId(Integer layoutId) {
    this.layoutId = layoutId;
    return this;
  }

  /**
   * layout id
   * @return layoutId
  */
  @ApiModelProperty(required = true, value = "layout id")
  @NotNull


  public Integer getLayoutId() {
    return layoutId;
  }

  public void setLayoutId(Integer layoutId) {
    this.layoutId = layoutId;
  }

  public DocumentDeliveryNoteGET pageAmount(Integer pageAmount) {
    this.pageAmount = pageAmount;
    return this;
  }

  /**
   * how many pages delivery note has
   * @return pageAmount
  */
  @ApiModelProperty(required = true, value = "how many pages delivery note has")
  @NotNull


  public Integer getPageAmount() {
    return pageAmount;
  }

  public void setPageAmount(Integer pageAmount) {
    this.pageAmount = pageAmount;
  }

  public DocumentDeliveryNoteGET notes(String notes) {
    this.notes = notes;
    return this;
  }

  /**
   * optional notes
   * @return notes
  */
  @ApiModelProperty(required = true, value = "optional notes")
  @NotNull


  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public DocumentDeliveryNoteGET status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * status of delivery note, possible values: DR - draft, S - sent, B - billed, D - deleted (but still visible)
   * @return status
  */
  @ApiModelProperty(required = true, value = "status of delivery note, possible values: DR - draft, S - sent, B - billed, D - deleted (but still visible)")
  @NotNull


  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public DocumentDeliveryNoteGET created(LocalDateTime created) {
    this.created = created;
    return this;
  }

  /**
   * date that delivery note was created
   * @return created
  */
  @ApiModelProperty(required = true, value = "date that delivery note was created")
  @NotNull

  @Valid

  public LocalDateTime getCreated() {
    return created;
  }

  public void setCreated(LocalDateTime created) {
    this.created = created;
  }

  public DocumentDeliveryNoteGET customFields(List<DescriptiveCustomFieldGET> customFields) {
    this.customFields = customFields;
    return this;
  }

  public DocumentDeliveryNoteGET addCustomFieldsItem(DescriptiveCustomFieldGET customFieldsItem) {
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

  public DocumentDeliveryNoteGET positions(List<DocumentDeliveryNotePositionGET> positions) {
    this.positions = positions;
    return this;
  }

  public DocumentDeliveryNoteGET addPositionsItem(DocumentDeliveryNotePositionGET positionsItem) {
    if (this.positions == null) {
      this.positions = new ArrayList<>();
    }
    this.positions.add(positionsItem);
    return this;
  }

  /**
   * positions objects
   * @return positions
  */
  @ApiModelProperty(value = "positions objects")

  @Valid

  public List<DocumentDeliveryNotePositionGET> getPositions() {
    return positions;
  }

  public void setPositions(List<DocumentDeliveryNotePositionGET> positions) {
    this.positions = positions;
  }

  public DocumentDeliveryNoteGET texts(List<DocumentDeliveryNoteTextGET> texts) {
    this.texts = texts;
    return this;
  }

  public DocumentDeliveryNoteGET addTextsItem(DocumentDeliveryNoteTextGET textsItem) {
    if (this.texts == null) {
      this.texts = new ArrayList<>();
    }
    this.texts.add(textsItem);
    return this;
  }

  /**
   * texts objects
   * @return texts
  */
  @ApiModelProperty(value = "texts objects")

  @Valid

  public List<DocumentDeliveryNoteTextGET> getTexts() {
    return texts;
  }

  public void setTexts(List<DocumentDeliveryNoteTextGET> texts) {
    this.texts = texts;
  }

  public DocumentDeliveryNoteGET freeTexts(List<DocumentFreeTextGET> freeTexts) {
    this.freeTexts = freeTexts;
    return this;
  }

  public DocumentDeliveryNoteGET addFreeTextsItem(DocumentFreeTextGET freeTextsItem) {
    if (this.freeTexts == null) {
      this.freeTexts = new ArrayList<>();
    }
    this.freeTexts.add(freeTextsItem);
    return this;
  }

  /**
   * free texts objects
   * @return freeTexts
  */
  @ApiModelProperty(value = "free texts objects")

  @Valid

  public List<DocumentFreeTextGET> getFreeTexts() {
    return freeTexts;
  }

  public void setFreeTexts(List<DocumentFreeTextGET> freeTexts) {
    this.freeTexts = freeTexts;
  }

  public DocumentDeliveryNoteGET permissions(List<PermissionsEnum> permissions) {
    this.permissions = permissions;
    return this;
  }

  public DocumentDeliveryNoteGET addPermissionsItem(PermissionsEnum permissionsItem) {
    if (this.permissions == null) {
      this.permissions = new ArrayList<>();
    }
    this.permissions.add(permissionsItem);
    return this;
  }

  /**
   * actions that can be performed on an item (possible values: view, edit, manage) 
   * @return permissions
  */
  @ApiModelProperty(value = "actions that can be performed on an item (possible values: view, edit, manage) ")


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
    DocumentDeliveryNoteGET documentDeliveryNoteGET = (DocumentDeliveryNoteGET) o;
    return Objects.equals(this.id, documentDeliveryNoteGET.id) &&
        Objects.equals(this.number, documentDeliveryNoteGET.number) &&
        Objects.equals(this.contactId, documentDeliveryNoteGET.contactId) &&
        Objects.equals(this.contactName, documentDeliveryNoteGET.contactName) &&
        Objects.equals(this.contact, documentDeliveryNoteGET.contact) &&
        Objects.equals(this.contactAddressId, documentDeliveryNoteGET.contactAddressId) &&
        Objects.equals(this.contactAddress, documentDeliveryNoteGET.contactAddress) &&
        Objects.equals(this.contactPrepageAddressId, documentDeliveryNoteGET.contactPrepageAddressId) &&
        Objects.equals(this.contactPrepageAddress, documentDeliveryNoteGET.contactPrepageAddress) &&
        Objects.equals(this.contactPersonId, documentDeliveryNoteGET.contactPersonId) &&
        Objects.equals(this.contactPerson, documentDeliveryNoteGET.contactPerson) &&
        Objects.equals(this.date, documentDeliveryNoteGET.date) &&
        Objects.equals(this.periodText, documentDeliveryNoteGET.periodText) &&
        Objects.equals(this.currency, documentDeliveryNoteGET.currency) &&
        Objects.equals(this.total, documentDeliveryNoteGET.total) &&
        Objects.equals(this.vatIncluded, documentDeliveryNoteGET.vatIncluded) &&
        Objects.equals(this.discountRate, documentDeliveryNoteGET.discountRate) &&
        Objects.equals(this.discountType, documentDeliveryNoteGET.discountType) &&
        Objects.equals(this.language, documentDeliveryNoteGET.language) &&
        Objects.equals(this.signatureId, documentDeliveryNoteGET.signatureId) &&
        Objects.equals(this.layoutId, documentDeliveryNoteGET.layoutId) &&
        Objects.equals(this.pageAmount, documentDeliveryNoteGET.pageAmount) &&
        Objects.equals(this.notes, documentDeliveryNoteGET.notes) &&
        Objects.equals(this.status, documentDeliveryNoteGET.status) &&
        Objects.equals(this.created, documentDeliveryNoteGET.created) &&
        Objects.equals(this.customFields, documentDeliveryNoteGET.customFields) &&
        Objects.equals(this.positions, documentDeliveryNoteGET.positions) &&
        Objects.equals(this.texts, documentDeliveryNoteGET.texts) &&
        Objects.equals(this.freeTexts, documentDeliveryNoteGET.freeTexts) &&
        Objects.equals(this.permissions, documentDeliveryNoteGET.permissions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, number, contactId, contactName, contact, contactAddressId, contactAddress, contactPrepageAddressId, contactPrepageAddress, contactPersonId, contactPerson, date, periodText, currency, total, vatIncluded, discountRate, discountType, language, signatureId, layoutId, pageAmount, notes, status, created, customFields, positions, texts, freeTexts, permissions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DocumentDeliveryNoteGET {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
    sb.append("    contactId: ").append(toIndentedString(contactId)).append("\n");
    sb.append("    contactName: ").append(toIndentedString(contactName)).append("\n");
    sb.append("    contact: ").append(toIndentedString(contact)).append("\n");
    sb.append("    contactAddressId: ").append(toIndentedString(contactAddressId)).append("\n");
    sb.append("    contactAddress: ").append(toIndentedString(contactAddress)).append("\n");
    sb.append("    contactPrepageAddressId: ").append(toIndentedString(contactPrepageAddressId)).append("\n");
    sb.append("    contactPrepageAddress: ").append(toIndentedString(contactPrepageAddress)).append("\n");
    sb.append("    contactPersonId: ").append(toIndentedString(contactPersonId)).append("\n");
    sb.append("    contactPerson: ").append(toIndentedString(contactPerson)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    periodText: ").append(toIndentedString(periodText)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
    sb.append("    vatIncluded: ").append(toIndentedString(vatIncluded)).append("\n");
    sb.append("    discountRate: ").append(toIndentedString(discountRate)).append("\n");
    sb.append("    discountType: ").append(toIndentedString(discountType)).append("\n");
    sb.append("    language: ").append(toIndentedString(language)).append("\n");
    sb.append("    signatureId: ").append(toIndentedString(signatureId)).append("\n");
    sb.append("    layoutId: ").append(toIndentedString(layoutId)).append("\n");
    sb.append("    pageAmount: ").append(toIndentedString(pageAmount)).append("\n");
    sb.append("    notes: ").append(toIndentedString(notes)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    customFields: ").append(toIndentedString(customFields)).append("\n");
    sb.append("    positions: ").append(toIndentedString(positions)).append("\n");
    sb.append("    texts: ").append(toIndentedString(texts)).append("\n");
    sb.append("    freeTexts: ").append(toIndentedString(freeTexts)).append("\n");
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

