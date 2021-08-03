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
 * DashboardBoxCustomPOST
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-08-03T11:25:04.200+02:00[Europe/Zurich]")
public class DashboardBoxCustomPOST  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("box_id")
  private Integer boxId;

  @JsonProperty("configuration")
  private String _configuration;

  @JsonProperty("column")
  private Integer column;

  @JsonProperty("order")
  private Integer order;

  public DashboardBoxCustomPOST boxId(Integer boxId) {
    this.boxId = boxId;
    return this;
  }

  /**
   * box id
   * @return boxId
  */
  @ApiModelProperty(required = true, value = "box id")
  @NotNull


  public Integer getBoxId() {
    return boxId;
  }

  public void setBoxId(Integer boxId) {
    this.boxId = boxId;
  }

  public DashboardBoxCustomPOST _configuration(String _configuration) {
    this._configuration = _configuration;
    return this;
  }

  /**
   * configuration JSON
   * @return _configuration
  */
  @ApiModelProperty(value = "configuration JSON")


  public String getConfiguration() {
    return _configuration;
  }

  public void setConfiguration(String _configuration) {
    this._configuration = _configuration;
  }

  public DashboardBoxCustomPOST column(Integer column) {
    this.column = column;
    return this;
  }

  /**
   * presentation column starting from 1 to 1 (if null on POST, box will go to the first column)
   * @return column
  */
  @ApiModelProperty(value = "presentation column starting from 1 to 1 (if null on POST, box will go to the first column)")


  public Integer getColumn() {
    return column;
  }

  public void setColumn(Integer column) {
    this.column = column;
  }

  public DashboardBoxCustomPOST order(Integer order) {
    this.order = order;
    return this;
  }

  /**
   * presentation order starting from 1 (if null on POST, box will go to the end)
   * @return order
  */
  @ApiModelProperty(value = "presentation order starting from 1 (if null on POST, box will go to the end)")


  public Integer getOrder() {
    return order;
  }

  public void setOrder(Integer order) {
    this.order = order;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DashboardBoxCustomPOST dashboardBoxCustomPOST = (DashboardBoxCustomPOST) o;
    return Objects.equals(this.boxId, dashboardBoxCustomPOST.boxId) &&
        Objects.equals(this._configuration, dashboardBoxCustomPOST._configuration) &&
        Objects.equals(this.column, dashboardBoxCustomPOST.column) &&
        Objects.equals(this.order, dashboardBoxCustomPOST.order);
  }

  @Override
  public int hashCode() {
    return Objects.hash(boxId, _configuration, column, order);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DashboardBoxCustomPOST {\n");
    
    sb.append("    boxId: ").append(toIndentedString(boxId)).append("\n");
    sb.append("    _configuration: ").append(toIndentedString(_configuration)).append("\n");
    sb.append("    column: ").append(toIndentedString(column)).append("\n");
    sb.append("    order: ").append(toIndentedString(order)).append("\n");
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

