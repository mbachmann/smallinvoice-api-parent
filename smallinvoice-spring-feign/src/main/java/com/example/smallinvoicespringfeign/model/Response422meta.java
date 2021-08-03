package com.example.smallinvoicespringfeign.model;

import java.util.Objects;
import com.example.smallinvoicespringfeign.model.Response422metaError;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonCreator;
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
 * Response422meta
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-08-03T10:50:58.837+02:00[Europe/Zurich]")
public class Response422meta  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("errors")
  @Valid
  private List<Response422metaError> errors = new ArrayList<>();

  public Response422meta errors(List<Response422metaError> errors) {
    this.errors = errors;
    return this;
  }

  public Response422meta addErrorsItem(Response422metaError errorsItem) {
    this.errors.add(errorsItem);
    return this;
  }

  /**
   * Specific validation errors
   * @return errors
  */
  @ApiModelProperty(required = true, value = "Specific validation errors")
  @NotNull

  @Valid

  public List<Response422metaError> getErrors() {
    return errors;
  }

  public void setErrors(List<Response422metaError> errors) {
    this.errors = errors;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Response422meta response422meta = (Response422meta) o;
    return Objects.equals(this.errors, response422meta.errors);
  }

  @Override
  public int hashCode() {
    return Objects.hash(errors);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Response422meta {\n");
    
    sb.append("    errors: ").append(toIndentedString(errors)).append("\n");
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

