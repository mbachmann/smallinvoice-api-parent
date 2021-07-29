package com.example.smallinvoicespringfeign.model;

import java.util.Objects;
import com.example.smallinvoicespringfeign.model.DescriptiveCustomFieldPUT;
import com.example.smallinvoicespringfeign.model.DocumentFreeTextPUT;
import com.example.smallinvoicespringfeign.model.DocumentInvoicePositionPUT;
import com.example.smallinvoicespringfeign.model.DocumentInvoiceTextPUT;
import com.example.smallinvoicespringfeign.model.DocumentInvoiceWorkflowPUT;
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
 * InvoicePUT
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-29T11:25:10.409375+02:00[Europe/Zurich]")
public class InvoicePUT  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("contact_id")
  private Integer contactId;

  @JsonProperty("contact_address_id")
  private Integer contactAddressId;

  @JsonProperty("contact_prepage_address_id")
  private Integer contactPrepageAddressId;

  @JsonProperty("contact_person_id")
  private Integer contactPersonId;

  @JsonProperty("currency")
  private String currency;

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

  @JsonProperty("bank_account_id")
  private Integer bankAccountId;

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

  @JsonProperty("layout_id")
  private Integer layoutId;

  @JsonProperty("period_text")
  private String periodText;

  @JsonProperty("vat_included")
  private Boolean vatIncluded;

  @JsonProperty("signature_id")
  private Integer signatureId;

  @JsonProperty("notes")
  private String notes;

  @JsonProperty("cash_discount_rate")
  private Integer cashDiscountRate;

  @JsonProperty("cash_discount_date")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE)
  private LocalDate cashDiscountDate;

  @JsonProperty("custom_fields")
  @Valid
  private List<DescriptiveCustomFieldPUT> customFields = null;

  @JsonProperty("positions")
  @Valid
  private List<DocumentInvoicePositionPUT> positions = null;

  @JsonProperty("texts")
  @Valid
  private List<DocumentInvoiceTextPUT> texts = null;

  @JsonProperty("free_texts")
  @Valid
  private List<DocumentFreeTextPUT> freeTexts = null;

  @JsonProperty("workflow")
  @Valid
  private List<DocumentInvoiceWorkflowPUT> workflow = null;

  public InvoicePUT contactId(Integer contactId) {
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

  public InvoicePUT contactAddressId(Integer contactAddressId) {
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

  public InvoicePUT contactPrepageAddressId(Integer contactPrepageAddressId) {
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

  public InvoicePUT contactPersonId(Integer contactPersonId) {
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

  public InvoicePUT currency(String currency) {
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

  public InvoicePUT discountRate(Float discountRate) {
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

  public InvoicePUT discountType(DiscountTypeEnum discountType) {
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

  public InvoicePUT isrId(Integer isrId) {
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

  public InvoicePUT isrPosition(IsrPositionEnum isrPosition) {
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

  public InvoicePUT paymentLinkPaypal(Boolean paymentLinkPaypal) {
    this.paymentLinkPaypal = paymentLinkPaypal;
    return this;
  }

  /**
   * whether to print PayPal link on invoice
   * @return paymentLinkPaypal
  */
  @ApiModelProperty(value = "whether to print PayPal link on invoice")


  public Boolean getPaymentLinkPaypal() {
    return paymentLinkPaypal;
  }

  public void setPaymentLinkPaypal(Boolean paymentLinkPaypal) {
    this.paymentLinkPaypal = paymentLinkPaypal;
  }

  public InvoicePUT paymentLinkPostfinance(Boolean paymentLinkPostfinance) {
    this.paymentLinkPostfinance = paymentLinkPostfinance;
    return this;
  }

  /**
   * whether to print PostFinance link on invoice
   * @return paymentLinkPostfinance
  */
  @ApiModelProperty(value = "whether to print PostFinance link on invoice")


  public Boolean getPaymentLinkPostfinance() {
    return paymentLinkPostfinance;
  }

  public void setPaymentLinkPostfinance(Boolean paymentLinkPostfinance) {
    this.paymentLinkPostfinance = paymentLinkPostfinance;
  }

  public InvoicePUT paymentLinkPayrexx(Boolean paymentLinkPayrexx) {
    this.paymentLinkPayrexx = paymentLinkPayrexx;
    return this;
  }

  /**
   * whether to print Payrexx link on invoice
   * @return paymentLinkPayrexx
  */
  @ApiModelProperty(value = "whether to print Payrexx link on invoice")


  public Boolean getPaymentLinkPayrexx() {
    return paymentLinkPayrexx;
  }

  public void setPaymentLinkPayrexx(Boolean paymentLinkPayrexx) {
    this.paymentLinkPayrexx = paymentLinkPayrexx;
  }

  public InvoicePUT paymentLinkSmartcommerce(Boolean paymentLinkSmartcommerce) {
    this.paymentLinkSmartcommerce = paymentLinkSmartcommerce;
    return this;
  }

  /**
   * whether to print SmartCommerce link on invoice
   * @return paymentLinkSmartcommerce
  */
  @ApiModelProperty(value = "whether to print SmartCommerce link on invoice")


  public Boolean getPaymentLinkSmartcommerce() {
    return paymentLinkSmartcommerce;
  }

  public void setPaymentLinkSmartcommerce(Boolean paymentLinkSmartcommerce) {
    this.paymentLinkSmartcommerce = paymentLinkSmartcommerce;
  }

  public InvoicePUT bankAccountId(Integer bankAccountId) {
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

  public InvoicePUT language(LanguageEnum language) {
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

  public InvoicePUT layoutId(Integer layoutId) {
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

  public InvoicePUT periodText(String periodText) {
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

  public InvoicePUT vatIncluded(Boolean vatIncluded) {
    this.vatIncluded = vatIncluded;
    return this;
  }

  /**
   * whether prices in invoice include VAT
   * @return vatIncluded
  */
  @ApiModelProperty(value = "whether prices in invoice include VAT")


  public Boolean getVatIncluded() {
    return vatIncluded;
  }

  public void setVatIncluded(Boolean vatIncluded) {
    this.vatIncluded = vatIncluded;
  }

  public InvoicePUT signatureId(Integer signatureId) {
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

  public InvoicePUT notes(String notes) {
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

  public InvoicePUT cashDiscountRate(Integer cashDiscountRate) {
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

  public InvoicePUT cashDiscountDate(LocalDate cashDiscountDate) {
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

  public InvoicePUT customFields(List<DescriptiveCustomFieldPUT> customFields) {
    this.customFields = customFields;
    return this;
  }

  public InvoicePUT addCustomFieldsItem(DescriptiveCustomFieldPUT customFieldsItem) {
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

  public InvoicePUT positions(List<DocumentInvoicePositionPUT> positions) {
    this.positions = positions;
    return this;
  }

  public InvoicePUT addPositionsItem(DocumentInvoicePositionPUT positionsItem) {
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

  public List<DocumentInvoicePositionPUT> getPositions() {
    return positions;
  }

  public void setPositions(List<DocumentInvoicePositionPUT> positions) {
    this.positions = positions;
  }

  public InvoicePUT texts(List<DocumentInvoiceTextPUT> texts) {
    this.texts = texts;
    return this;
  }

  public InvoicePUT addTextsItem(DocumentInvoiceTextPUT textsItem) {
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

  public List<DocumentInvoiceTextPUT> getTexts() {
    return texts;
  }

  public void setTexts(List<DocumentInvoiceTextPUT> texts) {
    this.texts = texts;
  }

  public InvoicePUT freeTexts(List<DocumentFreeTextPUT> freeTexts) {
    this.freeTexts = freeTexts;
    return this;
  }

  public InvoicePUT addFreeTextsItem(DocumentFreeTextPUT freeTextsItem) {
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

  public InvoicePUT workflow(List<DocumentInvoiceWorkflowPUT> workflow) {
    this.workflow = workflow;
    return this;
  }

  public InvoicePUT addWorkflowItem(DocumentInvoiceWorkflowPUT workflowItem) {
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

  public List<DocumentInvoiceWorkflowPUT> getWorkflow() {
    return workflow;
  }

  public void setWorkflow(List<DocumentInvoiceWorkflowPUT> workflow) {
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
    InvoicePUT invoicePUT = (InvoicePUT) o;
    return Objects.equals(this.contactId, invoicePUT.contactId) &&
        Objects.equals(this.contactAddressId, invoicePUT.contactAddressId) &&
        Objects.equals(this.contactPrepageAddressId, invoicePUT.contactPrepageAddressId) &&
        Objects.equals(this.contactPersonId, invoicePUT.contactPersonId) &&
        Objects.equals(this.currency, invoicePUT.currency) &&
        Objects.equals(this.discountRate, invoicePUT.discountRate) &&
        Objects.equals(this.discountType, invoicePUT.discountType) &&
        Objects.equals(this.isrId, invoicePUT.isrId) &&
        Objects.equals(this.isrPosition, invoicePUT.isrPosition) &&
        Objects.equals(this.paymentLinkPaypal, invoicePUT.paymentLinkPaypal) &&
        Objects.equals(this.paymentLinkPostfinance, invoicePUT.paymentLinkPostfinance) &&
        Objects.equals(this.paymentLinkPayrexx, invoicePUT.paymentLinkPayrexx) &&
        Objects.equals(this.paymentLinkSmartcommerce, invoicePUT.paymentLinkSmartcommerce) &&
        Objects.equals(this.bankAccountId, invoicePUT.bankAccountId) &&
        Objects.equals(this.language, invoicePUT.language) &&
        Objects.equals(this.layoutId, invoicePUT.layoutId) &&
        Objects.equals(this.periodText, invoicePUT.periodText) &&
        Objects.equals(this.vatIncluded, invoicePUT.vatIncluded) &&
        Objects.equals(this.signatureId, invoicePUT.signatureId) &&
        Objects.equals(this.notes, invoicePUT.notes) &&
        Objects.equals(this.cashDiscountRate, invoicePUT.cashDiscountRate) &&
        Objects.equals(this.cashDiscountDate, invoicePUT.cashDiscountDate) &&
        Objects.equals(this.customFields, invoicePUT.customFields) &&
        Objects.equals(this.positions, invoicePUT.positions) &&
        Objects.equals(this.texts, invoicePUT.texts) &&
        Objects.equals(this.freeTexts, invoicePUT.freeTexts) &&
        Objects.equals(this.workflow, invoicePUT.workflow);
  }

  @Override
  public int hashCode() {
    return Objects.hash(contactId, contactAddressId, contactPrepageAddressId, contactPersonId, currency, discountRate, discountType, isrId, isrPosition, paymentLinkPaypal, paymentLinkPostfinance, paymentLinkPayrexx, paymentLinkSmartcommerce, bankAccountId, language, layoutId, periodText, vatIncluded, signatureId, notes, cashDiscountRate, cashDiscountDate, customFields, positions, texts, freeTexts, workflow);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InvoicePUT {\n");
    
    sb.append("    contactId: ").append(toIndentedString(contactId)).append("\n");
    sb.append("    contactAddressId: ").append(toIndentedString(contactAddressId)).append("\n");
    sb.append("    contactPrepageAddressId: ").append(toIndentedString(contactPrepageAddressId)).append("\n");
    sb.append("    contactPersonId: ").append(toIndentedString(contactPersonId)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    discountRate: ").append(toIndentedString(discountRate)).append("\n");
    sb.append("    discountType: ").append(toIndentedString(discountType)).append("\n");
    sb.append("    isrId: ").append(toIndentedString(isrId)).append("\n");
    sb.append("    isrPosition: ").append(toIndentedString(isrPosition)).append("\n");
    sb.append("    paymentLinkPaypal: ").append(toIndentedString(paymentLinkPaypal)).append("\n");
    sb.append("    paymentLinkPostfinance: ").append(toIndentedString(paymentLinkPostfinance)).append("\n");
    sb.append("    paymentLinkPayrexx: ").append(toIndentedString(paymentLinkPayrexx)).append("\n");
    sb.append("    paymentLinkSmartcommerce: ").append(toIndentedString(paymentLinkSmartcommerce)).append("\n");
    sb.append("    bankAccountId: ").append(toIndentedString(bankAccountId)).append("\n");
    sb.append("    language: ").append(toIndentedString(language)).append("\n");
    sb.append("    layoutId: ").append(toIndentedString(layoutId)).append("\n");
    sb.append("    periodText: ").append(toIndentedString(periodText)).append("\n");
    sb.append("    vatIncluded: ").append(toIndentedString(vatIncluded)).append("\n");
    sb.append("    signatureId: ").append(toIndentedString(signatureId)).append("\n");
    sb.append("    notes: ").append(toIndentedString(notes)).append("\n");
    sb.append("    cashDiscountRate: ").append(toIndentedString(cashDiscountRate)).append("\n");
    sb.append("    cashDiscountDate: ").append(toIndentedString(cashDiscountDate)).append("\n");
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

