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
 * InvoiceGET
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-29T19:43:05.733009+02:00[Europe/Zurich]")
public class InvoiceGET  implements Serializable {
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

  @JsonProperty("currency")
  private String currency;

  @JsonProperty("total")
  private Float total;

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

  @JsonProperty("isr_reference_number")
  private String isrReferenceNumber;

  /**
   * status of invoice, possible values: DR - draft, S - sent, P - paid, PP - partially paid, R1 - 1st reminder, R2 - 2nd reminder, R3 - 3rd reminder, R - reminder, DC - debt collection, C - cancelled, D - deleted (but still visible)
   */
  public enum StatusEnum {
    DR("DR"),
    
    S("S"),
    
    P("P"),
    
    PP("PP"),
    
    R1("R1"),
    
    R2("R2"),
    
    R3("R3"),
    
    R("R"),
    
    DC("DC"),
    
    C("C"),
    
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

  @JsonProperty("bank_account_id")
  private Integer bankAccountId;

  @JsonProperty("bank_account")
  private ConfigurationBankAccountGET bankAccount;

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

  @JsonProperty("page_amount")
  private Integer pageAmount;

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

  @JsonProperty("created")
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
  private LocalDateTime created;

  @JsonProperty("cash_discount_rate")
  private Integer cashDiscountRate;

  @JsonProperty("cash_discount_date")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE)
  private LocalDate cashDiscountDate;

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

