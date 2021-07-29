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
 * ActivityGET
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-29T19:43:05.733009+02:00[Europe/Zurich]")
public class ActivityGET  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("id")
  private Integer id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("service_id")
  private Integer serviceId;

  @JsonProperty("use_service_price")
  private Boolean useServicePrice;

  /**
   * Gets or Sets permissions
   */
  public enum PermissionsEnum {
    VIEW("view"),
    
    EDIT("edit");

    private String value;

    PermissionsEnum(String value) {
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
    public static PermissionsEnum fromValue(String value) {
      for (PermissionsEnum b : PermissionsEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("permissions")
  @Valid
  private List<PermissionsEnum> permissions = null;

  public ActivityGET id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * activity id
   * @return id
  */
  @ApiModelProperty(required = true, value = "activity id")
  @NotNull


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public ActivityGET name(String name) {
    this.name = name;
    return this;
  }

  /**
   * name of activity
   * @return name
  */
  @ApiModelProperty(required = true, value = "name of activity")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ActivityGET serviceId(Integer serviceId) {
    this.serviceId = serviceId;
    return this;
  }

  /**
   * id of related service
   * @return serviceId
  */
  @ApiModelProperty(required = true, value = "id of related service")
  @NotNull


  public Integer getServiceId() {
    return serviceId;
  }

  public void setServiceId(Integer serviceId) {
    this.serviceId = serviceId;
  }

  public ActivityGET useServicePrice(Boolean useServicePrice) {
    this.useServicePrice = useServicePrice;
    return this;
  }

  /**
   * use price defined in service
   * @return useServicePrice
  */
  @ApiModelProperty(required = true, value = "use price defined in service")
  @NotNull


  public Boolean getUseServicePrice() {
    return useServicePrice;
  }

  public void setUseServicePrice(Boolean useServicePrice) {
    this.useServicePrice = useServicePrice;
  }

  public ActivityGET permissions(List<PermissionsEnum> permissions) {
    this.permissions = permissions;
    return this;
  }

  public ActivityGET addPermissionsItem(PermissionsEnum permissionsItem) {
    if (this.permissions == null) {
      this.permissions = new ArrayList<>();
    }
    this.permissions.add(permissionsItem);
    return this;
  }

  /**
   * actions that can be performed on an item (possible values: view, edit) 
   * @return permissions
  */
  @ApiModelProperty(value = "actions that can be performed on an item (possible values: view, edit) ")


  public List<PermissionsEnum> getPermissions() {
    return permissions;
  }

  public void setPermissions(List<PermissionsEnum> permissions) {
    this.permissions = permissions;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ActivityGET activityGET = (ActivityGET) o;
    return Objects.equals(this.id, activityGET.id) &&
        Objects.equals(this.name, activityGET.name) &&
        Objects.equals(this.serviceId, activityGET.serviceId) &&
        Objects.equals(this.useServicePrice, activityGET.useServicePrice) &&
        Objects.equals(this.permissions, activityGET.permissions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, serviceId, useServicePrice, permissions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ActivityGET {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    serviceId: ").append(toIndentedString(serviceId)).append("\n");
    sb.append("    useServicePrice: ").append(toIndentedString(useServicePrice)).append("\n");
    sb.append("    permissions: ").append(toIndentedString(permissions)).append("\n");
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

