package com.example.smallinvoicespringfeign.model;

import java.util.Objects;
import com.example.smallinvoicespringfeign.model.DescriptiveCustomFieldPUT;
import com.example.smallinvoicespringfeign.model.DocumentDeliveryNotePositionPUT;
import com.example.smallinvoicespringfeign.model.DocumentDeliveryNoteTextPUT;
import com.example.smallinvoicespringfeign.model.DocumentFreeTextPUT;
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
 * DocumentDeliveryNotePUT
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-27T20:43:02.724916+02:00[Europe/Zurich]")
public class DocumentDeliveryNotePUT  implements Serializable {
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
  private List<DescriptiveCustomFieldPUT> customFields = null;

  @JsonProperty("positions")
  @Valid
  private List<DocumentDeliveryNotePositionPUT> positions = null;

  @JsonProperty("texts")
  @Valid
  private List<DocumentDeliveryNoteTextPUT> texts = null;

  @JsonProperty("free_texts")
  @Valid
  private List<DocumentFreeTextPUT> freeTexts = null;

  public DocumentDeliveryNotePUT number(String number) {
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

  public DocumentDeliveryNotePUT contactId(Integer contactId) {
    this.contactId = contactId;
    return this;
  }

  /**
   * id of a contact
   * @return contactId
  */
  @ApiModelProperty(value = "id of a contact")


  public Integer getContactId() {
    return contactId;
  }

  public void setContactId(Integer contactId) {
    this.contactId = contactId;
  }

  public DocumentDeliveryNotePUT contactAddressId(Integer contactAddressId) {
    this.contactAddressId = contactAddressId;
    return this;
  }

  /**
   * id of a contact's address
   * @return contactAddressId
  */
  @ApiModelProperty(value = "id of a contact's address")


  public Integer getContactAddressId() {
    return contactAddressId;
  }

  public void setContactAddressId(Integer contactAddressId) {
    this.contactAddressId = contactAddressId;
  }

  public DocumentDeliveryNotePUT contactPrepageAddressId(Integer contactPrepageAddressId) {
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

  public DocumentDeliveryNotePUT contactPersonId(Integer contactPersonId) {
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

  public DocumentDeliveryNotePUT date(LocalDate date) {
    this.date = date;
    return this;
  }

  /**
   * date of the delivery note
   * @return date
  */
  @ApiModelProperty(value = "date of the delivery note")

  @Valid

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public DocumentDeliveryNotePUT periodText(String periodText) {
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

  public DocumentDeliveryNotePUT currency(String currency) {
    this.currency = currency;
    return this;
  }

  /**
   * currency (e.g. CHF, EUR)
   * @return currency
  */
  @ApiModelProperty(value = "currency (e.g. CHF, EUR)")


  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public DocumentDeliveryNotePUT vatIncluded(Boolean vatIncluded) {
    this.vatIncluded = vatIncluded;
    return this;
  }

  /**
   * whether prices in delivery note include VAT
   * @return vatIncluded
  */
  @ApiModelProperty(value = "whether prices in delivery note include VAT")


  public Boolean getVatIncluded() {
    return vatIncluded;
  }

  public void setVatIncluded(Boolean vatIncluded) {
    this.vatIncluded = vatIncluded;
  }

  public DocumentDeliveryNotePUT discountRate(Float discountRate) {
    this.discountRate = discountRate;
    return this;
  }

  /**
   * optional discount rate
   * @return discountRate
  */
  @ApiModelProperty(value = "optional discount rate")


  public Float getDiscountRate() {
    return discountRate;
  }

  public void setDiscountRate(Float discountRate) {
    this.discountRate = discountRate;
  }

  public DocumentDeliveryNotePUT discountType(DiscountTypeEnum discountType) {
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

  public DocumentDeliveryNotePUT language(LanguageEnum language) {
    this.language = language;
    return this;
  }

  /**
   * language; possible values: de, en, es, fr, it 
   * @return language
  */
  @ApiModelProperty(value = "language; possible values: de, en, es, fr, it ")


  public LanguageEnum getLanguage() {
    return language;
  }

  public void setLanguage(LanguageEnum language) {
    this.language = language;
  }

  public DocumentDeliveryNotePUT signatureId(Integer signatureId) {
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

  public DocumentDeliveryNotePUT layoutId(Integer layoutId) {
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

  public DocumentDeliveryNotePUT notes(String notes) {
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

  public DocumentDeliveryNotePUT customFields(List<DescriptiveCustomFieldPUT> customFields) {
    this.customFields = customFields;
    return this;
  }

  public DocumentDeliveryNotePUT addCustomFieldsItem(DescriptiveCustomFieldPUT customFieldsItem) {
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

  public DocumentDeliveryNotePUT positions(List<DocumentDeliveryNotePositionPUT> positions) {
    this.positions = positions;
    return this;
  }

  public DocumentDeliveryNotePUT addPositionsItem(DocumentDeliveryNotePositionPUT positionsItem) {
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

  public List<DocumentDeliveryNotePositionPUT> getPositions() {
    return positions;
  }

  public void setPositions(List<DocumentDeliveryNotePositionPUT> positions) {
    this.positions = positions;
  }

  public DocumentDeliveryNotePUT texts(List<DocumentDeliveryNoteTextPUT> texts) {
    this.texts = texts;
    return this;
  }

  public DocumentDeliveryNotePUT addTextsItem(DocumentDeliveryNoteTextPUT textsItem) {
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

  public List<DocumentDeliveryNoteTextPUT> getTexts() {
    return texts;
  }

  public void setTexts(List<DocumentDeliveryNoteTextPUT> texts) {
    this.texts = texts;
  }

  public DocumentDeliveryNotePUT freeTexts(List<DocumentFreeTextPUT> freeTexts) {
    this.freeTexts = freeTexts;
    return this;
  }

  public DocumentDeliveryNotePUT addFreeTextsItem(DocumentFreeTextPUT freeTextsItem) {
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

  public List<DocumentFreeTextPUT> getFreeTexts() {
    return freeTexts;
  }

  public void setFreeTexts(List<DocumentFreeTextPUT> freeTexts) {
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
    DocumentDeliveryNotePUT documentDeliveryNotePUT = (DocumentDeliveryNotePUT) o;
    return Objects.equals(this.number, documentDeliveryNotePUT.number) &&
        Objects.equals(this.contactId, documentDeliveryNotePUT.contactId) &&
        Objects.equals(this.contactAddressId, documentDeliveryNotePUT.contactAddressId) &&
        Objects.equals(this.contactPrepageAddressId, documentDeliveryNotePUT.contactPrepageAddressId) &&
        Objects.equals(this.contactPersonId, documentDeliveryNotePUT.contactPersonId) &&
        Objects.equals(this.date, documentDeliveryNotePUT.date) &&
        Objects.equals(this.periodText, documentDeliveryNotePUT.periodText) &&
        Objects.equals(this.currency, documentDeliveryNotePUT.currency) &&
        Objects.equals(this.vatIncluded, documentDeliveryNotePUT.vatIncluded) &&
        Objects.equals(this.discountRate, documentDeliveryNotePUT.discountRate) &&
        Objects.equals(this.discountType, documentDeliveryNotePUT.discountType) &&
        Objects.equals(this.language, documentDeliveryNotePUT.language) &&
        Objects.equals(this.signatureId, documentDeliveryNotePUT.signatureId) &&
        Objects.equals(this.layoutId, documentDeliveryNotePUT.layoutId) &&
        Objects.equals(this.notes, documentDeliveryNotePUT.notes) &&
        Objects.equals(this.customFields, documentDeliveryNotePUT.customFields) &&
        Objects.equals(this.positions, documentDeliveryNotePUT.positions) &&
        Objects.equals(this.texts, documentDeliveryNotePUT.texts) &&
        Objects.equals(this.freeTexts, documentDeliveryNotePUT.freeTexts);
  }

  @Override
  public int hashCode() {
    return Objects.hash(number, contactId, contactAddressId, contactPrepageAddressId, contactPersonId, date, periodText, currency, vatIncluded, discountRate, discountType, language, signatureId, layoutId, notes, customFields, positions, texts, freeTexts);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DocumentDeliveryNotePUT {\n");
    
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
    sb.append("    contactId: ").append(toIndentedString(contactId)).append("\n");
    sb.append("    contactAddressId: ").append(toIndentedString(contactAddressId)).append("\n");
    sb.append("    contactPrepageAddressId: ").append(toIndentedString(contactPrepageAddressId)).append("\n");
    sb.append("    contactPersonId: ").append(toIndentedString(contactPersonId)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    periodText: ").append(toIndentedString(periodText)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    vatIncluded: ").append(toIndentedString(vatIncluded)).append("\n");
    sb.append("    discountRate: ").append(toIndentedString(discountRate)).append("\n");
    sb.append("    discountType: ").append(toIndentedString(discountType)).append("\n");
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

