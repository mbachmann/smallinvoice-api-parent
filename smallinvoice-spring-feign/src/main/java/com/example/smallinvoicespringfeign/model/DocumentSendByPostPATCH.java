package com.example.smallinvoicespringfeign.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;

/**
 * DocumentSendByPostPATCH
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-29T11:25:10.409375+02:00[Europe/Zurich]")
public class DocumentSendByPostPATCH  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("palette")
  private String palette;

  @JsonProperty("print")
  private String print;

  /**
   * post speed for reminding contact (valid only when action is CP); possible values: P - priority, E - economy 
   */
  public enum SpeedEnum {
    P("P"),
    
    E("E");

    private String value;

    SpeedEnum(String value) {
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
    public static SpeedEnum fromValue(String value) {
      for (SpeedEnum b : SpeedEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("speed")
  private SpeedEnum speed;

  public DocumentSendByPostPATCH palette(String palette) {
    this.palette = palette;
    return this;
  }

  /**
   * palette; possible values: C - colour, BW - black&white
   * @return palette
  */
  @ApiModelProperty(required = true, value = "palette; possible values: C - colour, BW - black&white")
  @NotNull


  public String getPalette() {
    return palette;
  }

  public void setPalette(String palette) {
    this.palette = palette;
  }

  public DocumentSendByPostPATCH print(String print) {
    this.print = print;
    return this;
  }

  /**
   * printing type; possible values: D - duplex (two-sided), S - simplex (one-sided)
   * @return print
  */
  @ApiModelProperty(required = true, value = "printing type; possible values: D - duplex (two-sided), S - simplex (one-sided)")
  @NotNull


  public String getPrint() {
    return print;
  }

  public void setPrint(String print) {
    this.print = print;
  }

  public DocumentSendByPostPATCH speed(SpeedEnum speed) {
    this.speed = speed;
    return this;
  }

  /**
   * post speed for reminding contact (valid only when action is CP); possible values: P - priority, E - economy 
   * @return speed
  */
  @ApiModelProperty(required = true, value = "post speed for reminding contact (valid only when action is CP); possible values: P - priority, E - economy ")
  @NotNull


  public SpeedEnum getSpeed() {
    return speed;
  }

  public void setSpeed(SpeedEnum speed) {
    this.speed = speed;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DocumentSendByPostPATCH documentSendByPostPATCH = (DocumentSendByPostPATCH) o;
    return Objects.equals(this.palette, documentSendByPostPATCH.palette) &&
        Objects.equals(this.print, documentSendByPostPATCH.print) &&
        Objects.equals(this.speed, documentSendByPostPATCH.speed);
  }

  @Override
  public int hashCode() {
    return Objects.hash(palette, print, speed);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DocumentSendByPostPATCH {\n");
    
    sb.append("    palette: ").append(toIndentedString(palette)).append("\n");
    sb.append("    print: ").append(toIndentedString(print)).append("\n");
    sb.append("    speed: ").append(toIndentedString(speed)).append("\n");
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

