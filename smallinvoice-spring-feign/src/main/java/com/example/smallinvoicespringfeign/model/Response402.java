package com.example.smallinvoicespringfeign.model;

import java.util.Objects;
import com.example.smallinvoicespringfeign.model.Response402meta;
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
 * Response402
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-27T20:43:02.724916+02:00[Europe/Zurich]")
public class Response402  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("code")
  private Integer code;

  @JsonProperty("message")
  private String message;

  @JsonProperty("meta")
  private Response402meta meta;

  public Response402 code(Integer code) {
    this.code = code;
    return this;
  }

  /**
   * Error code
   * @return code
  */
  @ApiModelProperty(value = "Error code")


  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public Response402 message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Error message
   * @return message
  */
  @ApiModelProperty(value = "Error message")


  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Response402 meta(Response402meta meta) {
    this.meta = meta;
    return this;
  }

  /**
   * Get meta
   * @return meta
  */
  @ApiModelProperty(value = "")

  @Valid

  public Response402meta getMeta() {
    return meta;
  }

  public void setMeta(Response402meta meta) {
    this.meta = meta;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Response402 response402 = (Response402) o;
    return Objects.equals(this.code, response402.code) &&
        Objects.equals(this.message, response402.message) &&
        Objects.equals(this.meta, response402.meta);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, message, meta);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Response402 {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    meta: ").append(toIndentedString(meta)).append("\n");
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

