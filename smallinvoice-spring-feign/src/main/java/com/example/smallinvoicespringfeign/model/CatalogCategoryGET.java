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
 * CatalogCategoryGET
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-28T19:49:25.792053+02:00[Europe/Zurich]")
public class CatalogCategoryGET  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("id")
  private Integer id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("accounting_account_number")
  private String accountingAccountNumber;

  @JsonProperty("usage")
  private Integer usage;

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

  public CatalogCategoryGET id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public CatalogCategoryGET name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CatalogCategoryGET accountingAccountNumber(String accountingAccountNumber) {
    this.accountingAccountNumber = accountingAccountNumber;
    return this;
  }

  /**
   * Get accountingAccountNumber
   * @return accountingAccountNumber
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getAccountingAccountNumber() {
    return accountingAccountNumber;
  }

  public void setAccountingAccountNumber(String accountingAccountNumber) {
    this.accountingAccountNumber = accountingAccountNumber;
  }

  public CatalogCategoryGET usage(Integer usage) {
    this.usage = usage;
    return this;
  }

  /**
   * how many catalog items are using this category
   * @return usage
  */
  @ApiModelProperty(required = true, value = "how many catalog items are using this category")
  @NotNull


  public Integer getUsage() {
    return usage;
  }

  public void setUsage(Integer usage) {
    this.usage = usage;
  }

  public CatalogCategoryGET permissions(List<PermissionsEnum> permissions) {
    this.permissions = permissions;
    return this;
  }

  public CatalogCategoryGET addPermissionsItem(PermissionsEnum permissionsItem) {
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
    CatalogCategoryGET catalogCategoryGET = (CatalogCategoryGET) o;
    return Objects.equals(this.id, catalogCategoryGET.id) &&
        Objects.equals(this.name, catalogCategoryGET.name) &&
        Objects.equals(this.accountingAccountNumber, catalogCategoryGET.accountingAccountNumber) &&
        Objects.equals(this.usage, catalogCategoryGET.usage) &&
        Objects.equals(this.permissions, catalogCategoryGET.permissions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, accountingAccountNumber, usage, permissions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CatalogCategoryGET {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    accountingAccountNumber: ").append(toIndentedString(accountingAccountNumber)).append("\n");
    sb.append("    usage: ").append(toIndentedString(usage)).append("\n");
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

