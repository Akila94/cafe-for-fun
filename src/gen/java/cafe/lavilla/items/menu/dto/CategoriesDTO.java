package cafe.lavilla.items.menu.dto;

import cafe.lavilla.items.menu.dto.CategoryDTO;
import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.*;

import javax.validation.constraints.NotNull;





@ApiModel(description = "")
public class CategoriesDTO  {
  
  
  
  private List<CategoryDTO> categories = new ArrayList<CategoryDTO>();

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("categories")
  public List<CategoryDTO> getCategories() {
    return categories;
  }
  public void setCategories(List<CategoryDTO> categories) {
    this.categories = categories;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class CategoriesDTO {\n");
    
    sb.append("  categories: ").append(categories).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
