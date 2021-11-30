package com.example.smallinvoicespringfeign.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
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
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-11-30T10:06:31.741+01:00[Europe/Zurich]")
public class DocumentInvoicePaymentPOST  implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * type of the payment; possible values: N - normal, C - cash discount, D - rounding difference, W - write off
   */
  public enum TypeEnum {
    N("N"),
    
    C("C"),
    
    D("D"),
    
    W("W");

    private String value;

    TypeEnum(String value) {
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
    public static TypeEnum fromValue(String value) {
      for (TypeEnum b : TypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("type")
  private TypeEnum type;

  /**
   * channel of the payment; possible values: T - bank transfer, C - cash, PP - Paypal, PF - Postfinance, CC - Credit card, PR - Payrexx, SC - Smartcommerce
   */
  public enum ChannelEnum {
    T("T"),
    
    C("C"),
    
    PP("PP"),
    
    PF("PF"),
    
    CC("CC"),
    
    PR("PR"),
    
    SC("SC");

    private String value;

    ChannelEnum(String value) {
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
    public static ChannelEnum fromValue(String value) {
      for (ChannelEnum b : ChannelEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("channel")
  private ChannelEnum channel;

  @JsonProperty("amount")
  private Float amount;

  @JsonProperty("date")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE)
  private LocalDate date;

  @JsonProperty("notes")
  private String notes;

  public DocumentInvoicePaymentPOST type(TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * type of the payment; possible values: N - normal, C - cash discount, D - rounding difference, W - write off
   * @return type
  */
  @ApiModelProperty(required = true, value = "type of the payment; possible values: N - normal, C - cash discount, D - rounding difference, W - write off")
  @NotNull


  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public DocumentInvoicePaymentPOST channel(ChannelEnum channel) {
    this.channel = channel;
    return this;
  }

  /**
   * channel of the payment; possible values: T - bank transfer, C - cash, PP - Paypal, PF - Postfinance, CC - Credit card, PR - Payrexx, SC - Smartcommerce
   * @return channel
  */
  @ApiModelProperty(value = "channel of the payment; possible values: T - bank transfer, C - cash, PP - Paypal, PF - Postfinance, CC - Credit card, PR - Payrexx, SC - Smartcommerce")


  public ChannelEnum getChannel() {
    return channel;
  }

  public void setChannel(ChannelEnum channel) {
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

