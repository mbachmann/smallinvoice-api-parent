package com.example.smallinvoicespringfeign.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import java.time.LocalDateTime;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;

/**
 * DashboardBoxCustomGET
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-11-30T10:06:31.741+01:00[Europe/Zurich]")
public class DashboardBoxCustomGET  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("id")
  private Integer id;

  @JsonProperty("box_id")
  private Integer boxId;

  @JsonProperty("box_title")
  private String boxTitle;

  @JsonProperty("box_content")
  private String boxContent;

  @JsonProperty("box_customizable")
  private Boolean boxCustomizable;

  @JsonProperty("configuration")
  private String _configuration;

  @JsonProperty("column")
  private Integer column;

  @JsonProperty("order")
  private Integer order;

  @JsonProperty("created")
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
  private LocalDateTime created;

  public DashboardBoxCustomGET id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * custom box id
   * @return id
  */
  @ApiModelProperty(required = true, value = "custom box id")
  @NotNull


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public DashboardBoxCustomGET boxId(Integer boxId) {
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

  public DashboardBoxCustomGET boxTitle(String boxTitle) {
    this.boxTitle = boxTitle;
    return this;
  }

  /**
   * box title
   * @return boxTitle
  */
  @ApiModelProperty(required = true, value = "box title")
  @NotNull


  public String getBoxTitle() {
    return boxTitle;
  }

  public void setBoxTitle(String boxTitle) {
    this.boxTitle = boxTitle;
  }

  public DashboardBoxCustomGET boxContent(String boxContent) {
    this.boxContent = boxContent;
    return this;
  }

  /**
   * box HTML content
   * @return boxContent
  */
  @ApiModelProperty(value = "box HTML content")


  public String getBoxContent() {
    return boxContent;
  }

  public void setBoxContent(String boxContent) {
    this.boxContent = boxContent;
  }

  public DashboardBoxCustomGET boxCustomizable(Boolean boxCustomizable) {
    this.boxCustomizable = boxCustomizable;
    return this;
  }

  /**
   * whether box needs a configuration
   * @return boxCustomizable
  */
  @ApiModelProperty(required = true, value = "whether box needs a configuration")
  @NotNull


  public Boolean getBoxCustomizable() {
    return boxCustomizable;
  }

  public void setBoxCustomizable(Boolean boxCustomizable) {
    this.boxCustomizable = boxCustomizable;
  }

  public DashboardBoxCustomGET _configuration(String _configuration) {
    this._configuration = _configuration;
    return this;
  }

  /**
   * configuration JSON
   * @return _configuration
  */
  @ApiModelProperty(required = true, value = "configuration JSON")
  @NotNull


  public String getConfiguration() {
    return _configuration;
  }

  public void setConfiguration(String _configuration) {
    this._configuration = _configuration;
  }

  public DashboardBoxCustomGET column(Integer column) {
    this.column = column;
    return this;
  }

  /**
   * presentation column starting from 1 to 1 (if null on POST, box will go to the first column)
   * @return column
  */
  @ApiModelProperty(required = true, value = "presentation column starting from 1 to 1 (if null on POST, box will go to the first column)")
  @NotNull


  public Integer getColumn() {
    return column;
  }

  public void setColumn(Integer column) {
    this.column = column;
  }

  public DashboardBoxCustomGET order(Integer order) {
    this.order = order;
    return this;
  }

  /**
   * presentation order starting from 1 (if null on POST, box will go to the end)
   * @return order
  */
  @ApiModelProperty(required = true, value = "presentation order starting from 1 (if null on POST, box will go to the end)")
  @NotNull


  public Integer getOrder() {
    return order;
  }

  public void setOrder(Integer order) {
    this.order = order;
  }

  public DashboardBoxCustomGET created(LocalDateTime created) {
    this.created = created;
    return this;
  }

  /**
   * when custom box was created
   * @return created
  */
  @ApiModelProperty(required = true, value = "when custom box was created")
  @NotNull

  @Valid

  public LocalDateTime getCreated() {
    return created;
  }

  public void setCreated(LocalDateTime created) {
    this.created = created;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DashboardBoxCustomGET dashboardBoxCustomGET = (DashboardBoxCustomGET) o;
    return Objects.equals(this.id, dashboardBoxCustomGET.id) &&
        Objects.equals(this.boxId, dashboardBoxCustomGET.boxId) &&
        Objects.equals(this.boxTitle, dashboardBoxCustomGET.boxTitle) &&
        Objects.equals(this.boxContent, dashboardBoxCustomGET.boxContent) &&
        Objects.equals(this.boxCustomizable, dashboardBoxCustomGET.boxCustomizable) &&
        Objects.equals(this._configuration, dashboardBoxCustomGET._configuration) &&
        Objects.equals(this.column, dashboardBoxCustomGET.column) &&
        Objects.equals(this.order, dashboardBoxCustomGET.order) &&
        Objects.equals(this.created, dashboardBoxCustomGET.created);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, boxId, boxTitle, boxContent, boxCustomizable, _configuration, column, order, created);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DashboardBoxCustomGET {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    boxId: ").append(toIndentedString(boxId)).append("\n");
    sb.append("    boxTitle: ").append(toIndentedString(boxTitle)).append("\n");
    sb.append("    boxContent: ").append(toIndentedString(boxContent)).append("\n");
    sb.append("    boxCustomizable: ").append(toIndentedString(boxCustomizable)).append("\n");
    sb.append("    _configuration: ").append(toIndentedString(_configuration)).append("\n");
    sb.append("    column: ").append(toIndentedString(column)).append("\n");
    sb.append("    order: ").append(toIndentedString(order)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
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

