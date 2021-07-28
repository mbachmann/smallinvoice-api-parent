package com.example.smallinvoicespringfeign.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.LocalDateTime;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;

/**
 * DocumentInvoicePaymentGET
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-28T19:49:25.792053+02:00[Europe/Zurich]")
public class DocumentInvoicePaymentGET  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("id")
  private Integer id;

  @JsonProperty("type")
  private String type;

  @JsonProperty("channel")
  private String channel;

  @JsonProperty("amount")
  private Float amount;

  @JsonProperty("date")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE)
  private LocalDate date;

  @JsonProperty("notes")
  private String notes;

  @JsonProperty("created")
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
  private LocalDateTime created;

  public DocumentInvoicePaymentGET id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * payment id
   * @return id
  */
  @ApiModelProperty(required = true, value = "payment id")
  @NotNull


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public DocumentInvoicePaymentGET type(String type) {
    this.type = type;
    return this;
  }

  /**
   * type of the payment; possible values: N - normal, C - cash discount, D - rounding difference, W - write off
   * @return type
  */
  @ApiModelProperty(required = true, value = "type of the payment; possible values: N - normal, C - cash discount, D - rounding difference, W - write off")
  @NotNull


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public DocumentInvoicePaymentGET channel(String channel) {
    this.channel = channel;
    return this;
  }

  /**
   * channel of the payment; possible values: T - bank transfer, C - cash, PP - Paypal, PF - Postfinance, CC - Credit card, PR - Payrexx, SC - Smartcommerce
   * @return channel
  */
  @ApiModelProperty(required = true, value = "channel of the payment; possible values: T - bank transfer, C - cash, PP - Paypal, PF - Postfinance, CC - Credit card, PR - Payrexx, SC - Smartcommerce")
  @NotNull


  public String getChannel() {
    return channel;
  }

  public void setChannel(String channel) {
    this.channel = channel;
  }

  public DocumentInvoicePaymentGET amount(Float amount) {
    this.amount = amount;
    return this;
  }

  /**
   * amount of the payment
   * @return amount
  */
  @ApiModelProperty(required = true, value = "amount of the payment")
  @NotNull


  public Float getAmount() {
    return amount;
  }

  public void setAmount(Float amount) {
    this.amount = amount;
  }

  public DocumentInvoicePaymentGET date(LocalDate date) {
    this.date = date;
    return this;
  }

  /**
   * date that payment was made
   * @return date
  */
  @ApiModelProperty(required = true, value = "date that payment was made")
  @NotNull

  @Valid

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public DocumentInvoicePaymentGET notes(String notes) {
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

  public DocumentInvoicePaymentGET created(LocalDateTime created) {
    this.created = created;
    return this;
  }

  /**
   * date that payment was created (in the system)
   * @return created
  */
  @ApiModelProperty(required = true, value = "date that payment was created (in the system)")
  @NotNull

  @Valid

  public LocalDateTime getCreated() {
    return created;
  }

  public void setCreated(LocalDateTime created) {
    this.created = created;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DocumentInvoicePaymentGET documentInvoicePaymentGET = (DocumentInvoicePaymentGET) o;
    return Objects.equals(this.id, documentInvoicePaymentGET.id) &&
        Objects.equals(this.type, documentInvoicePaymentGET.type) &&
        Objects.equals(this.channel, documentInvoicePaymentGET.channel) &&
        Objects.equals(this.amount, documentInvoicePaymentGET.amount) &&
        Objects.equals(this.date, documentInvoicePaymentGET.date) &&
        Objects.equals(this.notes, documentInvoicePaymentGET.notes) &&
        Objects.equals(this.created, documentInvoicePaymentGET.created);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, type, channel, amount, date, notes, created);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DocumentInvoicePaymentGET {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    channel: ").append(toIndentedString(channel)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    notes: ").append(toIndentedString(notes)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
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

