package com.example.smallinvoicespringfeign.model;

import java.util.Objects;
import com.example.smallinvoicespringfeign.model.DocumentSendByEmailRecipientPATCH;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;

/**
 * DocumentOfferSendByEmailPATCH
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-29T19:43:05.733009+02:00[Europe/Zurich]")
public class DocumentOfferSendByEmailPATCH  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("subject")
  private String subject;

  @JsonProperty("body")
  private String body;

  @JsonProperty("recipients")
  @Valid
  private List<DocumentSendByEmailRecipientPATCH> recipients = new ArrayList<>();

  /**
   * sender's email: if nothing specified, company's default will be applied; possible values: CO - company's email, U - user's email, S - company's SMTP email, CE - central email: no-reply@smallinvoice.com 
   */
  public enum FromEnum {
    CO("CO"),
    
    U("U"),
    
    S("S"),
    
    CE("CE");

    private String value;

    FromEnum(String value) {
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
    public static FromEnum fromValue(String value) {
      for (FromEnum b : FromEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("from")
  private FromEnum from;

  public DocumentOfferSendByEmailPATCH subject(String subject) {
    this.subject = subject;
    return this;
  }

  /**
   * email's subject
   * @return subject
  */
  @ApiModelProperty(required = true, value = "email's subject")
  @NotNull


  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public DocumentOfferSendByEmailPATCH body(String body) {
    this.body = body;
    return this;
  }

  /**
   * email's body
   * @return body
  */
  @ApiModelProperty(required = true, value = "email's body")
  @NotNull


  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public DocumentOfferSendByEmailPATCH recipients(List<DocumentSendByEmailRecipientPATCH> recipients) {
    this.recipients = recipients;
    return this;
  }

  public DocumentOfferSendByEmailPATCH addRecipientsItem(DocumentSendByEmailRecipientPATCH recipientsItem) {
    this.recipients.add(recipientsItem);
    return this;
  }

  /**
   * email's recipients
   * @return recipients
  */
  @ApiModelProperty(required = true, value = "email's recipients")
  @NotNull

  @Valid

  public List<DocumentSendByEmailRecipientPATCH> getRecipients() {
    return recipients;
  }

  public void setRecipients(List<DocumentSendByEmailRecipientPATCH> recipients) {
    this.recipients = recipients;
  }

  public DocumentOfferSendByEmailPATCH from(FromEnum from) {
    this.from = from;
    return this;
  }

  /**
   * sender's email: if nothing specified, company's default will be applied; possible values: CO - company's email, U - user's email, S - company's SMTP email, CE - central email: no-reply@smallinvoice.com 
   * @return from
  */
  @ApiModelProperty(value = "sender's email: if nothing specified, company's default will be applied; possible values: CO - company's email, U - user's email, S - company's SMTP email, CE - central email: no-reply@smallinvoice.com ")


  public FromEnum getFrom() {
    return from;
  }

  public void setFrom(FromEnum from) {
    this.from = from;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DocumentOfferSendByEmailPATCH documentOfferSendByEmailPATCH = (DocumentOfferSendByEmailPATCH) o;
    return Objects.equals(this.subject, documentOfferSendByEmailPATCH.subject) &&
        Objects.equals(this.body, documentOfferSendByEmailPATCH.body) &&
        Objects.equals(this.recipients, documentOfferSendByEmailPATCH.recipients) &&
        Objects.equals(this.from, documentOfferSendByEmailPATCH.from);
  }

  @Override
  public int hashCode() {
    return Objects.hash(subject, body, recipients, from);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DocumentOfferSendByEmailPATCH {\n");
    
    sb.append("    subject: ").append(toIndentedString(subject)).append("\n");
    sb.append("    body: ").append(toIndentedString(body)).append("\n");
    sb.append("    recipients: ").append(toIndentedString(recipients)).append("\n");
    sb.append("    from: ").append(toIndentedString(from)).append("\n");
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

