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
 * DashboardBoxGET
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-11-30T10:06:31.741+01:00[Europe/Zurich]")
public class DashboardBoxGET  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("id")
  private Integer id;

  @JsonProperty("title")
  private String title;

  @JsonProperty("description")
  private String description;

  @JsonProperty("group")
  private String group;

  @JsonProperty("customizable")
  private Boolean customizable;

  @JsonProperty("allowed")
  private Boolean allowed;

  public DashboardBoxGET id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * box id
   * @return id
  */
  @ApiModelProperty(required = true, value = "box id")
  @NotNull


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public DashboardBoxGET title(String title) {
    this.title = title;
    return this;
  }

  /**
   * box title
   * @return title
  */
  @ApiModelProperty(required = true, value = "box title")
  @NotNull


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public DashboardBoxGET description(String description) {
    this.description = description;
    return this;
  }

  /**
   * box description
   * @return description
  */
  @ApiModelProperty(required = true, value = "box description")
  @NotNull


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public DashboardBoxGET group(String group) {
    this.group = group;
    return this;
  }

  /**
   * box group
   * @return group
  */
  @ApiModelProperty(required = true, value = "box group")
  @NotNull


  public String getGroup() {
    return group;
  }

  public void setGroup(String group) {
    this.group = group;
  }

  public DashboardBoxGET customizable(Boolean customizable) {
    this.customizable = customizable;
    return this;
  }

  /**
   * whether box needs a configuration
   * @return customizable
  */
  @ApiModelProperty(required = true, value = "whether box needs a configuration")
  @NotNull


  public Boolean getCustomizable() {
    return customizable;
  }

  public void setCustomizable(Boolean customizable) {
    this.customizable = customizable;
  }

  public DashboardBoxGET allowed(Boolean allowed) {
    this.allowed = allowed;
    return this;
  }

  /**
   * whether user can add this box to his dashboard
   * @return allowed
  */
  @ApiModelProperty(required = true, value = "whether user can add this box to his dashboard")
  @NotNull


  public Boolean getAllowed() {
    return allowed;
  }

  public void setAllowed(Boolean allowed) {
    this.allowed = allowed;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DashboardBoxGET dashboardBoxGET = (DashboardBoxGET) o;
    return Objects.equals(this.id, dashboardBoxGET.id) &&
        Objects.equals(this.title, dashboardBoxGET.title) &&
        Objects.equals(this.description, dashboardBoxGET.description) &&
        Objects.equals(this.group, dashboardBoxGET.group) &&
        Objects.equals(this.customizable, dashboardBoxGET.customizable) &&
        Objects.equals(this.allowed, dashboardBoxGET.allowed);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, description, group, customizable, allowed);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DashboardBoxGET {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    group: ").append(toIndentedString(group)).append("\n");
    sb.append("    customizable: ").append(toIndentedString(customizable)).append("\n");
    sb.append("    allowed: ").append(toIndentedString(allowed)).append("\n");
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

