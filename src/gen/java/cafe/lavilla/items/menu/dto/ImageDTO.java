package cafe.lavilla.items.menu.dto;


import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.*;

import javax.validation.constraints.NotNull;





@ApiModel(description = "")
public class ImageDTO  {


  @NotNull
  private String imageUrl = null;


  private String imageName = null;


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


  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("imageName")
  public String getImageName() {
    return imageName;
  }
  public void setImageName(String imageName) {
    this.imageName = imageName;
  }



  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class ImageDTO {\n");

    sb.append("  imageUrl: ").append(imageUrl).append("\n");
    sb.append("  imageName: ").append(imageName).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}