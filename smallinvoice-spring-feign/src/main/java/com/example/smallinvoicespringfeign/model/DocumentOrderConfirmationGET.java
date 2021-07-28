package com.example.smallinvoicespringfeign.model;

import java.util.Objects;
import com.example.smallinvoicespringfeign.model.ContactAddressGET;
import com.example.smallinvoicespringfeign.model.ContactGET;
import com.example.smallinvoicespringfeign.model.ContactPeopleGET;
import com.example.smallinvoicespringfeign.model.DescriptiveCustomFieldGET;
import com.example.smallinvoicespringfeign.model.DocumentFreeTextGET;
import com.example.smallinvoicespringfeign.model.DocumentOrderConfirmationPositionGET;
import com.example.smallinvoicespringfeign.model.DocumentOrderConfirmationTextGET;
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
 * DocumentOrderConfirmationGET
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-28T19:49:25.792053+02:00[Europe/Zurich]")
public class DocumentOrderConfirmationGET  implements Serializable {
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
   * status of order confirmation, possible values: DR - draft, S - sent, B - billed, D - deleted (but still visible)
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
  private List<DocumentOrderConfirmationPositionGET> positions = null;

  @JsonProperty("texts")
  @Valid
  private List<DocumentOrderConfirmationTextGET> texts = null;

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

