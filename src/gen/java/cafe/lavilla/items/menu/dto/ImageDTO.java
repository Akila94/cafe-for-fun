package cafe.lavilla.items.menu.dto;


import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.*;

import javax.validation.constraints.NotNull;





@ApiModel(description = "")
public class ImageDTO  {
  
  
  @NotNull
  private String imageUrl = null;

  
  /**
   **/
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("imageUrl")
  public String getImageUrl() {
    return imageUrl;
  }
  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class ImageDTO {\n");
    
    sb.append("  imageUrl: ").append(imageUrl).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
