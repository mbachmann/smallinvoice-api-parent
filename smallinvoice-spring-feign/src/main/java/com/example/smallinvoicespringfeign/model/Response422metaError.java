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
 * Response422metaError
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-08-03T10:50:58.837+02:00[Europe/Zurich]")
public class Response422metaError  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("key")
  private String key;

  @JsonProperty("code")
  private Integer code;

  @JsonProperty("message")
  private String message;

  public Response422metaError key(String key) {
    this.key = key;
    return this;
  }

  /**
   * Key of invalid value
   * @return key
  */
  @ApiModelProperty(required = true, value = "Key of invalid value")
  @NotNull


  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public Response422metaError code(Integer code) {
    this.code = code;
    return this;
  }

  /**
   * Error code
   * @return code
  */
  @ApiModelProperty(required = true, value = "Error code")
  @NotNull


  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public Response422metaError message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Error message
   * @return message
  */
  @ApiModelProperty(required = true, value = "Error message")
  @NotNull


  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Response422metaError response422metaError = (Response422metaError) o;
    return Objects.equals(this.key, response422metaError.key) &&
        Objects.equals(this.code, response422metaError.code) &&
        Objects.equals(this.message, response422metaError.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(key, code, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Response422metaError {\n");
    
    sb.append("    key: ").append(toIndentedString(key)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
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

