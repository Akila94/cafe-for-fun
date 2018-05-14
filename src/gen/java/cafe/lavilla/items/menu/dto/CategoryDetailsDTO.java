package cafe.lavilla.items.menu.dto;


import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.*;

import javax.validation.constraints.NotNull;





@ApiModel(description = "")
public class CategoryDetailsDTO  {



  private Integer categoryId = null;

  @NotNull
  private String categoryName = null;


  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("categoryId")
  public Integer getCategoryId() {
    return categoryId;
  }
  public void setCategoryId(Integer categoryId) {
    this.categoryId = categoryId;
  }


  /**
   **/
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("categoryName")
  public String getCategoryName() {
    return categoryName;
  }
  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }



  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class CategoryDetailsDTO {\n");

    sb.append("  categoryId: ").append(categoryId).append("\n");
    sb.append("  categoryName: ").append(categoryName).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}