  public DocumentOrderConfirmationGET id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * order confirmation id
   * @return id
  */
  @ApiModelProperty(required = true, value = "order confirmation id")
  @NotNull


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public DocumentOrderConfirmationGET number(String number) {
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

  public DocumentOrderConfirmationGET contactId(Integer contactId) {
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

  public DocumentOrderConfirmationGET contactName(String contactName) {
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

  public DocumentOrderConfirmationGET contact(ContactGET contact) {
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

  public DocumentOrderConfirmationGET contactAddressId(Integer contactAddressId) {
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

  public DocumentOrderConfirmationGET contactAddress(ContactAddressGET contactAddress) {
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

  public DocumentOrderConfirmationGET contactPrepageAddressId(Integer contactPrepageAddressId) {
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

  public DocumentOrderConfirmationGET contactPrepageAddress(ContactAddressGET contactPrepageAddress) {
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

  public DocumentOrderConfirmationGET contactPersonId(Integer contactPersonId) {
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

  public DocumentOrderConfirmationGET contactPerson(ContactPeopleGET contactPerson) {
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

  public DocumentOrderConfirmationGET date(LocalDate date) {
    this.date = date;
    return this;
  }

  /**
   * date of the order confirmation
   * @return date
  */
  @ApiModelProperty(required = true, value = "date of the order confirmation")
  @NotNull

  @Valid

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public DocumentOrderConfirmationGET periodText(String periodText) {
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

  public DocumentOrderConfirmationGET currency(String currency) {
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

  public DocumentOrderConfirmationGET total(Float total) {
    this.total = total;
    return this;
  }

  /**
   * total amount of the order confirmation
   * @return total
  */
  @ApiModelProperty(required = true, value = "total amount of the order confirmation")
  @NotNull


  public Float getTotal() {
    return total;
  }

  public void setTotal(Float total) {
    this.total = total;
  }

  public DocumentOrderConfirmationGET vatIncluded(Boolean vatIncluded) {
    this.vatIncluded = vatIncluded;
    return this;
  }

  /**
   * whether prices in order confirmation include VAT
   * @return vatIncluded
  */
  @ApiModelProperty(required = true, value = "whether prices in order confirmation include VAT")
  @NotNull


  public Boolean getVatIncluded() {
    return vatIncluded;
  }

  public void setVatIncluded(Boolean vatIncluded) {
    this.vatIncluded = vatIncluded;
  }

  public DocumentOrderConfirmationGET discountRate(Float discountRate) {
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

  public DocumentOrderConfirmationGET discountType(DiscountTypeEnum discountType) {
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

  public DocumentOrderConfirmationGET language(LanguageEnum language) {
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

  public DocumentOrderConfirmationGET signatureId(Integer signatureId) {
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

  public DocumentOrderConfirmationGET layoutId(Integer layoutId) {
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

  public DocumentOrderConfirmationGET pageAmount(Integer pageAmount) {
    this.pageAmount = pageAmount;
    return this;
  }

  /**
   * how many pages order confirmation has
   * @return pageAmount
  */
  @ApiModelProperty(required = true, value = "how many pages order confirmation has")
  @NotNull


  public Integer getPageAmount() {
    return pageAmount;
  }

  public void setPageAmount(Integer pageAmount) {
    this.pageAmount = pageAmount;
  }

  public DocumentOrderConfirmationGET notes(String notes) {
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

  public DocumentOrderConfirmationGET status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * status of order confirmation, possible values: DR - draft, S - sent, B - billed, D - deleted (but still visible)
   * @return status
  */
  @ApiModelProperty(required = true, value = "status of order confirmation, possible values: DR - draft, S - sent, B - billed, D - deleted (but still visible)")
  @NotNull


  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public DocumentOrderConfirmationGET created(LocalDateTime created) {
    this.created = created;
    return this;
  }

  /**
   * date that order confirmation was created
   * @return created
  */
  @ApiModelProperty(required = true, value = "date that order confirmation was created")
  @NotNull

  @Valid

  public LocalDateTime getCreated() {
    return created;
  }

  public void setCreated(LocalDateTime created) {
    this.created = created;
  }

  public DocumentOrderConfirmationGET customFields(List<DescriptiveCustomFieldGET> customFields) {
    this.customFields = customFields;
    return this;
  }

  public DocumentOrderConfirmationGET addCustomFieldsItem(DescriptiveCustomFieldGET customFieldsItem) {
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

  public DocumentOrderConfirmationGET positions(List<DocumentOrderConfirmationPositionGET> positions) {
    this.positions = positions;
    return this;
  }

  public DocumentOrderConfirmationGET addPositionsItem(DocumentOrderConfirmationPositionGET positionsItem) {
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

  public List<DocumentOrderConfirmationPositionGET> getPositions() {
    return positions;
  }

  public void setPositions(List<DocumentOrderConfirmationPositionGET> positions) {
    this.positions = positions;
  }

  public DocumentOrderConfirmationGET texts(List<DocumentOrderConfirmationTextGET> texts) {
    this.texts = texts;
    return this;
  }

  public DocumentOrderConfirmationGET addTextsItem(DocumentOrderConfirmationTextGET textsItem) {
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

  public List<DocumentOrderConfirmationTextGET> getTexts() {
    return texts;
  }

  public void setTexts(List<DocumentOrderConfirmationTextGET> texts) {
    this.texts = texts;
  }

  public DocumentOrderConfirmationGET freeTexts(List<DocumentFreeTextGET> freeTexts) {
    this.freeTexts = freeTexts;
    return this;
  }

  public DocumentOrderConfirmationGET addFreeTextsItem(DocumentFreeTextGET freeTextsItem) {
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

  public DocumentOrderConfirmationGET permissions(List<PermissionsEnum> permissions) {
    this.permissions = permissions;
    return this;
  }

  public DocumentOrderConfirmationGET addPermissionsItem(PermissionsEnum permissionsItem) {
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
    DocumentOrderConfirmationGET documentOrderConfirmationGET = (DocumentOrderConfirmationGET) o;
    return Objects.equals(this.id, documentOrderConfirmationGET.id) &&
        Objects.equals(this.number, documentOrderConfirmationGET.number) &&
        Objects.equals(this.contactId, documentOrderConfirmationGET.contactId) &&
        Objects.equals(this.contactName, documentOrderConfirmationGET.contactName) &&
        Objects.equals(this.contact, documentOrderConfirmationGET.contact) &&
        Objects.equals(this.contactAddressId, documentOrderConfirmationGET.contactAddressId) &&
        Objects.equals(this.contactAddress, documentOrderConfirmationGET.contactAddress) &&
        Objects.equals(this.contactPrepageAddressId, documentOrderConfirmationGET.contactPrepageAddressId) &&
        Objects.equals(this.contactPrepageAddress, documentOrderConfirmationGET.contactPrepageAddress) &&
        Objects.equals(this.contactPersonId, documentOrderConfirmationGET.contactPersonId) &&
        Objects.equals(this.contactPerson, documentOrderConfirmationGET.contactPerson) &&
        Objects.equals(this.date, documentOrderConfirmationGET.date) &&
        Objects.equals(this.periodText, documentOrderConfirmationGET.periodText) &&
        Objects.equals(this.currency, documentOrderConfirmationGET.currency) &&
        Objects.equals(this.total, documentOrderConfirmationGET.total) &&
        Objects.equals(this.vatIncluded, documentOrderConfirmationGET.vatIncluded) &&
        Objects.equals(this.discountRate, documentOrderConfirmationGET.discountRate) &&
        Objects.equals(this.discountType, documentOrderConfirmationGET.discountType) &&
        Objects.equals(this.language, documentOrderConfirmationGET.language) &&
        Objects.equals(this.signatureId, documentOrderConfirmationGET.signatureId) &&
        Objects.equals(this.layoutId, documentOrderConfirmationGET.layoutId) &&
        Objects.equals(this.pageAmount, documentOrderConfirmationGET.pageAmount) &&
        Objects.equals(this.notes, documentOrderConfirmationGET.notes) &&
        Objects.equals(this.status, documentOrderConfirmationGET.status) &&
        Objects.equals(this.created, documentOrderConfirmationGET.created) &&
        Objects.equals(this.customFields, documentOrderConfirmationGET.customFields) &&
        Objects.equals(this.positions, documentOrderConfirmationGET.positions) &&
        Objects.equals(this.texts, documentOrderConfirmationGET.texts) &&
        Objects.equals(this.freeTexts, documentOrderConfirmationGET.freeTexts) &&
        Objects.equals(this.permissions, documentOrderConfirmationGET.permissions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, number, contactId, contactName, contact, contactAddressId, contactAddress, contactPrepageAddressId, contactPrepageAddress, contactPersonId, contactPerson, date, periodText, currency, total, vatIncluded, discountRate, discountType, language, signatureId, layoutId, pageAmount, notes, status, created, customFields, positions, texts, freeTexts, permissions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DocumentOrderConfirmationGET {\n");
    
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

