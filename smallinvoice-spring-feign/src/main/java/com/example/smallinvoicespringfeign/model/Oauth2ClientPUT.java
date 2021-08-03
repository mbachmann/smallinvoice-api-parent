package com.example.smallinvoicespringfeign.model;

import java.util.Objects;
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
 * Oauth2ClientPUT
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-08-03T10:50:58.837+02:00[Europe/Zurich]")
public class Oauth2ClientPUT  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("name")
  private String name;

  /**
   * oauth client grant type; possible values: CC - client credentials, AC - authorization code
   */
  public enum GrantTypeEnum {
    CC("CC"),
    
    AC("AC");

    private String value;

    GrantTypeEnum(String value) {
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
    public static GrantTypeEnum fromValue(String value) {
      for (GrantTypeEnum b : GrantTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("grant_type")
  private GrantTypeEnum grantType;

  @JsonProperty("redirect_uri")
  private String redirectUri;

  @JsonProperty("scopes")
  @Valid
  private List<String> scopes = null;

  public Oauth2ClientPUT name(String name) {
    this.name = name;
    return this;
  }

  /**
   * oauth client name (unique in the whole system)
   * @return name
  */
  @ApiModelProperty(value = "oauth client name (unique in the whole system)")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Oauth2ClientPUT grantType(GrantTypeEnum grantType) {
    this.grantType = grantType;
    return this;
  }

  /**
   * oauth client grant type; possible values: CC - client credentials, AC - authorization code
   * @return grantType
  */
  @ApiModelProperty(value = "oauth client grant type; possible values: CC - client credentials, AC - authorization code")


  public GrantTypeEnum getGrantType() {
    return grantType;
  }

  public void setGrantType(GrantTypeEnum grantType) {
    this.grantType = grantType;
  }

  public Oauth2ClientPUT redirectUri(String redirectUri) {
    this.redirectUri = redirectUri;
    return this;
  }

  /**
   * oauth client redirect URI (only for grant type authorization code)
   * @return redirectUri
  */
  @ApiModelProperty(value = "oauth client redirect URI (only for grant type authorization code)")


  public String getRedirectUri() {
    return redirectUri;
  }

  public void setRedirectUri(String redirectUri) {
    this.redirectUri = redirectUri;
  }

  public Oauth2ClientPUT scopes(List<String> scopes) {
    this.scopes = scopes;
    return this;
  }

  public Oauth2ClientPUT addScopesItem(String scopesItem) {
    if (this.scopes == null) {
      this.scopes = new ArrayList<>();
    }
    this.scopes.add(scopesItem);
    return this;
  }

  /**
   * oauth client scopes
   * @return scopes
  */
  @ApiModelProperty(value = "oauth client scopes")


  public List<String> getScopes() {
    return scopes;
  }

  public void setScopes(List<String> scopes) {
    this.scopes = scopes;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Oauth2ClientPUT oauth2ClientPUT = (Oauth2ClientPUT) o;
    return Objects.equals(this.name, oauth2ClientPUT.name) &&
        Objects.equals(this.grantType, oauth2ClientPUT.grantType) &&
        Objects.equals(this.redirectUri, oauth2ClientPUT.redirectUri) &&
        Objects.equals(this.scopes, oauth2ClientPUT.scopes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, grantType, redirectUri, scopes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Oauth2ClientPUT {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    grantType: ").append(toIndentedString(grantType)).append("\n");
    sb.append("    redirectUri: ").append(toIndentedString(redirectUri)).append("\n");
    sb.append("    scopes: ").append(toIndentedString(scopes)).append("\n");
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

