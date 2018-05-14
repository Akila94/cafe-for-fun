package cafe.lavilla.items.menu.dto;

import cafe.lavilla.items.menu.dto.FoodDetailsDTO;
import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.*;

import javax.validation.constraints.NotNull;





@ApiModel(description = "")
public class CategoriesDTO  {
  
  
  
  private Integer categoryId = null;
  
  
  private String categoryName = null;
  
  
  private List<FoodDetailsDTO> items = new ArrayList<FoodDetailsDTO>();

  
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
  @ApiModelProperty(value = "")
  @JsonProperty("categoryName")
  public String getCategoryName() {
    return categoryName;
  }
  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("items")
  public List<FoodDetailsDTO> getItems() {
    return items;
  }
  public void setItems(List<FoodDetailsDTO> items) {
    this.items = items;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class CategoriesDTO {\n");
    
    sb.append("  categoryId: ").append(categoryId).append("\n");
    sb.append("  categoryName: ").append(categoryName).append("\n");
    sb.append("  items: ").append(items).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
