package com.example.smallinvoicespringfeign.model;

import java.util.Objects;
import com.example.smallinvoicespringfeign.model.DescriptiveAccountingCostGET;
import com.example.smallinvoicespringfeign.model.DescriptiveAccountingInvoiceGET;
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
 * AccountingRequestGET
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-08-03T11:25:04.200+02:00[Europe/Zurich]")
public class AccountingRequestGET  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("id")
  private Integer id;

  /**
   * category of the request; possible values: V - VAT statement, FS - Annual financial statement
   */
  public enum CategoryEnum {
    V("V"),
    
    FS("FS");

    private String value;

    CategoryEnum(String value) {
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
    public static CategoryEnum fromValue(String value) {
      for (CategoryEnum b : CategoryEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("category")
  private CategoryEnum category;

  @JsonProperty("period_from")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE)
  private LocalDate periodFrom;

  @JsonProperty("period_to")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE)
  private LocalDate periodTo;

  @JsonProperty("latest_delivery")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE)
  private LocalDate latestDelivery;

  @JsonProperty("legal_country")
  private String legalCountry;

  /**
   * legal form; possible values: SE - Sole proprietorship, LLC - GmbH, L - AG, LP - General partnership
   */
  public enum LegalFormEnum {
    SE("SE"),
    
    LLC("LLC"),
    
    L("L"),
    
    LP("LP");

    private String value;

    LegalFormEnum(String value) {
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
    public static LegalFormEnum fromValue(String value) {
      for (LegalFormEnum b : LegalFormEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("legal_form")
  private LegalFormEnum legalForm;

  @JsonProperty("contact_company")
  private String contactCompany;

  @JsonProperty("contact_address")
  private String contactAddress;

  @JsonProperty("contact_person")
  private String contactPerson;

  @JsonProperty("contact_phone")
  private String contactPhone;

  @JsonProperty("contact_email")
  private String contactEmail;

  @JsonProperty("comment")
  private String comment;

  @JsonProperty("data_invoice")
  @Valid
  private List<DescriptiveAccountingInvoiceGET> dataInvoice = null;

  @JsonProperty("data_invoice_vat")
  @Valid
  private List<Float> dataInvoiceVat = null;

  @JsonProperty("data_cost")
  @Valid
  private List<DescriptiveAccountingCostGET> dataCost = null;

  @JsonProperty("data_cost_vat")
  @Valid
  private List<Float> dataCostVat = null;

  @JsonProperty("data_cost_category_count")
  private Integer dataCostCategoryCount;

  /**
   * status of the request; possible values: O - Open, C - Cancelled, A - Awarded
   */
  public enum StatusEnum {
    O("O"),
    
    C("C"),
    
    A("A");

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
  private StatusEnum status = StatusEnum.O;

  @JsonProperty("offer_count")
  private Integer offerCount;

  @JsonProperty("offer_awarded_id")
  private Integer offerAwardedId;

  @JsonProperty("offer_awarded_company_name")
  private String offerAwardedCompanyName;

  @JsonProperty("created")
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
  private LocalDateTime created;

  /**
   * Gets or Sets permissions
   */
  public enum PermissionsEnum {
    VIEW("view"),
    
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

  public AccountingRequestGET id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * id of the request
   * @return id
  */
  @ApiModelProperty(required = true, value = "id of the request")
  @NotNull


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public AccountingRequestGET category(CategoryEnum category) {
    this.category = category;
    return this;
  }

  /**
   * category of the request; possible values: V - VAT statement, FS - Annual financial statement
   * @return category
  */
  @ApiModelProperty(required = true, value = "category of the request; possible values: V - VAT statement, FS - Annual financial statement")
  @NotNull


  public CategoryEnum getCategory() {
    return category;
  }

  public void setCategory(CategoryEnum category) {
    this.category = category;
  }

  public AccountingRequestGET periodFrom(LocalDate periodFrom) {
    this.periodFrom = periodFrom;
    return this;
  }

  /**
   * start of an accounting period
   * @return periodFrom
  */
  @ApiModelProperty(required = true, value = "start of an accounting period")
  @NotNull

  @Valid

  public LocalDate getPeriodFrom() {
    return periodFrom;
  }

  public void setPeriodFrom(LocalDate periodFrom) {
    this.periodFrom = periodFrom;
  }

  public AccountingRequestGET periodTo(LocalDate periodTo) {
    this.periodTo = periodTo;
    return this;
  }

  /**
   * end of an accounting period
   * @return periodTo
  */
  @ApiModelProperty(required = true, value = "end of an accounting period")
  @NotNull

  @Valid

  public LocalDate getPeriodTo() {
    return periodTo;
  }

  public void setPeriodTo(LocalDate periodTo) {
    this.periodTo = periodTo;
  }

  public AccountingRequestGET latestDelivery(LocalDate latestDelivery) {
    this.latestDelivery = latestDelivery;
    return this;
  }

  /**
   * date of latest accepted delivery
   * @return latestDelivery
  */
  @ApiModelProperty(required = true, value = "date of latest accepted delivery")
  @NotNull

  @Valid

  public LocalDate getLatestDelivery() {
    return latestDelivery;
  }

  public void setLatestDelivery(LocalDate latestDelivery) {
    this.latestDelivery = latestDelivery;
  }

  public AccountingRequestGET legalCountry(String legalCountry) {
    this.legalCountry = legalCountry;
    return this;
  }

  /**
   * country ISO2
   * @return legalCountry
  */
  @ApiModelProperty(required = true, value = "country ISO2")
  @NotNull


  public String getLegalCountry() {
    return legalCountry;
  }

  public void setLegalCountry(String legalCountry) {
    this.legalCountry = legalCountry;
  }

  public AccountingRequestGET legalForm(LegalFormEnum legalForm) {
    this.legalForm = legalForm;
    return this;
  }

  /**
   * legal form; possible values: SE - Sole proprietorship, LLC - GmbH, L - AG, LP - General partnership
   * @return legalForm
  */
  @ApiModelProperty(required = true, value = "legal form; possible values: SE - Sole proprietorship, LLC - GmbH, L - AG, LP - General partnership")
  @NotNull


  public LegalFormEnum getLegalForm() {
    return legalForm;
  }

  public void setLegalForm(LegalFormEnum legalForm) {
    this.legalForm = legalForm;
  }

  public AccountingRequestGET contactCompany(String contactCompany) {
    this.contactCompany = contactCompany;
    return this;
  }

  /**
   * company name
   * @return contactCompany
  */
  @ApiModelProperty(required = true, value = "company name")
  @NotNull


  public String getContactCompany() {
    return contactCompany;
  }

  public void setContactCompany(String contactCompany) {
    this.contactCompany = contactCompany;
  }

  public AccountingRequestGET contactAddress(String contactAddress) {
    this.contactAddress = contactAddress;
    return this;
  }

  /**
   * company address
   * @return contactAddress
  */
  @ApiModelProperty(required = true, value = "company address")
  @NotNull


  public String getContactAddress() {
    return contactAddress;
  }

  public void setContactAddress(String contactAddress) {
    this.contactAddress = contactAddress;
  }

  public AccountingRequestGET contactPerson(String contactPerson) {
    this.contactPerson = contactPerson;
    return this;
  }

  /**
   * company contact person name
   * @return contactPerson
  */
  @ApiModelProperty(required = true, value = "company contact person name")
  @NotNull


  public String getContactPerson() {
    return contactPerson;
  }

  public void setContactPerson(String contactPerson) {
    this.contactPerson = contactPerson;
  }

  public AccountingRequestGET contactPhone(String contactPhone) {
    this.contactPhone = contactPhone;
    return this;
  }

  /**
   * company contact phone number
   * @return contactPhone
  */
  @ApiModelProperty(required = true, value = "company contact phone number")
  @NotNull


  public String getContactPhone() {
    return contactPhone;
  }

  public void setContactPhone(String contactPhone) {
    this.contactPhone = contactPhone;
  }

  public AccountingRequestGET contactEmail(String contactEmail) {
    this.contactEmail = contactEmail;
    return this;
  }

  /**
   * company contact email address
   * @return contactEmail
  */
  @ApiModelProperty(required = true, value = "company contact email address")
  @NotNull


  public String getContactEmail() {
    return contactEmail;
  }

  public void setContactEmail(String contactEmail) {
    this.contactEmail = contactEmail;
  }

  public AccountingRequestGET comment(String comment) {
    this.comment = comment;
    return this;
  }

  /**
   * optional comment
   * @return comment
  */
  @ApiModelProperty(required = true, value = "optional comment")
  @NotNull


  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public AccountingRequestGET dataInvoice(List<DescriptiveAccountingInvoiceGET> dataInvoice) {
    this.dataInvoice = dataInvoice;
    return this;
  }

  public AccountingRequestGET addDataInvoiceItem(DescriptiveAccountingInvoiceGET dataInvoiceItem) {
    if (this.dataInvoice == null) {
      this.dataInvoice = new ArrayList<>();
    }
    this.dataInvoice.add(dataInvoiceItem);
    return this;
  }

  /**
   * amounts of invoices in a period
   * @return dataInvoice
  */
  @ApiModelProperty(value = "amounts of invoices in a period")

  @Valid

  public List<DescriptiveAccountingInvoiceGET> getDataInvoice() {
    return dataInvoice;
  }

  public void setDataInvoice(List<DescriptiveAccountingInvoiceGET> dataInvoice) {
    this.dataInvoice = dataInvoice;
  }

  public AccountingRequestGET dataInvoiceVat(List<Float> dataInvoiceVat) {
    this.dataInvoiceVat = dataInvoiceVat;
    return this;
  }

  public AccountingRequestGET addDataInvoiceVatItem(Float dataInvoiceVatItem) {
    if (this.dataInvoiceVat == null) {
      this.dataInvoiceVat = new ArrayList<>();
    }
    this.dataInvoiceVat.add(dataInvoiceVatItem);
    return this;
  }

  /**
   * invoiced VAT rates
   * @return dataInvoiceVat
  */
  @ApiModelProperty(value = "invoiced VAT rates")


  public List<Float> getDataInvoiceVat() {
    return dataInvoiceVat;
  }

  public void setDataInvoiceVat(List<Float> dataInvoiceVat) {
    this.dataInvoiceVat = dataInvoiceVat;
  }

  public AccountingRequestGET dataCost(List<DescriptiveAccountingCostGET> dataCost) {
    this.dataCost = dataCost;
    return this;
  }

  public AccountingRequestGET addDataCostItem(DescriptiveAccountingCostGET dataCostItem) {
    if (this.dataCost == null) {
      this.dataCost = new ArrayList<>();
    }
    this.dataCost.add(dataCostItem);
    return this;
  }

  /**
   * amounts of costs in a period
   * @return dataCost
  */
  @ApiModelProperty(value = "amounts of costs in a period")

  @Valid

  public List<DescriptiveAccountingCostGET> getDataCost() {
    return dataCost;
  }

  public void setDataCost(List<DescriptiveAccountingCostGET> dataCost) {
    this.dataCost = dataCost;
  }

  public AccountingRequestGET dataCostVat(List<Float> dataCostVat) {
    this.dataCostVat = dataCostVat;
    return this;
  }

  public AccountingRequestGET addDataCostVatItem(Float dataCostVatItem) {
    if (this.dataCostVat == null) {
      this.dataCostVat = new ArrayList<>();
    }
    this.dataCostVat.add(dataCostVatItem);
    return this;
  }

  /**
   * received VAT rates
   * @return dataCostVat
  */
  @ApiModelProperty(value = "received VAT rates")


  public List<Float> getDataCostVat() {
    return dataCostVat;
  }

  public void setDataCostVat(List<Float> dataCostVat) {
    this.dataCostVat = dataCostVat;
  }

  public AccountingRequestGET dataCostCategoryCount(Integer dataCostCategoryCount) {
    this.dataCostCategoryCount = dataCostCategoryCount;
    return this;
  }

  /**
   * amount of cost categories
   * @return dataCostCategoryCount
  */
  @ApiModelProperty(value = "amount of cost categories")


  public Integer getDataCostCategoryCount() {
    return dataCostCategoryCount;
  }

  public void setDataCostCategoryCount(Integer dataCostCategoryCount) {
    this.dataCostCategoryCount = dataCostCategoryCount;
  }

  public AccountingRequestGET status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * status of the request; possible values: O - Open, C - Cancelled, A - Awarded
   * @return status
  */
  @ApiModelProperty(required = true, value = "status of the request; possible values: O - Open, C - Cancelled, A - Awarded")
  @NotNull


  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public AccountingRequestGET offerCount(Integer offerCount) {
    this.offerCount = offerCount;
    return this;
  }

  /**
   * how many offers were made for the request
   * @return offerCount
  */
  @ApiModelProperty(required = true, value = "how many offers were made for the request")
  @NotNull


  public Integer getOfferCount() {
    return offerCount;
  }

  public void setOfferCount(Integer offerCount) {
    this.offerCount = offerCount;
  }

  public AccountingRequestGET offerAwardedId(Integer offerAwardedId) {
    this.offerAwardedId = offerAwardedId;
    return this;
  }

  /**
   * id of the offer that was accepted for the request
   * @return offerAwardedId
  */
  @ApiModelProperty(required = true, value = "id of the offer that was accepted for the request")
  @NotNull


  public Integer getOfferAwardedId() {
    return offerAwardedId;
  }

  public void setOfferAwardedId(Integer offerAwardedId) {
    this.offerAwardedId = offerAwardedId;
  }

  public AccountingRequestGET offerAwardedCompanyName(String offerAwardedCompanyName) {
    this.offerAwardedCompanyName = offerAwardedCompanyName;
    return this;
  }

  /**
   * name of the company that offer was accepted for the request
   * @return offerAwardedCompanyName
  */
  @ApiModelProperty(required = true, value = "name of the company that offer was accepted for the request")
  @NotNull


  public String getOfferAwardedCompanyName() {
    return offerAwardedCompanyName;
  }

  public void setOfferAwardedCompanyName(String offerAwardedCompanyName) {
    this.offerAwardedCompanyName = offerAwardedCompanyName;
  }

  public AccountingRequestGET created(LocalDateTime created) {
    this.created = created;
    return this;
  }

  /**
   * date & time of creating the request
   * @return created
  */
  @ApiModelProperty(required = true, value = "date & time of creating the request")
  @NotNull

  @Valid

  public LocalDateTime getCreated() {
    return created;
  }

  public void setCreated(LocalDateTime created) {
    this.created = created;
  }

  public AccountingRequestGET permissions(List<PermissionsEnum> permissions) {
    this.permissions = permissions;
    return this;
  }

  public AccountingRequestGET addPermissionsItem(PermissionsEnum permissionsItem) {
    if (this.permissions == null) {
      this.permissions = new ArrayList<>();
    }
    this.permissions.add(permissionsItem);
    return this;
  }

  /**
   * actions that can be performed on an item (possible values: view, manage) 
   * @return permissions
  */
  @ApiModelProperty(value = "actions that can be performed on an item (possible values: view, manage) ")


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
    AccountingRequestGET accountingRequestGET = (AccountingRequestGET) o;
    return Objects.equals(this.id, accountingRequestGET.id) &&
        Objects.equals(this.category, accountingRequestGET.category) &&
        Objects.equals(this.periodFrom, accountingRequestGET.periodFrom) &&
        Objects.equals(this.periodTo, accountingRequestGET.periodTo) &&
        Objects.equals(this.latestDelivery, accountingRequestGET.latestDelivery) &&
        Objects.equals(this.legalCountry, accountingRequestGET.legalCountry) &&
        Objects.equals(this.legalForm, accountingRequestGET.legalForm) &&
        Objects.equals(this.contactCompany, accountingRequestGET.contactCompany) &&
        Objects.equals(this.contactAddress, accountingRequestGET.contactAddress) &&
        Objects.equals(this.contactPerson, accountingRequestGET.contactPerson) &&
        Objects.equals(this.contactPhone, accountingRequestGET.contactPhone) &&
        Objects.equals(this.contactEmail, accountingRequestGET.contactEmail) &&
        Objects.equals(this.comment, accountingRequestGET.comment) &&
        Objects.equals(this.dataInvoice, accountingRequestGET.dataInvoice) &&
        Objects.equals(this.dataInvoiceVat, accountingRequestGET.dataInvoiceVat) &&
        Objects.equals(this.dataCost, accountingRequestGET.dataCost) &&
        Objects.equals(this.dataCostVat, accountingRequestGET.dataCostVat) &&
        Objects.equals(this.dataCostCategoryCount, accountingRequestGET.dataCostCategoryCount) &&
        Objects.equals(this.status, accountingRequestGET.status) &&
        Objects.equals(this.offerCount, accountingRequestGET.offerCount) &&
        Objects.equals(this.offerAwardedId, accountingRequestGET.offerAwardedId) &&
        Objects.equals(this.offerAwardedCompanyName, accountingRequestGET.offerAwardedCompanyName) &&
        Objects.equals(this.created, accountingRequestGET.created) &&
        Objects.equals(this.permissions, accountingRequestGET.permissions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, category, periodFrom, periodTo, latestDelivery, legalCountry, legalForm, contactCompany, contactAddress, contactPerson, contactPhone, contactEmail, comment, dataInvoice, dataInvoiceVat, dataCost, dataCostVat, dataCostCategoryCount, status, offerCount, offerAwardedId, offerAwardedCompanyName, created, permissions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountingRequestGET {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    periodFrom: ").append(toIndentedString(periodFrom)).append("\n");
    sb.append("    periodTo: ").append(toIndentedString(periodTo)).append("\n");
    sb.append("    latestDelivery: ").append(toIndentedString(latestDelivery)).append("\n");
    sb.append("    legalCountry: ").append(toIndentedString(legalCountry)).append("\n");
    sb.append("    legalForm: ").append(toIndentedString(legalForm)).append("\n");
    sb.append("    contactCompany: ").append(toIndentedString(contactCompany)).append("\n");
    sb.append("    contactAddress: ").append(toIndentedString(contactAddress)).append("\n");
    sb.append("    contactPerson: ").append(toIndentedString(contactPerson)).append("\n");
    sb.append("    contactPhone: ").append(toIndentedString(contactPhone)).append("\n");
    sb.append("    contactEmail: ").append(toIndentedString(contactEmail)).append("\n");
    sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
    sb.append("    dataInvoice: ").append(toIndentedString(dataInvoice)).append("\n");
    sb.append("    dataInvoiceVat: ").append(toIndentedString(dataInvoiceVat)).append("\n");
    sb.append("    dataCost: ").append(toIndentedString(dataCost)).append("\n");
    sb.append("    dataCostVat: ").append(toIndentedString(dataCostVat)).append("\n");
    sb.append("    dataCostCategoryCount: ").append(toIndentedString(dataCostCategoryCount)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    offerCount: ").append(toIndentedString(offerCount)).append("\n");
    sb.append("    offerAwardedId: ").append(toIndentedString(offerAwardedId)).append("\n");
    sb.append("    offerAwardedCompanyName: ").append(toIndentedString(offerAwardedCompanyName)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
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

