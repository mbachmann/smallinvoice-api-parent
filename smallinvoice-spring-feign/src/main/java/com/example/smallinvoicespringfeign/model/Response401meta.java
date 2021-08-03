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
 * Response401meta
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-08-03T11:25:04.200+02:00[Europe/Zurich]")
public class Response401meta  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("error_type")
  private String errorType;

  @JsonProperty("hint")
  private String hint;

  public Response401meta errorType(String errorType) {
    this.errorType = errorType;
    return this;
  }

  /**
   * OAuth error type
   * @return errorType
  */
  @ApiModelProperty(required = true, value = "OAuth error type")
  @NotNull


  public String getErrorType() {
    return errorType;
  }

  public void setErrorType(String errorType) {
    this.errorType = errorType;
  }

  public Response401meta hint(String hint) {
    this.hint = hint;
    return this;
  }

  /**
   * OAuth hint
   * @return hint
  */
  @ApiModelProperty(value = "OAuth hint")


  public String getHint() {
    return hint;
  }

  public void setHint(String hint) {
    this.hint = hint;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Response401meta response401meta = (Response401meta) o;
    return Objects.equals(this.errorType, response401meta.errorType) &&
        Objects.equals(this.hint, response401meta.hint);
  }

  @Override
  public int hashCode() {
    return Objects.hash(errorType, hint);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Response401meta {\n");
    
    sb.append("    errorType: ").append(toIndentedString(errorType)).append("\n");
    sb.append("    hint: ").append(toIndentedString(hint)).append("\n");
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

