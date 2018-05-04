package cafe.lavilla.items.menu.dto;

import cafe.lavilla.items.menu.dto.CategoriesDTO;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.*;

import javax.validation.constraints.NotNull;





@ApiModel(description = "")
public class CategoryDTO  {
  
  
  
  private CategoriesDTO categories = null;

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("categories")
  public CategoriesDTO getCategories() {
    return categories;
  }
  public void setCategories(CategoriesDTO categories) {
    this.categories = categories;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class CategoryDTO {\n");
    
    sb.append("  categories: ").append(categories).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
