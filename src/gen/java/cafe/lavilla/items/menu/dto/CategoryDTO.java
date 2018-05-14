package cafe.lavilla.items.menu.dto;

import cafe.lavilla.items.menu.dto.CategoriesDTO;
import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.*;

import javax.validation.constraints.NotNull;





@ApiModel(description = "")
public class CategoryDTO  {
  
  
  
  private List<CategoriesDTO> itemsByCategory = new ArrayList<CategoriesDTO>();

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("itemsByCategory")
  public List<CategoriesDTO> getItemsByCategory() {
    return itemsByCategory;
  }
  public void setItemsByCategory(List<CategoriesDTO> itemsByCategory) {
    this.itemsByCategory = itemsByCategory;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class CategoryDTO {\n");
    
    sb.append("  itemsByCategory: ").append(itemsByCategory).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
