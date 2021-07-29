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
 * ContactAddressGET
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-29T19:43:05.733009+02:00[Europe/Zurich]")
public class ContactAddressGET  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("id")
  private Integer id;

  @JsonProperty("default")
  private Boolean _default;

  @JsonProperty("country")
  private String country;

  @JsonProperty("street")
  private String street;

  @JsonProperty("street_no")
  private String streetNo;

  @JsonProperty("street2")
  private String street2;

  @JsonProperty("postcode")
  private String postcode;

  @JsonProperty("city")
  private String city;

  @JsonProperty("hide_on_documents")
  private Boolean hideOnDocuments;

  @JsonProperty("default_prepage")
  private Boolean defaultPrepage;

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

  public ContactAddressGET id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * id of an address
   * @return id
  */
  @ApiModelProperty(required = true, value = "id of an address")
  @NotNull


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public ContactAddressGET _default(Boolean _default) {
    this._default = _default;
    return this;
  }

  /**
   * whether it is a default contact's address
   * @return _default
  */
  @ApiModelProperty(required = true, value = "whether it is a default contact's address")
  @NotNull


  public Boolean getDefault() {
    return _default;
  }

  public void setDefault(Boolean _default) {
    this._default = _default;
  }

  public ContactAddressGET country(String country) {
    this.country = country;
    return this;
  }

  /**
   * country ISO2 code (eg. CH)
   * @return country
  */
  @ApiModelProperty(required = true, value = "country ISO2 code (eg. CH)")
  @NotNull


  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public ContactAddressGET street(String street) {
    this.street = street;
    return this;
  }

  /**
   * street
   * @return street
  */
  @ApiModelProperty(required = true, value = "street")
  @NotNull


  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public ContactAddressGET streetNo(String streetNo) {
    this.streetNo = streetNo;
    return this;
  }

  /**
   * number of apartment
   * @return streetNo
  */
  @ApiModelProperty(required = true, value = "number of apartment")
  @NotNull


  public String getStreetNo() {
    return streetNo;
  }

  public void setStreetNo(String streetNo) {
    this.streetNo = streetNo;
  }

  public ContactAddressGET street2(String street2) {
    this.street2 = street2;
    return this;
  }

  /**
   * additional address information
   * @return street2
  */
  @ApiModelProperty(required = true, value = "additional address information")
  @NotNull


  public String getStreet2() {
    return street2;
  }

  public void setStreet2(String street2) {
    this.street2 = street2;
  }

  public ContactAddressGET postcode(String postcode) {
    this.postcode = postcode;
    return this;
  }

  /**
   * postcode
   * @return postcode
  */
  @ApiModelProperty(required = true, value = "postcode")
  @NotNull


  public String getPostcode() {
    return postcode;
  }

  public void setPostcode(String postcode) {
    this.postcode = postcode;
  }

  public ContactAddressGET city(String city) {
    this.city = city;
    return this;
  }

  /**
   * city
   * @return city
  */
  @ApiModelProperty(required = true, value = "city")
  @NotNull


  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public ContactAddressGET hideOnDocuments(Boolean hideOnDocuments) {
    this.hideOnDocuments = hideOnDocuments;
    return this;
  }

  /**
   * whether to hide this address on documents
   * @return hideOnDocuments
  */
  @ApiModelProperty(required = true, value = "whether to hide this address on documents")
  @NotNull


  public Boolean getHideOnDocuments() {
    return hideOnDocuments;
  }

  public void setHideOnDocuments(Boolean hideOnDocuments) {
    this.hideOnDocuments = hideOnDocuments;
  }

  public ContactAddressGET defaultPrepage(Boolean defaultPrepage) {
    this.defaultPrepage = defaultPrepage;
    return this;
  }

  /**
   * whether the address is a default postal address
   * @return defaultPrepage
  */
  @ApiModelProperty(required = true, value = "whether the address is a default postal address")
  @NotNull


  public Boolean getDefaultPrepage() {
    return defaultPrepage;
  }

  public void setDefaultPrepage(Boolean defaultPrepage) {
    this.defaultPrepage = defaultPrepage;
  }

  public ContactAddressGET permissions(List<PermissionsEnum> permissions) {
    this.permissions = permissions;
    return this;
  }

  public ContactAddressGET addPermissionsItem(PermissionsEnum permissionsItem) {
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
    ContactAddressGET contactAddressGET = (ContactAddressGET) o;
    return Objects.equals(this.id, contactAddressGET.id) &&
        Objects.equals(this._default, contactAddressGET._default) &&
        Objects.equals(this.country, contactAddressGET.country) &&
        Objects.equals(this.street, contactAddressGET.street) &&
        Objects.equals(this.streetNo, contactAddressGET.streetNo) &&
        Objects.equals(this.street2, contactAddressGET.street2) &&
        Objects.equals(this.postcode, contactAddressGET.postcode) &&
        Objects.equals(this.city, contactAddressGET.city) &&
        Objects.equals(this.hideOnDocuments, contactAddressGET.hideOnDocuments) &&
        Objects.equals(this.defaultPrepage, contactAddressGET.defaultPrepage) &&
        Objects.equals(this.permissions, contactAddressGET.permissions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, _default, country, street, streetNo, street2, postcode, city, hideOnDocuments, defaultPrepage, permissions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContactAddressGET {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    _default: ").append(toIndentedString(_default)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    street: ").append(toIndentedString(street)).append("\n");
    sb.append("    streetNo: ").append(toIndentedString(streetNo)).append("\n");
    sb.append("    street2: ").append(toIndentedString(street2)).append("\n");
    sb.append("    postcode: ").append(toIndentedString(postcode)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    hideOnDocuments: ").append(toIndentedString(hideOnDocuments)).append("\n");
    sb.append("    defaultPrepage: ").append(toIndentedString(defaultPrepage)).append("\n");
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

