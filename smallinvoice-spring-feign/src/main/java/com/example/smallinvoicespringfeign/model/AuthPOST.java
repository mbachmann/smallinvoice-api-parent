package com.example.smallinvoicespringfeign.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;

/**
 * Request for authentication
 */
@ApiModel(description = "Request for authentication")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-12-09T09:40:26.748128+01:00[Europe/Zurich]")
public class AuthPOST  implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * Gets or Sets grantType
   */
  public enum GrantTypeEnum {
    CLIENT_CREDENTIALS("client_credentials"),
    
    REFRESH_TOKEN("refresh_token");

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
  private GrantTypeEnum grantType = GrantTypeEnum.CLIENT_CREDENTIALS;

  @JsonProperty("client_id")
  private String clientId;

  @JsonProperty("client_secret")
  private String clientSecret;

  @JsonProperty("scope")
  private JsonNullable<Object> scope = JsonNullable.undefined();

  @JsonProperty("refresh_token")
  private JsonNullable<Object> refreshToken = JsonNullable.undefined();

  public AuthPOST grantType(GrantTypeEnum grantType) {
    this.grantType = grantType;
    return this;
  }

  /**
   * Get grantType
   * @return grantType
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public GrantTypeEnum getGrantType() {
    return grantType;
  }

  public void setGrantType(GrantTypeEnum grantType) {
    this.grantType = grantType;
  }

  public AuthPOST clientId(String clientId) {
    this.clientId = clientId;
    return this;
  }

  /**
   * Client id provided by smallinvoice when registering new client
   * @return clientId
  */
  @ApiModelProperty(required = true, value = "Client id provided by smallinvoice when registering new client")
  @NotNull


  public String getClientId() {
    return clientId;
  }

  public void setClientId(String clientId) {
    this.clientId = clientId;
  }

  public AuthPOST clientSecret(String clientSecret) {
    this.clientSecret = clientSecret;
    return this;
  }

  /**
   * Client secret provided by smallinvoice when registering new client
   * @return clientSecret
  */
  @ApiModelProperty(required = true, value = "Client secret provided by smallinvoice when registering new client")
  @NotNull


  public String getClientSecret() {
    return clientSecret;
  }

  public void setClientSecret(String clientSecret) {
    this.clientSecret = clientSecret;
  }

  public AuthPOST scope(Object scope) {
    this.scope = JsonNullable.of(scope);
    return this;
  }

  /**
   * Scopes separated by space. Avalilable scopes(scopes to be utilized in requests are in written in small letters): profile (Profile),  contact (Contacts) contact_reminder (Reminders), letter (Letters), configuration (Settings), catalog (Catalog), invoice (Invoices), offer (Offers) delivery_note (Delivery notes) order_confirmation (Order confirmations), project (Projects) cost_unit (Cost units), working_hours (Working hours), activity (Activities), effort (Efforts) 
   * @return scope
  */
  @ApiModelProperty(required = true, value = "Scopes separated by space. Avalilable scopes(scopes to be utilized in requests are in written in small letters): profile (Profile),  contact (Contacts) contact_reminder (Reminders), letter (Letters), configuration (Settings), catalog (Catalog), invoice (Invoices), offer (Offers) delivery_note (Delivery notes) order_confirmation (Order confirmations), project (Projects) cost_unit (Cost units), working_hours (Working hours), activity (Activities), effort (Efforts) ")
  @NotNull


  public JsonNullable<Object> getScope() {
    return scope;
  }

  public void setScope(JsonNullable<Object> scope) {
    this.scope = scope;
  }

  public AuthPOST refreshToken(Object refreshToken) {
    this.refreshToken = JsonNullable.of(refreshToken);
    return this;
  }

  /**
   * Refresh token when grant_type property value is set to 'refresh_token'
   * @return refreshToken
  */
  @ApiModelProperty(value = "Refresh token when grant_type property value is set to 'refresh_token'")


  public JsonNullable<Object> getRefreshToken() {
    return refreshToken;
  }

  public void setRefreshToken(JsonNullable<Object> refreshToken) {
    this.refreshToken = refreshToken;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AuthPOST authPOST = (AuthPOST) o;
    return Objects.equals(this.grantType, authPOST.grantType) &&
        Objects.equals(this.clientId, authPOST.clientId) &&
        Objects.equals(this.clientSecret, authPOST.clientSecret) &&
        Objects.equals(this.scope, authPOST.scope) &&
        Objects.equals(this.refreshToken, authPOST.refreshToken);
  }

  @Override
  public int hashCode() {
    return Objects.hash(grantType, clientId, clientSecret, scope, refreshToken);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AuthPOST {\n");
    
    sb.append("    grantType: ").append(toIndentedString(grantType)).append("\n");
    sb.append("    clientId: ").append(toIndentedString(clientId)).append("\n");
    sb.append("    clientSecret: ").append(toIndentedString(clientSecret)).append("\n");
    sb.append("    scope: ").append(toIndentedString(scope)).append("\n");
    sb.append("    refreshToken: ").append(toIndentedString(refreshToken)).append("\n");
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

