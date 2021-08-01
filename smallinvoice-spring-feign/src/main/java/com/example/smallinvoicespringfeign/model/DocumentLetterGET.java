package com.example.smallinvoicespringfeign.model;

import java.util.Objects;
import com.example.smallinvoicespringfeign.model.ContactAddressGET;
import com.example.smallinvoicespringfeign.model.ContactGET;
import com.example.smallinvoicespringfeign.model.ContactPeopleGET;
import com.example.smallinvoicespringfeign.model.DescriptiveCustomFieldGET;
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
 * DocumentLetterGET
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-31T13:05:18.255013+02:00[Europe/Zurich]")
public class DocumentLetterGET  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("id")
  private Integer id;

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

  @JsonProperty("title")
  private String title;

  @JsonProperty("content")
  private String content;

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
   * status of letter, possible values: DR - draft, S - sent, D - deleted (but still visible)
   */
  public enum StatusEnum {
    DR("DR"),
    
    S("S"),
    
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
  private StatusEnum status;

  @JsonProperty("created")
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
  private LocalDateTime created;

  @JsonProperty("custom_fields")
  @Valid
  private List<DescriptiveCustomFieldGET> customFields = null;

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

  public DocumentLetterGET id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * contact letter id
   * @return id
  */
  @ApiModelProperty(required = true, value = "contact letter id")
  @NotNull


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public DocumentLetterGET contactId(Integer contactId) {
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

  public DocumentLetterGET contactName(String contactName) {
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

  public DocumentLetterGET contact(ContactGET contact) {
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

  public DocumentLetterGET contactAddressId(Integer contactAddressId) {
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

  public DocumentLetterGET contactAddress(ContactAddressGET contactAddress) {
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

  public DocumentLetterGET contactPrepageAddressId(Integer contactPrepageAddressId) {
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

  public DocumentLetterGET contactPrepageAddress(ContactAddressGET contactPrepageAddress) {
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

  public DocumentLetterGET contactPersonId(Integer contactPersonId) {
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

  public DocumentLetterGET contactPerson(ContactPeopleGET contactPerson) {
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

  public DocumentLetterGET date(LocalDate date) {
    this.date = date;
    return this;
  }

  /**
   * date of the letter
   * @return date
  */
  @ApiModelProperty(required = true, value = "date of the letter")
  @NotNull

  @Valid

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public DocumentLetterGET title(String title) {
    this.title = title;
    return this;
  }

  /**
   * title of the letter
   * @return title
  */
  @ApiModelProperty(required = true, value = "title of the letter")
  @NotNull


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public DocumentLetterGET content(String content) {
    this.content = content;
    return this;
  }

  /**
   * content of the letter
   * @return content
  */
  @ApiModelProperty(required = true, value = "content of the letter")
  @NotNull


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public DocumentLetterGET language(LanguageEnum language) {
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

  public DocumentLetterGET signatureId(Integer signatureId) {
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

  public DocumentLetterGET layoutId(Integer layoutId) {
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

  public DocumentLetterGET pageAmount(Integer pageAmount) {
    this.pageAmount = pageAmount;
    return this;
  }

  /**
   * how many pages letter has
   * @return pageAmount
  */
  @ApiModelProperty(required = true, value = "how many pages letter has")
  @NotNull


  public Integer getPageAmount() {
    return pageAmount;
  }

  public void setPageAmount(Integer pageAmount) {
    this.pageAmount = pageAmount;
  }

  public DocumentLetterGET notes(String notes) {
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

  public DocumentLetterGET status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * status of letter, possible values: DR - draft, S - sent, D - deleted (but still visible)
   * @return status
  */
  @ApiModelProperty(required = true, value = "status of letter, possible values: DR - draft, S - sent, D - deleted (but still visible)")
  @NotNull


  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public DocumentLetterGET created(LocalDateTime created) {
    this.created = created;
    return this;
  }

  /**
   * date that letter was created
   * @return created
  */
  @ApiModelProperty(required = true, value = "date that letter was created")
  @NotNull

  @Valid

  public LocalDateTime getCreated() {
    return created;
  }

  public void setCreated(LocalDateTime created) {
    this.created = created;
  }

  public DocumentLetterGET customFields(List<DescriptiveCustomFieldGET> customFields) {
    this.customFields = customFields;
    return this;
  }

  public DocumentLetterGET addCustomFieldsItem(DescriptiveCustomFieldGET customFieldsItem) {
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

  public DocumentLetterGET freeTexts(List<DocumentFreeTextGET> freeTexts) {
    this.freeTexts = freeTexts;
    return this;
  }

  public DocumentLetterGET addFreeTextsItem(DocumentFreeTextGET freeTextsItem) {
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

  public DocumentLetterGET permissions(List<PermissionsEnum> permissions) {
    this.permissions = permissions;
    return this;
  }

  public DocumentLetterGET addPermissionsItem(PermissionsEnum permissionsItem) {
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
    DocumentLetterGET documentLetterGET = (DocumentLetterGET) o;
    return Objects.equals(this.id, documentLetterGET.id) &&
        Objects.equals(this.contactId, documentLetterGET.contactId) &&
        Objects.equals(this.contactName, documentLetterGET.contactName) &&
        Objects.equals(this.contact, documentLetterGET.contact) &&
        Objects.equals(this.contactAddressId, documentLetterGET.contactAddressId) &&
        Objects.equals(this.contactAddress, documentLetterGET.contactAddress) &&
        Objects.equals(this.contactPrepageAddressId, documentLetterGET.contactPrepageAddressId) &&
        Objects.equals(this.contactPrepageAddress, documentLetterGET.contactPrepageAddress) &&
        Objects.equals(this.contactPersonId, documentLetterGET.contactPersonId) &&
        Objects.equals(this.contactPerson, documentLetterGET.contactPerson) &&
        Objects.equals(this.date, documentLetterGET.date) &&
        Objects.equals(this.title, documentLetterGET.title) &&
        Objects.equals(this.content, documentLetterGET.content) &&
        Objects.equals(this.language, documentLetterGET.language) &&
        Objects.equals(this.signatureId, documentLetterGET.signatureId) &&
        Objects.equals(this.layoutId, documentLetterGET.layoutId) &&
        Objects.equals(this.pageAmount, documentLetterGET.pageAmount) &&
        Objects.equals(this.notes, documentLetterGET.notes) &&
        Objects.equals(this.status, documentLetterGET.status) &&
        Objects.equals(this.created, documentLetterGET.created) &&
        Objects.equals(this.customFields, documentLetterGET.customFields) &&
        Objects.equals(this.freeTexts, documentLetterGET.freeTexts) &&
        Objects.equals(this.permissions, documentLetterGET.permissions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, contactId, contactName, contact, contactAddressId, contactAddress, contactPrepageAddressId, contactPrepageAddress, contactPersonId, contactPerson, date, title, content, language, signatureId, layoutId, pageAmount, notes, status, created, customFields, freeTexts, permissions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DocumentLetterGET {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("    language: ").append(toIndentedString(language)).append("\n");
    sb.append("    signatureId: ").append(toIndentedString(signatureId)).append("\n");
    sb.append("    layoutId: ").append(toIndentedString(layoutId)).append("\n");
    sb.append("    pageAmount: ").append(toIndentedString(pageAmount)).append("\n");
    sb.append("    notes: ").append(toIndentedString(notes)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    customFields: ").append(toIndentedString(customFields)).append("\n");
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

