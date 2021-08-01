package com.example.smallinvoicespringfeign.model;

import java.util.Objects;
import com.example.smallinvoicespringfeign.model.DescriptiveCustomFieldPOST;
import com.example.smallinvoicespringfeign.model.DocumentFreeTextPOST;
import com.example.smallinvoicespringfeign.model.DocumentOfferPositionPOST;
import com.example.smallinvoicespringfeign.model.DocumentOfferTextPOST;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;

/**
 * DocumentOfferPOST
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-31T13:05:18.255013+02:00[Europe/Zurich]")
public class DocumentOfferPOST  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("number")
  private String number;

  @JsonProperty("contact_id")
  private Integer contactId;

  @JsonProperty("contact_address_id")
  private Integer contactAddressId;

  @JsonProperty("contact_prepage_address_id")
  private Integer contactPrepageAddressId;

  @JsonProperty("contact_person_id")
  private Integer contactPersonId;

  @JsonProperty("date")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE)
  private LocalDate date;

  @JsonProperty("valid_until")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE)
  private LocalDate validUntil;

  @JsonProperty("period_text")
  private String periodText;

  @JsonProperty("currency")
  private String currency;

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

  @JsonProperty("accept_online")
  private Boolean acceptOnline;

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

  @JsonProperty("notes")
  private String notes;

  @JsonProperty("custom_fields")
  @Valid
  private List<DescriptiveCustomFieldPOST> customFields = null;

  @JsonProperty("positions")
  @Valid
  private List<DocumentOfferPositionPOST> positions = new ArrayList<>();

  @JsonProperty("texts")
  @Valid
  private List<DocumentOfferTextPOST> texts = null;

  @JsonProperty("free_texts")
  @Valid
  private List<DocumentFreeTextPOST> freeTexts = null;

  public DocumentOfferPOST number(String number) {
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

  public DocumentOfferPOST contactId(Integer contactId) {
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

  public DocumentOfferPOST contactAddressId(Integer contactAddressId) {
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

  public DocumentOfferPOST contactPrepageAddressId(Integer contactPrepageAddressId) {
    this.contactPrepageAddressId = contactPrepageAddressId;
    return this;
  }

  /**
   * id of a contact's prepage address
   * @return contactPrepageAddressId
  */
  @ApiModelProperty(value = "id of a contact's prepage address")


  public Integer getContactPrepageAddressId() {
    return contactPrepageAddressId;
  }

  public void setContactPrepageAddressId(Integer contactPrepageAddressId) {
    this.contactPrepageAddressId = contactPrepageAddressId;
  }

  public DocumentOfferPOST contactPersonId(Integer contactPersonId) {
    this.contactPersonId = contactPersonId;
    return this;
  }

  /**
   * id of a contact's person
   * @return contactPersonId
  */
  @ApiModelProperty(value = "id of a contact's person")


  public Integer getContactPersonId() {
    return contactPersonId;
  }

  public void setContactPersonId(Integer contactPersonId) {
    this.contactPersonId = contactPersonId;
  }

  public DocumentOfferPOST date(LocalDate date) {
    this.date = date;
    return this;
  }

  /**
   * date of the offer
   * @return date
  */
  @ApiModelProperty(required = true, value = "date of the offer")
  @NotNull

  @Valid

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public DocumentOfferPOST validUntil(LocalDate validUntil) {
    this.validUntil = validUntil;
    return this;
  }

  /**
   * date that offer is valid until
   * @return validUntil
  */
  @ApiModelProperty(required = true, value = "date that offer is valid until")
  @NotNull

  @Valid

  public LocalDate getValidUntil() {
    return validUntil;
  }

  public void setValidUntil(LocalDate validUntil) {
    this.validUntil = validUntil;
  }

  public DocumentOfferPOST periodText(String periodText) {
    this.periodText = periodText;
    return this;
  }

  /**
   * service/delivery
   * @return periodText
  */
  @ApiModelProperty(value = "service/delivery")


  public String getPeriodText() {
    return periodText;
  }

  public void setPeriodText(String periodText) {
    this.periodText = periodText;
  }

  public DocumentOfferPOST currency(String currency) {
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

  public DocumentOfferPOST vatIncluded(Boolean vatIncluded) {
    this.vatIncluded = vatIncluded;
    return this;
  }

  /**
   * whether prices in offer include VAT - default value: false
   * @return vatIncluded
  */
  @ApiModelProperty(value = "whether prices in offer include VAT - default value: false")


  public Boolean getVatIncluded() {
    return vatIncluded;
  }

  public void setVatIncluded(Boolean vatIncluded) {
    this.vatIncluded = vatIncluded;
  }

  public DocumentOfferPOST discountRate(Float discountRate) {
    this.discountRate = discountRate;
    return this;
  }

  /**
   * optional discount rate - default value: 0.0
   * @return discountRate
  */
  @ApiModelProperty(value = "optional discount rate - default value: 0.0")


  public Float getDiscountRate() {
    return discountRate;
  }

  public void setDiscountRate(Float discountRate) {
    this.discountRate = discountRate;
  }

  public DocumentOfferPOST discountType(DiscountTypeEnum discountType) {
    this.discountType = discountType;
    return this;
  }

  /**
   * optional discount type; possible values: A - amount, P - in % 
   * @return discountType
  */
  @ApiModelProperty(value = "optional discount type; possible values: A - amount, P - in % ")


  public DiscountTypeEnum getDiscountType() {
    return discountType;
  }

  public void setDiscountType(DiscountTypeEnum discountType) {
    this.discountType = discountType;
  }

  public DocumentOfferPOST acceptOnline(Boolean acceptOnline) {
    this.acceptOnline = acceptOnline;
    return this;
  }

  /**
   * whether offer can be accepted online - default value: false
   * @return acceptOnline
  */
  @ApiModelProperty(value = "whether offer can be accepted online - default value: false")


  public Boolean getAcceptOnline() {
    return acceptOnline;
  }

  public void setAcceptOnline(Boolean acceptOnline) {
    this.acceptOnline = acceptOnline;
  }

  public DocumentOfferPOST language(LanguageEnum language) {
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

  public DocumentOfferPOST signatureId(Integer signatureId) {
    this.signatureId = signatureId;
    return this;
  }

  /**
   * signature id
   * @return signatureId
  */
  @ApiModelProperty(value = "signature id")


  public Integer getSignatureId() {
    return signatureId;
  }

  public void setSignatureId(Integer signatureId) {
    this.signatureId = signatureId;
  }

  public DocumentOfferPOST layoutId(Integer layoutId) {
    this.layoutId = layoutId;
    return this;
  }

  /**
   * layout id
   * @return layoutId
  */
  @ApiModelProperty(value = "layout id")


  public Integer getLayoutId() {
    return layoutId;
  }

  public void setLayoutId(Integer layoutId) {
    this.layoutId = layoutId;
  }

  public DocumentOfferPOST notes(String notes) {
    this.notes = notes;
    return this;
  }

  /**
   * optional notes
   * @return notes
  */
  @ApiModelProperty(value = "optional notes")


  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public DocumentOfferPOST customFields(List<DescriptiveCustomFieldPOST> customFields) {
    this.customFields = customFields;
    return this;
  }

  public DocumentOfferPOST addCustomFieldsItem(DescriptiveCustomFieldPOST customFieldsItem) {
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

  public DocumentOfferPOST positions(List<DocumentOfferPositionPOST> positions) {
    this.positions = positions;
    return this;
  }

  public DocumentOfferPOST addPositionsItem(DocumentOfferPositionPOST positionsItem) {
    this.positions.add(positionsItem);
    return this;
  }

  /**
   * positions objects
   * @return positions
  */
  @ApiModelProperty(required = true, value = "positions objects")
  @NotNull

  @Valid

  public List<DocumentOfferPositionPOST> getPositions() {
    return positions;
  }

  public void setPositions(List<DocumentOfferPositionPOST> positions) {
    this.positions = positions;
  }

  public DocumentOfferPOST texts(List<DocumentOfferTextPOST> texts) {
    this.texts = texts;
    return this;
  }

  public DocumentOfferPOST addTextsItem(DocumentOfferTextPOST textsItem) {
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

  public List<DocumentOfferTextPOST> getTexts() {
    return texts;
  }

  public void setTexts(List<DocumentOfferTextPOST> texts) {
    this.texts = texts;
  }

  public DocumentOfferPOST freeTexts(List<DocumentFreeTextPOST> freeTexts) {
    this.freeTexts = freeTexts;
    return this;
  }

  public DocumentOfferPOST addFreeTextsItem(DocumentFreeTextPOST freeTextsItem) {
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

  public List<DocumentFreeTextPOST> getFreeTexts() {
    return freeTexts;
  }

  public void setFreeTexts(List<DocumentFreeTextPOST> freeTexts) {
    this.freeTexts = freeTexts;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DocumentOfferPOST documentOfferPOST = (DocumentOfferPOST) o;
    return Objects.equals(this.number, documentOfferPOST.number) &&
        Objects.equals(this.contactId, documentOfferPOST.contactId) &&
        Objects.equals(this.contactAddressId, documentOfferPOST.contactAddressId) &&
        Objects.equals(this.contactPrepageAddressId, documentOfferPOST.contactPrepageAddressId) &&
        Objects.equals(this.contactPersonId, documentOfferPOST.contactPersonId) &&
        Objects.equals(this.date, documentOfferPOST.date) &&
        Objects.equals(this.validUntil, documentOfferPOST.validUntil) &&
        Objects.equals(this.periodText, documentOfferPOST.periodText) &&
        Objects.equals(this.currency, documentOfferPOST.currency) &&
        Objects.equals(this.vatIncluded, documentOfferPOST.vatIncluded) &&
        Objects.equals(this.discountRate, documentOfferPOST.discountRate) &&
        Objects.equals(this.discountType, documentOfferPOST.discountType) &&
        Objects.equals(this.acceptOnline, documentOfferPOST.acceptOnline) &&
        Objects.equals(this.language, documentOfferPOST.language) &&
        Objects.equals(this.signatureId, documentOfferPOST.signatureId) &&
        Objects.equals(this.layoutId, documentOfferPOST.layoutId) &&
        Objects.equals(this.notes, documentOfferPOST.notes) &&
        Objects.equals(this.customFields, documentOfferPOST.customFields) &&
        Objects.equals(this.positions, documentOfferPOST.positions) &&
        Objects.equals(this.texts, documentOfferPOST.texts) &&
        Objects.equals(this.freeTexts, documentOfferPOST.freeTexts);
  }

  @Override
  public int hashCode() {
    return Objects.hash(number, contactId, contactAddressId, contactPrepageAddressId, contactPersonId, date, validUntil, periodText, currency, vatIncluded, discountRate, discountType, acceptOnline, language, signatureId, layoutId, notes, customFields, positions, texts, freeTexts);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DocumentOfferPOST {\n");
    
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
    sb.append("    contactId: ").append(toIndentedString(contactId)).append("\n");
    sb.append("    contactAddressId: ").append(toIndentedString(contactAddressId)).append("\n");
    sb.append("    contactPrepageAddressId: ").append(toIndentedString(contactPrepageAddressId)).append("\n");
    sb.append("    contactPersonId: ").append(toIndentedString(contactPersonId)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    validUntil: ").append(toIndentedString(validUntil)).append("\n");
    sb.append("    periodText: ").append(toIndentedString(periodText)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    vatIncluded: ").append(toIndentedString(vatIncluded)).append("\n");
    sb.append("    discountRate: ").append(toIndentedString(discountRate)).append("\n");
    sb.append("    discountType: ").append(toIndentedString(discountType)).append("\n");
    sb.append("    acceptOnline: ").append(toIndentedString(acceptOnline)).append("\n");
    sb.append("    language: ").append(toIndentedString(language)).append("\n");
    sb.append("    signatureId: ").append(toIndentedString(signatureId)).append("\n");
    sb.append("    layoutId: ").append(toIndentedString(layoutId)).append("\n");
    sb.append("    notes: ").append(toIndentedString(notes)).append("\n");
    sb.append("    customFields: ").append(toIndentedString(customFields)).append("\n");
    sb.append("    positions: ").append(toIndentedString(positions)).append("\n");
    sb.append("    texts: ").append(toIndentedString(texts)).append("\n");
    sb.append("    freeTexts: ").append(toIndentedString(freeTexts)).append("\n");
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

