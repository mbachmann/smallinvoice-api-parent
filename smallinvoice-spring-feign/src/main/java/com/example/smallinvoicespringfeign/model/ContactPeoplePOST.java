package com.example.smallinvoicespringfeign.model;

import java.util.Objects;
import com.example.smallinvoicespringfeign.model.DescriptiveCustomFieldPOST;
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
 * ContactPeoplePOST
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-11-30T10:06:31.741+01:00[Europe/Zurich]")
public class ContactPeoplePOST  implements Serializable {
  private static final long serialVersionUID = 1L;

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
  private List<DescriptiveCustomFieldPOST> customFields = null;

  public ContactPeoplePOST _default(Boolean _default) {
    this._default = _default;
    return this;
  }

  /**
   * whether it is a default contact's person - default value: false
   * @return _default
  */
  @ApiModelProperty(value = "whether it is a default contact's person - default value: false")


  public Boolean getDefault() {
    return _default;
  }

  public void setDefault(Boolean _default) {
    this._default = _default;
  }

  public ContactPeoplePOST name(String name) {
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

  public ContactPeoplePOST surname(String surname) {
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

  public ContactPeoplePOST gender(GenderEnum gender) {
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

  public ContactPeoplePOST email(String email) {
    this.email = email;
    return this;
  }

  /**
   * email
   * @return email
  */
  @ApiModelProperty(value = "email")


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public ContactPeoplePOST phone(String phone) {
    this.phone = phone;
    return this;
  }

  /**
   * phone
   * @return phone
  */
  @ApiModelProperty(value = "phone")


  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public ContactPeoplePOST department(String department) {
    this.department = department;
    return this;
  }

  /**
   * department
   * @return department
  */
  @ApiModelProperty(value = "department")


  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public ContactPeoplePOST salutation(String salutation) {
    this.salutation = salutation;
    return this;
  }

  /**
   * salutation
   * @return salutation
  */
  @ApiModelProperty(value = "salutation")


  public String getSalutation() {
    return salutation;
  }

  public void setSalutation(String salutation) {
    this.salutation = salutation;
  }

  public ContactPeoplePOST showTitle(Boolean showTitle) {
    this.showTitle = showTitle;
    return this;
  }

  /**
   * whether to show Mr/Ms before name - default value: false
   * @return showTitle
  */
  @ApiModelProperty(value = "whether to show Mr/Ms before name - default value: false")


  public Boolean getShowTitle() {
    return showTitle;
  }

  public void setShowTitle(Boolean showTitle) {
    this.showTitle = showTitle;
  }

  public ContactPeoplePOST showDepartment(Boolean showDepartment) {
    this.showDepartment = showDepartment;
    return this;
  }

  /**
   * whether to show department - default value: false
   * @return showDepartment
  */
  @ApiModelProperty(value = "whether to show department - default value: false")


  public Boolean getShowDepartment() {
    return showDepartment;
  }

  public void setShowDepartment(Boolean showDepartment) {
    this.showDepartment = showDepartment;
  }

  public ContactPeoplePOST wantsNewsletter(Boolean wantsNewsletter) {
    this.wantsNewsletter = wantsNewsletter;
    return this;
  }

  /**
   * whether person whishes to receive newsletter - default value: true
   * @return wantsNewsletter
  */
  @ApiModelProperty(value = "whether person whishes to receive newsletter - default value: true")


  public Boolean getWantsNewsletter() {
    return wantsNewsletter;
  }

  public void setWantsNewsletter(Boolean wantsNewsletter) {
    this.wantsNewsletter = wantsNewsletter;
  }

  public ContactPeoplePOST customFields(List<DescriptiveCustomFieldPOST> customFields) {
    this.customFields = customFields;
    return this;
  }

  public ContactPeoplePOST addCustomFieldsItem(DescriptiveCustomFieldPOST customFieldsItem) {
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

  public List<DescriptiveCustomFieldPOST> getCustomFields() {
    return customFields;
  }

  public void setCustomFields(List<DescriptiveCustomFieldPOST> customFields) {
    this.customFields = customFields;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContactPeoplePOST contactPeoplePOST = (ContactPeoplePOST) o;
    return Objects.equals(this._default, contactPeoplePOST._default) &&
        Objects.equals(this.name, contactPeoplePOST.name) &&
        Objects.equals(this.surname, contactPeoplePOST.surname) &&
        Objects.equals(this.gender, contactPeoplePOST.gender) &&
        Objects.equals(this.email, contactPeoplePOST.email) &&
        Objects.equals(this.phone, contactPeoplePOST.phone) &&
        Objects.equals(this.department, contactPeoplePOST.department) &&
        Objects.equals(this.salutation, contactPeoplePOST.salutation) &&
        Objects.equals(this.showTitle, contactPeoplePOST.showTitle) &&
        Objects.equals(this.showDepartment, contactPeoplePOST.showDepartment) &&
        Objects.equals(this.wantsNewsletter, contactPeoplePOST.wantsNewsletter) &&
        Objects.equals(this.customFields, contactPeoplePOST.customFields);
  }

  @Override
  public int hashCode() {
    return Objects.hash(_default, name, surname, gender, email, phone, department, salutation, showTitle, showDepartment, wantsNewsletter, customFields);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContactPeoplePOST {\n");
    
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

