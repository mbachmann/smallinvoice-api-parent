package com.example.smallinvoicespringfeign.model;

import java.util.Objects;
import com.example.smallinvoicespringfeign.model.DescriptiveCustomFieldGET;
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
 * ContactPeopleGET
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-28T19:49:25.792053+02:00[Europe/Zurich]")
public class ContactPeopleGET  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("id")
  private Integer id;

  @JsonProperty("default")
  private Boolean _default;

  @JsonProperty("name")
  private String name;

  @JsonProperty("surname")
  private String surname;

  /**
   * gender of contact (required for P type); possible values: M - Male, F - Female
   */
  public enum GenderEnum {
    M("M"),
    
    F("F");

    private String value;

    GenderEnum(String value) {
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
    public static GenderEnum fromValue(String value) {
      for (GenderEnum b : GenderEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("gender")
  private GenderEnum gender;

  @JsonProperty("email")
  private String email;

  @JsonProperty("phone")
  private String phone;

  @JsonProperty("department")
  private String department;

  @JsonProperty("salutation")
  private String salutation;

  @JsonProperty("show_title")
  private Boolean showTitle;

  @JsonProperty("show_department")
  private Boolean showDepartment;

  @JsonProperty("wants_newsletter")
  private Boolean wantsNewsletter;

  @JsonProperty("custom_fields")
  @Valid
  private List<DescriptiveCustomFieldGET> customFields = null;

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

  public ContactPeopleGET id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * id of a person
   * @return id
  */
  @ApiModelProperty(required = true, value = "id of a person")
  @NotNull


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public ContactPeopleGET _default(Boolean _default) {
    this._default = _default;
    return this;
  }

  /**
   * whether it is a default contact's person
   * @return _default
  */
  @ApiModelProperty(required = true, value = "whether it is a default contact's person")
  @NotNull


  public Boolean getDefault() {
    return _default;
  }

  public void setDefault(Boolean _default) {
    this._default = _default;
  }

  public ContactPeopleGET name(String name) {
    this.name = name;
    return this;
  }

  /**
   * name
   * @return name
  */
  @ApiModelProperty(required = true, value = "name")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ContactPeopleGET surname(String surname) {
    this.surname = surname;
    return this;
  }

  /**
   * surname
   * @return surname
  */
  @ApiModelProperty(required = true, value = "surname")
  @NotNull


  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public ContactPeopleGET gender(GenderEnum gender) {
    this.gender = gender;
    return this;
  }

  /**
   * gender of contact (required for P type); possible values: M - Male, F - Female
   * @return gender
  */
  @ApiModelProperty(required = true, value = "gender of contact (required for P type); possible values: M - Male, F - Female")
  @NotNull


  public GenderEnum getGender() {
    return gender;
  }

  public void setGender(GenderEnum gender) {
    this.gender = gender;
  }

  public ContactPeopleGET email(String email) {
    this.email = email;
    return this;
  }

  /**
   * email
   * @return email
  */
  @ApiModelProperty(required = true, value = "email")
  @NotNull


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public ContactPeopleGET phone(String phone) {
    this.phone = phone;
    return this;
  }

  /**
   * phone
   * @return phone
  */
  @ApiModelProperty(required = true, value = "phone")
  @NotNull


  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public ContactPeopleGET department(String department) {
    this.department = department;
    return this;
  }

  /**
   * department
   * @return department
  */
  @ApiModelProperty(required = true, value = "department")
  @NotNull


  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public ContactPeopleGET salutation(String salutation) {
    this.salutation = salutation;
    return this;
  }

  /**
   * salutation
   * @return salutation
  */
  @ApiModelProperty(required = true, value = "salutation")
  @NotNull


  public String getSalutation() {
    return salutation;
  }

  public void setSalutation(String salutation) {
    this.salutation = salutation;
  }

  public ContactPeopleGET showTitle(Boolean showTitle) {
    this.showTitle = showTitle;
    return this;
  }

  /**
   * whether to show Mr/Ms before name
   * @return showTitle
  */
  @ApiModelProperty(required = true, value = "whether to show Mr/Ms before name")
  @NotNull


  public Boolean getShowTitle() {
    return showTitle;
  }

  public void setShowTitle(Boolean showTitle) {
    this.showTitle = showTitle;
  }

  public ContactPeopleGET showDepartment(Boolean showDepartment) {
    this.showDepartment = showDepartment;
    return this;
  }

  /**
   * whether to show department
   * @return showDepartment
  */
  @ApiModelProperty(required = true, value = "whether to show department")
  @NotNull


  public Boolean getShowDepartment() {
    return showDepartment;
  }

  public void setShowDepartment(Boolean showDepartment) {
    this.showDepartment = showDepartment;
  }

  public ContactPeopleGET wantsNewsletter(Boolean wantsNewsletter) {
    this.wantsNewsletter = wantsNewsletter;
    return this;
  }

  /**
   * whether person whishes to receive newsletter
   * @return wantsNewsletter
  */
  @ApiModelProperty(required = true, value = "whether person whishes to receive newsletter")
  @NotNull


  public Boolean getWantsNewsletter() {
    return wantsNewsletter;
  }

  public void setWantsNewsletter(Boolean wantsNewsletter) {
    this.wantsNewsletter = wantsNewsletter;
  }

  public ContactPeopleGET customFields(List<DescriptiveCustomFieldGET> customFields) {
    this.customFields = customFields;
    return this;
  }

  public ContactPeopleGET addCustomFieldsItem(DescriptiveCustomFieldGET customFieldsItem) {
    if (this.customFields == null) {
      this.customFields = new ArrayList<>();
    }
    this.customFields.add(customFieldsItem);
    return this;
  }

  /**
   * custom fields values
   * @return customFields
  */
  @ApiModelProperty(value = "custom fields values")

  @Valid

  public List<DescriptiveCustomFieldGET> getCustomFields() {
    return customFields;
  }

  public void setCustomFields(List<DescriptiveCustomFieldGET> customFields) {
    this.customFields = customFields;
  }

  public ContactPeopleGET permissions(List<PermissionsEnum> permissions) {
    this.permissions = permissions;
    return this;
  }

  public ContactPeopleGET addPermissionsItem(PermissionsEnum permissionsItem) {
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
    ContactPeopleGET contactPeopleGET = (ContactPeopleGET) o;
    return Objects.equals(this.id, contactPeopleGET.id) &&
        Objects.equals(this._default, contactPeopleGET._default) &&
        Objects.equals(this.name, contactPeopleGET.name) &&
        Objects.equals(this.surname, contactPeopleGET.surname) &&
        Objects.equals(this.gender, contactPeopleGET.gender) &&
        Objects.equals(this.email, contactPeopleGET.email) &&
        Objects.equals(this.phone, contactPeopleGET.phone) &&
        Objects.equals(this.department, contactPeopleGET.department) &&
        Objects.equals(this.salutation, contactPeopleGET.salutation) &&
        Objects.equals(this.showTitle, contactPeopleGET.showTitle) &&
        Objects.equals(this.showDepartment, contactPeopleGET.showDepartment) &&
        Objects.equals(this.wantsNewsletter, contactPeopleGET.wantsNewsletter) &&
        Objects.equals(this.customFields, contactPeopleGET.customFields) &&
        Objects.equals(this.permissions, contactPeopleGET.permissions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, _default, name, surname, gender, email, phone, department, salutation, showTitle, showDepartment, wantsNewsletter, customFields, permissions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContactPeopleGET {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    _default: ").append(toIndentedString(_default)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    surname: ").append(toIndentedString(surname)).append("\n");
    sb.append("    gender: ").append(toIndentedString(gender)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
    sb.append("    department: ").append(toIndentedString(department)).append("\n");
    sb.append("    salutation: ").append(toIndentedString(salutation)).append("\n");
    sb.append("    showTitle: ").append(toIndentedString(showTitle)).append("\n");
    sb.append("    showDepartment: ").append(toIndentedString(showDepartment)).append("\n");
    sb.append("    wantsNewsletter: ").append(toIndentedString(wantsNewsletter)).append("\n");
    sb.append("    customFields: ").append(toIndentedString(customFields)).append("\n");
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

