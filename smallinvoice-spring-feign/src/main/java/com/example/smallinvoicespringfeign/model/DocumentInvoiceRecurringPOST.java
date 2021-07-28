package com.example.smallinvoicespringfeign.model;

import java.util.Objects;
import com.example.smallinvoicespringfeign.model.DescriptiveCustomFieldPOST;
import com.example.smallinvoicespringfeign.model.DocumentFreeTextPOST;
import com.example.smallinvoicespringfeign.model.DocumentInvoicePositionPOST;
import com.example.smallinvoicespringfeign.model.DocumentInvoiceTextPOST;
import com.example.smallinvoicespringfeign.model.DocumentInvoiceWorkflowPOST;
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
 * DocumentInvoiceRecurringPOST
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-28T19:49:25.792053+02:00[Europe/Zurich]")
public class DocumentInvoiceRecurringPOST  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("contact_id")
  private Integer contactId;

  @JsonProperty("contact_address_id")
  private Integer contactAddressId;

  @JsonProperty("contact_prepage_address_id")
  private Integer contactPrepageAddressId;

  @JsonProperty("contact_person_id")
  private Integer contactPersonId;

  @JsonProperty("start_date")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE)
  private LocalDate startDate;

  @JsonProperty("end_date")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE)
  private LocalDate endDate;

  @JsonProperty("frequency")
  private Integer frequency;

  @JsonProperty("grace")
  private Integer grace;

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

  @JsonProperty("cash_discount_rate")
  private Integer cashDiscountRate;

  @JsonProperty("cash_discount_date")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE)
  private LocalDate cashDiscountDate;

  @JsonProperty("bank_account_id")
  private Integer bankAccountId;

  @JsonProperty("isr_id")
  private Integer isrId;

  /**
   * ISR position; possible values: A - additional page, F - first page, L - last page 
   */
  public enum IsrPositionEnum {
    A("A"),
    
    F("F"),
    
    L("L");

    private String value;

    IsrPositionEnum(String value) {
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
    public static IsrPositionEnum fromValue(String value) {
      for (IsrPositionEnum b : IsrPositionEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("isr_position")
  private IsrPositionEnum isrPosition = IsrPositionEnum.A;

  @JsonProperty("payment_link_paypal")
  private Boolean paymentLinkPaypal;

  @JsonProperty("payment_link_postfinance")
  private Boolean paymentLinkPostfinance;

  @JsonProperty("payment_link_payrexx")
  private Boolean paymentLinkPayrexx;

  @JsonProperty("payment_link_smartcommerce")
  private Boolean paymentLinkSmartcommerce;

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
  private List<DocumentInvoicePositionPOST> positions = new ArrayList<>();

  @JsonProperty("texts")
  @Valid
  private List<DocumentInvoiceTextPOST> texts = null;

  @JsonProperty("free_texts")
  @Valid
  private List<DocumentFreeTextPOST> freeTexts = null;

  @JsonProperty("workflow")
  @Valid
  private List<DocumentInvoiceWorkflowPOST> workflow = null;

  public DocumentInvoiceRecurringPOST contactId(Integer contactId) {
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

  public DocumentInvoiceRecurringPOST contactAddressId(Integer contactAddressId) {
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

  public DocumentInvoiceRecurringPOST contactPrepageAddressId(Integer contactPrepageAddressId) {
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

  public DocumentInvoiceRecurringPOST contactPersonId(Integer contactPersonId) {
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

  public DocumentInvoiceRecurringPOST startDate(LocalDate startDate) {
    this.startDate = startDate;
    return this;
  }

  /**
   * date of first execution of invoice
   * @return startDate
  */
  @ApiModelProperty(required = true, value = "date of first execution of invoice")
  @NotNull

  @Valid

  public LocalDate getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }

  public DocumentInvoiceRecurringPOST endDate(LocalDate endDate) {
    this.endDate = endDate;
    return this;
  }

  /**
   * date of latest execution of invoice
   * @return endDate
  */
  @ApiModelProperty(value = "date of latest execution of invoice")

  @Valid

  public LocalDate getEndDate() {
    return endDate;
  }

  public void setEndDate(LocalDate endDate) {
    this.endDate = endDate;
  }

  public DocumentInvoiceRecurringPOST frequency(Integer frequency) {
    this.frequency = frequency;
    return this;
  }

  /**
   * frequency (number of months) of creating a standard invoice from recurring invoice; possible values: 1, 3, 6, 12
   * @return frequency
  */
  @ApiModelProperty(required = true, value = "frequency (number of months) of creating a standard invoice from recurring invoice; possible values: 1, 3, 6, 12")
  @NotNull


  public Integer getFrequency() {
    return frequency;
  }

  public void setFrequency(Integer frequency) {
    this.frequency = frequency;
  }

  public DocumentInvoiceRecurringPOST grace(Integer grace) {
    this.grace = grace;
    return this;
  }

  /**
   * payment deadline in days
   * @return grace
  */
  @ApiModelProperty(required = true, value = "payment deadline in days")
  @NotNull


  public Integer getGrace() {
    return grace;
  }

  public void setGrace(Integer grace) {
    this.grace = grace;
  }

  public DocumentInvoiceRecurringPOST periodText(String periodText) {
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

  public DocumentInvoiceRecurringPOST currency(String currency) {
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

  public DocumentInvoiceRecurringPOST vatIncluded(Boolean vatIncluded) {
    this.vatIncluded = vatIncluded;
    return this;
  }

  /**
   * whether prices in invoice include VAT - default value: false
   * @return vatIncluded
  */
  @ApiModelProperty(value = "whether prices in invoice include VAT - default value: false")


  public Boolean getVatIncluded() {
    return vatIncluded;
  }

  public void setVatIncluded(Boolean vatIncluded) {
    this.vatIncluded = vatIncluded;
  }

  public DocumentInvoiceRecurringPOST discountRate(Float discountRate) {
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

  public DocumentInvoiceRecurringPOST discountType(DiscountTypeEnum discountType) {
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

  public DocumentInvoiceRecurringPOST cashDiscountRate(Integer cashDiscountRate) {
    this.cashDiscountRate = cashDiscountRate;
    return this;
  }

  /**
   * cash discount value in %
   * @return cashDiscountRate
  */
  @ApiModelProperty(value = "cash discount value in %")


  public Integer getCashDiscountRate() {
    return cashDiscountRate;
  }

  public void setCashDiscountRate(Integer cashDiscountRate) {
    this.cashDiscountRate = cashDiscountRate;
  }

  public DocumentInvoiceRecurringPOST cashDiscountDate(LocalDate cashDiscountDate) {
    this.cashDiscountDate = cashDiscountDate;
    return this;
  }

  /**
   * cash discount deadline date
   * @return cashDiscountDate
  */
  @ApiModelProperty(value = "cash discount deadline date")

  @Valid

  public LocalDate getCashDiscountDate() {
    return cashDiscountDate;
  }

  public void setCashDiscountDate(LocalDate cashDiscountDate) {
    this.cashDiscountDate = cashDiscountDate;
  }

  public DocumentInvoiceRecurringPOST bankAccountId(Integer bankAccountId) {
    this.bankAccountId = bankAccountId;
    return this;
  }

  /**
   * bank account id
   * @return bankAccountId
  */
  @ApiModelProperty(value = "bank account id")


  public Integer getBankAccountId() {
    return bankAccountId;
  }

  public void setBankAccountId(Integer bankAccountId) {
    this.bankAccountId = bankAccountId;
  }

  public DocumentInvoiceRecurringPOST isrId(Integer isrId) {
    this.isrId = isrId;
    return this;
  }

  /**
   * ISR id
   * @return isrId
  */
  @ApiModelProperty(value = "ISR id")


  public Integer getIsrId() {
    return isrId;
  }

  public void setIsrId(Integer isrId) {
    this.isrId = isrId;
  }

  public DocumentInvoiceRecurringPOST isrPosition(IsrPositionEnum isrPosition) {
    this.isrPosition = isrPosition;
    return this;
  }

  /**
   * ISR position; possible values: A - additional page, F - first page, L - last page 
   * @return isrPosition
  */
  @ApiModelProperty(value = "ISR position; possible values: A - additional page, F - first page, L - last page ")


  public IsrPositionEnum getIsrPosition() {
    return isrPosition;
  }

  public void setIsrPosition(IsrPositionEnum isrPosition) {
    this.isrPosition = isrPosition;
  }

  public DocumentInvoiceRecurringPOST paymentLinkPaypal(Boolean paymentLinkPaypal) {
    this.paymentLinkPaypal = paymentLinkPaypal;
    return this;
  }

  /**
   * whether to print PayPal link on invoice - default value: false
   * @return paymentLinkPaypal
  */
  @ApiModelProperty(value = "whether to print PayPal link on invoice - default value: false")


  public Boolean getPaymentLinkPaypal() {
    return paymentLinkPaypal;
  }

  public void setPaymentLinkPaypal(Boolean paymentLinkPaypal) {
    this.paymentLinkPaypal = paymentLinkPaypal;
  }

  public DocumentInvoiceRecurringPOST paymentLinkPostfinance(Boolean paymentLinkPostfinance) {
    this.paymentLinkPostfinance = paymentLinkPostfinance;
    return this;
  }

  /**
   * whether to print PostFinance link on invoice - default value: false
   * @return paymentLinkPostfinance
  */
  @ApiModelProperty(value = "whether to print PostFinance link on invoice - default value: false")


  public Boolean getPaymentLinkPostfinance() {
    return paymentLinkPostfinance;
  }

  public void setPaymentLinkPostfinance(Boolean paymentLinkPostfinance) {
    this.paymentLinkPostfinance = paymentLinkPostfinance;
  }

  public DocumentInvoiceRecurringPOST paymentLinkPayrexx(Boolean paymentLinkPayrexx) {
    this.paymentLinkPayrexx = paymentLinkPayrexx;
    return this;
  }

  /**
   * whether to print Payrexx link on invoice - default value: false
   * @return paymentLinkPayrexx
  */
  @ApiModelProperty(value = "whether to print Payrexx link on invoice - default value: false")


  public Boolean getPaymentLinkPayrexx() {
    return paymentLinkPayrexx;
  }

  public void setPaymentLinkPayrexx(Boolean paymentLinkPayrexx) {
    this.paymentLinkPayrexx = paymentLinkPayrexx;
  }

  public DocumentInvoiceRecurringPOST paymentLinkSmartcommerce(Boolean paymentLinkSmartcommerce) {
    this.paymentLinkSmartcommerce = paymentLinkSmartcommerce;
    return this;
  }

  /**
   * whether to print SmartCommerce link on invoice - default value: false
   * @return paymentLinkSmartcommerce
  */
  @ApiModelProperty(value = "whether to print SmartCommerce link on invoice - default value: false")


  public Boolean getPaymentLinkSmartcommerce() {
    return paymentLinkSmartcommerce;
  }

  public void setPaymentLinkSmartcommerce(Boolean paymentLinkSmartcommerce) {
    this.paymentLinkSmartcommerce = paymentLinkSmartcommerce;
  }

  public DocumentInvoiceRecurringPOST language(LanguageEnum language) {
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

  public DocumentInvoiceRecurringPOST signatureId(Integer signatureId) {
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

  public DocumentInvoiceRecurringPOST layoutId(Integer layoutId) {
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

  public DocumentInvoiceRecurringPOST notes(String notes) {
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

  public DocumentInvoiceRecurringPOST customFields(List<DescriptiveCustomFieldPOST> customFields) {
    this.customFields = customFields;
    return this;
  }

  public DocumentInvoiceRecurringPOST addCustomFieldsItem(DescriptiveCustomFieldPOST customFieldsItem) {
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

  public DocumentInvoiceRecurringPOST positions(List<DocumentInvoicePositionPOST> positions) {
    this.positions = positions;
    return this;
  }

  public DocumentInvoiceRecurringPOST addPositionsItem(DocumentInvoicePositionPOST positionsItem) {
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

  public List<DocumentInvoicePositionPOST> getPositions() {
    return positions;
  }

  public void setPositions(List<DocumentInvoicePositionPOST> positions) {
    this.positions = positions;
  }

  public DocumentInvoiceRecurringPOST texts(List<DocumentInvoiceTextPOST> texts) {
    this.texts = texts;
    return this;
  }

  public DocumentInvoiceRecurringPOST addTextsItem(DocumentInvoiceTextPOST textsItem) {
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

  public List<DocumentInvoiceTextPOST> getTexts() {
    return texts;
  }

  public void setTexts(List<DocumentInvoiceTextPOST> texts) {
    this.texts = texts;
  }

  public DocumentInvoiceRecurringPOST freeTexts(List<DocumentFreeTextPOST> freeTexts) {
    this.freeTexts = freeTexts;
    return this;
  }

  public DocumentInvoiceRecurringPOST addFreeTextsItem(DocumentFreeTextPOST freeTextsItem) {
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

  public DocumentInvoiceRecurringPOST workflow(List<DocumentInvoiceWorkflowPOST> workflow) {
    this.workflow = workflow;
    return this;
  }

  public DocumentInvoiceRecurringPOST addWorkflowItem(DocumentInvoiceWorkflowPOST workflowItem) {
    if (this.workflow == null) {
      this.workflow = new ArrayList<>();
    }
    this.workflow.add(workflowItem);
    return this;
  }

  /**
   * workflow objects
   * @return workflow
  */
  @ApiModelProperty(value = "workflow objects")

  @Valid

  public List<DocumentInvoiceWorkflowPOST> getWorkflow() {
    return workflow;
  }

  public void setWorkflow(List<DocumentInvoiceWorkflowPOST> workflow) {
    this.workflow = workflow;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DocumentInvoiceRecurringPOST documentInvoiceRecurringPOST = (DocumentInvoiceRecurringPOST) o;
    return Objects.equals(this.contactId, documentInvoiceRecurringPOST.contactId) &&
        Objects.equals(this.contactAddressId, documentInvoiceRecurringPOST.contactAddressId) &&
        Objects.equals(this.contactPrepageAddressId, documentInvoiceRecurringPOST.contactPrepageAddressId) &&
        Objects.equals(this.contactPersonId, documentInvoiceRecurringPOST.contactPersonId) &&
        Objects.equals(this.startDate, documentInvoiceRecurringPOST.startDate) &&
        Objects.equals(this.endDate, documentInvoiceRecurringPOST.endDate) &&
        Objects.equals(this.frequency, documentInvoiceRecurringPOST.frequency) &&
        Objects.equals(this.grace, documentInvoiceRecurringPOST.grace) &&
        Objects.equals(this.periodText, documentInvoiceRecurringPOST.periodText) &&
        Objects.equals(this.currency, documentInvoiceRecurringPOST.currency) &&
        Objects.equals(this.vatIncluded, documentInvoiceRecurringPOST.vatIncluded) &&
        Objects.equals(this.discountRate, documentInvoiceRecurringPOST.discountRate) &&
        Objects.equals(this.discountType, documentInvoiceRecurringPOST.discountType) &&
        Objects.equals(this.cashDiscountRate, documentInvoiceRecurringPOST.cashDiscountRate) &&
        Objects.equals(this.cashDiscountDate, documentInvoiceRecurringPOST.cashDiscountDate) &&
        Objects.equals(this.bankAccountId, documentInvoiceRecurringPOST.bankAccountId) &&
        Objects.equals(this.isrId, documentInvoiceRecurringPOST.isrId) &&
        Objects.equals(this.isrPosition, documentInvoiceRecurringPOST.isrPosition) &&
        Objects.equals(this.paymentLinkPaypal, documentInvoiceRecurringPOST.paymentLinkPaypal) &&
        Objects.equals(this.paymentLinkPostfinance, documentInvoiceRecurringPOST.paymentLinkPostfinance) &&
        Objects.equals(this.paymentLinkPayrexx, documentInvoiceRecurringPOST.paymentLinkPayrexx) &&
        Objects.equals(this.paymentLinkSmartcommerce, documentInvoiceRecurringPOST.paymentLinkSmartcommerce) &&
        Objects.equals(this.language, documentInvoiceRecurringPOST.language) &&
        Objects.equals(this.signatureId, documentInvoiceRecurringPOST.signatureId) &&
        Objects.equals(this.layoutId, documentInvoiceRecurringPOST.layoutId) &&
        Objects.equals(this.notes, documentInvoiceRecurringPOST.notes) &&
        Objects.equals(this.customFields, documentInvoiceRecurringPOST.customFields) &&
        Objects.equals(this.positions, documentInvoiceRecurringPOST.positions) &&
        Objects.equals(this.texts, documentInvoiceRecurringPOST.texts) &&
        Objects.equals(this.freeTexts, documentInvoiceRecurringPOST.freeTexts) &&
        Objects.equals(this.workflow, documentInvoiceRecurringPOST.workflow);
  }

  @Override
  public int hashCode() {
    return Objects.hash(contactId, contactAddressId, contactPrepageAddressId, contactPersonId, startDate, endDate, frequency, grace, periodText, currency, vatIncluded, discountRate, discountType, cashDiscountRate, cashDiscountDate, bankAccountId, isrId, isrPosition, paymentLinkPaypal, paymentLinkPostfinance, paymentLinkPayrexx, paymentLinkSmartcommerce, language, signatureId, layoutId, notes, customFields, positions, texts, freeTexts, workflow);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DocumentInvoiceRecurringPOST {\n");
    
    sb.append("    contactId: ").append(toIndentedString(contactId)).append("\n");
    sb.append("    contactAddressId: ").append(toIndentedString(contactAddressId)).append("\n");
    sb.append("    contactPrepageAddressId: ").append(toIndentedString(contactPrepageAddressId)).append("\n");
    sb.append("    contactPersonId: ").append(toIndentedString(contactPersonId)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
    sb.append("    frequency: ").append(toIndentedString(frequency)).append("\n");
    sb.append("    grace: ").append(toIndentedString(grace)).append("\n");
    sb.append("    periodText: ").append(toIndentedString(periodText)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    vatIncluded: ").append(toIndentedString(vatIncluded)).append("\n");
    sb.append("    discountRate: ").append(toIndentedString(discountRate)).append("\n");
    sb.append("    discountType: ").append(toIndentedString(discountType)).append("\n");
    sb.append("    cashDiscountRate: ").append(toIndentedString(cashDiscountRate)).append("\n");
    sb.append("    cashDiscountDate: ").append(toIndentedString(cashDiscountDate)).append("\n");
    sb.append("    bankAccountId: ").append(toIndentedString(bankAccountId)).append("\n");
    sb.append("    isrId: ").append(toIndentedString(isrId)).append("\n");
    sb.append("    isrPosition: ").append(toIndentedString(isrPosition)).append("\n");
    sb.append("    paymentLinkPaypal: ").append(toIndentedString(paymentLinkPaypal)).append("\n");
    sb.append("    paymentLinkPostfinance: ").append(toIndentedString(paymentLinkPostfinance)).append("\n");
    sb.append("    paymentLinkPayrexx: ").append(toIndentedString(paymentLinkPayrexx)).append("\n");
    sb.append("    paymentLinkSmartcommerce: ").append(toIndentedString(paymentLinkSmartcommerce)).append("\n");
    sb.append("    language: ").append(toIndentedString(language)).append("\n");
    sb.append("    signatureId: ").append(toIndentedString(signatureId)).append("\n");
    sb.append("    layoutId: ").append(toIndentedString(layoutId)).append("\n");
    sb.append("    notes: ").append(toIndentedString(notes)).append("\n");
    sb.append("    customFields: ").append(toIndentedString(customFields)).append("\n");
    sb.append("    positions: ").append(toIndentedString(positions)).append("\n");
    sb.append("    texts: ").append(toIndentedString(texts)).append("\n");
    sb.append("    freeTexts: ").append(toIndentedString(freeTexts)).append("\n");
    sb.append("    workflow: ").append(toIndentedString(workflow)).append("\n");
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

