package com.example.smallinvoicespringfeign.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import java.time.LocalDateTime;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;

/**
 * Oauth2ConnectedApplicationGET
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-28T19:49:25.792053+02:00[Europe/Zurich]")
public class Oauth2ConnectedApplicationGET  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("id")
  private Integer id;

  @JsonProperty("client_id")
  private Integer clientId;

  @JsonProperty("client_identifier")
  private String clientIdentifier;

  @JsonProperty("client_name")
  private String clientName;

  @JsonProperty("last_used")
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
  private LocalDateTime lastUsed;

  @JsonProperty("created")
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
  private LocalDateTime created;

  public Oauth2ConnectedApplicationGET id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * application id
   * @return id
  */
  @ApiModelProperty(required = true, value = "application id")
  @NotNull


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Oauth2ConnectedApplicationGET clientId(Integer clientId) {
    this.clientId = clientId;
    return this;
  }

  /**
   * oauth client id (system id)
   * @return clientId
  */
  @ApiModelProperty(required = true, value = "oauth client id (system id)")
  @NotNull


  public Integer getClientId() {
    return clientId;
  }

  public void setClientId(Integer clientId) {
    this.clientId = clientId;
  }

  public Oauth2ConnectedApplicationGET clientIdentifier(String clientIdentifier) {
    this.clientIdentifier = clientIdentifier;
    return this;
  }

  /**
   * oauth client identifier (THE CLIENT ID used for authorization)
   * @return clientIdentifier
  */
  @ApiModelProperty(required = true, value = "oauth client identifier (THE CLIENT ID used for authorization)")
  @NotNull


  public String getClientIdentifier() {
    return clientIdentifier;
  }

  public void setClientIdentifier(String clientIdentifier) {
    this.clientIdentifier = clientIdentifier;
  }

  public Oauth2ConnectedApplicationGET clientName(String clientName) {
    this.clientName = clientName;
    return this;
  }

  /**
   * oauth client name
   * @return clientName
  */
  @ApiModelProperty(required = true, value = "oauth client name")
  @NotNull


  public String getClientName() {
    return clientName;
  }

  public void setClientName(String clientName) {
    this.clientName = clientName;
  }

  public Oauth2ConnectedApplicationGET lastUsed(LocalDateTime lastUsed) {
    this.lastUsed = lastUsed;
    return this;
  }

  /**
   * when was application las used
   * @return lastUsed
  */
  @ApiModelProperty(required = true, value = "when was application las used")
  @NotNull

  @Valid

  public LocalDateTime getLastUsed() {
    return lastUsed;
  }

  public void setLastUsed(LocalDateTime lastUsed) {
    this.lastUsed = lastUsed;
  }

  public Oauth2ConnectedApplicationGET created(LocalDateTime created) {
    this.created = created;
    return this;
  }

  /**
   * when was application connected
   * @return created
  */
  @ApiModelProperty(required = true, value = "when was application connected")
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
    Oauth2ConnectedApplicationGET oauth2ConnectedApplicationGET = (Oauth2ConnectedApplicationGET) o;
    return Objects.equals(this.id, oauth2ConnectedApplicationGET.id) &&
        Objects.equals(this.clientId, oauth2ConnectedApplicationGET.clientId) &&
        Objects.equals(this.clientIdentifier, oauth2ConnectedApplicationGET.clientIdentifier) &&
        Objects.equals(this.clientName, oauth2ConnectedApplicationGET.clientName) &&
        Objects.equals(this.lastUsed, oauth2ConnectedApplicationGET.lastUsed) &&
        Objects.equals(this.created, oauth2ConnectedApplicationGET.created);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, clientId, clientIdentifier, clientName, lastUsed, created);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Oauth2ConnectedApplicationGET {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    clientId: ").append(toIndentedString(clientId)).append("\n");
    sb.append("    clientIdentifier: ").append(toIndentedString(clientIdentifier)).append("\n");
    sb.append("    clientName: ").append(toIndentedString(clientName)).append("\n");
    sb.append("    lastUsed: ").append(toIndentedString(lastUsed)).append("\n");
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

