package com.example.smallinvoicespringfeign.model;

import java.util.Objects;
import com.example.smallinvoicespringfeign.model.ConfigurationBankAccountGET;
import com.example.smallinvoicespringfeign.model.ContactAddressGET;
import com.example.smallinvoicespringfeign.model.ContactGET;
import com.example.smallinvoicespringfeign.model.ContactPeopleGET;
import com.example.smallinvoicespringfeign.model.DescriptiveCustomFieldGET;
import com.example.smallinvoicespringfeign.model.DocumentFreeTextGET;
import com.example.smallinvoicespringfeign.model.DocumentInvoicePositionGET;
import com.example.smallinvoicespringfeign.model.DocumentInvoiceTextGET;
import com.example.smallinvoicespringfeign.model.DocumentInvoiceWorkflowGET;
import com.example.smallinvoicespringfeign.model.ReceivablesConfigurationIsrGET;
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
 * DocumentInvoiceStandardGET
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-27T20:43:02.724916+02:00[Europe/Zurich]")
public class DocumentInvoiceStandardGET  implements Serializable {
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

  @JsonProperty("due")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE)
  private LocalDate due;

  @JsonProperty("period_from")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE)
  private LocalDate periodFrom;

  @JsonProperty("period_to")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE)
  private LocalDate periodTo;

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

  @JsonProperty("cash_discount_rate")
  private Integer cashDiscountRate;

  @JsonProperty("cash_discount_date")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE)
  private LocalDate cashDiscountDate;

  @JsonProperty("total_paid")
  private Float totalPaid;

  @JsonProperty("paid_date")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE)
  private LocalDate paidDate;

  @JsonProperty("bank_account_id")
  private Integer bankAccountId;

  @JsonProperty("bank_account")
  private ConfigurationBankAccountGET bankAccount;

  @JsonProperty("isr_id")
  private Integer isrId;

  @JsonProperty("isr")
  private ReceivablesConfigurationIsrGET isr;

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

  @JsonProperty("isr_reference_number")
  private String isrReferenceNumber;

  @JsonProperty("payment_link_paypal")
  private Boolean paymentLinkPaypal;

  @JsonProperty("payment_link_paypal_url")
  private String paymentLinkPaypalUrl;

  @JsonProperty("payment_link_postfinance")
  private Boolean paymentLinkPostfinance;

  @JsonProperty("payment_link_postfinance_url")
  private String paymentLinkPostfinanceUrl;

  @JsonProperty("payment_link_payrexx")
  private Boolean paymentLinkPayrexx;

  @JsonProperty("payment_link_payrexx_url")
  private String paymentLinkPayrexxUrl;

  @JsonProperty("payment_link_smartcommerce")
  private Boolean paymentLinkSmartcommerce;

  @JsonProperty("payment_link_smartcommerce_url")
  private String paymentLinkSmartcommerceUrl;

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

  @JsonProperty("status")
  private String status;

  @JsonProperty("created")
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
  private LocalDateTime created;

  @JsonProperty("custom_fields")
  @Valid
  private List<DescriptiveCustomFieldGET> customFields = null;

  @JsonProperty("positions")
  @Valid
  private List<DocumentInvoicePositionGET> positions = null;

  @JsonProperty("texts")
  @Valid
  private List<DocumentInvoiceTextGET> texts = null;

  @JsonProperty("free_texts")
  @Valid
  private List<DocumentFreeTextGET> freeTexts = null;

  @JsonProperty("workflow")
  @Valid
  private List<DocumentInvoiceWorkflowGET> workflow = null;

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

  public DocumentInvoiceStandardGET id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * invoice id
   * @return id
  */
  @ApiModelProperty(required = true, value = "invoice id")
  @NotNull


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public DocumentInvoiceStandardGET number(String number) {
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

  public DocumentInvoiceStandardGET contactId(Integer contactId) {
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

  public DocumentInvoiceStandardGET contactName(String contactName) {
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

  public DocumentInvoiceStandardGET contact(ContactGET contact) {
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

  public DocumentInvoiceStandardGET contactAddressId(Integer contactAddressId) {
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

  public DocumentInvoiceStandardGET contactAddress(ContactAddressGET contactAddress) {
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

  public DocumentInvoiceStandardGET contactPrepageAddressId(Integer contactPrepageAddressId) {
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

  public DocumentInvoiceStandardGET contactPrepageAddress(ContactAddressGET contactPrepageAddress) {
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

  public DocumentInvoiceStandardGET contactPersonId(Integer contactPersonId) {
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

  public DocumentInvoiceStandardGET contactPerson(ContactPeopleGET contactPerson) {
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

  public DocumentInvoiceStandardGET date(LocalDate date) {
    this.date = date;
    return this;
  }

  /**
   * date of the invoice
   * @return date
  */
  @ApiModelProperty(required = true, value = "date of the invoice")
  @NotNull

  @Valid

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public DocumentInvoiceStandardGET due(LocalDate due) {
    this.due = due;
    return this;
  }

  /**
   * due date of the invoice
   * @return due
  */
  @ApiModelProperty(required = true, value = "due date of the invoice")
  @NotNull

  @Valid

  public LocalDate getDue() {
    return due;
  }

  public void setDue(LocalDate due) {
    this.due = due;
  }

  public DocumentInvoiceStandardGET periodFrom(LocalDate periodFrom) {
    this.periodFrom = periodFrom;
    return this;
  }

  /**
   * service period from
   * @return periodFrom
  */
  @ApiModelProperty(required = true, value = "service period from")
  @NotNull

  @Valid

  public LocalDate getPeriodFrom() {
    return periodFrom;
  }

  public void setPeriodFrom(LocalDate periodFrom) {
    this.periodFrom = periodFrom;
  }

  public DocumentInvoiceStandardGET periodTo(LocalDate periodTo) {
    this.periodTo = periodTo;
    return this;
  }

  /**
   * service period to
   * @return periodTo
  */
  @ApiModelProperty(required = true, value = "service period to")
  @NotNull

  @Valid

  public LocalDate getPeriodTo() {
    return periodTo;
  }

  public void setPeriodTo(LocalDate periodTo) {
    this.periodTo = periodTo;
  }

  public DocumentInvoiceStandardGET periodText(String periodText) {
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

  public DocumentInvoiceStandardGET currency(String currency) {
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

  public DocumentInvoiceStandardGET total(Float total) {
    this.total = total;
    return this;
  }

  /**
   * total amount of the invoice
   * @return total
  */
  @ApiModelProperty(required = true, value = "total amount of the invoice")
  @NotNull


  public Float getTotal() {
    return total;
  }

  public void setTotal(Float total) {
    this.total = total;
  }

  public DocumentInvoiceStandardGET vatIncluded(Boolean vatIncluded) {
    this.vatIncluded = vatIncluded;
    return this;
  }

  /**
   * whether prices in invoice include VAT
   * @return vatIncluded
  */
  @ApiModelProperty(required = true, value = "whether prices in invoice include VAT")
  @NotNull


  public Boolean getVatIncluded() {
    return vatIncluded;
  }

  public void setVatIncluded(Boolean vatIncluded) {
    this.vatIncluded = vatIncluded;
  }

  public DocumentInvoiceStandardGET discountRate(Float discountRate) {
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

  public DocumentInvoiceStandardGET discountType(DiscountTypeEnum discountType) {
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

  public DocumentInvoiceStandardGET cashDiscountRate(Integer cashDiscountRate) {
    this.cashDiscountRate = cashDiscountRate;
    return this;
  }

  /**
   * cash discount value in %
   * @return cashDiscountRate
  */
  @ApiModelProperty(required = true, value = "cash discount value in %")
  @NotNull


  public Integer getCashDiscountRate() {
    return cashDiscountRate;
  }

  public void setCashDiscountRate(Integer cashDiscountRate) {
    this.cashDiscountRate = cashDiscountRate;
  }

  public DocumentInvoiceStandardGET cashDiscountDate(LocalDate cashDiscountDate) {
    this.cashDiscountDate = cashDiscountDate;
    return this;
  }

  /**
   * cash discount deadline date
   * @return cashDiscountDate
  */
  @ApiModelProperty(required = true, value = "cash discount deadline date")
  @NotNull

  @Valid

  public LocalDate getCashDiscountDate() {
    return cashDiscountDate;
  }

  public void setCashDiscountDate(LocalDate cashDiscountDate) {
    this.cashDiscountDate = cashDiscountDate;
  }

  public DocumentInvoiceStandardGET totalPaid(Float totalPaid) {
    this.totalPaid = totalPaid;
    return this;
  }

  /**
   * paid amount of the invoice
   * @return totalPaid
  */
  @ApiModelProperty(required = true, value = "paid amount of the invoice")
  @NotNull


  public Float getTotalPaid() {
    return totalPaid;
  }

  public void setTotalPaid(Float totalPaid) {
    this.totalPaid = totalPaid;
  }

  public DocumentInvoiceStandardGET paidDate(LocalDate paidDate) {
    this.paidDate = paidDate;
    return this;
  }

  /**
   * date when invoice was fully paid
   * @return paidDate
  */
  @ApiModelProperty(required = true, value = "date when invoice was fully paid")
  @NotNull

  @Valid

  public LocalDate getPaidDate() {
    return paidDate;
  }

  public void setPaidDate(LocalDate paidDate) {
    this.paidDate = paidDate;
  }

  public DocumentInvoiceStandardGET bankAccountId(Integer bankAccountId) {
    this.bankAccountId = bankAccountId;
    return this;
  }

  /**
   * bank account id
   * @return bankAccountId
  */
  @ApiModelProperty(required = true, value = "bank account id")
  @NotNull


  public Integer getBankAccountId() {
    return bankAccountId;
  }

  public void setBankAccountId(Integer bankAccountId) {
    this.bankAccountId = bankAccountId;
  }

  public DocumentInvoiceStandardGET bankAccount(ConfigurationBankAccountGET bankAccount) {
    this.bankAccount = bankAccount;
    return this;
  }

  /**
   * Get bankAccount
   * @return bankAccount
  */
  @ApiModelProperty(value = "")

  @Valid

  public ConfigurationBankAccountGET getBankAccount() {
    return bankAccount;
  }

  public void setBankAccount(ConfigurationBankAccountGET bankAccount) {
    this.bankAccount = bankAccount;
  }

  public DocumentInvoiceStandardGET isrId(Integer isrId) {
    this.isrId = isrId;
    return this;
  }

  /**
   * ISR id
   * @return isrId
  */
  @ApiModelProperty(required = true, value = "ISR id")
  @NotNull


  public Integer getIsrId() {
    return isrId;
  }

  public void setIsrId(Integer isrId) {
    this.isrId = isrId;
  }

  public DocumentInvoiceStandardGET isr(ReceivablesConfigurationIsrGET isr) {
    this.isr = isr;
    return this;
  }

  /**
   * Get isr
   * @return isr
  */
  @ApiModelProperty(value = "")

  @Valid

  public ReceivablesConfigurationIsrGET getIsr() {
    return isr;
  }

  public void setIsr(ReceivablesConfigurationIsrGET isr) {
    this.isr = isr;
  }

  public DocumentInvoiceStandardGET isrPosition(IsrPositionEnum isrPosition) {
    this.isrPosition = isrPosition;
    return this;
  }

  /**
   * ISR position; possible values: A - additional page, F - first page, L - last page 
   * @return isrPosition
  */
  @ApiModelProperty(required = true, value = "ISR position; possible values: A - additional page, F - first page, L - last page ")
  @NotNull


  public IsrPositionEnum getIsrPosition() {
    return isrPosition;
  }

  public void setIsrPosition(IsrPositionEnum isrPosition) {
    this.isrPosition = isrPosition;
  }

  public DocumentInvoiceStandardGET isrReferenceNumber(String isrReferenceNumber) {
    this.isrReferenceNumber = isrReferenceNumber;
    return this;
  }

  /**
   * ISR reference number
   * @return isrReferenceNumber
  */
  @ApiModelProperty(required = true, value = "ISR reference number")
  @NotNull


  public String getIsrReferenceNumber() {
    return isrReferenceNumber;
  }

  public void setIsrReferenceNumber(String isrReferenceNumber) {
    this.isrReferenceNumber = isrReferenceNumber;
  }

  public DocumentInvoiceStandardGET paymentLinkPaypal(Boolean paymentLinkPaypal) {
    this.paymentLinkPaypal = paymentLinkPaypal;
    return this;
  }

  /**
   * whether to print PayPal link on invoice
   * @return paymentLinkPaypal
  */
  @ApiModelProperty(required = true, value = "whether to print PayPal link on invoice")
  @NotNull


  public Boolean getPaymentLinkPaypal() {
    return paymentLinkPaypal;
  }

  public void setPaymentLinkPaypal(Boolean paymentLinkPaypal) {
    this.paymentLinkPaypal = paymentLinkPaypal;
  }

  public DocumentInvoiceStandardGET paymentLinkPaypalUrl(String paymentLinkPaypalUrl) {
    this.paymentLinkPaypalUrl = paymentLinkPaypalUrl;
    return this;
  }

  /**
   * PayPal link URL
   * @return paymentLinkPaypalUrl
  */
  @ApiModelProperty(required = true, value = "PayPal link URL")
  @NotNull


  public String getPaymentLinkPaypalUrl() {
    return paymentLinkPaypalUrl;
  }

  public void setPaymentLinkPaypalUrl(String paymentLinkPaypalUrl) {
    this.paymentLinkPaypalUrl = paymentLinkPaypalUrl;
  }

  public DocumentInvoiceStandardGET paymentLinkPostfinance(Boolean paymentLinkPostfinance) {
    this.paymentLinkPostfinance = paymentLinkPostfinance;
    return this;
  }

  /**
   * whether to print PostFinance link on invoice
   * @return paymentLinkPostfinance
  */
  @ApiModelProperty(required = true, value = "whether to print PostFinance link on invoice")
  @NotNull


  public Boolean getPaymentLinkPostfinance() {
    return paymentLinkPostfinance;
  }

  public void setPaymentLinkPostfinance(Boolean paymentLinkPostfinance) {
    this.paymentLinkPostfinance = paymentLinkPostfinance;
  }

  public DocumentInvoiceStandardGET paymentLinkPostfinanceUrl(String paymentLinkPostfinanceUrl) {
    this.paymentLinkPostfinanceUrl = paymentLinkPostfinanceUrl;
    return this;
  }

  /**
   * PostFinance link URL
   * @return paymentLinkPostfinanceUrl
  */
  @ApiModelProperty(required = true, value = "PostFinance link URL")
  @NotNull


  public String getPaymentLinkPostfinanceUrl() {
    return paymentLinkPostfinanceUrl;
  }

  public void setPaymentLinkPostfinanceUrl(String paymentLinkPostfinanceUrl) {
    this.paymentLinkPostfinanceUrl = paymentLinkPostfinanceUrl;
  }

  public DocumentInvoiceStandardGET paymentLinkPayrexx(Boolean paymentLinkPayrexx) {
    this.paymentLinkPayrexx = paymentLinkPayrexx;
    return this;
  }

  /**
   * whether to print Payrexx link on invoice
   * @return paymentLinkPayrexx
  */
  @ApiModelProperty(required = true, value = "whether to print Payrexx link on invoice")
  @NotNull


  public Boolean getPaymentLinkPayrexx() {
    return paymentLinkPayrexx;
  }

  public void setPaymentLinkPayrexx(Boolean paymentLinkPayrexx) {
    this.paymentLinkPayrexx = paymentLinkPayrexx;
  }

  public DocumentInvoiceStandardGET paymentLinkPayrexxUrl(String paymentLinkPayrexxUrl) {
    this.paymentLinkPayrexxUrl = paymentLinkPayrexxUrl;
    return this;
  }

  /**
   * Payrexx link URL
   * @return paymentLinkPayrexxUrl
  */
  @ApiModelProperty(required = true, value = "Payrexx link URL")
  @NotNull


  public String getPaymentLinkPayrexxUrl() {
    return paymentLinkPayrexxUrl;
  }

  public void setPaymentLinkPayrexxUrl(String paymentLinkPayrexxUrl) {
    this.paymentLinkPayrexxUrl = paymentLinkPayrexxUrl;
  }

  public DocumentInvoiceStandardGET paymentLinkSmartcommerce(Boolean paymentLinkSmartcommerce) {
    this.paymentLinkSmartcommerce = paymentLinkSmartcommerce;
    return this;
  }

  /**
   * whether to print SmartCommerce link on invoice
   * @return paymentLinkSmartcommerce
  */
  @ApiModelProperty(required = true, value = "whether to print SmartCommerce link on invoice")
  @NotNull


  public Boolean getPaymentLinkSmartcommerce() {
    return paymentLinkSmartcommerce;
  }

  public void setPaymentLinkSmartcommerce(Boolean paymentLinkSmartcommerce) {
    this.paymentLinkSmartcommerce = paymentLinkSmartcommerce;
  }

  public DocumentInvoiceStandardGET paymentLinkSmartcommerceUrl(String paymentLinkSmartcommerceUrl) {
    this.paymentLinkSmartcommerceUrl = paymentLinkSmartcommerceUrl;
    return this;
  }

  /**
   * SmartCommerce link URL
   * @return paymentLinkSmartcommerceUrl
  */
  @ApiModelProperty(required = true, value = "SmartCommerce link URL")
  @NotNull


  public String getPaymentLinkSmartcommerceUrl() {
    return paymentLinkSmartcommerceUrl;
  }

  public void setPaymentLinkSmartcommerceUrl(String paymentLinkSmartcommerceUrl) {
    this.paymentLinkSmartcommerceUrl = paymentLinkSmartcommerceUrl;
  }

  public DocumentInvoiceStandardGET language(LanguageEnum language) {
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

  public DocumentInvoiceStandardGET signatureId(Integer signatureId) {
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

  public DocumentInvoiceStandardGET layoutId(Integer layoutId) {
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

  public DocumentInvoiceStandardGET pageAmount(Integer pageAmount) {
    this.pageAmount = pageAmount;
    return this;
  }

  /**
   * how many pages invoice has
   * @return pageAmount
  */
  @ApiModelProperty(required = true, value = "how many pages invoice has")
  @NotNull


  public Integer getPageAmount() {
    return pageAmount;
  }

  public void setPageAmount(Integer pageAmount) {
    this.pageAmount = pageAmount;
  }

  public DocumentInvoiceStandardGET notes(String notes) {
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

  public DocumentInvoiceStandardGET status(String status) {
    this.status = status;
    return this;
  }

  /**
   * status of invoice, possible values: DR - draft, S - sent, P - paid, PP - partially paid, R1 - 1st reminder, R2 - 2nd reminder, R3 - 3rd reminder, R - reminder, DC - debt collection, C - cancelled, D - deleted (but still visible)
   * @return status
  */
  @ApiModelProperty(required = true, value = "status of invoice, possible values: DR - draft, S - sent, P - paid, PP - partially paid, R1 - 1st reminder, R2 - 2nd reminder, R3 - 3rd reminder, R - reminder, DC - debt collection, C - cancelled, D - deleted (but still visible)")
  @NotNull


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public DocumentInvoiceStandardGET created(LocalDateTime created) {
    this.created = created;
    return this;
  }

  /**
   * date that invoice was created
   * @return created
  */
  @ApiModelProperty(required = true, value = "date that invoice was created")
  @NotNull

  @Valid

  public LocalDateTime getCreated() {
    return created;
  }

  public void setCreated(LocalDateTime created) {
    this.created = created;
  }

  public DocumentInvoiceStandardGET customFields(List<DescriptiveCustomFieldGET> customFields) {
    this.customFields = customFields;
    return this;
  }

  public DocumentInvoiceStandardGET addCustomFieldsItem(DescriptiveCustomFieldGET customFieldsItem) {
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

  public DocumentInvoiceStandardGET positions(List<DocumentInvoicePositionGET> positions) {
    this.positions = positions;
    return this;
  }

  public DocumentInvoiceStandardGET addPositionsItem(DocumentInvoicePositionGET positionsItem) {
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

  public List<DocumentInvoicePositionGET> getPositions() {
    return positions;
  }

  public void setPositions(List<DocumentInvoicePositionGET> positions) {
    this.positions = positions;
  }

  public DocumentInvoiceStandardGET texts(List<DocumentInvoiceTextGET> texts) {
    this.texts = texts;
    return this;
  }

  public DocumentInvoiceStandardGET addTextsItem(DocumentInvoiceTextGET textsItem) {
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

  public List<DocumentInvoiceTextGET> getTexts() {
    return texts;
  }

  public void setTexts(List<DocumentInvoiceTextGET> texts) {
    this.texts = texts;
  }

  public DocumentInvoiceStandardGET freeTexts(List<DocumentFreeTextGET> freeTexts) {
    this.freeTexts = freeTexts;
    return this;
  }

  public DocumentInvoiceStandardGET addFreeTextsItem(DocumentFreeTextGET freeTextsItem) {
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

  public DocumentInvoiceStandardGET workflow(List<DocumentInvoiceWorkflowGET> workflow) {
    this.workflow = workflow;
    return this;
  }

  public DocumentInvoiceStandardGET addWorkflowItem(DocumentInvoiceWorkflowGET workflowItem) {
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

  public List<DocumentInvoiceWorkflowGET> getWorkflow() {
    return workflow;
  }

  public void setWorkflow(List<DocumentInvoiceWorkflowGET> workflow) {
    this.workflow = workflow;
  }

  public DocumentInvoiceStandardGET permissions(List<PermissionsEnum> permissions) {
    this.permissions = permissions;
    return this;
  }

  public DocumentInvoiceStandardGET addPermissionsItem(PermissionsEnum permissionsItem) {
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
    DocumentInvoiceStandardGET documentInvoiceStandardGET = (DocumentInvoiceStandardGET) o;
    return Objects.equals(this.id, documentInvoiceStandardGET.id) &&
        Objects.equals(this.number, documentInvoiceStandardGET.number) &&
        Objects.equals(this.contactId, documentInvoiceStandardGET.contactId) &&
        Objects.equals(this.contactName, documentInvoiceStandardGET.contactName) &&
        Objects.equals(this.contact, documentInvoiceStandardGET.contact) &&
        Objects.equals(this.contactAddressId, documentInvoiceStandardGET.contactAddressId) &&
        Objects.equals(this.contactAddress, documentInvoiceStandardGET.contactAddress) &&
        Objects.equals(this.contactPrepageAddressId, documentInvoiceStandardGET.contactPrepageAddressId) &&
        Objects.equals(this.contactPrepageAddress, documentInvoiceStandardGET.contactPrepageAddress) &&
        Objects.equals(this.contactPersonId, documentInvoiceStandardGET.contactPersonId) &&
        Objects.equals(this.contactPerson, documentInvoiceStandardGET.contactPerson) &&
        Objects.equals(this.date, documentInvoiceStandardGET.date) &&
        Objects.equals(this.due, documentInvoiceStandardGET.due) &&
        Objects.equals(this.periodFrom, documentInvoiceStandardGET.periodFrom) &&
        Objects.equals(this.periodTo, documentInvoiceStandardGET.periodTo) &&
        Objects.equals(this.periodText, documentInvoiceStandardGET.periodText) &&
        Objects.equals(this.currency, documentInvoiceStandardGET.currency) &&
        Objects.equals(this.total, documentInvoiceStandardGET.total) &&
        Objects.equals(this.vatIncluded, documentInvoiceStandardGET.vatIncluded) &&
        Objects.equals(this.discountRate, documentInvoiceStandardGET.discountRate) &&
        Objects.equals(this.discountType, documentInvoiceStandardGET.discountType) &&
        Objects.equals(this.cashDiscountRate, documentInvoiceStandardGET.cashDiscountRate) &&
        Objects.equals(this.cashDiscountDate, documentInvoiceStandardGET.cashDiscountDate) &&
        Objects.equals(this.totalPaid, documentInvoiceStandardGET.totalPaid) &&
        Objects.equals(this.paidDate, documentInvoiceStandardGET.paidDate) &&
        Objects.equals(this.bankAccountId, documentInvoiceStandardGET.bankAccountId) &&
        Objects.equals(this.bankAccount, documentInvoiceStandardGET.bankAccount) &&
        Objects.equals(this.isrId, documentInvoiceStandardGET.isrId) &&
        Objects.equals(this.isr, documentInvoiceStandardGET.isr) &&
        Objects.equals(this.isrPosition, documentInvoiceStandardGET.isrPosition) &&
        Objects.equals(this.isrReferenceNumber, documentInvoiceStandardGET.isrReferenceNumber) &&
        Objects.equals(this.paymentLinkPaypal, documentInvoiceStandardGET.paymentLinkPaypal) &&
        Objects.equals(this.paymentLinkPaypalUrl, documentInvoiceStandardGET.paymentLinkPaypalUrl) &&
        Objects.equals(this.paymentLinkPostfinance, documentInvoiceStandardGET.paymentLinkPostfinance) &&
        Objects.equals(this.paymentLinkPostfinanceUrl, documentInvoiceStandardGET.paymentLinkPostfinanceUrl) &&
        Objects.equals(this.paymentLinkPayrexx, documentInvoiceStandardGET.paymentLinkPayrexx) &&
        Objects.equals(this.paymentLinkPayrexxUrl, documentInvoiceStandardGET.paymentLinkPayrexxUrl) &&
        Objects.equals(this.paymentLinkSmartcommerce, documentInvoiceStandardGET.paymentLinkSmartcommerce) &&
        Objects.equals(this.paymentLinkSmartcommerceUrl, documentInvoiceStandardGET.paymentLinkSmartcommerceUrl) &&
        Objects.equals(this.language, documentInvoiceStandardGET.language) &&
        Objects.equals(this.signatureId, documentInvoiceStandardGET.signatureId) &&
        Objects.equals(this.layoutId, documentInvoiceStandardGET.layoutId) &&
        Objects.equals(this.pageAmount, documentInvoiceStandardGET.pageAmount) &&
        Objects.equals(this.notes, documentInvoiceStandardGET.notes) &&
        Objects.equals(this.status, documentInvoiceStandardGET.status) &&
        Objects.equals(this.created, documentInvoiceStandardGET.created) &&
        Objects.equals(this.customFields, documentInvoiceStandardGET.customFields) &&
        Objects.equals(this.positions, documentInvoiceStandardGET.positions) &&
        Objects.equals(this.texts, documentInvoiceStandardGET.texts) &&
        Objects.equals(this.freeTexts, documentInvoiceStandardGET.freeTexts) &&
        Objects.equals(this.workflow, documentInvoiceStandardGET.workflow) &&
        Objects.equals(this.permissions, documentInvoiceStandardGET.permissions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, number, contactId, contactName, contact, contactAddressId, contactAddress, contactPrepageAddressId, contactPrepageAddress, contactPersonId, contactPerson, date, due, periodFrom, periodTo, periodText, currency, total, vatIncluded, discountRate, discountType, cashDiscountRate, cashDiscountDate, totalPaid, paidDate, bankAccountId, bankAccount, isrId, isr, isrPosition, isrReferenceNumber, paymentLinkPaypal, paymentLinkPaypalUrl, paymentLinkPostfinance, paymentLinkPostfinanceUrl, paymentLinkPayrexx, paymentLinkPayrexxUrl, paymentLinkSmartcommerce, paymentLinkSmartcommerceUrl, language, signatureId, layoutId, pageAmount, notes, status, created, customFields, positions, texts, freeTexts, workflow, permissions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DocumentInvoiceStandardGET {\n");
    
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
    sb.append("    due: ").append(toIndentedString(due)).append("\n");
    sb.append("    periodFrom: ").append(toIndentedString(periodFrom)).append("\n");
    sb.append("    periodTo: ").append(toIndentedString(periodTo)).append("\n");
    sb.append("    periodText: ").append(toIndentedString(periodText)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
    sb.append("    vatIncluded: ").append(toIndentedString(vatIncluded)).append("\n");
    sb.append("    discountRate: ").append(toIndentedString(discountRate)).append("\n");
    sb.append("    discountType: ").append(toIndentedString(discountType)).append("\n");
    sb.append("    cashDiscountRate: ").append(toIndentedString(cashDiscountRate)).append("\n");
    sb.append("    cashDiscountDate: ").append(toIndentedString(cashDiscountDate)).append("\n");
    sb.append("    totalPaid: ").append(toIndentedString(totalPaid)).append("\n");
    sb.append("    paidDate: ").append(toIndentedString(paidDate)).append("\n");
    sb.append("    bankAccountId: ").append(toIndentedString(bankAccountId)).append("\n");
    sb.append("    bankAccount: ").append(toIndentedString(bankAccount)).append("\n");
    sb.append("    isrId: ").append(toIndentedString(isrId)).append("\n");
    sb.append("    isr: ").append(toIndentedString(isr)).append("\n");
    sb.append("    isrPosition: ").append(toIndentedString(isrPosition)).append("\n");
    sb.append("    isrReferenceNumber: ").append(toIndentedString(isrReferenceNumber)).append("\n");
    sb.append("    paymentLinkPaypal: ").append(toIndentedString(paymentLinkPaypal)).append("\n");
    sb.append("    paymentLinkPaypalUrl: ").append(toIndentedString(paymentLinkPaypalUrl)).append("\n");
    sb.append("    paymentLinkPostfinance: ").append(toIndentedString(paymentLinkPostfinance)).append("\n");
    sb.append("    paymentLinkPostfinanceUrl: ").append(toIndentedString(paymentLinkPostfinanceUrl)).append("\n");
    sb.append("    paymentLinkPayrexx: ").append(toIndentedString(paymentLinkPayrexx)).append("\n");
    sb.append("    paymentLinkPayrexxUrl: ").append(toIndentedString(paymentLinkPayrexxUrl)).append("\n");
    sb.append("    paymentLinkSmartcommerce: ").append(toIndentedString(paymentLinkSmartcommerce)).append("\n");
    sb.append("    paymentLinkSmartcommerceUrl: ").append(toIndentedString(paymentLinkSmartcommerceUrl)).append("\n");
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
    sb.append("    workflow: ").append(toIndentedString(workflow)).append("\n");
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