  public InvoiceGET id(Integer id) {
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

  public InvoiceGET contactId(Integer contactId) {
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

  public InvoiceGET contactName(String contactName) {
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

  public InvoiceGET contact(ContactGET contact) {
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

  public InvoiceGET contactAddressId(Integer contactAddressId) {
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

  public InvoiceGET contactAddress(ContactAddressGET contactAddress) {
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

  public InvoiceGET contactPrepageAddressId(Integer contactPrepageAddressId) {
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

  public InvoiceGET contactPrepageAddress(ContactAddressGET contactPrepageAddress) {
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

  public InvoiceGET contactPersonId(Integer contactPersonId) {
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

  public InvoiceGET contactPerson(ContactPeopleGET contactPerson) {
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

  public InvoiceGET currency(String currency) {
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

  public InvoiceGET total(Float total) {
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

  public InvoiceGET discountRate(Float discountRate) {
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

  public InvoiceGET discountType(DiscountTypeEnum discountType) {
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

  public InvoiceGET isrReferenceNumber(String isrReferenceNumber) {
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

  public InvoiceGET status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * status of invoice, possible values: DR - draft, S - sent, P - paid, PP - partially paid, R1 - 1st reminder, R2 - 2nd reminder, R3 - 3rd reminder, R - reminder, DC - debt collection, C - cancelled, D - deleted (but still visible)
   * @return status
  */
  @ApiModelProperty(required = true, value = "status of invoice, possible values: DR - draft, S - sent, P - paid, PP - partially paid, R1 - 1st reminder, R2 - 2nd reminder, R3 - 3rd reminder, R - reminder, DC - debt collection, C - cancelled, D - deleted (but still visible)")
  @NotNull


  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public InvoiceGET isrId(Integer isrId) {
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

  public InvoiceGET isr(ReceivablesConfigurationIsrGET isr) {
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

  public InvoiceGET isrPosition(IsrPositionEnum isrPosition) {
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

  public InvoiceGET paymentLinkPaypal(Boolean paymentLinkPaypal) {
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

  public InvoiceGET paymentLinkPaypalUrl(String paymentLinkPaypalUrl) {
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

  public InvoiceGET paymentLinkPostfinance(Boolean paymentLinkPostfinance) {
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

  public InvoiceGET paymentLinkPostfinanceUrl(String paymentLinkPostfinanceUrl) {
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

  public InvoiceGET paymentLinkPayrexx(Boolean paymentLinkPayrexx) {
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

  public InvoiceGET paymentLinkPayrexxUrl(String paymentLinkPayrexxUrl) {
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

  public InvoiceGET paymentLinkSmartcommerce(Boolean paymentLinkSmartcommerce) {
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

  public InvoiceGET paymentLinkSmartcommerceUrl(String paymentLinkSmartcommerceUrl) {
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

  public InvoiceGET bankAccountId(Integer bankAccountId) {
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

  public InvoiceGET bankAccount(ConfigurationBankAccountGET bankAccount) {
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

  public InvoiceGET language(LanguageEnum language) {
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

  public InvoiceGET pageAmount(Integer pageAmount) {
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

  public InvoiceGET layoutId(Integer layoutId) {
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

  public InvoiceGET periodText(String periodText) {
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

  public InvoiceGET vatIncluded(Boolean vatIncluded) {
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

  public InvoiceGET signatureId(Integer signatureId) {
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

  public InvoiceGET notes(String notes) {
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

  public InvoiceGET created(LocalDateTime created) {
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

  public InvoiceGET cashDiscountRate(Integer cashDiscountRate) {
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

  public InvoiceGET cashDiscountDate(LocalDate cashDiscountDate) {
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

  public InvoiceGET customFields(List<DescriptiveCustomFieldGET> customFields) {
    this.customFields = customFields;
    return this;
  }

  public InvoiceGET addCustomFieldsItem(DescriptiveCustomFieldGET customFieldsItem) {
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

  public InvoiceGET positions(List<DocumentInvoicePositionGET> positions) {
    this.positions = positions;
    return this;
  }

  public InvoiceGET addPositionsItem(DocumentInvoicePositionGET positionsItem) {
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

  public InvoiceGET texts(List<DocumentInvoiceTextGET> texts) {
    this.texts = texts;
    return this;
  }

  public InvoiceGET addTextsItem(DocumentInvoiceTextGET textsItem) {
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

  public InvoiceGET freeTexts(List<DocumentFreeTextGET> freeTexts) {
    this.freeTexts = freeTexts;
    return this;
  }

  public InvoiceGET addFreeTextsItem(DocumentFreeTextGET freeTextsItem) {
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

  public InvoiceGET workflow(List<DocumentInvoiceWorkflowGET> workflow) {
    this.workflow = workflow;
    return this;
  }

  public InvoiceGET addWorkflowItem(DocumentInvoiceWorkflowGET workflowItem) {
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

  public InvoiceGET permissions(List<PermissionsEnum> permissions) {
    this.permissions = permissions;
    return this;
  }

  public InvoiceGET addPermissionsItem(PermissionsEnum permissionsItem) {
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
    InvoiceGET invoiceGET = (InvoiceGET) o;
    return Objects.equals(this.id, invoiceGET.id) &&
        Objects.equals(this.contactId, invoiceGET.contactId) &&
        Objects.equals(this.contactName, invoiceGET.contactName) &&
        Objects.equals(this.contact, invoiceGET.contact) &&
        Objects.equals(this.contactAddressId, invoiceGET.contactAddressId) &&
        Objects.equals(this.contactAddress, invoiceGET.contactAddress) &&
        Objects.equals(this.contactPrepageAddressId, invoiceGET.contactPrepageAddressId) &&
        Objects.equals(this.contactPrepageAddress, invoiceGET.contactPrepageAddress) &&
        Objects.equals(this.contactPersonId, invoiceGET.contactPersonId) &&
        Objects.equals(this.contactPerson, invoiceGET.contactPerson) &&
        Objects.equals(this.currency, invoiceGET.currency) &&
        Objects.equals(this.total, invoiceGET.total) &&
        Objects.equals(this.discountRate, invoiceGET.discountRate) &&
        Objects.equals(this.discountType, invoiceGET.discountType) &&
        Objects.equals(this.isrReferenceNumber, invoiceGET.isrReferenceNumber) &&
        Objects.equals(this.status, invoiceGET.status) &&
        Objects.equals(this.isrId, invoiceGET.isrId) &&
        Objects.equals(this.isr, invoiceGET.isr) &&
        Objects.equals(this.isrPosition, invoiceGET.isrPosition) &&
        Objects.equals(this.paymentLinkPaypal, invoiceGET.paymentLinkPaypal) &&
        Objects.equals(this.paymentLinkPaypalUrl, invoiceGET.paymentLinkPaypalUrl) &&
        Objects.equals(this.paymentLinkPostfinance, invoiceGET.paymentLinkPostfinance) &&
        Objects.equals(this.paymentLinkPostfinanceUrl, invoiceGET.paymentLinkPostfinanceUrl) &&
        Objects.equals(this.paymentLinkPayrexx, invoiceGET.paymentLinkPayrexx) &&
        Objects.equals(this.paymentLinkPayrexxUrl, invoiceGET.paymentLinkPayrexxUrl) &&
        Objects.equals(this.paymentLinkSmartcommerce, invoiceGET.paymentLinkSmartcommerce) &&
        Objects.equals(this.paymentLinkSmartcommerceUrl, invoiceGET.paymentLinkSmartcommerceUrl) &&
        Objects.equals(this.bankAccountId, invoiceGET.bankAccountId) &&
        Objects.equals(this.bankAccount, invoiceGET.bankAccount) &&
        Objects.equals(this.language, invoiceGET.language) &&
        Objects.equals(this.pageAmount, invoiceGET.pageAmount) &&
        Objects.equals(this.layoutId, invoiceGET.layoutId) &&
        Objects.equals(this.periodText, invoiceGET.periodText) &&
        Objects.equals(this.vatIncluded, invoiceGET.vatIncluded) &&
        Objects.equals(this.signatureId, invoiceGET.signatureId) &&
        Objects.equals(this.notes, invoiceGET.notes) &&
        Objects.equals(this.created, invoiceGET.created) &&
        Objects.equals(this.cashDiscountRate, invoiceGET.cashDiscountRate) &&
        Objects.equals(this.cashDiscountDate, invoiceGET.cashDiscountDate) &&
        Objects.equals(this.customFields, invoiceGET.customFields) &&
        Objects.equals(this.positions, invoiceGET.positions) &&
        Objects.equals(this.texts, invoiceGET.texts) &&
        Objects.equals(this.freeTexts, invoiceGET.freeTexts) &&
        Objects.equals(this.workflow, invoiceGET.workflow) &&
        Objects.equals(this.permissions, invoiceGET.permissions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, contactId, contactName, contact, contactAddressId, contactAddress, contactPrepageAddressId, contactPrepageAddress, contactPersonId, contactPerson, currency, total, discountRate, discountType, isrReferenceNumber, status, isrId, isr, isrPosition, paymentLinkPaypal, paymentLinkPaypalUrl, paymentLinkPostfinance, paymentLinkPostfinanceUrl, paymentLinkPayrexx, paymentLinkPayrexxUrl, paymentLinkSmartcommerce, paymentLinkSmartcommerceUrl, bankAccountId, bankAccount, language, pageAmount, layoutId, periodText, vatIncluded, signatureId, notes, created, cashDiscountRate, cashDiscountDate, customFields, positions, texts, freeTexts, workflow, permissions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InvoiceGET {\n");
    
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
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
    sb.append("    discountRate: ").append(toIndentedString(discountRate)).append("\n");
    sb.append("    discountType: ").append(toIndentedString(discountType)).append("\n");
    sb.append("    isrReferenceNumber: ").append(toIndentedString(isrReferenceNumber)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    isrId: ").append(toIndentedString(isrId)).append("\n");
    sb.append("    isr: ").append(toIndentedString(isr)).append("\n");
    sb.append("    isrPosition: ").append(toIndentedString(isrPosition)).append("\n");
    sb.append("    paymentLinkPaypal: ").append(toIndentedString(paymentLinkPaypal)).append("\n");
    sb.append("    paymentLinkPaypalUrl: ").append(toIndentedString(paymentLinkPaypalUrl)).append("\n");
    sb.append("    paymentLinkPostfinance: ").append(toIndentedString(paymentLinkPostfinance)).append("\n");
    sb.append("    paymentLinkPostfinanceUrl: ").append(toIndentedString(paymentLinkPostfinanceUrl)).append("\n");
    sb.append("    paymentLinkPayrexx: ").append(toIndentedString(paymentLinkPayrexx)).append("\n");
    sb.append("    paymentLinkPayrexxUrl: ").append(toIndentedString(paymentLinkPayrexxUrl)).append("\n");
    sb.append("    paymentLinkSmartcommerce: ").append(toIndentedString(paymentLinkSmartcommerce)).append("\n");
    sb.append("    paymentLinkSmartcommerceUrl: ").append(toIndentedString(paymentLinkSmartcommerceUrl)).append("\n");
    sb.append("    bankAccountId: ").append(toIndentedString(bankAccountId)).append("\n");
    sb.append("    bankAccount: ").append(toIndentedString(bankAccount)).append("\n");
    sb.append("    language: ").append(toIndentedString(language)).append("\n");
    sb.append("    pageAmount: ").append(toIndentedString(pageAmount)).append("\n");
    sb.append("    layoutId: ").append(toIndentedString(layoutId)).append("\n");
    sb.append("    periodText: ").append(toIndentedString(periodText)).append("\n");
    sb.append("    vatIncluded: ").append(toIndentedString(vatIncluded)).append("\n");
    sb.append("    signatureId: ").append(toIndentedString(signatureId)).append("\n");
    sb.append("    notes: ").append(toIndentedString(notes)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    cashDiscountRate: ").append(toIndentedString(cashDiscountRate)).append("\n");
    sb.append("    cashDiscountDate: ").append(toIndentedString(cashDiscountDate)).append("\n");
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

