package cafe.lavilla.food.menu.endpoint.dto;


import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.*;

import javax.validation.constraints.NotNull;





@ApiModel(description = "")
public class SaladDTO  {
  
  
  
  private Integer id = null;
  
  
  private String name = null;
  
  
  private String description = null;
  
  
  private String arabicDescription = null;
  
  
  private Integer price = null;
  
  
  private String imgUrl = null;

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("id")
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("name")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("arabicDescription")
  public String getArabicDescription() {
    return arabicDescription;
  }
  public void setArabicDescription(String arabicDescription) {
    this.arabicDescription = arabicDescription;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("price")
  public Integer getPrice() {
    return price;
  }
  public void setPrice(Integer price) {
    this.price = price;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("imgUrl")
  public String getImgUrl() {
    return imgUrl;
  }
  public void setImgUrl(String imgUrl) {
    this.imgUrl = imgUrl;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class SaladDTO {\n");
    
    sb.append("  id: ").append(id).append("\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("  description: ").append(description).append("\n");
    sb.append("  arabicDescription: ").append(arabicDescription).append("\n");
    sb.append("  price: ").append(price).append("\n");
    sb.append("  imgUrl: ").append(imgUrl).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
