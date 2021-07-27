package com.example.smallinvoicespringfeign.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;

/**
 * DocumentInvoicePaymentPOST
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-27T20:43:02.724916+02:00[Europe/Zurich]")
public class DocumentInvoicePaymentPOST  implements Serializable {
  private static final long serialVersionUID = 1L;

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

  public DocumentInvoicePaymentPOST type(String type) {
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

  public DocumentInvoicePaymentPOST channel(String channel) {
    this.channel = channel;
    return this;
  }

  /**
   * channel of the payment; possible values: T - bank transfer, C - cash, PP - Paypal, PF - Postfinance, CC - Credit card, PR - Payrexx, SC - Smartcommerce
   * @return channel
  */
  @ApiModelProperty(value = "channel of the payment; possible values: T - bank transfer, C - cash, PP - Paypal, PF - Postfinance, CC - Credit card, PR - Payrexx, SC - Smartcommerce")


  public String getChannel() {
    return channel;
  }

  public void setChannel(String channel) {
    this.channel = channel;
  }

  public DocumentInvoicePaymentPOST amount(Float amount) {
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

  public DocumentInvoicePaymentPOST date(LocalDate date) {
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

  public DocumentInvoicePaymentPOST notes(String notes) {
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


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DocumentInvoicePaymentPOST documentInvoicePaymentPOST = (DocumentInvoicePaymentPOST) o;
    return Objects.equals(this.type, documentInvoicePaymentPOST.type) &&
        Objects.equals(this.channel, documentInvoicePaymentPOST.channel) &&
        Objects.equals(this.amount, documentInvoicePaymentPOST.amount) &&
        Objects.equals(this.date, documentInvoicePaymentPOST.date) &&
        Objects.equals(this.notes, documentInvoicePaymentPOST.notes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, channel, amount, date, notes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DocumentInvoicePaymentPOST {\n");
    
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    channel: ").append(toIndentedString(channel)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    notes: ").append(toIndentedString(notes)).append("\n");
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

