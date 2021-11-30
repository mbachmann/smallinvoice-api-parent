package com.example.smallinvoicespringfeign.model;

import java.util.Objects;
import com.example.smallinvoicespringfeign.model.DescriptiveAccountingCostPOST;
import com.example.smallinvoicespringfeign.model.DescriptiveAccountingInvoicePOST;
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
 * AccountingRequestPOST
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-11-30T10:06:31.741+01:00[Europe/Zurich]")
public class AccountingRequestPOST  implements Serializable {
  private static final long serialVersionUID = 1L;

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
  private List<DescriptiveAccountingInvoicePOST> dataInvoice = new ArrayList<>();

  @JsonProperty("data_invoice_vat")
  @Valid
  private List<Float> dataInvoiceVat = new ArrayList<>();

  @JsonProperty("data_cost")
  @Valid
  private List<DescriptiveAccountingCostPOST> dataCost = new ArrayList<>();

  @JsonProperty("data_cost_vat")
  @Valid
  private List<Float> dataCostVat = new ArrayList<>();

  @JsonProperty("data_cost_category_count")
  private Integer dataCostCategoryCount;

  public AccountingRequestPOST category(CategoryEnum category) {
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

  public AccountingRequestPOST periodFrom(LocalDate periodFrom) {
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

  public AccountingRequestPOST periodTo(LocalDate periodTo) {
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

  public AccountingRequestPOST latestDelivery(LocalDate latestDelivery) {
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

  public AccountingRequestPOST legalCountry(String legalCountry) {
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

  public AccountingRequestPOST legalForm(LegalFormEnum legalForm) {
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

  public AccountingRequestPOST contactPerson(String contactPerson) {
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

  public AccountingRequestPOST contactPhone(String contactPhone) {
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

  public AccountingRequestPOST contactEmail(String contactEmail) {
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

  public AccountingRequestPOST comment(String comment) {
    this.comment = comment;
    return this;
  }

  /**
   * optional comment
   * @return comment
  */
  @ApiModelProperty(value = "optional comment")


  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public AccountingRequestPOST dataInvoice(List<DescriptiveAccountingInvoicePOST> dataInvoice) {
    this.dataInvoice = dataInvoice;
    return this;
  }

  public AccountingRequestPOST addDataInvoiceItem(DescriptiveAccountingInvoicePOST dataInvoiceItem) {
    this.dataInvoice.add(dataInvoiceItem);
    return this;
  }

  /**
   * amounts of invoices in a period
   * @return dataInvoice
  */
  @ApiModelProperty(required = true, value = "amounts of invoices in a period")
  @NotNull

  @Valid

  public List<DescriptiveAccountingInvoicePOST> getDataInvoice() {
    return dataInvoice;
  }

  public void setDataInvoice(List<DescriptiveAccountingInvoicePOST> dataInvoice) {
    this.dataInvoice = dataInvoice;
  }

  public AccountingRequestPOST dataInvoiceVat(List<Float> dataInvoiceVat) {
    this.dataInvoiceVat = dataInvoiceVat;
    return this;
  }

  public AccountingRequestPOST addDataInvoiceVatItem(Float dataInvoiceVatItem) {
    this.dataInvoiceVat.add(dataInvoiceVatItem);
    return this;
  }

  /**
   * invoiced VAT rates
   * @return dataInvoiceVat
  */
  @ApiModelProperty(required = true, value = "invoiced VAT rates")
  @NotNull


  public List<Float> getDataInvoiceVat() {
    return dataInvoiceVat;
  }

  public void setDataInvoiceVat(List<Float> dataInvoiceVat) {
    this.dataInvoiceVat = dataInvoiceVat;
  }

  public AccountingRequestPOST dataCost(List<DescriptiveAccountingCostPOST> dataCost) {
    this.dataCost = dataCost;
    return this;
  }

  public AccountingRequestPOST addDataCostItem(DescriptiveAccountingCostPOST dataCostItem) {
    this.dataCost.add(dataCostItem);
    return this;
  }

  /**
   * amounts of costs in a period
   * @return dataCost
  */
  @ApiModelProperty(required = true, value = "amounts of costs in a period")
  @NotNull

  @Valid

  public List<DescriptiveAccountingCostPOST> getDataCost() {
    return dataCost;
  }

  public void setDataCost(List<DescriptiveAccountingCostPOST> dataCost) {
    this.dataCost = dataCost;
  }

  public AccountingRequestPOST dataCostVat(List<Float> dataCostVat) {
    this.dataCostVat = dataCostVat;
    return this;
  }

  public AccountingRequestPOST addDataCostVatItem(Float dataCostVatItem) {
    this.dataCostVat.add(dataCostVatItem);
    return this;
  }

  /**
   * received VAT rates
   * @return dataCostVat
  */
  @ApiModelProperty(required = true, value = "received VAT rates")
  @NotNull


  public List<Float> getDataCostVat() {
    return dataCostVat;
  }

  public void setDataCostVat(List<Float> dataCostVat) {
    this.dataCostVat = dataCostVat;
  }

  public AccountingRequestPOST dataCostCategoryCount(Integer dataCostCategoryCount) {
    this.dataCostCategoryCount = dataCostCategoryCount;
    return this;
  }

  /**
   * amount of cost categories
   * @return dataCostCategoryCount
  */
  @ApiModelProperty(required = true, value = "amount of cost categories")
  @NotNull


  public Integer getDataCostCategoryCount() {
    return dataCostCategoryCount;
  }

  public void setDataCostCategoryCount(Integer dataCostCategoryCount) {
    this.dataCostCategoryCount = dataCostCategoryCount;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountingRequestPOST accountingRequestPOST = (AccountingRequestPOST) o;
    return Objects.equals(this.category, accountingRequestPOST.category) &&
        Objects.equals(this.periodFrom, accountingRequestPOST.periodFrom) &&
        Objects.equals(this.periodTo, accountingRequestPOST.periodTo) &&
        Objects.equals(this.latestDelivery, accountingRequestPOST.latestDelivery) &&
        Objects.equals(this.legalCountry, accountingRequestPOST.legalCountry) &&
        Objects.equals(this.legalForm, accountingRequestPOST.legalForm) &&
        Objects.equals(this.contactPerson, accountingRequestPOST.contactPerson) &&
        Objects.equals(this.contactPhone, accountingRequestPOST.contactPhone) &&
        Objects.equals(this.contactEmail, accountingRequestPOST.contactEmail) &&
        Objects.equals(this.comment, accountingRequestPOST.comment) &&
        Objects.equals(this.dataInvoice, accountingRequestPOST.dataInvoice) &&
        Objects.equals(this.dataInvoiceVat, accountingRequestPOST.dataInvoiceVat) &&
        Objects.equals(this.dataCost, accountingRequestPOST.dataCost) &&
        Objects.equals(this.dataCostVat, accountingRequestPOST.dataCostVat) &&
        Objects.equals(this.dataCostCategoryCount, accountingRequestPOST.dataCostCategoryCount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(category, periodFrom, periodTo, latestDelivery, legalCountry, legalForm, contactPerson, contactPhone, contactEmail, comment, dataInvoice, dataInvoiceVat, dataCost, dataCostVat, dataCostCategoryCount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountingRequestPOST {\n");
    
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    periodFrom: ").append(toIndentedString(periodFrom)).append("\n");
    sb.append("    periodTo: ").append(toIndentedString(periodTo)).append("\n");
    sb.append("    latestDelivery: ").append(toIndentedString(latestDelivery)).append("\n");
    sb.append("    legalCountry: ").append(toIndentedString(legalCountry)).append("\n");
    sb.append("    legalForm: ").append(toIndentedString(legalForm)).append("\n");
    sb.append("    contactPerson: ").append(toIndentedString(contactPerson)).append("\n");
    sb.append("    contactPhone: ").append(toIndentedString(contactPhone)).append("\n");
    sb.append("    contactEmail: ").append(toIndentedString(contactEmail)).append("\n");
    sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
    sb.append("    dataInvoice: ").append(toIndentedString(dataInvoice)).append("\n");
    sb.append("    dataInvoiceVat: ").append(toIndentedString(dataInvoiceVat)).append("\n");
    sb.append("    dataCost: ").append(toIndentedString(dataCost)).append("\n");
    sb.append("    dataCostVat: ").append(toIndentedString(dataCostVat)).append("\n");
    sb.append("    dataCostCategoryCount: ").append(toIndentedString(dataCostCategoryCount)).append("\n");
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

