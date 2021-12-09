package com.example.smallinvoicespringfeign.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
 * Oauth2ClientGET
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-12-09T09:40:26.748128+01:00[Europe/Zurich]")
public class Oauth2ClientGET  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("id")
  private Integer id;

  @JsonProperty("identifier")
  private String identifier;

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
  private List<String> scopes = new ArrayList<>();

  @JsonProperty("revoked")
  private Boolean revoked;

  @JsonProperty("created")
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
  private LocalDateTime created;

  public Oauth2ClientGET id(Integer id) {
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

  public Oauth2ClientGET identifier(String identifier) {
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

  public Oauth2ClientGET name(String name) {
    this.name = name;
    return this;
  }

  /**
   * oauth client name (unique in the whole system)
   * @return name
  */
  @ApiModelProperty(required = true, value = "oauth client name (unique in the whole system)")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Oauth2ClientGET grantType(GrantTypeEnum grantType) {
    this.grantType = grantType;
    return this;
  }

  /**
   * oauth client grant type; possible values: CC - client credentials, AC - authorization code
   * @return grantType
  */
  @ApiModelProperty(required = true, value = "oauth client grant type; possible values: CC - client credentials, AC - authorization code")
  @NotNull


  public GrantTypeEnum getGrantType() {
    return grantType;
  }

  public void setGrantType(GrantTypeEnum grantType) {
    this.grantType = grantType;
  }

  public Oauth2ClientGET redirectUri(String redirectUri) {
    this.redirectUri = redirectUri;
    return this;
  }

  /**
   * oauth client redirect URI (only for grant type authorization code)
   * @return redirectUri
  */
  @ApiModelProperty(required = true, value = "oauth client redirect URI (only for grant type authorization code)")
  @NotNull


  public String getRedirectUri() {
    return redirectUri;
  }

  public void setRedirectUri(String redirectUri) {
    this.redirectUri = redirectUri;
  }

  public Oauth2ClientGET scopes(List<String> scopes) {
    this.scopes = scopes;
    return this;
  }

  public Oauth2ClientGET addScopesItem(String scopesItem) {
    this.scopes.add(scopesItem);
    return this;
  }

  /**
   * oauth client scopes
   * @return scopes
  */
  @ApiModelProperty(required = true, value = "oauth client scopes")
  @NotNull


  public List<String> getScopes() {
    return scopes;
  }

  public void setScopes(List<String> scopes) {
    this.scopes = scopes;
  }

  public Oauth2ClientGET revoked(Boolean revoked) {
    this.revoked = revoked;
    return this;
  }

  /**
   * is oauth client revoked
   * @return revoked
  */
  @ApiModelProperty(required = true, value = "is oauth client revoked")
  @NotNull


  public Boolean getRevoked() {
    return revoked;
  }

  public void setRevoked(Boolean revoked) {
    this.revoked = revoked;
  }

  public Oauth2ClientGET created(LocalDateTime created) {
    this.created = created;
    return this;
  }

  /**
   * when was oauth client created
   * @return created
  */
  @ApiModelProperty(required = true, value = "when was oauth client created")
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
    Oauth2ClientGET oauth2ClientGET = (Oauth2ClientGET) o;
    return Objects.equals(this.id, oauth2ClientGET.id) &&
        Objects.equals(this.identifier, oauth2ClientGET.identifier) &&
        Objects.equals(this.name, oauth2ClientGET.name) &&
        Objects.equals(this.grantType, oauth2ClientGET.grantType) &&
        Objects.equals(this.redirectUri, oauth2ClientGET.redirectUri) &&
        Objects.equals(this.scopes, oauth2ClientGET.scopes) &&
        Objects.equals(this.revoked, oauth2ClientGET.revoked) &&
        Objects.equals(this.created, oauth2ClientGET.created);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, identifier, name, grantType, redirectUri, scopes, revoked, created);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Oauth2ClientGET {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    identifier: ").append(toIndentedString(identifier)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    grantType: ").append(toIndentedString(grantType)).append("\n");
    sb.append("    redirectUri: ").append(toIndentedString(redirectUri)).append("\n");
    sb.append("    scopes: ").append(toIndentedString(scopes)).append("\n");
    sb.append("    revoked: ").append(toIndentedString(revoked)).append("\n");
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

