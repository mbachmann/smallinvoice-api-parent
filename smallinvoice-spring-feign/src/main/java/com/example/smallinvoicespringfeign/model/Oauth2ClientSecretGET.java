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
 * Oauth2ClientSecretGET
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-29T11:25:10.409375+02:00[Europe/Zurich]")
public class Oauth2ClientSecretGET  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("id")
  private Integer id;

  @JsonProperty("identifier")
  private String identifier;

  @JsonProperty("secret")
  private String secret;

  public Oauth2ClientSecretGET id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * oauth client id (system id)
   * @return id
  */
  @ApiModelProperty(required = true, value = "oauth client id (system id)")
  @NotNull


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Oauth2ClientSecretGET identifier(String identifier) {
    this.identifier = identifier;
    return this;
  }

  /**
   * oauth client identifier (THE CLIENT ID used for authorization)
   * @return identifier
  */
  @ApiModelProperty(required = true, value = "oauth client identifier (THE CLIENT ID used for authorization)")
  @NotNull


  public String getIdentifier() {
    return identifier;
  }

  public void setIdentifier(String identifier) {
    this.identifier = identifier;
  }

  public Oauth2ClientSecretGET secret(String secret) {
    this.secret = secret;
    return this;
  }

  /**
   * oauth client secret  (THE CLIENT SECRET used for authorization)
   * @return secret
  */
  @ApiModelProperty(required = true, value = "oauth client secret  (THE CLIENT SECRET used for authorization)")
  @NotNull


  public String getSecret() {
    return secret;
  }

  public void setSecret(String secret) {
    this.secret = secret;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Oauth2ClientSecretGET oauth2ClientSecretGET = (Oauth2ClientSecretGET) o;
    return Objects.equals(this.id, oauth2ClientSecretGET.id) &&
        Objects.equals(this.identifier, oauth2ClientSecretGET.identifier) &&
        Objects.equals(this.secret, oauth2ClientSecretGET.secret);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, identifier, secret);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Oauth2ClientSecretGET {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    identifier: ").append(toIndentedString(identifier)).append("\n");
    sb.append("    secret: ").append(toIndentedString(secret)).append("\n");
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

