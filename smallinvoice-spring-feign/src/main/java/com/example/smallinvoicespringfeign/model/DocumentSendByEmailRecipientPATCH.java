package com.example.smallinvoicespringfeign.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;

/**
 * DocumentSendByEmailRecipientPATCH
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-27T20:43:02.724916+02:00[Europe/Zurich]")
public class DocumentSendByEmailRecipientPATCH  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("email")
  private String email;

  @JsonProperty("name")
  private String name;

  public DocumentSendByEmailRecipientPATCH email(String email) {
    this.email = email;
    return this;
  }

  /**
   * recipients's email address
   * @return email
  */
  @ApiModelProperty(required = true, value = "recipients's email address")
  @NotNull


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public DocumentSendByEmailRecipientPATCH name(String name) {
    this.name = name;
    return this;
  }

  /**
   * recipient's name
   * @return name
  */
  @ApiModelProperty(required = true, value = "recipient's name")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DocumentSendByEmailRecipientPATCH documentSendByEmailRecipientPATCH = (DocumentSendByEmailRecipientPATCH) o;
    return Objects.equals(this.email, documentSendByEmailRecipientPATCH.email) &&
        Objects.equals(this.name, documentSendByEmailRecipientPATCH.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(email, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DocumentSendByEmailRecipientPATCH {\n");
    
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

