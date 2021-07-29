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
 * ListPagination
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-29T19:43:05.733009+02:00[Europe/Zurich]")
public class ListPagination  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("page")
  private Integer page;

  @JsonProperty("pages")
  private Integer pages;

  @JsonProperty("total")
  private Integer total;

  @JsonProperty("first")
  private String first;

  @JsonProperty("last")
  private String last;

  @JsonProperty("next")
  private String next;

  @JsonProperty("previous")
  private String previous;

  public ListPagination page(Integer page) {
    this.page = page;
    return this;
  }

  /**
   * Current page number
   * @return page
  */
  @ApiModelProperty(required = true, value = "Current page number")
  @NotNull


  public Integer getPage() {
    return page;
  }

  public void setPage(Integer page) {
    this.page = page;
  }

  public ListPagination pages(Integer pages) {
    this.pages = pages;
    return this;
  }

  /**
   * Total number of pages
   * @return pages
  */
  @ApiModelProperty(required = true, value = "Total number of pages")
  @NotNull


  public Integer getPages() {
    return pages;
  }

  public void setPages(Integer pages) {
    this.pages = pages;
  }

  public ListPagination total(Integer total) {
    this.total = total;
    return this;
  }

  /**
   * Total number of items
   * @return total
  */
  @ApiModelProperty(required = true, value = "Total number of items")
  @NotNull


  public Integer getTotal() {
    return total;
  }

  public void setTotal(Integer total) {
    this.total = total;
  }

  public ListPagination first(String first) {
    this.first = first;
    return this;
  }

  /**
   * URL to the first page of results
   * @return first
  */
  @ApiModelProperty(required = true, value = "URL to the first page of results")
  @NotNull


  public String getFirst() {
    return first;
  }

  public void setFirst(String first) {
    this.first = first;
  }

  public ListPagination last(String last) {
    this.last = last;
    return this;
  }

  /**
   * URL to the last page of results
   * @return last
  */
  @ApiModelProperty(required = true, value = "URL to the last page of results")
  @NotNull


  public String getLast() {
    return last;
  }

  public void setLast(String last) {
    this.last = last;
  }

  public ListPagination next(String next) {
    this.next = next;
    return this;
  }

  /**
   * URL to the next page of results, if exists
   * @return next
  */
  @ApiModelProperty(value = "URL to the next page of results, if exists")


  public String getNext() {
    return next;
  }

  public void setNext(String next) {
    this.next = next;
  }

  public ListPagination previous(String previous) {
    this.previous = previous;
    return this;
  }

  /**
   * URL to the previous page of results, if exists
   * @return previous
  */
  @ApiModelProperty(value = "URL to the previous page of results, if exists")


  public String getPrevious() {
    return previous;
  }

  public void setPrevious(String previous) {
    this.previous = previous;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListPagination listPagination = (ListPagination) o;
    return Objects.equals(this.page, listPagination.page) &&
        Objects.equals(this.pages, listPagination.pages) &&
        Objects.equals(this.total, listPagination.total) &&
        Objects.equals(this.first, listPagination.first) &&
        Objects.equals(this.last, listPagination.last) &&
        Objects.equals(this.next, listPagination.next) &&
        Objects.equals(this.previous, listPagination.previous);
  }

  @Override
  public int hashCode() {
    return Objects.hash(page, pages, total, first, last, next, previous);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListPagination {\n");
    
    sb.append("    page: ").append(toIndentedString(page)).append("\n");
    sb.append("    pages: ").append(toIndentedString(pages)).append("\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
    sb.append("    first: ").append(toIndentedString(first)).append("\n");
    sb.append("    last: ").append(toIndentedString(last)).append("\n");
    sb.append("    next: ").append(toIndentedString(next)).append("\n");
    sb.append("    previous: ").append(toIndentedString(previous)).append("\n");
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

